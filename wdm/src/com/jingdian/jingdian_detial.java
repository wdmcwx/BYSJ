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
	        
	      //  bundle.getInt("index");
			//ָ��Ҫ���ص���ҳ
		//	webview.loadUrl("http://127.0.0.1:8080/wdm/index.jsp");
	        switch(bundle.getInt("index")){
	        	case 1: //����֮��
	        		 initWebView() ;
	        		 webView.loadUrl("http://ticket.lvmama.com/scenic-105140");	   		
					break;
				case 2://�������ȳ�
					//Toast.makeText(jingdian.this, 2+"", 1).show();
					 initWebView() ;
					 webView.loadUrl("http://ticket.lvmama.com/scenic-122400");
					break;
				case 3: //�����л�
				//	Toast.makeText(jingdian.this,3+"", 1).show();
					 initWebView() ;
					 webView.loadUrl("http://ticket.lvmama.com/scenic-173304");
					break;
				case 4: //��������
					//Toast.makeText(jingdian.this, 4+"", 1).show();
					webView.loadUrl("http://ticket.lvmama.com/scenic-109610");
					initWebView() ;
					//����WebViewĬ��ʹ�õ�������ϵͳĬ�����������ҳ����Ϊ��ʹ��ҳ��WebView��
					break;
				case 5: //���ڻ��ֹ�
				//	Toast.makeText(jingdian.this, position+","+id, 1).show();
					 initWebView() ;
					 webView.loadUrl("http://ticket.lvmama.com/scenic-104960");
					break;
				case 6: //����Ұ������԰
				//	Toast.makeText(jingdian.this, position+","+id, 1).show();
					initWebView() ;
					webView.loadUrl("http://ticket.lvmama.com/scenic-109718");
					break;
				case 7://����ɽˮ��԰
					//Toast.makeText(jingdian.this, position+","+id, 1).show();
					initWebView() ;
					webView.loadUrl("http://ticket.lvmama.com/scenic-159249");
					break;
				case 8: //������԰
					//Toast.makeText(jingdian.this, position+","+id, 1).show();
					initWebView() ;
					webView.loadUrl("http://ticket.lvmama.com/scenic-100051");
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
	    
	   //��android��ʵ�����ƷŴ���С���� 
	    @Override  
	    public boolean onTouchEvent(MotionEvent event) {      
	                  
	        int nCnt = event.getPointerCount();  	          
	        int n = event.getAction();  
	        
	        if( (event.getAction()&MotionEvent.ACTION_MASK) == MotionEvent.ACTION_POINTER_DOWN && 2 == nCnt)//<span style="color:#ff0000;">2��ʾ������ָ</span>  
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
	          //ͨ��������ָ��ʼ����ͽ������룬���жϷŴ���С  
	            if(nLenEnd > nLenStart){  
	                Toast.makeText(getApplicationContext(), "�Ŵ�", 3000).show();  
	            }else{  
	                Toast.makeText(getApplicationContext(), "��С", 3000).show();  
	            }  
	        }  
	        return super.onTouchEvent(event);  
	    }  
}
