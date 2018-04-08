package com.example.wdm;

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

public class lunbo extends Activity{
	WebView webView;
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.lunbo);
	        
	        if (android.os.Build.VERSION.SDK_INT > 9) {
	            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	            StrictMode.setThreadPolicy(policy);
	        }
	        
	        webView=(WebView) findViewById(R.id.webview_lunbo);
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
	        
	        switch(bundle.getInt("index")){
		       	case 1:
		       		 initWebView() ;
		       		 webView.loadUrl("http://ticket.lvmama.com/scenic-122400");	   		
						break;
				case 2:
					 initWebView() ;
					 webView.loadUrl("http://ticket.lvmama.com/scenic-105140");
					break;
				case 3:
					 initWebView() ;
					 webView.loadUrl("http://www.mafengwo.cn/poi/5203413.html");
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
