package com.example.wdm;


import com.gonglue.test;

import com.jingdian.jingdian_search;

import com.jiudian.jiudian_search;
import com.map.MapActivity;

import weather.WeatherActivity;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;

import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.TextView;

import android.widget.ViewFlipper;
import android.widget.ImageView.ScaleType;

public class Fragment1 extends Fragment {
	
	//------轮播图--start----
	private ViewFlipper viewFlipper;
    private String[] titles;
    private TextView tv_title;

    float startx;
    float x = 0;
    float y = 0;
   //--------end-------------------
    
    TextView  jingdian;
    TextView  luxian;
    TextView  jiudian;
    TextView  tianqi;
    TextView  gonglue;
    View view=null;
    
	//重写一个onCreateView()方法来返回这个Fragment的布局
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle saveInstanceState){
		view = inflater.inflate(R.layout.f1, null);
		return view;	
	}
	
	 public void onActivityCreated(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        initView(); //获取控件    
	        setOnclickByZJ(); //多个事件监听	
	        lunbotu(); //轮播图
	 }
	 
	 //初始化控件
	 private void initView(){
		 viewFlipper = (ViewFlipper) view.findViewById(R.id.details1);
	  
	     jingdian = (TextView)view.findViewById(R.id.jingdian1);
	     tianqi=(TextView)view.findViewById(R.id.tianqi1);
	     jiudian=(TextView)view.findViewById(R.id.jiudian1);
	     gonglue=(TextView)view.findViewById(R.id.gonglue1);
	     luxian=(TextView)view.findViewById(R.id.luxian1);
	     
//	     //计算屏幕大小
	     Display display = getActivity().getWindowManager().getDefaultDisplay();
	     int width = display.getWidth();
	     int height=display.getHeight();
	     
	     //动态设置viewFlipper的高度
	     LinearLayout.LayoutParams linearParams =(LinearLayout.LayoutParams) viewFlipper.getLayoutParams(); //取控件viewFlipper当前的布局参数  
	     linearParams.height = height/3;// 控件的高强制设成20          
	     viewFlipper.setLayoutParams(linearParams); //使设置好的布局参数应用到控件</pre>  
	 }
	 
	 //添加多个事件监听
	 private void setOnclickByZJ() {

	    jingdian.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(),jingdian_search.class);
				startActivity(intent);
			}
		 });
		 
		tianqi.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
			//	Toast.makeText(getActivity(), "1111", Toast.LENGTH_LONG).show();
				Intent intent=new Intent(getActivity(),WeatherActivity.class);
				startActivity(intent);
			}
		});
  
		luxian.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				 // 实现页面跳转
            	Intent intent =new Intent(getActivity(),MapActivity.class);
            	startActivity(intent);
			}
		});
		gonglue.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
			//	Intent intent=new Intent(getActivity(),gonglue.class);
				Intent intent=new Intent(getActivity(),test.class);
				startActivity(intent);
			}
		});
		jiudian.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent(getActivity(),jiudian_search.class);
				startActivity(intent);
			}
		});
		 
	 }
	
	 
	//  ----------轮播图 start---------------- 
	    private void lunbotu(){
	   	 viewFlipper = (ViewFlipper)view.findViewById(R.id.details1);
	    
	      //用int型数组来储存三张照片的编号
	        int image[] = new int[]{
	                    R.drawable.abc,R.drawable.dd,R.drawable.bbccjpg
	                };
	      //  ViewPaper通俗的说，它是一个装页面的容器 
	      //将三张照片加入viewflipper里
	        for(int i=0;i<image.length;i++){
	            ImageView iv = new ImageView(getActivity().getApplicationContext());
	            iv.setBackgroundResource(image[i]);
	            iv.setScaleType(ScaleType.CENTER_INSIDE);//这里设置图片变换格式
	            iv.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
	            
	            viewFlipper.addView(iv);
	        }

	        handler.sendMessageDelayed(new Message(), 5000);
	       
	        
	   //     对ViewFlipper设置监听事件（进行手势操作的核心），注意，这里的监听不是onclicklistener,而是ontouchlistener
	        viewFlipper.setOnTouchListener(new OnTouchListener() {
	              
	            @SuppressLint("ClickableViewAccessibility")
	            @Override
	            public boolean onTouch(View v, MotionEvent event) {
	                // TODO Auto-generated method stub
	                 
	                switch(event.getAction()){
		                case MotionEvent.ACTION_DOWN:////手指按下
		                {   x = event.getX();  //全局变量，接收按下是的手指坐标                 
		               //     Toast.makeText(getApplicationContext(), "down"+event.getX(), 1).show();
		                }break;
		                case MotionEvent.ACTION_UP: //手指松开
		                {   
		                    y = event.getX();   //全局变量，接收松开是的手指坐标     
		                  //下面就是简单的逻辑判断，从而区分向左滑、向右滑以及不滑（也就是点击事件）
		                    if(y>x){
		                        Log.v(null, "result:y>x");
		                        showPre();
		                         
		                    } else if(x==y){
		                        Log.v(null, "result:y=x");                 
		                        showDetail();
		                    } else {
		                        Log.v(null, "result:x>y");                      
		                        showNext();
		                    }                  
		                } break;            
	                }              
	                return true;
	            }
	        });

	        
	   }
	   
		   //handler机制，其实和定时器差不多（至少在这里是）
		   private Handler handler = new Handler(){
		       @Override
		       public void handleMessage(Message msg){
		           super.handleMessage(msg);
		           showNext();        
		           handler.sendMessageDelayed(new Message(), 5000);
		       }		            
		   };
		  // 然后是图片切换动作，也就是上段代码中的showPre()、showNext()、showDetail()方法。作用分别是向左滑、向右滑、不滑（这里可以用来实现点击事件）代码如下：
		   private void showNext(){
		       viewFlipper.showNext();//sdk封装好的，使用非常方便
		       int cur = viewFlipper.getDisplayedChild();    
		   
		   }
		   private void showPre(){
		       viewFlipper.showPrevious();
		       int cur = viewFlipper.getDisplayedChild();    
		    
		   }
		   
		   private void showDetail() {
		 //viewFlipper.getDisplayedChild(),是显示当前显示图片的int值 
		   //  Toast.makeText(getActivity(),viewFlipper.getDisplayedChild()+"", 1).show();
			   final Intent intent=new Intent(getActivity(),lunbo.class);
			   final Bundle bundle=new Bundle();
			   
			   switch(viewFlipper.getDisplayedChild()){
			  	case 0:	
			  		viewFlipper.getCurrentView().setOnClickListener(new OnClickListener() {  
		                @Override  
		                public void onClick(View arg0) {  
		                  //东部华侨城
		                	//http://ticket.lvmama.com/scenic-122400
		                	bundle.putInt("index", 1);
							intent.putExtras(bundle);
							startActivity(intent);
		                }  
		            });  
			  		break;
			  	 case 1:
			  		viewFlipper.getCurrentView().setOnClickListener(new OnClickListener() {  
		                @Override  
		                public void onClick(View arg0) {  
		                    // TODO Auto-generated method stub  
		               //     startActivity(new Intent(getActivity(),jingdian.class));  
		                	//世界之窗
		                    //http://ticket.lvmama.com/scenic-105140
		                    bundle.putInt("index", 2);
							intent.putExtras(bundle);
							startActivity(intent);
		                }  
		            });
			  		break;
			  	 case 2:
			  		viewFlipper.getCurrentView().setOnClickListener(new OnClickListener() {  
		                @Override  
		                public void onClick(View arg0) {  
		                    // TODO Auto-generated method stub  
		               //    startActivity(new Intent(getActivity(),gonglue.class));  
		                	//玫瑰海岸
		                   //http://www.mafengwo.cn/poi/5203413.html
		                   bundle.putInt("index", 3);
						   intent.putExtras(bundle);
						   startActivity(intent);
		                }  
		            }); 
			  		break;	  		
			  } 
			  
		   }
		   
		    @Override
		    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		    	inflater.inflate(R.menu.main, menu);
		        super.onCreateOptionsMenu(menu,inflater);
		    }
		
		    @Override
		    public boolean onOptionsItemSelected(MenuItem item) {
		        // Handle action bar item clicks here. The action bar will
		        // automatically handle clicks on the Home/Up button, so long
		        // as you specify a parent activity in AndroidManifest.xml.
		        int id = item.getItemId();
		        if (id == R.id.action_settings) {
		            return true;
		        }
		        return super.onOptionsItemSelected(item);
		    }
		    
		   //-------轮播图 end--------------
}
