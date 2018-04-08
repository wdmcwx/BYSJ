package com.servlet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.service.Service;

public class Jiudian_spider {
	//酒店
		Document document;
		Element div ;

	    
	    String[] imgs=new String[8];//用来保存图片
	    String[] names=new String[8]; //用来保存名称
	    String[] addrs=new String[8];; //用来保存地址
	    public void crawlHtml(String url) throws Exception {
			//获取工具类返回的html,并用Jsoup解析
			String result = AbstractSpider.getResult(url);
			document = Jsoup.parse(result);
			document.setBaseUri(url);
			//获取所有的img元素
			div= document.getElementById("hotelList");
			
			jiudian();
			
			 // 新建服务对象
	        Service service=new Service();
	      
			for(int i=0;i<imgs.length;i++){
				 service.insertJiudian(imgs[i],names[i],addrs[i]);
			}
		}
	    
	    private void jiudian() {
			// TODO 自动生成的方法存根
			first_hotel();
			second_hotel();
			three_hotel();
			four_hotel();
			five_hotel();
			six_hotel();
			sevent_hotel();  //显示有问题
			eight_hotel();
		}
	    
	    public void first_hotel(){
			
			Element d=div.getElementById("hotelId30141488");
			
			Element img=d.select("div.clearfix").get(0).select("div.h_img").get(0).select("a").get(0).select("img").get(0);
			//图片
			String str_img=img.attr("src");
			
			Element name=d.select("div.clearfix").get(0).select("div.detail_info").get(0).select("div.left").get(0).select("h2").get(0);
			//名称
			String str_name=name.text();
			
			Element addr=d.select("div.clearfix").get(0).select("div.detail_info").get(0).select("p:contains(地址)").get(0);
			//地址
			String str_addr=addr.text();
			
			imgs[0]=str_img;
			names[0]=str_name;
			addrs[0]=str_addr;	
		}

		public void second_hotel(){
			

			Element d=div.getElementById("hotelId30171265");
			
			Element img=d.select("div.clearfix").get(0).select("div.h_img").get(0).select("a").get(0).select("img").get(0);
			//图片
			String str_img=img.attr("src");
			
			Element name=d.select("div.clearfix").get(0).select("div.detail_info").get(0).select("div.left").get(0).select("h2").get(0);
			//名称
			String str_name=name.text();
			
			Element addr=d.select("div.clearfix").get(0).select("div.detail_info").get(0).select("p:contains(地址)").get(0);
			//地址
			String str_addr=addr.text();
			
			imgs[1]=str_img;
			names[1]=str_name;
			addrs[1]=str_addr;	
		}
		public void three_hotel(){
			

			Element d=div.getElementById("hotelId30430992");
			
			Element img=d.select("div.clearfix").get(0).select("div.h_img").get(0).select("a").get(0).select("img").get(0);
			//图片
			String str_img=img.attr("src");
			
			Element name=d.select("div.clearfix").get(0).select("div.detail_info").get(0).select("div.left").get(0).select("h2").get(0);
			//名称
			String str_name=name.text();
			
			Element addr=d.select("div.clearfix").get(0).select("div.detail_info").get(0).select("p:contains(地址)").get(0);
			//地址
			String str_addr=addr.text();
	
			imgs[2]=str_img;
			names[2]=str_name;
			addrs[2]=str_addr;	
		}
		public void four_hotel(){
			
			Element d=div.getElementById("hotelId30000831");
			
			Element img=d.select("div.clearfix").get(0).select("div.h_img").get(0).select("a").get(0).select("img").get(0);
			//图片
			String str_img=img.attr("src");
			
			Element name=d.select("div.clearfix").get(0).select("div.detail_info").get(0).select("div.left").get(0).select("h2").get(0);
			//名称
			String str_name=name.text();
			
			Element addr=d.select("div.clearfix").get(0).select("div.detail_info").get(0).select("p:contains(地址)").get(0);
			//地址
			String str_addr=addr.text();
			
			imgs[3]=str_img;
			names[3]=str_name;
			addrs[3]=str_addr;
		}
		
		public void five_hotel(){
			
			Element d=div.getElementById("hotelId30001685");
			
			Element img=d.select("div.clearfix").get(0).select("div.h_img").get(0).select("a").get(0).select("img").get(0);
			//图片
			String str_img=img.attr("src");
			
			Element name=d.select("div.clearfix").get(0).select("div.detail_info").get(0).select("div.left").get(0).select("h2").get(0);
			//名称
			String str_name=name.text();
			
			Element addr=d.select("div.clearfix").get(0).select("div.detail_info").get(0).select("p:contains(地址)").get(0);
			//地址
			String str_addr=addr.text();
			
			imgs[4]=str_img;
			names[4]=str_name;
			addrs[4]=str_addr;
		}
		
		public void six_hotel(){
			
			Element d=div.getElementById("hotelId30073248");
			
			Element img=d.select("div.clearfix").get(0).select("div.h_img").get(0).select("a").get(0).select("img").get(0);
			//图片
			String str_img=img.attr("src");
			
			Element name=d.select("div.clearfix").get(0).select("div.detail_info").get(0).select("div.left").get(0).select("h2").get(0);
			//名称
			String str_name=name.text();
			
			Element addr=d.select("div.clearfix").get(0).select("div.detail_info").get(0).select("p:contains(地址)").get(0);
			//地址
			String str_addr=addr.text();
			
			imgs[5]=str_img;
			names[5]=str_name;
			addrs[5]=str_addr;
		}
		public void sevent_hotel(){ //显示有问题
			
			Element d=div.getElementById("hotelId30000552");
			
			Element img=d.select("div.clearfix").get(0).select("div.h_img").get(0).select("a").get(0).select("img").get(0);
			//图片
			String str_img=img.attr("src");
			
			Element name=d.select("div.clearfix").get(0).select("div.detail_info").get(0).select("div.left").get(0).select("h2").get(0);
			//名称
			String str_name=name.text();
			
			Element addr=d.select("div.clearfix").get(0).select("div.detail_info").get(0).select("p:contains(地址)").get(0);
			//地址
			String str_addr=addr.text();
			
			imgs[6]=str_img;
			names[6]=str_name;
			addrs[6]=str_addr;
		}
		public void eight_hotel(){
			
			Element d=div.getElementById("hotelId30184691");
			
			Element img=d.select("div.clearfix").get(0).select("div.h_img").get(0).select("a").get(0).select("img").get(0);
			//图片
			String str_img=img.attr("src");
			
			Element name=d.select("div.clearfix").get(0).select("div.detail_info").get(0).select("div.left").get(0).select("h2").get(0);
			//名称
			String str_name=name.text();

			
			Element addr=d.select("div.clearfix").get(0).select("div.detail_info").get(0).select("p:contains(地址)").get(0);
			//地址
			String str_addr=addr.text();
			
			imgs[6]=str_img;
			names[6]=str_name;
			addrs[6]=str_addr;
		}
		
}
