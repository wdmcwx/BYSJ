package com.meishi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.example.wdm.R;
import com.example.wdm.R.layout;


import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Window;

public class meishi extends Activity {
		//√¿ ≥
			Document document_meishi;
			Element div_meishi ;
		 @Override
		    protected void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        requestWindowFeature(Window.FEATURE_NO_TITLE);
		        setContentView(R.layout.meishi);
		        
		        if (android.os.Build.VERSION.SDK_INT > 9) {
		            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		            StrictMode.setThreadPolicy(policy);
		        }
		        
		        
		        try {
					document_meishi= Jsoup.connect("http://www.lvmama.com/lvyou/food/d-shenzhen231.html").timeout(60000).get();
		        } catch (Exception e) {
					// TODO ◊‘∂Ø…˙≥…µƒ catch øÈ
					e.printStackTrace();
				}
		        div_meishi=document_meishi.getElementById("elite_trip");
		        //√¿ ≥
		         meishi(); 
		 }
		 
		   public void meishi(){
		    	 first_meishi();
		          second_meishi();
		          three_meishi();
		          four_meishi();
		          five_meishi();
		          six_meishi();
		          sevent_meishi();
		          eighth_meishi();   
		    }

			public void first_meishi(){
				Element dl=div_meishi.selectFirst("dl");
				Element img=dl.selectFirst("dt").selectFirst("a").selectFirst("img");
				//Õº∆¨
				String str_img=img.attr("src");
				Log.i("str_img------------:",str_img);
				//Toast.makeText(MainActivity.this, str_img, Toast.LENGTH_LONG).show();
				Element detail_dd=dl.selectFirst("dd");
				Element title=detail_dd.selectFirst("div.title").selectFirst("a");
				//≤À√˚
				String str_title=title.text();
				Log.i("str_title------------:",str_title);
				//Toast.makeText(MainActivity.this, str_title, Toast.LENGTH_LONG).show();
				Element ms_box=detail_dd.selectFirst("div.ms-box");
				
				//≤Àœµ
				Element caixi=ms_box.selectFirst("p");
				String str_caixi=caixi.text();
				Log.i("str_caixi------------:",str_caixi);
				//Toast.makeText(MainActivity.this, str_caixi, Toast.LENGTH_LONG).show();
				
				//≤À∆∑ΩÈ…‹
				Element ms_tripInfo=ms_box.select("p").get(1);
				String str_ms_tripInfo=ms_tripInfo.text();
				Log.i("str_ms_tripInfo------------:",str_ms_tripInfo);
				//Toast.makeText(MainActivity.this, str_ms_tripInfo, Toast.LENGTH_LONG).show();		
			}
			public void second_meishi(){
				Element dl=div_meishi.select("dl").get(1);
				Element img=dl.selectFirst("dt").selectFirst("a").selectFirst("img");
				//Õº∆¨
				String str_img=img.attr("src");
				Log.i("str_img------------:",str_img);
				//Toast.makeText(MainActivity.this, str_img, Toast.LENGTH_LONG).show();
				Element detail_dd=dl.selectFirst("dd");
				Element title=detail_dd.selectFirst("div.title").selectFirst("a");
				//≤À√˚
				String str_title=title.text();
				Log.i("str_title------------:",str_title);
				//Toast.makeText(MainActivity.this, str_title, Toast.LENGTH_LONG).show();
				Element ms_box=detail_dd.selectFirst("div.ms-box");
				
				//≤Àœµ
				Element caixi=ms_box.selectFirst("p");
				String str_caixi=caixi.text();
				Log.i("str_caixi------------:",str_caixi);
				//Toast.makeText(MainActivity.this, str_caixi, Toast.LENGTH_LONG).show();
				
				//≤À∆∑ΩÈ…‹
				Element ms_tripInfo=ms_box.select("p").get(1);
				String str_ms_tripInfo=ms_tripInfo.text();
				Log.i("str_ms_tripInfo------------:",str_ms_tripInfo);
				//Toast.makeText(MainActivity.this, str_ms_tripInfo, Toast.LENGTH_LONG).show();	
			}
			public void three_meishi(){
				Element dl=div_meishi.select("dl").get(2);
				Element img=dl.selectFirst("dt").selectFirst("a").selectFirst("img");
				//Õº∆¨
				String str_img=img.attr("src");
				Log.i("str_img------------:",str_img);
				//Toast.makeText(MainActivity.this, str_img, Toast.LENGTH_LONG).show();
				Element detail_dd=dl.selectFirst("dd");
				Element title=detail_dd.selectFirst("div.title").selectFirst("a");
				//≤À√˚
				String str_title=title.text();
				Log.i("str_title------------:",str_title);
				//Toast.makeText(MainActivity.this, str_title, Toast.LENGTH_LONG).show();
				Element ms_box=detail_dd.selectFirst("div.ms-box");
				
				//≤Àœµ
				Element caixi=ms_box.selectFirst("p");
				String str_caixi=caixi.text();
				Log.i("str_caixi------------:",str_caixi);
				//Toast.makeText(MainActivity.this, str_caixi, Toast.LENGTH_LONG).show();
				
				//≤À∆∑ΩÈ…‹
				Element ms_tripInfo=ms_box.select("p").get(1);
				String str_ms_tripInfo=ms_tripInfo.text();
				Log.i("str_ms_tripInfo------------:",str_ms_tripInfo);
				//Toast.makeText(MainActivity.this, str_ms_tripInfo, Toast.LENGTH_LONG).show();	
			}
			public void four_meishi(){
				Element dl=div_meishi.select("dl").get(3);
				Element img=dl.selectFirst("dt").selectFirst("a").selectFirst("img");
				//Õº∆¨
				String str_img=img.attr("src");
				Log.i("str_img------------:",str_img);
				//Toast.makeText(MainActivity.this, str_img, Toast.LENGTH_LONG).show();
				Element detail_dd=dl.selectFirst("dd");
				Element title=detail_dd.selectFirst("div.title").selectFirst("a");
				//≤À√˚
				String str_title=title.text();
				Log.i("str_title------------:",str_title);
				//Toast.makeText(MainActivity.this, str_title, Toast.LENGTH_LONG).show();
				Element ms_box=detail_dd.selectFirst("div.ms-box");
				
				//≤Àœµ
				Element caixi=ms_box.selectFirst("p");
				String str_caixi=caixi.text();
				Log.i("str_caixi------------:",str_caixi);
				//Toast.makeText(MainActivity.this, str_caixi, Toast.LENGTH_LONG).show();
				
				//≤À∆∑ΩÈ…‹
				Element ms_tripInfo=ms_box.select("p").get(1);
				String str_ms_tripInfo=ms_tripInfo.text();
				Log.i("str_ms_tripInfo------------:",str_ms_tripInfo);
				//Toast.makeText(MainActivity.this, str_ms_tripInfo, Toast.LENGTH_LONG).show();	
			}
			public void five_meishi(){
				Element dl=div_meishi.select("dl").get(4);
				Element img=dl.selectFirst("dt").selectFirst("a").selectFirst("img");
				//Õº∆¨
				String str_img=img.attr("src");
				Log.i("str_img------------:",str_img);
				//Toast.makeText(MainActivity.this, str_img, Toast.LENGTH_LONG).show();
				Element detail_dd=dl.selectFirst("dd");
				Element title=detail_dd.selectFirst("div.title").selectFirst("a");
				//≤À√˚
				String str_title=title.text();
				Log.i("str_title------------:",str_title);
				//Toast.makeText(MainActivity.this, str_title, Toast.LENGTH_LONG).show();
				Element ms_box=detail_dd.selectFirst("div.ms-box");
				
				//≤Àœµ
				Element caixi=ms_box.selectFirst("p");
				String str_caixi=caixi.text();
				Log.i("str_caixi------------:",str_caixi);
				//Toast.makeText(MainActivity.this, str_caixi, Toast.LENGTH_LONG).show();
				
				//≤À∆∑ΩÈ…‹
				Element ms_tripInfo=ms_box.select("p").get(1);
				String str_ms_tripInfo=ms_tripInfo.text();
				Log.i("str_ms_tripInfo------------:",str_ms_tripInfo);
				//Toast.makeText(MainActivity.this, str_ms_tripInfo, Toast.LENGTH_LONG).show();	
			}
			public void six_meishi(){
				Element dl=div_meishi.select("dl").get(5);
				Element img=dl.selectFirst("dt").selectFirst("a").selectFirst("img");
				//Õº∆¨
				String str_img=img.attr("src");
				Log.i("str_img------------:",str_img);
				//Toast.makeText(MainActivity.this, str_img, Toast.LENGTH_LONG).show();
				Element detail_dd=dl.selectFirst("dd");
				Element title=detail_dd.selectFirst("div.title").selectFirst("a");
				//≤À√˚
				String str_title=title.text();
				Log.i("str_title------------:",str_title);
				//Toast.makeText(MainActivity.this, str_title, Toast.LENGTH_LONG).show();
				Element ms_box=detail_dd.selectFirst("div.ms-box");
				
				//≤Àœµ
				Element caixi=ms_box.selectFirst("p");
				String str_caixi=caixi.text();
				Log.i("str_caixi------------:",str_caixi);
				//Toast.makeText(MainActivity.this, str_caixi, Toast.LENGTH_LONG).show();
				
				//≤À∆∑ΩÈ…‹
				Element ms_tripInfo=ms_box.select("p").get(1);
				String str_ms_tripInfo=ms_tripInfo.text();
				Log.i("str_ms_tripInfo------------:",str_ms_tripInfo);
				//Toast.makeText(MainActivity.this, str_ms_tripInfo, Toast.LENGTH_LONG).show();	
			}
			public void sevent_meishi(){
				Element dl=div_meishi.select("dl").get(6);
				Element img=dl.selectFirst("dt").selectFirst("a").selectFirst("img");
				//Õº∆¨
				String str_img=img.attr("src");
				Log.i("str_img------------:",str_img);
				//Toast.makeText(MainActivity.this, str_img, Toast.LENGTH_LONG).show();
				Element detail_dd=dl.selectFirst("dd");
				Element title=detail_dd.selectFirst("div.title").selectFirst("a");
				//≤À√˚
				String str_title=title.text();
				Log.i("str_title------------:",str_title);
				//Toast.makeText(MainActivity.this, str_title, Toast.LENGTH_LONG).show();
				Element ms_box=detail_dd.selectFirst("div.ms-box");
				
				//≤Àœµ
				Element caixi=ms_box.selectFirst("p");
				String str_caixi=caixi.text();
				Log.i("str_caixi------------:",str_caixi);
				//Toast.makeText(MainActivity.this, str_caixi, Toast.LENGTH_LONG).show();
				
				//≤À∆∑ΩÈ…‹
				Element ms_tripInfo=ms_box.select("p").get(1);
				String str_ms_tripInfo=ms_tripInfo.text();
				Log.i("str_ms_tripInfo------------:",str_ms_tripInfo);
				//Toast.makeText(MainActivity.this, str_ms_tripInfo, Toast.LENGTH_LONG).show();	
			}
			public void eighth_meishi(){
				Element dl=div_meishi.select("dl").get(7);
				Element img=dl.selectFirst("dt").selectFirst("a").selectFirst("img");
				//Õº∆¨
				String str_img=img.attr("src");
				Log.i("str_img------------:",str_img);
				//Toast.makeText(MainActivity.this, str_img, Toast.LENGTH_LONG).show();
				Element detail_dd=dl.selectFirst("dd");
				Element title=detail_dd.selectFirst("div.title").selectFirst("a");
				//≤À√˚
				String str_title=title.text();
				Log.i("str_title------------:",str_title);
				//Toast.makeText(MainActivity.this, str_title, Toast.LENGTH_LONG).show();
				Element ms_box=detail_dd.selectFirst("div.ms-box");
				
				//≤Àœµ
				Element caixi=ms_box.selectFirst("p");
				String str_caixi=caixi.text();
				Log.i("str_caixi------------:",str_caixi);
				//Toast.makeText(MainActivity.this, str_caixi, Toast.LENGTH_LONG).show();
				
				//≤À∆∑ΩÈ…‹
				Element ms_tripInfo=ms_box.select("p").get(1);
				String str_ms_tripInfo=ms_tripInfo.text();
				Log.i("str_ms_tripInfo------------:",str_ms_tripInfo);
				//Toast.makeText(MainActivity.this, str_ms_tripInfo, Toast.LENGTH_LONG).show();	
			}
}
