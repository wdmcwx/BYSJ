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
	        //�������ò���ʾϵͳ��������Ȼ���ٳ�ʼ��SDK���õ�Contextȫ�ֱ�����������init()����
	        requestWindowFeature(Window.FEATURE_NO_TITLE);//���ò���ʾ������
	        setContentView(R.layout.suosou);
	        
	        webView=(WebView) findViewById(R.id.webview_souosuo);
	        initWebView();
	        loadHtml();
	  	}
	    // webview ����html
	    private void  loadHtml(){
	    	webView.getSettings().setJavaScriptEnabled(true);//����JavaScript����
	    	//����js��ʾ�����ĶԻ���
	    	webView.setWebChromeClient(new WebChromeClient());
	    	webView.getSettings().setAllowFileAccess(true);  
	    	webView.getSettings().setDomStorageEnabled(true);//����DCOM
	    	//��������
	    //	webView.loadDataWithBaseURL(null, sb.toString(), "text/html", "utf-8", null);
	    	 webView.loadUrl("https://map.baidu.com/");	
	    }
	    
	    private void initWebView() {  
	        WebSettings ws = webView.getSettings();     
	        //setWebClient����Ҫ�����������Ⱦ��ҳ���������������
	        webView.setWebViewClient(new WebViewClient(){  
	            @Override  
	            public boolean shouldOverrideUrlLoading(WebView view, String url) {  
	                view.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);  
	                view.loadUrl(url);  
	                return super.shouldOverrideUrlLoading(view, url);  
	            }
	        });  
	 } 
	// ���ϣ���������ҳ���˶������˳����������ҪWebView����URL���أ������Զ�������ʷ���ʼ�¼�������Ϳ���ͨ��ǰ������˷����ѷ��ʹ���վ�㡣
	//��д�������������ص��߼�
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
