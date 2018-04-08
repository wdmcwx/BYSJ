package com.servlet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.service.Service;


public class Gonglue_spider {
	
	Element element;
	String[] titles=new String[8]; //用于保存标题
	String[] imgs=new String[8];  //用于保存照片
	String[] author_time=new String[8]; //用于保存作者和发表时间
	String[] profiles=new String[8];  //用于发表简介
	
	public void crawlHtml(String url) throws Exception {
		//获取工具类返回的html,并用Jsoup解析
		String result = AbstractSpider.getResult(url);
		//解析html字符串
		Document document = Jsoup.parse(result);
		//setBaseUri(String baseUri)来指定基URL，否则获取的完整URL只会是空字符串
		document.setBaseUri(url);
		//获取所有的img元素
		element= document.getElementById("new_guide");
		// 使用jsoup爬取信息
		gl();	
		 // 新建服务对象
        Service service=new Service();
       // 调取插入数据库操作 
        for(int i=0;i<titles.length;i++){
        	service.insertGonglue(titles[i],imgs[i],author_time[i],profiles[i]);
        }
        
	}
	
	 public void gl(){
   	    first_gl();
        second_gl(); 
        three_gl();
        four_gl();
        five_gl();
        six_gl();
        seven_gl();
        eighth_gl();
     }
	 public void first_gl(){
	    	Element dl=element.getElementById("guide_elite_202726");
	    	Element img_ele=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
	    	//获取照片
	    	String str_img=img_ele.attr("src");
	    	
	    	Element details=dl.select("dd").get(0);
	    	Element title=details.select("div").get(0).select("a").get(0);
	    	//标题
	    	String str_title=title.text();
	    	
	    	Element anthor_time=details.select("p").get(0);
	    	//作者——发表时间
	    	String str_anthor_time=anthor_time.text();
	    	
	    	//简述
	    	Element profile=details.select("p").get(1);
	    	String str_profile=profile.text();	
	    	
	    	titles[0]=str_title;
	    	imgs[0]=str_img;
	    	author_time[0]=str_anthor_time;
	    	profiles[0]=str_profile;
	    }
	 
	 public void second_gl(){
	    	Element dl=element.getElementById("guide_elite_202441");
	    	Element img_ele=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
	    	//获取照片
	    	String str_img=img_ele.attr("src");
	    
	    	//Toast.makeText(MainActivity.this, str_img, Toast.LENGTH_LONG).show();
	    	
	    	Element details=dl.select("dd").get(0);
	    	Element title=details.select("div").get(0).select("a").get(0);
	    	//标题
	    	String str_title=title.text();
	    
	    	//Toast.makeText(MainActivity.this, str_title, Toast.LENGTH_LONG).show();
	    	Element anthor_time=details.select("p").get(0);
	    	//作者——发表时间
	    	String str_anthor_time=anthor_time.text();
	    	
	    	
	    	//简述
	    	Element profile=details.select("p").get(1);
	    	String str_profile=profile.text();
	    
	    	
	    	titles[1]=str_title;
	    	imgs[1]=str_img;
	    	author_time[1]=str_anthor_time;
	    	profiles[1]=str_profile;
	    }
		public void three_gl(){
			Element dl=element.getElementById("guide_elite_202378");
	    	Element img_ele=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
	    	//获取照片
	    	String str_img=img_ele.attr("src");
	    
	    	//Toast.makeText(MainActivity.this, str_img, Toast.LENGTH_LONG).show();
	    	
	    	Element details=dl.select("dd").get(0);
	    	Element title=details.select("div").get(0).select("a").get(0);
	    	//标题
	    	String str_title=title.text();
	    
	    	//Toast.makeText(MainActivity.this, str_title, Toast.LENGTH_LONG).show();
	    	Element anthor_time=details.select("p").get(0);
	    	//作者——发表时间
	    	String str_anthor_time=anthor_time.text();
	    	
	    	
	    	//简述
	    	Element profile=details.select("p").get(1);
	    	String str_profile=profile.text();
	    	
	    	
	    	titles[2]=str_title;
	    	imgs[2]=str_img;
	    	author_time[2]=str_anthor_time;
	    	profiles[2]=str_profile;
		}
		public void four_gl(){
			Element dl=element.getElementById("guide_elite_202173");
	    	Element img_ele=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
	    	//获取照片
	    	String str_img=img_ele.attr("src");
	
	    	Element details=dl.select("dd").get(0);
	    	Element title=details.select("div").get(0).select("a").get(0);
	    	//标题
	    	String str_title=title.text();
	 
	    	Element anthor_time=details.select("p").get(0);
	    	//作者——发表时间
	    	String str_anthor_time=anthor_time.text();
	    	
	    	
	    	//简述
	    	Element profile=details.select("p").get(1);
	    	String str_profile=profile.text();
	   	
	    	titles[3]=str_title;
	    	imgs[3]=str_img;
	    	author_time[3]=str_anthor_time;
	    	profiles[3]=str_profile;
		}
		public void five_gl(){
			Element dl=element.getElementById("guide_elite_202076");
	    	Element img_ele=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
	    	//获取照片
	    	String str_img=img_ele.attr("src");
	    	
	    	Element details=dl.select("dd").get(0);
	    	Element title=details.select("div").get(0).select("a").get(0);
	    	//标题
	    	String str_title=title.text();
	  
	    	Element anthor_time=details.select("p").get(0);
	    	//作者——发表时间
	    	String str_anthor_time=anthor_time.text();
	    	
	    	
	    	//简述
	    	Element profile=details.select("p").get(1);
	    	String str_profile=profile.text();	
	    	
	    	titles[4]=str_title;
	    	imgs[4]=str_img;
	    	author_time[4]=str_anthor_time;
	    	profiles[4]=str_profile;
		}
		public void six_gl(){
			Element dl=element.getElementById("guide_elite_201728");
	    	Element img_ele=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
	    	//获取照片
	    	String str_img=img_ele.attr("src");
	   
	    	
	    	Element details=dl.select("dd").get(0);
	    	Element title=details.select("div").get(0).select("a").get(0);
	    	//标题
	    	String str_title=title.text();
	    	
	    	Element anthor_time=details.select("p").get(0);
	    	//作者——发表时间
	    	String str_anthor_time=anthor_time.text();
	    
	    	
	    	//简述
	    	Element profile=details.select("p").get(1);
	    	String str_profile=profile.text();
	    
	    	
	    	titles[5]=str_title;
	    	imgs[5]=str_img;
	    	author_time[5]=str_anthor_time;
	    	profiles[5]=str_profile;
		}
		public void seven_gl(){
			Element dl=element.getElementById("guide_elite_201599");
	    	Element img_ele=dl.select("dt").get(0).select("a").get(0).select("img").get(0 );
	    	//获取照片
	    	String str_img=img_ele.attr("src");

	    	Element details=dl.select("dd").get(0);
	    	Element title=details.select("div").get(0).select("a").get(0);
	    	//标题
	    	String str_title=title.text();

	    	Element anthor_time=details.select("p").get(0);
	    	//作者——发表时间
	    	String str_anthor_time=anthor_time.text();
	    	
	    	
	    	//简述
	    	Element profile=details.select("p").get(1);
	    	String str_profile=profile.text();
	   
	    	
	    	titles[6]=str_title;
	    	imgs[6]=str_img;
	    	author_time[6]=str_anthor_time;
	    	profiles[6]=str_profile;
		}
		public void eighth_gl(){
			Element dl=element.getElementById("guide_elite_200874");
	    	Element img_ele=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
	    	//获取照片
	    	String str_img=img_ele.attr("src");

	    	
	    	Element details=dl.select("dd").get(0);
	    	Element title=details.select("div").get(0).select("a").get(0);
	    	//标题
	    	String str_title=title.text();
	
	    	Element anthor_time=details.select("p").get(0);
	    	//作者——发表时间
	    	String str_anthor_time=anthor_time.text();
	  
	    	
	    	//简述
	    	Element profile=details.select("p").get(1);
	    	String str_profile=profile.text();

	    	
	    	titles[7]=str_title;
	    	imgs[7]=str_img;
	    	author_time[7]=str_anthor_time;
	    	profiles[7]=str_profile;
		}
}
