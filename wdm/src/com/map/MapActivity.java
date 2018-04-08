package com.map;

import java.io.File;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.RouteOverlay;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.MKAddrInfo;
import com.baidu.mapapi.search.MKBusLineResult;
import com.baidu.mapapi.search.MKDrivingRouteResult;
import com.baidu.mapapi.search.MKPoiResult;
import com.baidu.mapapi.search.MKSearch;
import com.baidu.mapapi.search.MKSearchListener;
import com.baidu.mapapi.search.MKSuggestionResult;
import com.baidu.mapapi.search.MKTransitRouteResult;
import com.baidu.mapapi.search.MKWalkingRouteResult;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.example.wdm.R;
import com.example.wdm.SouSuoActivity;
import com.example.wdm.R.drawable;
import com.example.wdm.R.id;
import com.example.wdm.R.layout;
import com.example.wdm.R.menu;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.widget.ImageView.ScaleType;

public class MapActivity extends Activity {

	//百度地图组件
	private MapView mMapView=null;
	//百度地图对象
	private BaiduMap mBaiduMap=null;
	Location location=null;
	
	String start,end;
	//-------------start-----------------
	BMapManager bMapManager = null;  // 定义管理sdk的对象
	// 定义控件
	EditText startEditText;
	EditText et_start,et_end;
	Button button,btn2;
		
	// 定义路径搜索对象
	MKSearch mkSearch = null;
	
	//-------------end--------------------
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		
        //首先设置不显示系统标题栏，然后再初始化SDK引用的Context全局变量，最后调用init()方法
        requestWindowFeature(Window.FEATURE_NO_TITLE);//设置不显示标题栏
        SDKInitializer.initialize(getApplicationContext());//初始化SDK
        
        setContentView(R.layout.activity_main);
        jingweidu(); //获取经纬度
        init(); //初始化方法
        
        button=(Button) findViewById(R.id.button1);
        btn2=(Button) findViewById(R.id.button2);
        
        //点击按钮调用第三方应用
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				openBaidu();
			}
		});
        //搜索
        btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
			//	loadHtml();
				Intent intent=new Intent(MapActivity.this,SouSuoActivity.class);
				startActivity(intent);
			}
		});
    }

    //判断地图应用是否安装
    private boolean isInstallByread(String packageName) {  
        return new File("/data/data/" + packageName).exists();  
    }  
    // 调用第三方地图
    private void openBaidu(){  
        try {  
            if (isInstallByread("com.baidu.BaiduMap")) {  
                Intent intent = new Intent(); 
                //为intent设置数据
                intent.setData(Uri.parse("baidumap://map/"
                +"&mode=transit&sy=0&index=0&target=1"));  
                intent.setPackage("com.baidu.BaiduMap");  
                startActivity(intent); // 启动调用  
            } else {  
                Toast.makeText(MapActivity.this, "没有安装百度地图客户端，请先下载该地图应用", Toast.LENGTH_SHORT).show();  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
    
    //在该文件中获取布局文件中添加的百度地图组件，以及百度地图对象，再设置地图类型为普通地图
    //接下来再设置定位点为深圳市，最后定义覆盖物用于标记所在位置。
    private void init(){
    	mMapView=(MapView)findViewById(R.id.bmapview); // 获取百度地图组件
    	//mMapView.setBuiltInZoomControls(true);  
    	mBaiduMap=mMapView.getMap(); // 获取百度地图对象
    	mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);  //普通地图
    	
    	// 定位
    	//设定中心点坐标
    	//location.getLatitude(), location.getLongitude() 获取经纬度
    	//LatLng 保存坐标信息
    	LatLng cenpt=new LatLng(location.getLatitude(), location.getLongitude());
    	//定义地图状态
    	MapStatus mMapStatus=new MapStatus.Builder().target(cenpt).zoom(15).build();
    	//定义MapStatusUpdate对象，以便描述地图状态将要发生的变化。
    	MapStatusUpdate mMapStatusUpdate=MapStatusUpdateFactory.newMapStatus(mMapStatus);
    	//改变地图状态
    	mBaiduMap.setMapStatus(mMapStatusUpdate);
    	// ------------------------------
    	//定义maker坐标点
    	//（1）需要定义一个LatLng对象，该对象用于保存覆盖物的位置坐标。
    	LatLng point=new LatLng(location.getLatitude(), location.getLongitude());
    	//构建maker图标
    	BitmapDescriptor bitmap=BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher);
    	//构建MarkerOption，用于在地图上添加marker
    	OverlayOptions option =new MarkerOptions().position(point).icon(bitmap);
    	//在地图上添加marker，并显示
    	mBaiduMap.addOverlay(option);	
    }
    
    private void jingweidu(){
    	//在系统服务中获取位置服务，然后更新位置信息，接着在文本框中显示经纬度数据
        StringBuilder sb =new StringBuilder() ;// 使用StringBuilder 保存数据
        
        //获得位置服务
        LocationManager manager=(LocationManager) getSystemService(LOCATION_SERVICE);
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,10000, 2, new LocationListener() {		
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO 自动生成的方法存根				
			}
			
			@Override
			public void onProviderEnabled(String provider) {
				// TODO 自动生成的方法存根			
			}
			
			@Override
			public void onProviderDisabled(String provider) {
				// TODO 自动生成的方法存根				
			}
			
			@Override
			public void onLocationChanged(Location location) {
				// TODO 自动生成的方法存根			
			}
		});
        
        location =manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(location!=null){
        	sb.append("维度："+location.getLatitude()+"\n");
        	sb.append("经度："+location.getLongitude()+"\n");
        }else{
        	sb.append("location is null~");
        }
        
        //获取文本控件
     //   TextView text=(TextView) findViewById(R.id.location);
     //   text.setText(sb.toString()); //设置获取结果
    }
    
   
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onResume() {
    	// TODO 自动生成的方法存根
    	super.onResume();
    	mMapView.onResume();
    }
    
    @Override
    protected void onPause() {
    	// TODO 自动生成的方法存根
    	super.onPause();
    	mMapView.onPause();
    }
    
    @Override
    protected void onDestroy() {
    	// TODO 自动生成的方法存根
    	super.onDestroy();
    	mMapView.onDestroy();
    }
}
