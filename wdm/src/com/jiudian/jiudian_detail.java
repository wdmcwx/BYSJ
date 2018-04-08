package com.jiudian;

import com.example.wdm.R;
import com.example.wdm.R.id;
import com.example.wdm.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class jiudian_detail extends Activity{
	WebView webView;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.jiudain_detail);
	        
	        if (android.os.Build.VERSION.SDK_INT > 9) {
	            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	            StrictMode.setThreadPolicy(policy);
	        }
	        
	        webView=(WebView) findViewById(R.id.webview_jiudain);
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
	        ////隐藏webview缩放按钮
	        webView.getSettings().setDisplayZoomControls(false); 
	        //优先使用缓存
	        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
 		
	        Intent intent=getIntent();  //获取intent对象
	        Bundle bundle=intent.getExtras();  //获取传递的数据包
	        
	        switch(bundle.getInt("index")){
		        case 1://深圳富临大酒店 
	     		 initWebView() ;
	     		 webView.loadUrl("http://hotel.mangocity.com/jiudian-30000718.html");	   		
					break;
				case 2://深圳恒丰海悦国际酒店 
					 initWebView() ;
					 webView.loadUrl("http://hotel.mangocity.com/jiudian-30172883.html");
					break;
				case 3: //深圳求水山酒店 
					 initWebView() ;
					 webView.loadUrl("http://hotel.mangocity.com/jiudian-30171175.html");
					break;
				case 4: //深圳宝利来国际大酒店 
					webView.loadUrl("http://hotel.mangocity.com/jiudian-30073248.html");
					initWebView() ;
					//覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
					break;
				case 5: //深圳威尼斯睿途酒店
					 initWebView() ;
					 webView.loadUrl("http://hotel.mangocity.com/jiudian-30005920.html");
					break;
				case 6: //深圳阳光酒店
					initWebView() ;
					webView.loadUrl("http://hotel.mangocity.com/jiudian-30000831.html");
					break;
				case 7://深圳星河丽思卡尔顿酒店
					initWebView() ;
					webView.loadUrl("http://hotel.mangocity.com/jiudian-30171786.html");
					break;
				case 8: //深圳观澜湖度假酒店
					initWebView() ;
					webView.loadUrl("http://hotel.mangocity.com/jiudian-70266.html");
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
}
