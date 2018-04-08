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
	
	//------�ֲ�ͼ--start----
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
    
	//��дһ��onCreateView()�������������Fragment�Ĳ���
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle saveInstanceState){
		view = inflater.inflate(R.layout.f1, null);
		return view;	
	}
	
	 public void onActivityCreated(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        initView(); //��ȡ�ؼ�    
	        setOnclickByZJ(); //����¼�����	
	        lunbotu(); //�ֲ�ͼ
	 }
	 
	 //��ʼ���ؼ�
	 private void initView(){
		 viewFlipper = (ViewFlipper) view.findViewById(R.id.details1);
	  
	     jingdian = (TextView)view.findViewById(R.id.jingdian1);
	     tianqi=(TextView)view.findViewById(R.id.tianqi1);
	     jiudian=(TextView)view.findViewById(R.id.jiudian1);
	     gonglue=(TextView)view.findViewById(R.id.gonglue1);
	     luxian=(TextView)view.findViewById(R.id.luxian1);
	     
//	     //������Ļ��С
	     Display display = getActivity().getWindowManager().getDefaultDisplay();
	     int width = display.getWidth();
	     int height=display.getHeight();
	     
	     //��̬����viewFlipper�ĸ߶�
	     LinearLayout.LayoutParams linearParams =(LinearLayout.LayoutParams) viewFlipper.getLayoutParams(); //ȡ�ؼ�viewFlipper��ǰ�Ĳ��ֲ���  
	     linearParams.height = height/3;// �ؼ��ĸ�ǿ�����20          
	     viewFlipper.setLayoutParams(linearParams); //ʹ���úõĲ��ֲ���Ӧ�õ��ؼ�</pre>  
	 }
	 
	 //��Ӷ���¼�����
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
				// TODO �Զ����ɵķ������
				 // ʵ��ҳ����ת
            	Intent intent =new Intent(getActivity(),MapActivity.class);
            	startActivity(intent);
			}
		});
		gonglue.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
			//	Intent intent=new Intent(getActivity(),gonglue.class);
				Intent intent=new Intent(getActivity(),test.class);
				startActivity(intent);
			}
		});
		jiudian.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				Intent intent=new Intent(getActivity(),jiudian_search.class);
				startActivity(intent);
			}
		});
		 
	 }
	
	 
	//  ----------�ֲ�ͼ start---------------- 
	    private void lunbotu(){
	   	 viewFlipper = (ViewFlipper)view.findViewById(R.id.details1);
	    
	      //��int������������������Ƭ�ı��
	        int image[] = new int[]{
	                    R.drawable.abc,R.drawable.dd,R.drawable.bbccjpg
	                };
	      //  ViewPaperͨ�׵�˵������һ��װҳ������� 
	      //��������Ƭ����viewflipper��
	        for(int i=0;i<image.length;i++){
	            ImageView iv = new ImageView(getActivity().getApplicationContext());
	            iv.setBackgroundResource(image[i]);
	            iv.setScaleType(ScaleType.CENTER_INSIDE);//��������ͼƬ�任��ʽ
	            iv.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
	            
	            viewFlipper.addView(iv);
	        }

	        handler.sendMessageDelayed(new Message(), 5000);
	       
	        
	   //     ��ViewFlipper���ü����¼����������Ʋ����ĺ��ģ���ע�⣬����ļ�������onclicklistener,����ontouchlistener
	        viewFlipper.setOnTouchListener(new OnTouchListener() {
	              
	            @SuppressLint("ClickableViewAccessibility")
	            @Override
	            public boolean onTouch(View v, MotionEvent event) {
	                // TODO Auto-generated method stub
	                 
	                switch(event.getAction()){
		                case MotionEvent.ACTION_DOWN:////��ָ����
		                {   x = event.getX();  //ȫ�ֱ��������հ����ǵ���ָ����                 
		               //     Toast.makeText(getApplicationContext(), "down"+event.getX(), 1).show();
		                }break;
		                case MotionEvent.ACTION_UP: //��ָ�ɿ�
		                {   
		                    y = event.getX();   //ȫ�ֱ����������ɿ��ǵ���ָ����     
		                  //������Ǽ򵥵��߼��жϣ��Ӷ��������󻬡����һ��Լ�������Ҳ���ǵ���¼���
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
	   
		   //handler���ƣ���ʵ�Ͷ�ʱ����ࣨ�����������ǣ�
		   private Handler handler = new Handler(){
		       @Override
		       public void handleMessage(Message msg){
		           super.handleMessage(msg);
		           showNext();        
		           handler.sendMessageDelayed(new Message(), 5000);
		       }		            
		   };
		  // Ȼ����ͼƬ�л�������Ҳ�����϶δ����е�showPre()��showNext()��showDetail()���������÷ֱ������󻬡����һ��������������������ʵ�ֵ���¼����������£�
		   private void showNext(){
		       viewFlipper.showNext();//sdk��װ�õģ�ʹ�÷ǳ�����
		       int cur = viewFlipper.getDisplayedChild();    
		   
		   }
		   private void showPre(){
		       viewFlipper.showPrevious();
		       int cur = viewFlipper.getDisplayedChild();    
		    
		   }
		   
		   private void showDetail() {
		 //viewFlipper.getDisplayedChild(),����ʾ��ǰ��ʾͼƬ��intֵ 
		   //  Toast.makeText(getActivity(),viewFlipper.getDisplayedChild()+"", 1).show();
			   final Intent intent=new Intent(getActivity(),lunbo.class);
			   final Bundle bundle=new Bundle();
			   
			   switch(viewFlipper.getDisplayedChild()){
			  	case 0:	
			  		viewFlipper.getCurrentView().setOnClickListener(new OnClickListener() {  
		                @Override  
		                public void onClick(View arg0) {  
		                  //�������ȳ�
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
		                	//����֮��
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
		                	//õ�庣��
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
		    
		   //-------�ֲ�ͼ end--------------
}
