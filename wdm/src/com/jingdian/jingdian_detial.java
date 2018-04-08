package com.jingdian;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.example.wdm.R;
import com.example.wdm.R.id;
import com.example.wdm.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class jingdian_detial extends Activity{
	
	WebView webView;
	
	double nLenStart = 0;  
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.jingdian_detail);
	        
	        if (android.os.Build.VERSION.SDK_INT > 9) {
	            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	            StrictMode.setThreadPolicy(policy);
	        } 
	        
	        webView=(WebView) findViewById(R.id.webview_jingdian);
	        webView.getSettings().setJavaScriptEnabled(true);//允许运行javascript
	        
	        //setWebChromeClient：辅助WebView处理Javascript的对话框，网站图标，网站title，加载进度等
	        webView.setWebChromeClient(new WebChromeClient());
	        
	        webView.getSettings().setUseWideViewPort(true); //设置此属性，可任意比例缩放。
	        //设置可以支持缩放   
	        webView.getSettings().setSupportZoom(true);   
	         //设置默认缩放方式尺寸是far   
	        webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);  
	        //设置出现缩放工具   
	        webView.getSettings().setBuiltInZoomControls(true);
	        webView.getSettings().setDisplayZoomControls(false); //隐藏webview缩放按钮
	        //优先使用缓存
    		webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    		
	        Intent intent=getIntent();  //获取intent对象
	        Bundle bundle=intent.getExtras();  //获取传递的数据包
	        
	      //  bundle.getInt("index");
			//指定要加载的网页
		//	webview.loadUrl("http://127.0.0.1:8080/wdm/index.jsp");
	        switch(bundle.getInt("index")){
	        	case 1: //世界之窗
	        		 initWebView() ;
	        		 webView.loadUrl("http://ticket.lvmama.com/scenic-105140");	   		
					break;
				case 2://东部华侨城
					//Toast.makeText(jingdian.this, 2+"", 1).show();
					 initWebView() ;
					 webView.loadUrl("http://ticket.lvmama.com/scenic-122400");
					break;
				case 3: //锦绣中华
				//	Toast.makeText(jingdian.this,3+"", 1).show();
					 initWebView() ;
					 webView.loadUrl("http://ticket.lvmama.com/scenic-173304");
					break;
				case 4: //青青世界
					//Toast.makeText(jingdian.this, 4+"", 1).show();
					webView.loadUrl("http://ticket.lvmama.com/scenic-109610");
					initWebView() ;
					//覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
					break;
				case 5: //深圳欢乐谷
				//	Toast.makeText(jingdian.this, position+","+id, 1).show();
					 initWebView() ;
					 webView.loadUrl("http://ticket.lvmama.com/scenic-104960");
					break;
				case 6: //深圳野生动物园
				//	Toast.makeText(jingdian.this, position+","+id, 1).show();
					initWebView() ;
					webView.loadUrl("http://ticket.lvmama.com/scenic-109718");
					break;
				case 7://观澜山水田园
					//Toast.makeText(jingdian.this, position+","+id, 1).show();
					initWebView() ;
					webView.loadUrl("http://ticket.lvmama.com/scenic-159249");
					break;
				case 8: //海上田园
					//Toast.makeText(jingdian.this, position+","+id, 1).show();
					initWebView() ;
					webView.loadUrl("http://ticket.lvmama.com/scenic-100051");
					break;
	        }
	 	}
	 
	   private void initWebView() {  
	        WebSettings ws = webView.getSettings();   
	        ws.setJavaScriptEnabled(true);  
	        //setWebClient：主要处理解析，渲染网页等浏览器做的事情
	        webView.setWebViewClient(new WebViewClient(){  
	            @Override  
	            public boolean shouldOverrideUrlLoading(WebView view, String url) {  
	                view.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);  
	                view.loadUrl(url);  
	                return super.shouldOverrideUrlLoading(view, url);  
	            }
	        });  
	    } 
	// 如果希望浏览的网页后退而不是退出浏览器，需要WebView覆盖URL加载，让它自动生成历史访问记录，那样就可以通过前进或后退访问已访问过的站点。
	//改写物理按键——返回的逻辑
		 @Override
		 public boolean onKeyDown(int keyCode, KeyEvent event)
		 {
		     if(keyCode==KeyEvent.KEYCODE_BACK){
		         if(webView.canGoBack()){
		             webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		             webView.goBack();
		             return true;
		         }else {
		             finish();
		             return true;
		         }
		     }
		     return false;
		 }
	    
	   //在android上实现手势放大缩小功能 
	    @Override  
	    public boolean onTouchEvent(MotionEvent event) {      
	                  
	        int nCnt = event.getPointerCount();  	          
	        int n = event.getAction();  
	        
	        if( (event.getAction()&MotionEvent.ACTION_MASK) == MotionEvent.ACTION_POINTER_DOWN && 2 == nCnt)//<span style="color:#ff0000;">2表示两个手指</span>  
	        {  
	                      
	            for(int i=0; i< nCnt; i++)  {  
	                float x = event.getX(i);  
	                float y = event.getY(i);  
	                  
	                Point pt = new Point((int)x, (int)y);  	      
	            }  
	              
	            int xlen = Math.abs((int)event.getX(0) - (int)event.getX(1));  
	            int ylen = Math.abs((int)event.getY(0) - (int)event.getY(1));  
	              
	            nLenStart = Math.sqrt((double)xlen*xlen + (double)ylen * ylen);       	              
	        }else if( (event.getAction()&MotionEvent.ACTION_MASK) == MotionEvent.ACTION_POINTER_UP  && 2 == nCnt)   {  
	              
	            for(int i=0; i< nCnt; i++){  
	                float x = event.getX(i);  
	                float y = event.getY(i);  	                  
	                Point pt = new Point((int)x, (int)y);  
	            }  
	              
	            int xlen = Math.abs((int)event.getX(0) - (int)event.getX(1));  
	            int ylen = Math.abs((int)event.getY(0) - (int)event.getY(1));  
	              
	            double nLenEnd = Math.sqrt((double)xlen*xlen + (double)ylen * ylen);  
	          //通过两个手指开始距离和结束距离，来判断放大缩小  
	            if(nLenEnd > nLenStart){  
	                Toast.makeText(getApplicationContext(), "放大", 3000).show();  
	            }else{  
	                Toast.makeText(getApplicationContext(), "缩小", 3000).show();  
	            }  
	        }  
	        return super.onTouchEvent(event);  
	    }  
}
