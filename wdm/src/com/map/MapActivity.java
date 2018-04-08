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

	//�ٶȵ�ͼ���
	private MapView mMapView=null;
	//�ٶȵ�ͼ����
	private BaiduMap mBaiduMap=null;
	Location location=null;
	
	String start,end;
	//-------------start-----------------
	BMapManager bMapManager = null;  // �������sdk�Ķ���
	// ����ؼ�
	EditText startEditText;
	EditText et_start,et_end;
	Button button,btn2;
		
	// ����·����������
	MKSearch mkSearch = null;
	
	//-------------end--------------------
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		
        //�������ò���ʾϵͳ��������Ȼ���ٳ�ʼ��SDK���õ�Contextȫ�ֱ�����������init()����
        requestWindowFeature(Window.FEATURE_NO_TITLE);//���ò���ʾ������
        SDKInitializer.initialize(getApplicationContext());//��ʼ��SDK
        
        setContentView(R.layout.activity_main);
        jingweidu(); //��ȡ��γ��
        init(); //��ʼ������
        
        button=(Button) findViewById(R.id.button1);
        btn2=(Button) findViewById(R.id.button2);
        
        //�����ť���õ�����Ӧ��
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				openBaidu();
			}
		});
        //����
        btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
			//	loadHtml();
				Intent intent=new Intent(MapActivity.this,SouSuoActivity.class);
				startActivity(intent);
			}
		});
    }

    //�жϵ�ͼӦ���Ƿ�װ
    private boolean isInstallByread(String packageName) {  
        return new File("/data/data/" + packageName).exists();  
    }  
    // ���õ�������ͼ
    private void openBaidu(){  
        try {  
            if (isInstallByread("com.baidu.BaiduMap")) {  
                Intent intent = new Intent(); 
                //Ϊintent��������
                intent.setData(Uri.parse("baidumap://map/"
                +"&mode=transit&sy=0&index=0&target=1"));  
                intent.setPackage("com.baidu.BaiduMap");  
                startActivity(intent); // ��������  
            } else {  
                Toast.makeText(MapActivity.this, "û�а�װ�ٶȵ�ͼ�ͻ��ˣ��������ظõ�ͼӦ��", Toast.LENGTH_SHORT).show();  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
    
    //�ڸ��ļ��л�ȡ�����ļ�����ӵİٶȵ�ͼ������Լ��ٶȵ�ͼ���������õ�ͼ����Ϊ��ͨ��ͼ
    //�����������ö�λ��Ϊ�����У�����帲�������ڱ������λ�á�
    private void init(){
    	mMapView=(MapView)findViewById(R.id.bmapview); // ��ȡ�ٶȵ�ͼ���
    	//mMapView.setBuiltInZoomControls(true);  
    	mBaiduMap=mMapView.getMap(); // ��ȡ�ٶȵ�ͼ����
    	mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);  //��ͨ��ͼ
    	
    	// ��λ
    	//�趨���ĵ�����
    	//location.getLatitude(), location.getLongitude() ��ȡ��γ��
    	//LatLng ����������Ϣ
    	LatLng cenpt=new LatLng(location.getLatitude(), location.getLongitude());
    	//�����ͼ״̬
    	MapStatus mMapStatus=new MapStatus.Builder().target(cenpt).zoom(15).build();
    	//����MapStatusUpdate�����Ա�������ͼ״̬��Ҫ�����ı仯��
    	MapStatusUpdate mMapStatusUpdate=MapStatusUpdateFactory.newMapStatus(mMapStatus);
    	//�ı��ͼ״̬
    	mBaiduMap.setMapStatus(mMapStatusUpdate);
    	// ------------------------------
    	//����maker�����
    	//��1����Ҫ����һ��LatLng���󣬸ö������ڱ��渲�����λ�����ꡣ
    	LatLng point=new LatLng(location.getLatitude(), location.getLongitude());
    	//����makerͼ��
    	BitmapDescriptor bitmap=BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher);
    	//����MarkerOption�������ڵ�ͼ�����marker
    	OverlayOptions option =new MarkerOptions().position(point).icon(bitmap);
    	//�ڵ�ͼ�����marker������ʾ
    	mBaiduMap.addOverlay(option);	
    }
    
    private void jingweidu(){
    	//��ϵͳ�����л�ȡλ�÷���Ȼ�����λ����Ϣ���������ı�������ʾ��γ������
        StringBuilder sb =new StringBuilder() ;// ʹ��StringBuilder ��������
        
        //���λ�÷���
        LocationManager manager=(LocationManager) getSystemService(LOCATION_SERVICE);
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,10000, 2, new LocationListener() {		
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO �Զ����ɵķ������				
			}
			
			@Override
			public void onProviderEnabled(String provider) {
				// TODO �Զ����ɵķ������			
			}
			
			@Override
			public void onProviderDisabled(String provider) {
				// TODO �Զ����ɵķ������				
			}
			
			@Override
			public void onLocationChanged(Location location) {
				// TODO �Զ����ɵķ������			
			}
		});
        
        location =manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(location!=null){
        	sb.append("ά�ȣ�"+location.getLatitude()+"\n");
        	sb.append("���ȣ�"+location.getLongitude()+"\n");
        }else{
        	sb.append("location is null~");
        }
        
        //��ȡ�ı��ؼ�
     //   TextView text=(TextView) findViewById(R.id.location);
     //   text.setText(sb.toString()); //���û�ȡ���
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
    	// TODO �Զ����ɵķ������
    	super.onResume();
    	mMapView.onResume();
    }
    
    @Override
    protected void onPause() {
    	// TODO �Զ����ɵķ������
    	super.onPause();
    	mMapView.onPause();
    }
    
    @Override
    protected void onDestroy() {
    	// TODO �Զ����ɵķ������
    	super.onDestroy();
    	mMapView.onDestroy();
    }
}
