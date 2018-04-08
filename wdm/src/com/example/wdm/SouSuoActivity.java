package com.example.wdm;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.baidu.mapapi.SDKInitializer;


public class SouSuoActivity  extends Activity {
	
		WebView webView;
		
	  @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);			
	        //首先设置不显示系统标题栏，然后再初始化SDK引用的Context全局变量，最后调用init()方法
	        requestWindowFeature(Window.FEATURE_NO_TITLE);//设置不显示标题栏
	        setContentView(R.layout.suosou);
	        
	        webView=(WebView) findViewById(R.id.webview_souosuo);
	        initWebView();
	        loadHtml();
	  	}
	    // webview 载入html
	    private void  loadHtml(){
	    	webView.getSettings().setJavaScriptEnabled(true);//设置JavaScript可用
	    	//允许js显示弹出的对话框
	    	webView.setWebChromeClient(new WebChromeClient());
	    	webView.getSettings().setAllowFileAccess(true);  
	    	webView.getSettings().setDomStorageEnabled(true);//允许DCOM
	    	//加载数据
	    //	webView.loadDataWithBaseURL(null, sb.toString(), "text/html", "utf-8", null);
	    	 webView.loadUrl("https://map.baidu.com/");	
	    }
	    
	    private void initWebView() {  
	        WebSettings ws = webView.getSettings();     
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
