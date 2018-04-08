package com.servlet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.service.Service;

public class Youji_spider {
	//游记
	 Document document_youji;
	 Element div_youji ;
	 
	 String[] imgs=new String[8];//用来保存图片
	 String[] titles=new String[8]; //用来保存名称
	 String[] chapters=new String[8]; //用来保存章节目录
	 String[] summarys=new String[8];; //用来保存简述
	 String[] anthor_times=new String[8];; //用来保存作者-发表时间
	 
	 public void crawlHtml(String url) throws Exception {
			//获取工具类返回的html,并用Jsoup解析
			String result = AbstractSpider.getResult(url);
			document_youji = Jsoup.parse(result);
			document_youji.setBaseUri(url);
			
			//获取所有的img元素
			div_youji= document_youji.getElementById("new_guide");
			
			youji();
			
			  // 新建服务对象
	        Service service=new Service();
	       
			for(int i=0;i<imgs.length;i++){
				service.insertYouji(imgs[i],titles[i],chapters[i],summarys[i],anthor_times[i]);
			}
	}
	 
	public void youji(){
	 	    first_youji();
	        second_youji();
	        three_youji();
	        four_youji();
	        five_youji();
	        six_youji();
	        seven_youji();
	        eighth_youji();
	}

	public void first_youji(){
		Element dls=div_youji.select("div.countryBox").get(0);

		Element dl=dls.select("dl").get(0);
		Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
		//图片
		String str_img=img.attr("src");
	
		Element dd=dls.select("dd").get(0);
		Element title=dd.select("div").get(0)	;
		//文章标题
		String str_title=title.text();
	
		Element anthor_time=dd.select("p").get(0)	;
		String str_anthor_time=anthor_time.text();

		//章节目录
		Element chapter=dd.select("p").get(1);
		String str_chapter=chapter.text();

		//游记简述
		Element summary=dd.select("p").get(2);
		String str_summary=summary.text();
		
		imgs[0]=str_img;
		titles[0]=str_title;
		chapters[0]=str_chapter;
		summarys[0]=str_summary;
		anthor_times[0]=str_anthor_time;
	}
	public void second_youji(){
		Element dls=div_youji.select("div.countryBox").get(0);
		Element dl=dls.select("dl").get(1);
		Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
		//图片
		String str_img=img.attr("src");
		Element dd=dl.select("dd").get(0);
		Element title=dd.select("div").get(0)	;
		//文章标题
		String str_title=title.text();

		Element anthor_time=dd.select("p").get(0)	;
		String str_anthor_time=anthor_time.text();
		
		//章节目录
		Element chapter=dd.select("p").get(1);
		String str_chapter=chapter.text();
		//游记简述
		Element summary=dd.select("p").get(2);
		String str_summary=summary.text();

		
		imgs[1]=str_img;
		titles[1]=str_title;
		chapters[1]=str_chapter;
		summarys[1]=str_summary;
		anthor_times[1]=str_anthor_time;
	}
	public void three_youji(){
		Element dls=div_youji.select("div.countryBox").get(0);
		Element dl=dls.select("dl").get(2);
		Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
		//图片
		String str_img=img.attr("src");
		Element dd=dl.select("dd").get(0);
	
		Element title=dd.select("div").get(0)	;
		//文章标题
		String str_title=title.text();

		Element anthor_time=dd.select("p").get(0)	;
		String str_anthor_time=anthor_time.text();

		//章节目录
		Element chapter=dd.select("p").get(1);
		String str_chapter=chapter.text();
		//游记简述
		Element summary=dd.select("p").get(2);
		String str_summary=summary.text();
	
		imgs[2]=str_img;
		titles[2]=str_title;
		chapters[2]=str_chapter;
		summarys[2]=str_summary;
		anthor_times[2]=str_anthor_time;
	}
	public void four_youji(){
		Element dls=div_youji.select("div.countryBox").get(0);
		
		Element dl=dls.select("dl").get(3);

		Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
		//图片
		String str_img=img.attr("src");
		Element dd=dl.select("dd").get(0);
	
		Element title=dd.select("div").get(0);
		//文章标题
		String str_title=title.text();

		Element anthor_time=dd.select("p").get(0)	;
		String str_anthor_time=anthor_time.text();
	
		//章节目录
		Element chapter=dd.select("p").get(1);
		String str_chapter=chapter.text();

		//游记简述
		Element summary=dd.select("p").get(2);
		String str_summary=summary.text();
	
		imgs[3]=str_img;
		titles[3]=str_title;
		chapters[3]=str_chapter;
		summarys[3]=str_summary;
		anthor_times[3]=str_anthor_time;
	}
	public void five_youji(){
		Element dls=div_youji.select("div.countryBox").get(0);

		Element dl=dls.select("dl").get(4);

		Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
		//图片
		String str_img=img.attr("src");
		Element dd=dl.select("dd").get(0);
		
		Element title=dd.select("div").get(0)	;
		//文章标题
		String str_title=title.text();

		Element anthor_time=dd.select("p").get(0)	;
		String str_anthor_time=anthor_time.text();
		
		//章节目录
		Element chapter=dd.select("p").get(1);
		String str_chapter=chapter.text();

		//游记简述
		Element summary=dd.select("p").get(2);
		String str_summary=summary.text();

		imgs[4]=str_img;
		titles[4]=str_title;
		chapters[4]=str_chapter;
		summarys[4]=str_summary;
		anthor_times[4]=str_anthor_time;
	}
	public void six_youji(){
		Element dls=div_youji.select("div.countryBox").get(0);
		Element dl=dls.select("dl").get(5);
		Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
		//图片
		String str_img=img.attr("src");
		Element dd=dl.select("dd").get(0);
		Element title=dd.select("div").get(0)	;
		//文章标题
		String str_title=title.text();

		Element anthor_time=dd.select("p").get(0)	;
		String str_anthor_time=anthor_time.text();
		//章节目录
		Element chapter=dd.select("p").get(1);
		String str_chapter=chapter.text();

		//游记简述
		Element summary=dd.select("p").get(2);
		String str_summary=summary.text();
	
		imgs[5]=str_img;
		titles[5]=str_title;
		chapters[5]=str_chapter;
		summarys[5]=str_summary;
		anthor_times[5]=str_anthor_time;
	}
	public void seven_youji(){
		Element dls=div_youji.select("div.countryBox").get(0);
		Element dl=dls.select("dl").get(6);
		Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
		//图片
		String str_img=img.attr("src");
		Element dd=dl.select("dd").get(0);
		Element title=dd.select("div").get(0)	;
		//文章标题
		String str_title=title.text();

		Element anthor_time=dd.select("p").get(0)	;
		String str_anthor_time=anthor_time.text();
	
		//章节目录
		Element chapter=dd.select("p").get(1);
		String str_chapter=chapter.text();
	
		//游记简述
		Element summary=dd.select("p").get(2);
		String str_summary=summary.text();
		
		imgs[6]=str_img;
		titles[6]=str_title;
		chapters[6]=str_chapter;
		summarys[6]=str_summary;
		anthor_times[6]=str_anthor_time;
	}
	public void eighth_youji(){
		Element dls=div_youji.select("div.countryBox").get(0);
	
		Element dl=dls.select("dl").get(7);
		Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
		//图片
		String str_img=img.attr("src");
		Element dd=dl.select("dd").get(0);
		Element title=dd.select("div").get(0)	;
		//文章标题
		String str_title=title.text();

		Element anthor_time=dd.select("p").get(0)	;
		String str_anthor_time=anthor_time.text();
		
		//章节目录
		Element chapter=dd.select("p").get(1);
		String str_chapter=chapter.text();
		//游记简述
		Element summary=dd.select("p").get(2);
		String str_summary=summary.text();
		
		imgs[7]=str_img;
		titles[7]=str_title;
		chapters[7]=str_chapter;
		summarys[7]=str_summary;
		anthor_times[7]=str_anthor_time;
	}
}
