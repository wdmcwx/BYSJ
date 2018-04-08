package com.map;

import com.example.wdm.R;
import com.example.wdm.R.id;
import com.example.wdm.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MapTest extends Activity{
	WebView webview;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.maptest);
        
        webview=(WebView) findViewById(R.id.webview);
        CheckBox ck=(CheckBox) findViewById(R.id.chekbox);
        
        final StringBuilder sb=new StringBuilder();
        
        sb.append("<!DOCTYPE html><html><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /><style type='text/css'>*{margin:0;padding:0;list-style-type:none;}a,img{border:0;}body{font:12px/180% Arial, Helvetica, sans-serif, '新宋体';}.demo{width:850px;margin:20px auto;}#l-map{height:400px;width:600px;float:left;border:1px solid #bcbcbc;}#r-result{height:400px;width:230px;float:right;}</style><script type='text/javascript' src='http://api.map.baidu.com/api?v=1.4'></script></head><body><div class='demo'><p style='height:40px;'>输入城市：<input id='txtCity' type='text'/>  <button  onClick='getPoint()'>获取坐标</button><div id='l-map'></div><div id='r-result'></div></div><script type='text/javascript'>var map = new BMap.Map('l-map');map.centerAndZoom(new BMap.Point(116.404, 39.915), 4);map.enableScrollWheelZoom();var local = new BMap.LocalSearch('全国', {renderOptions: {map: map,panel : 'r-result',autoViewport: true,selectFirstResult: false}});function getPoint(){var city = document.getElementById('txtCity').value;local.search(city); }</script></body></html>");
       
        ck.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO 自动生成的方法存根
				if(isChecked){
					webview.getSettings().setJavaScriptEnabled(true);//允许运行javascript
					webview.setWebChromeClient(new WebChromeClient());
					//指定要加载的网页
				//	webview.loadUrl("http://127.0.0.1:8080/wdm/index.jsp");
				//	webview.loadDataWithBaseURL(null, sb.toString(), "text/html", "utf-8", null);
					webview.loadData(sb.toString(), "text/html", "utf-8");
				}
			}
		});
    }
}
