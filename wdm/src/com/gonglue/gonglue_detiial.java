package com.gonglue;

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

public class gonglue_detiial extends Activity{
	
	WebView webView;
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.gonglue_detiial);
	        
	        if (android.os.Build.VERSION.SDK_INT > 9) {
	            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	            StrictMode.setThreadPolicy(policy);
	        }
	        
	        webView=(WebView) findViewById(R.id.webview_gonglue);
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
	        webView.getSettings().setDisplayZoomControls(false); //����webview���Ű�ť
	        //����ʹ�û���
    		webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    		
	        Intent intent=getIntent();  //��ȡintent����
	        Bundle bundle=intent.getExtras();  //��ȡ���ݵ����ݰ�
	        
	        switch(bundle.getInt("index")){
        	case 1: //ʮһ����ȥ���� ������̶�񻶰�
        		 initWebView() ;
        		 webView.loadUrl("http://www.lvmama.com/lvyou/guide/2016-0918-202726.html");	   		
				break;
			case 2://�������ǻ�ǧ��һ���Σ�CSҰս+Ұ��+�ų�+�ϳ�β��̲��
				 initWebView() ;
				 webView.loadUrl("http://www.lvmama.com/lvyou/guide/2016-0813-202441.html");
				break;
			case 3: //Ѱ�����ڵ����������ǻ�ǧ��һ����
				 initWebView() ;
				 webView.loadUrl("http://www.lvmama.com/lvyou/guide/2016-0808-202378.html");
				break;
			case 4: //�����ͻ�+�ų�+��������+����+�ϳ�β��̲һ����
				webView.loadUrl("http://www.lvmama.com/lvyou/guide/2016-0724-202173.html");
				initWebView() ;
				//����WebViewĬ��ʹ�õ�������ϵͳĬ�����������ҳ����Ϊ��ʹ��ҳ��WebView��
				break;
			case 5: //�����ܱ�һ����
				 initWebView() ;
				 webView.loadUrl("http://www.lvmama.com/lvyou/guide/2016-0716-202076.html");
				break;
			case 6: //��������֮��
				initWebView() ;
				webView.loadUrl("http://www.lvmama.com/lvyou/guide/2016-0615-201728.html");
				break;
			case 7://���ӻ�����λ����
				initWebView() ;
				webView.loadUrl("http://www.lvmama.com/lvyou/guide/2016-0602-201599.html");
				break;
			case 8: //���ھ���ɽũ���ֵ��տ���ĺܺó�
				initWebView() ;
				webView.loadUrl("http://www.lvmama.com/lvyou/guide/2016-0323-200874.html");
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
