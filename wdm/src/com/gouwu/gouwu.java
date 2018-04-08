package com.gouwu;

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

public class gouwu  extends Activity {
	//����
		Document document_shopping;
		Element div_shopping ;
		 @Override
		    protected void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        requestWindowFeature(Window.FEATURE_NO_TITLE);
		        setContentView(R.layout.activity_main);
		        
		        if (android.os.Build.VERSION.SDK_INT > 9) {
		            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		            StrictMode.setThreadPolicy(policy);
		        }
		        
		        
		        try {
					document_shopping=Jsoup.connect("http://www.lvmama.com/lvyou/shop/d-shenzhen231.html").timeout(60000).get();
		        } catch (Exception e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
		        div_shopping=document_shopping.getElementById("list_sotret");
		        
		        first_shopping();
		 }
		 

			public void first_shopping(){
				Element dl=div_shopping.getElementById("hasbeen_10047305");
				Element img=dl.selectFirst("dt").selectFirst("a").selectFirst("img");
				//ͼƬ
				String str_img=img.attr("src");
				Log.i("str_img---:",str_img);
				Element dd=dl.selectFirst("dd");
				Element title=dd.selectFirst("div.title");
				//����
				String str_title=title.text();
				Log.i("str_title---:",str_title);
				Element addr=dd.selectFirst("div.ms-box").selectFirst("p");
				//��ַ
				String str_addr=addr.text();
				Log.i("str_addr---:",str_addr);
				//�Ƽ���Ʒ
				Element command=dd.selectFirst("div.ms-box").select("p").get(1);
				String str_command=command.text();
				Log.i("str_command---:",str_command);
			}
}
