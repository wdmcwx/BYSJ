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
	        webView.getSettings().setJavaScriptEnabled(true);//��������javascript
	        
	        //setWebChromeClient������WebView����Javascript�ĶԻ�����վͼ�꣬��վtitle�����ؽ��ȵ�
	        webView.setWebChromeClient(new WebChromeClient());
	        
	        webView.getSettings().setUseWideViewPort(true); //���ô����ԣ�������������š�
	        //���ÿ���֧������   
	        webView.getSettings().setSupportZoom(true);   
	         //����Ĭ�����ŷ�ʽ�ߴ���far   
	        webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);  
	        //���ó������Ź���   
	        webView.getSettings().setBuiltInZoomControls(true);
	        ////����webview���Ű�ť
	        webView.getSettings().setDisplayZoomControls(false); 
	        //����ʹ�û���
	        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
 		
	        Intent intent=getIntent();  //��ȡintent����
	        Bundle bundle=intent.getExtras();  //��ȡ���ݵ����ݰ�
	        
	        switch(bundle.getInt("index")){
		        case 1://���ڸ��ٴ�Ƶ� 
	     		 initWebView() ;
	     		 webView.loadUrl("http://hotel.mangocity.com/jiudian-30000718.html");	   		
					break;
				case 2://���ں�ả�ù��ʾƵ� 
					 initWebView() ;
					 webView.loadUrl("http://hotel.mangocity.com/jiudian-30172883.html");
					break;
				case 3: //������ˮɽ�Ƶ� 
					 initWebView() ;
					 webView.loadUrl("http://hotel.mangocity.com/jiudian-30171175.html");
					break;
				case 4: //���ڱ��������ʴ�Ƶ� 
					webView.loadUrl("http://hotel.mangocity.com/jiudian-30073248.html");
					initWebView() ;
					//����WebViewĬ��ʹ�õ�������ϵͳĬ�����������ҳ����Ϊ��ʹ��ҳ��WebView��
					break;
				case 5: //��������˹�;�Ƶ�
					 initWebView() ;
					 webView.loadUrl("http://hotel.mangocity.com/jiudian-30005920.html");
					break;
				case 6: //��������Ƶ�
					initWebView() ;
					webView.loadUrl("http://hotel.mangocity.com/jiudian-30000831.html");
					break;
				case 7://�����Ǻ���˼�����پƵ�
					initWebView() ;
					webView.loadUrl("http://hotel.mangocity.com/jiudian-30171786.html");
					break;
				case 8: //���ڹ������ȼپƵ�
					initWebView() ;
					webView.loadUrl("http://hotel.mangocity.com/jiudian-70266.html");
					break;
	        }
	  }
	 
	 private void initWebView() {  
	        WebSettings ws = webView.getSettings();   
	        ws.setJavaScriptEnabled(true);  
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
