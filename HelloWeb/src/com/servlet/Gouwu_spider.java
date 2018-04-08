package com.servlet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.service.Service;

public class Gouwu_spider {
	//购物
	Document document_shopping;
	Element div_shopping ;
	
	String[] imgs=new String[8];//用来保存图片
	String[] titles=new String[8]; //用来保存名称
	String[] addrs=new String[8]; //用来保存地址
	
	public void crawlHtml(String url) throws Exception {
		//获取工具类返回的html,并用Jsoup解析
		String result = AbstractSpider.getResult(url);
		document_shopping= Jsoup.parse(result);
		document_shopping.setBaseUri(url);
		//获取所有的img元素
		div_shopping= document_shopping.getElementById("list_sotret").select("div.countryBox").get(0);
		  //购物
        shopping(); 
     // 新建服务对象
        Service service=new Service();
      
		for(int i=0;i<titles.length;i++){
			 service.insertGouwu(imgs[i],titles[i],addrs[i]);
		}
	}
	
	public void shopping(){
		 first_shopping();
		 second_shopping();
		 three_shopping();
		 four_shopping();
		 five_shopping();
		 six_shopping();
		 seven_shopping();
		 eight_shopping();
	}
	
	public void first_shopping(){
		Element dl=div_shopping.getElementById("hasbeen_10047305");
		Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
				//图片
		String str_img=img.attr("src");
	
		Element dd=dl.select("dd").get(0);
		Element title=dd.select("div.title").get(0);
				//名称
		String str_title=title.text();
	
		Element addr=dd.select("div.ms-box").get(0).select("p").get(0);
				//地址
		String str_addr=addr.text();
		
		imgs[0]=str_img;
		titles[0]=str_title;
		addrs[0]=str_addr;	
	}
	
	public void second_shopping(){
		Element dl=div_shopping.getElementById("hasbeen_10047307");
		Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
				//图片
		String str_img=img.attr("src");
		Element dd=dl.select("dd").get(0);
		Element title=dd.select("div.title").get(0);
				//名称
		String str_title=title.text();
	
		Element addr=dd.select("div.ms-box").get(0).select("p").get(0);
				//地址
		String str_addr=addr.text();
				//推荐商品
		Element command=dd.select("div.ms-box").get(0).select("p").get(1);
		String str_command=command.text();
		imgs[1]=str_img;
		titles[1]=str_title;
		addrs[1]=str_addr;	
	}

	public void three_shopping(){
		Element dl=div_shopping.getElementById("hasbeen_10645431");
		Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
				//图片
		String str_img=img.attr("src");
		Element dd=dl.select("dd").get(0);
		Element title=dd.select("div.title").get(0);
				//名称
		String str_title=title.text();

		Element addr=dd.select("div.ms-box").get(0).select("p").get(0);
				//地址
		String str_addr=addr.text();

		imgs[2]=str_img;
		titles[2]=str_title;
		addrs[2]=str_addr;	
	}
	public void four_shopping(){
		Element dl=div_shopping.getElementById("hasbeen_11317522");
		Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
				//图片
		String str_img=img.attr("src");
		Element dd=dl.select("dd").get(0);
		Element title=dd.select("div.title").get(0);
				//名称
		String str_title=title.text();

		Element addr=dd.select("div.ms-box").get(0).select("p").get(0);
				//地址
		String str_addr=addr.text();

		imgs[3]=str_img;
		titles[3]=str_title;
		addrs[3]=str_addr;	
	}
	public void five_shopping(){
		Element dl=div_shopping.getElementById("hasbeen_10674281");
		Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
				//图片
		String str_img=img.attr("src");
	
		Element dd=dl.select("dd").get(0);
		Element title=dd.select("div.title").get(0);
				//名称
		String str_title=title.text();
		Element addr=dd.select("div.ms-box").get(0).select("p").get(0);
				//地址
		String str_addr=addr.text();
		imgs[4]=str_img;
		titles[4]=str_title;
		addrs[4]=str_addr;	
	}
	public void six_shopping(){
		Element dl=div_shopping.getElementById("hasbeen_10674283");
		Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
				//图片
		String str_img=img.attr("src");
		Element dd=dl.select("dd").get(0);
		Element title=dd.select("div.title").get(0);
				//名称
		String str_title=title.text();
		Element addr=dd.select("div.ms-box").get(0).select("p").get(0);
				//地址
		String str_addr=addr.text();

		imgs[5]=str_img;
		titles[5]=str_title;
		addrs[5]=str_addr;	
	}
	public void seven_shopping(){
		Element dl=div_shopping.getElementById("hasbeen_10674389");
		Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
				//图片
		String str_img=img.attr("src");

		Element dd=dl.select("dd").get(0);
		Element title=dd.select("div.title").get(0);
				//名称
		String str_title=title.text();
	
		Element addr=dd.select("div.ms-box").get(0).select("p").get(0);
				//地址
		String str_addr=addr.text();
	
		imgs[6]=str_img;
		titles[6]=str_title;
		addrs[6]=str_addr;	
	}
	
	public void eight_shopping(){
		Element dl=div_shopping.getElementById("hasbeen_10047306");
		Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
				//图片
		String str_img=img.attr("src");
		Element dd=dl.select("dd").get(0);
		Element title=dd.select("div.title").get(0);
				//名称
		String str_title=title.text();
	
		Element addr=dd.select("div.ms-box").get(0).select("p").get(0);
				//地址
		String str_addr=addr.text();
		imgs[7]=str_img;
		titles[7]=str_title;
		addrs[7]=str_addr;	
	}
}
