package com.servlet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Jingdian_spider {
	//景点
	Document document;
	Element div ;
	String[] imgs=new String[8];//用来保存图片
    String[] names=new String[8]; //用来保存名称
    String[] times=new String[8]; //用来保存时间
    String[] addrs=new String[8];; //用来保存地址
    String[] jianjies=new String[8]; //用来保存简介
    String[] tickey1=new String[8]; //用来保存第一种门票
    String[] tickey2=new String[8]; //用来保存第2种门票
    
	public void crawlHtml(String url) throws Exception {
		//获取工具类返回的html,并用Jsoup解析
		String result = AbstractSpider.getResult(url);
		document = Jsoup.parse(result);
		document.setBaseUri(url);
	
		System.out.println(document.html()); //获取不到相应的标签
	//	div= document.select("div.product-list").get(0);

	//	jingdian();
		
		for(int i=0;i<imgs.length;i++){
			System.out.println(imgs[i]);
		}
	}
	
	public void jingdian(){
        first_jingdian(); // 第一个景点
        second_jingdian(); //第二个景点
        three_jingdian(); // 第三个景点
        four_jingdian() ;//第四个景点
        five_jingdian(); //第五个景点 
        six_jingdian();//第六个景点
        seven_jingdian();// 第七个景点
        eighth_jingdian(); //第八个景点	
   }
	

	public void eighth_jingdian(){
    	Element product1=div.select("div.product-item.product-ticket.searchTicket.clearfix[productid='172140']").first();
     
   	 	Element img_ele=product1.select("div.product-regular.clearfix").first().select("div.product-left").first().select("a").first().select("img").first();
      
        String img1=img_ele.attr("src");
        imgs[7]=img1;

        //第一个景点名称
        Element name_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("h3").first();
        String name1= name_ele.text();

        //第一个景点地址
        Element addr_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(景点地址)").first().select("dd").first();
        String addr= addr_ele.text();

        //第一个景点营业时间
        Element time_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(营业时间)").first().select("dd").first().select("div").first();
        String time= time_ele.text();

        //第一个景点景点特色
        Element tese_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(景点特色)").first().select("dd").first().select("div").first();
        String tese=  tese_ele.text();

        //第一个景点门票
        Element tickets_li=product1.select("div.product-special").first().select("div.psh-tab-contents").first().select("div.psh-tab-content.active").first().select("ul").first();

        //第一种类门票
        Element tickets=tickets_li.select("li").first().select("div").first();
        Element ticket=tickets.select("div.name").first();
        Element ticketA=ticket.select("span").get(0);
        Element ticketB=ticket.select("span").get(1);
        //市场价
        Element shichangjia=tickets.select("div.price").first();
        String str_shichangjia="市场价："+ shichangjia.text();
        //驴妈妈价
        Element lvmamajia=tickets.select("div.lv-price").first();
        String str_lvmama="驴妈妈价："+ lvmamajia.text();
        //第一条总的门票信息
        String Piao=ticketA.text()+"  "+ticketB.text()+"  "+str_shichangjia+" "+str_lvmama;

        
      //第二种类门票
        Element tickets_two=tickets_li.select("li").get(1).select("div").first();
     
        Element ticket_two=tickets_two.select("div.name").first();
        Element ticketA_two=ticket_two.select("span").get(0);
        Element ticketB_two=ticket_two.select("span").get(1);
        
        //市场价
        Element shichangjia_two=tickets_two.select("div.price").first();
        String str_shichangjia_two="市场价："+ shichangjia_two.text();

        //驴妈妈价
        Element lvmamajia_two=tickets_two.select("div.lv-price").first();
        String str_lvmama_two="驴妈妈价："+ lvmamajia_two.text();

//        //第一条总的门票信息
        String Piao_two=ticketA_two.text()+"  "+ticketB_two.text()+"  "+str_shichangjia_two+" "+str_lvmama_two;

         imgs[7]=img1;
         names[7]=name1;
         addrs[7]=addr;
         times[7]=time;
         jianjies[7]=tese;
         tickey1[7]=Piao;
         tickey2[7]=Piao_two; 
    }
    public void seven_jingdian(){
    	Element product1=div.select("div.product-item.product-ticket.searchTicket.clearfix[productid='172163']").first();
        //  Log.i("555",product1.html());
   	 	Element img_ele=product1.select("div.product-regular.clearfix").first().select("div.product-left").first().select("a").first().select("img").first();
        //.select("div.product-left").first().select("img").first();
        //第一个景点图片
        String img1=img_ele.attr("src");
      //  Log.i("bbbxxxxxx---:",img1);
        
        imgs[6]=img1;
        
        //第一个景点名称
        Element name_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("h3").first();
        String name1= name_ele.text();
   //     Toast.makeText(jingdian.this, name1, Toast.LENGTH_LONG).show();
       // Log.i("zzzz---:",name1);
        //第一个景点地址
        Element addr_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(景点地址)").first().select("dd").first();
        String addr= addr_ele.text();
       // Toast.makeText(MainActivity.this, addr, Toast.LENGTH_LONG).show();
      //  Log.i("www---:",addr);
        //第一个景点营业时间
        Element time_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(营业时间)").first().select("dd").first().select("div").first();
        String time= time_ele.text();
     //   Log.i("xxx---:",time);
        //第一个景点景点特色
        Element tese_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(景点特色)").first().select("dd").first().select("div").first();
        String tese=  tese_ele.text();
       // Log.i("sss---:",tese);
        //第一个景点门票
        Element tickets_li=product1.select("div.product-special").first().select("div.psh-tab-contents").first().select("div.psh-tab-content.active").first().select("ul").first();
        //Log.i("ul---:",tickets_li.html());
        //第一种类门票
        Element tickets=tickets_li.select("li").first().select("div").first();
        Element ticket=tickets.select("div.name").first();
        Element ticketA=ticket.select("span").get(0);
        Element ticketB=ticket.select("span").get(1);
        //市场价
        Element shichangjia=tickets.select("div.price").first();
        String str_shichangjia="市场价："+ shichangjia.text();
        //驴妈妈价
        Element lvmamajia=tickets.select("div.lv-price").first();
        String str_lvmama="驴妈妈价："+ lvmamajia.text();
        //第一条总的门票信息
        String Piao=ticketA.text()+"  "+ticketB.text()+"  "+str_shichangjia+" "+str_lvmama;
       // Log.i("ticket4444---:",Piao);
        
      //第二种类门票
        Element tickets_two=tickets_li.select("li").get(1).select("div").first();
       // Log.i("ticket9999---:",tickets_two.text());
        Element ticket_two=tickets_two.select("div.name").first();
        Element ticketA_two=ticket_two.select("span").get(0);
        Element ticketB_two=ticket_two.select("span").get(1);
     //   Log.i("ticket0000---:",ticketA_two.text()+ticketB_two.text());     
        //市场价
        Element shichangjia_two=tickets_two.select("div.price").first();
        String str_shichangjia_two="市场价："+ shichangjia_two.text();
  //      Log.i("ticket---yyy---:",str_shichangjia_two);
        //驴妈妈价
        Element lvmamajia_two=tickets_two.select("div.lv-price").first();
        String str_lvmama_two="驴妈妈价："+ lvmamajia_two.text();
  //      Log.i("ticket---hhhhhh---:",str_lvmama_two);
//        //第一条总的门票信息
        String Piao_two=ticketA_two.text()+"  "+ticketB_two.text()+"  "+str_shichangjia_two+" "+str_lvmama_two;
     //   Log.i("ticket222---:",Piao_two);
    //    Toast.makeText(MainActivity.this, Piao_two, Toast.LENGTH_LONG).show();
       
      //第三种类门票
        Element tickets_three=tickets_li.select("li").get(2).select("div").first();
       // Log.i("ticket9999---:",tickets_two.text());
        Element ticket_three=tickets_three.select("div.name").first();
        Element ticketA_three=ticket_three.select("span").get(0);
        Element ticketB_three=ticket_three.select("span").get(1);
     //   Log.i("ticket0000---:",ticketA_two.text()+ticketB_two.text());     
        //市场价
        Element shichangjia_three=tickets_three.select("div.price").first();
        String str_shichangjia_three="市场价："+ shichangjia_three.text();
  //      Log.i("ticket---yyy---:",str_shichangjia_two);
        //驴妈妈价
        Element lvmamajia_three=tickets_three.select("div.lv-price").first();
        String str_lvmama_three="驴妈妈价："+ lvmamajia_three.text();
  //      Log.i("ticket---hhhhhh---:",str_lvmama_two);
//        //第一条总的门票信息
        String Piao_three=ticketA_three.text()+"  "+ticketB_three.text()+"  "+str_shichangjia_three+" "+str_lvmama_three;
        //Log.i("ticket222---:",Piao_three);
     //   Toast.makeText(MainActivity.this, Piao_three, Toast.LENGTH_LONG).show();
        imgs[6]=img1;
         names[6]=name1;
         addrs[6]=addr;
         times[6]=time;
         jianjies[6]=tese;
         tickey1[6]=Piao;
         tickey2[6]=Piao_two; 
    }
    public void six_jingdian(){
    	Element product1=div.select("div.product-item.product-ticket.searchTicket.clearfix[productid='182087']").first();
        //  Log.i("555",product1.html());
   	 	Element img_ele=product1.select("div.product-regular.clearfix").first().select("div.product-left").first().select("a").first().select("img").first();
        //.select("div.product-left").first().select("img").first();
        //第一个景点图片
        String img1=img_ele.attr("src");
      //  Log.i("bbbxxxxxx---:",img1);
        imgs[5]=img1;
      
        
        //第一个景点名称
        Element name_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("h3").first();
        String name1= name_ele.text();
      //  Toast.makeText(MainActivity.this, name1, Toast.LENGTH_LONG).show();
       // Log.i("zzzz---:",name1);
        //第一个景点地址
        Element addr_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(景点地址)").first().select("dd").first();
        String addr= addr_ele.text();
    //    Toast.makeText(jingdian.this, addr, Toast.LENGTH_LONG).show();
      //  Log.i("www---:",addr);
        //第一个景点营业时间
        Element time_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(营业时间)").first().select("dd").first().select("div").first();
        String time= time_ele.text();
     //   Log.i("xxx---:",time);
        //第一个景点景点特色
        Element tese_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(景点特色)").first().select("dd").first().select("div").first();
        String tese=  tese_ele.text();
       // Log.i("sss---:",tese);
        //第一个景点门票
        Element tickets_li=product1.select("div.product-special").first().select("div.psh-tab-contents").first().select("div.psh-tab-content.active").first().select("ul").first();
        //Log.i("ul---:",tickets_li.html());
        //第一种类门票
        Element tickets=tickets_li.select("li").first().select("div").first();
        Element ticket=tickets.select("div.name").first();
        Element ticketA=ticket.select("span").get(0);
        Element ticketB=ticket.select("span").get(1);
        //市场价
        Element shichangjia=tickets.select("div.price").first();
        String str_shichangjia="市场价："+ shichangjia.text();
        //驴妈妈价
        Element lvmamajia=tickets.select("div.lv-price").first();
        String str_lvmama="驴妈妈价："+ lvmamajia.text();
        //第一条总的门票信息
        String Piao=ticketA.text()+"  "+ticketB.text()+"  "+str_shichangjia+" "+str_lvmama;
       // Log.i("ticket4444---:",Piao);
        
      //第二种类门票
        Element tickets_two=tickets_li.select("li").get(1).select("div").first();
       // Log.i("ticket9999---:",tickets_two.text());
        Element ticket_two=tickets_two.select("div.name").first();
        Element ticketA_two=ticket_two.select("span").get(0);
        Element ticketB_two=ticket_two.select("span").get(1);
     //   Log.i("ticket0000---:",ticketA_two.text()+ticketB_two.text());     
        //市场价
        Element shichangjia_two=tickets_two.select("div.price").first();
        String str_shichangjia_two="市场价："+ shichangjia_two.text();
  //      Log.i("ticket---yyy---:",str_shichangjia_two);
        //驴妈妈价
        Element lvmamajia_two=tickets_two.select("div.lv-price").first();
        String str_lvmama_two="驴妈妈价："+ lvmamajia_two.text();
  //      Log.i("ticket---hhhhhh---:",str_lvmama_two);
//        //第一条总的门票信息
        String Piao_two=ticketA_two.text()+"  "+ticketB_two.text()+"  "+str_shichangjia_two+" "+str_lvmama_two;
     //   Log.i("ticket222---:",Piao_two);
    //    Toast.makeText(MainActivity.this, Piao_two, Toast.LENGTH_LONG).show();
       
      //第三种类门票
        Element tickets_three=tickets_li.select("li").get(2).select("div").first();
       // Log.i("ticket9999---:",tickets_two.text());
        Element ticket_three=tickets_three.select("div.name").first();
        Element ticketA_three=ticket_three.select("span").get(0);
        Element ticketB_three=ticket_three.select("span").get(1);
     //   Log.i("ticket0000---:",ticketA_two.text()+ticketB_two.text());     
        //市场价
        Element shichangjia_three=tickets_three.select("div.price").first();
        String str_shichangjia_three="市场价："+ shichangjia_three.text();
  //      Log.i("ticket---yyy---:",str_shichangjia_two);
        //驴妈妈价
        Element lvmamajia_three=tickets_three.select("div.lv-price").first();
        String str_lvmama_three="驴妈妈价："+ lvmamajia_three.text();
  //      Log.i("ticket---hhhhhh---:",str_lvmama_two);
//        //第一条总的门票信息
        String Piao_three=ticketA_three.text()+"  "+ticketB_three.text()+"  "+str_shichangjia_three+" "+str_lvmama_three;
        //Log.i("ticket222---:",Piao_three);
     //   Toast.makeText(MainActivity.this, Piao_three, Toast.LENGTH_LONG).show();
   
         imgs[5]=img1;
         names[5]=name1;
         addrs[5]=addr;
         times[5]=time;
         jianjies[5]=tese;
         tickey1[5]=Piao;
         tickey2[5]=Piao_two;
        
    }
    public void five_jingdian(){
    	Element product1=div.select("div.product-item.product-ticket.searchTicket.clearfix[productid='182128']").first();
        //  Log.i("555",product1.html());
   	 	Element img_ele=product1.select("div.product-regular.clearfix").first().select("div.product-left").first().select("a").first().select("img").first();
        //.select("div.product-left").first().select("img").first();
        //第一个景点图片
        String img1=img_ele.attr("src");
      //  Log.i("bbbxxxxxx---:",img1);
        
      //  imgs[4]=img1;
        
        //第一个景点名称
        Element name_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("h3").first();
        String name1= name_ele.text();
      //  Toast.makeText(MainActivity.this, name1, Toast.LENGTH_LONG).show();
       // Log.i("zzzz---:",name1);
        //第一个景点地址
        Element addr_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(景点地址)").first().select("dd").first();
        String addr= addr_ele.text();
    //    Toast.makeText(jingdian.this, addr, Toast.LENGTH_LONG).show();
      //  Log.i("www---:",addr);
        //第一个景点营业时间
        Element time_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(营业时间)").first().select("dd").first().select("div").first();
        String time= time_ele.text();
     //   Log.i("xxx---:",time);
        //第一个景点景点特色
        Element tese_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(景点特色)").first().select("dd").first().select("div").first();
        String tese=  tese_ele.text();
       // Log.i("sss---:",tese);
        //第一个景点门票
        Element tickets_li=product1.select("div.product-special").first().select("div.psh-tab-contents").first().select("div.psh-tab-content.active").first().select("ul").first();
        //Log.i("ul---:",tickets_li.html());
        //第一种类门票
        Element tickets=tickets_li.select("li").first().select("div").first();
        Element ticket=tickets.select("div.name").first();
        Element ticketA=ticket.select("span").get(0);
        Element ticketB=ticket.select("span").get(1);
        //市场价
        Element shichangjia=tickets.select("div.price").first();
        String str_shichangjia="市场价："+ shichangjia.text();
        //驴妈妈价
        Element lvmamajia=tickets.select("div.lv-price").first();
        String str_lvmama="驴妈妈价："+ lvmamajia.text();
        //第一条总的门票信息
        String Piao=ticketA.text()+"  "+ticketB.text()+"  "+str_shichangjia+" "+str_lvmama;
       // Log.i("ticket4444---:",Piao);
        
      //第二种类门票
        Element tickets_two=tickets_li.select("li").get(1).select("div").first();
       // Log.i("ticket9999---:",tickets_two.text());
        Element ticket_two=tickets_two.select("div.name").first();
        Element ticketA_two=ticket_two.select("span").get(0);
        Element ticketB_two=ticket_two.select("span").get(1);
     //   Log.i("ticket0000---:",ticketA_two.text()+ticketB_two.text());     
        //市场价
        Element shichangjia_two=tickets_two.select("div.price").first();
        String str_shichangjia_two="市场价："+ shichangjia_two.text();
  //      Log.i("ticket---yyy---:",str_shichangjia_two);
        //驴妈妈价
        Element lvmamajia_two=tickets_two.select("div.lv-price").first();
        String str_lvmama_two="驴妈妈价："+ lvmamajia_two.text();
  //      Log.i("ticket---hhhhhh---:",str_lvmama_two);
//        //第一条总的门票信息
        String Piao_two=ticketA_two.text()+"  "+ticketB_two.text()+"  "+str_shichangjia_two+" "+str_lvmama_two;
     //   Log.i("ticket222---:",Piao_two);
    //    Toast.makeText(MainActivity.this, Piao_two, Toast.LENGTH_LONG).show();
       
      //第三种类门票
        Element tickets_three=tickets_li.select("li").get(2).select("div").first();
       // Log.i("ticket9999---:",tickets_two.text());
        Element ticket_three=tickets_three.select("div.name").first();
        Element ticketA_three=ticket_three.select("span").get(0);
        Element ticketB_three=ticket_three.select("span").get(1);
     //   Log.i("ticket0000---:",ticketA_two.text()+ticketB_two.text());     
        //市场价
        Element shichangjia_three=tickets_three.select("div.price").first();
        String str_shichangjia_three="市场价："+ shichangjia_three.text();
  //      Log.i("ticket---yyy---:",str_shichangjia_two);
        //驴妈妈价
        Element lvmamajia_three=tickets_three.select("div.lv-price").first();
        String str_lvmama_three="驴妈妈价："+ lvmamajia_three.text();
  //      Log.i("ticket---hhhhhh---:",str_lvmama_two);
//        //第一条总的门票信息
        String Piao_three=ticketA_three.text()+"  "+ticketB_three.text()+"  "+str_shichangjia_three+" "+str_lvmama_three;

         imgs[4]=img1;
         names[4]=name1;
         addrs[4]=addr;
         times[4]=time;
         jianjies[4]=tese;
         tickey1[4]=Piao;
         tickey2[4]=Piao_two;
        
    }
    public void four_jingdian(){
    	 Element product1=div.select("div.product-item.product-ticket.searchTicket.clearfix[productid='182077']").first();
        
    	 Element img_ele=product1.select("div.product-regular.clearfix").first().select("div.product-left").first().select("a").first().select("img").first();
        
         //第一个景点图片
         String img1=img_ele.attr("src");
       
         imgs[3]=img1;
       
         
         //第一个景点名称
         Element name_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("h3").first();
         String name1= name_ele.text();

         //第一个景点地址
         Element addr_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(景点地址)").first().select("dd").first();
         String addr= addr_ele.text();

         //第一个景点营业时间
         Element time_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(营业时间)").first().select("dd").first().select("div").first();
         String time= time_ele.text();
    
         //第一个景点景点特色
         Element tese_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(景点特色)").first().select("dd").first().select("div").first();
         String tese=  tese_ele.text();

         //第一个景点门票
         Element tickets_li=product1.select("div.product-special").first().select("div.psh-tab-contents").first().select("div.psh-tab-content.active").first().select("ul").first();
         
         //第一种类门票
         Element tickets=tickets_li.select("li").first().select("div").first();
         Element ticket=tickets.select("div.name").first();
         Element ticketA=ticket.select("span").get(0);
         Element ticketB=ticket.select("span").get(1);
         //市场价
         Element shichangjia=tickets.select("div.price").first();
         String str_shichangjia="市场价："+ shichangjia.text();
         //驴妈妈价
         Element lvmamajia=tickets.select("div.lv-price").first();
         String str_lvmama="驴妈妈价："+ lvmamajia.text();
         //第一条总的门票信息
         String Piao=ticketA.text()+"  "+ticketB.text()+"  "+str_shichangjia+" "+str_lvmama;

         
       //第二种类门票
         Element tickets_two=tickets_li.select("li").get(1).select("div").first();
        // Log.i("ticket9999---:",tickets_two.text());
         Element ticket_two=tickets_two.select("div.name").first();
         Element ticketA_two=ticket_two.select("span").get(0);
         Element ticketB_two=ticket_two.select("span").get(1);
   
         //市场价
         Element shichangjia_two=tickets_two.select("div.price").first();
         String str_shichangjia_two="市场价："+ shichangjia_two.text();
   
         //驴妈妈价
         Element lvmamajia_two=tickets_two.select("div.lv-price").first();
         String str_lvmama_two="驴妈妈价："+ lvmamajia_two.text();

//         //第一条总的门票信息
         String Piao_two=ticketA_two.text()+"  "+ticketB_two.text()+"  "+str_shichangjia_two+" "+str_lvmama_two;

       //第三种类门票
         Element tickets_three=tickets_li.select("li").get(2).select("div").first();
        // Log.i("ticket9999---:",tickets_two.text());
         Element ticket_three=tickets_three.select("div.name").first();
         Element ticketA_three=ticket_three.select("span").get(0);
         Element ticketB_three=ticket_three.select("span").get(1);
        
         //市场价
         Element shichangjia_three=tickets_three.select("div.price").first();
         String str_shichangjia_three="市场价："+ shichangjia_three.text();
 
         //驴妈妈价
         Element lvmamajia_three=tickets_three.select("div.lv-price").first();
         String str_lvmama_three="驴妈妈价："+ lvmamajia_three.text();

//         //第一条总的门票信息
         String Piao_three=ticketA_three.text()+"  "+ticketB_three.text()+"  "+str_shichangjia_three+" "+str_lvmama_three;

         imgs[3]=img1;
         names[3]=name1;
         addrs[3]=addr;
         times[3]=time;
         jianjies[3]=tese;
         tickey1[3]=Piao;
         tickey2[3]=Piao_two;
        
    }
    public void three_jingdian(){
     Element product1=div.select("div.product-item.product-ticket.searchTicket.clearfix[productid='255010']").first();
      
   	 Element img_ele=product1.select("div.product-regular.clearfix").first().select("div.product-left").first().select("a").first().select("img").first();
      
        //第一个景点图片
        String img1=img_ele.attr("src");

        imgs[2]=img1;
    
        
        //第一个景点名称
        Element name_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("h3").first();
        String name1= name_ele.text();

        //第一个景点地址
        Element addr_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(景点地址)").first().select("dd").first();
        String addr= addr_ele.text();

        //第一个景点营业时间
        Element time_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(营业时间)").first().select("dd").first().select("div").first();
        String time= time_ele.text();

        //第一个景点景点特色
        Element tese_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(景点特色)").first().select("dd").first().select("div").first();
        String tese=  tese_ele.text();
      
        //第一个景点门票
        Element tickets_li=product1.select("div.product-special").first().select("div.psh-tab-contents").first().select("div.psh-tab-content.active").first().select("ul").first();

        //第一种类门票
        Element tickets=tickets_li.select("li").first().select("div").first();
        Element ticket=tickets.select("div.name").first();
        Element ticketA=ticket.select("span").get(0);
        Element ticketB=ticket.select("span").get(1);
        //市场价
        Element shichangjia=tickets.select("div.price").first();
        String str_shichangjia="市场价："+ shichangjia.text();
        //驴妈妈价
        Element lvmamajia=tickets.select("div.lv-price").first();
        String str_lvmama="驴妈妈价："+ lvmamajia.text();
        //第一条总的门票信息
        String Piao=ticketA.text()+"  "+ticketB.text()+"  "+str_shichangjia+" "+str_lvmama;
   
        
      //第二种类门票
        Element tickets_two=tickets_li.select("li").get(1).select("div").first();
       
        Element ticket_two=tickets_two.select("div.name").first();
        Element ticketA_two=ticket_two.select("span").get(0);
        Element ticketB_two=ticket_two.select("span").get(1);
    
        //市场价
        Element shichangjia_two=tickets_two.select("div.price").first();
        String str_shichangjia_two="市场价："+ shichangjia_two.text();

        //驴妈妈价
        Element lvmamajia_two=tickets_two.select("div.lv-price").first();
        String str_lvmama_two="驴妈妈价："+ lvmamajia_two.text();

//        //第一条总的门票信息
        String Piao_two=ticketA_two.text()+"  "+ticketB_two.text()+"  "+str_shichangjia_two+" "+str_lvmama_two;

      //第三种类门票
        Element tickets_three=tickets_li.select("li").get(2).select("div").first();
       // Log.i("ticket9999---:",tickets_two.text());
        Element ticket_three=tickets_three.select("div.name").first();
        Element ticketA_three=ticket_three.select("span").get(0);
        Element ticketB_three=ticket_three.select("span").get(1);
         
        //市场价
        Element shichangjia_three=tickets_three.select("div.price").first();
        String str_shichangjia_three="市场价："+ shichangjia_three.text();
 
        //驴妈妈价
        Element lvmamajia_three=tickets_three.select("div.lv-price").first();
        String str_lvmama_three="驴妈妈价："+ lvmamajia_three.text();

//        //第一条总的门票信息
        String Piao_three=ticketA_three.text()+"  "+ticketB_three.text()+"  "+str_shichangjia_three+" "+str_lvmama_three;
    
        
        //第四类门票
        Element tickets_four=tickets_li.select("li").get(4).select("div").first();
        // Log.i("ticket9999---:",tickets_two.text());
         Element ticket_four=tickets_four.select("div.name").first();
         Element ticketA_four=ticket_four.select("span").get(0);
         Element ticketB_four=ticket_four.select("span").get(1);
       
         //市场价
         Element shichangjia_four=tickets_four.select("div.price").first();
         String str_shichangjia_four="市场价："+ shichangjia_four.text();
 
         //驴妈妈价
         Element lvmamajia_four=tickets_four.select("div.lv-price").first();
         String str_lvmama_four="驴妈妈价："+ lvmamajia_four.text();

//         //第一条总的门票信息
         String Piao_four=ticketA_four.text()+"  "+ticketB_four.text()+"  "+str_shichangjia_four+" "+str_lvmama_four;

         imgs[2]=img1;
         names[2]=name1;
         addrs[2]=addr;
         times[2]=time;
         jianjies[2]=tese;
         tickey1[2]=Piao;
         tickey2[2]=Piao_two;
        
    
    }
    public void second_jingdian(){
    	 Element product1=div.select("div.product-item.product-ticket.searchTicket.clearfix[productid='252004']").first();
      
    	 Element img_ele=product1.select("div.product-regular.clearfix").first().select("div.product-left").first().select("a").first().select("img").first();
       
         //第一个景点图片
         String img1=img_ele.attr("src");
 
         //第一个景点名称
         Element name_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("h3").first();
         String name1= name_ele.text();

         //第一个景点地址
         Element addr_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(景点地址)").first().select("dd").first();
         String addr= addr_ele.text();

         //第一个景点营业时间
         Element time_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(营业时间)").first().select("dd").first().select("div").first();
         String time= time_ele.text();
    
         //第一个景点景点特色
         Element tese_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(景点特色)").first().select("dd").first().select("div").first();
         String tese=  tese_ele.text();

         //第一个景点门票
         Element tickets_li=product1.select("div.product-special").first().select("div.psh-tab-contents").first().select("div.psh-tab-content.active").first().select("ul").first();
        
         //第一种类门票
         Element tickets=tickets_li.select("li").first().select("div").first();
         Element ticket=tickets.select("div.name").first();
         Element ticketA=ticket.select("span").get(0);
         Element ticketB=ticket.select("span").get(1);
         //市场价
         Element shichangjia=tickets.select("div.price").first();
         String str_shichangjia="市场价："+ shichangjia.text();
         //驴妈妈价
         Element lvmamajia=tickets.select("div.lv-price").first();
         String str_lvmama="驴妈妈价："+ lvmamajia.text();
         //第一条总的门票信息
         String Piao=ticketA.text()+"  "+ticketB.text()+"  "+str_shichangjia+" "+str_lvmama;
      
         
       //第二种类门票
         Element tickets_two=tickets_li.select("li").get(1).select("div").first();
        // Log.i("ticket9999---:",tickets_two.text());
         Element ticket_two=tickets_two.select("div.name").first();
         Element ticketA_two=ticket_two.select("span").get(0);
         Element ticketB_two=ticket_two.select("span").get(1);
       
         //市场价
         Element shichangjia_two=tickets_two.select("div.price").first();
         String str_shichangjia_two="市场价："+ shichangjia_two.text();
   
         //驴妈妈价
         Element lvmamajia_two=tickets_two.select("div.lv-price").first();
         String str_lvmama_two="驴妈妈价："+ lvmamajia_two.text();
   
//         //第一条总的门票信息
         String Piao_two=ticketA_two.text()+"  "+ticketB_two.text()+"  "+str_shichangjia_two+" "+str_lvmama_two;  
       //第三种类门票
         Element tickets_three=tickets_li.select("li").get(2).select("div").first();
        // Log.i("ticket9999---:",tickets_two.text());
         Element ticket_three=tickets_three.select("div.name").first();
         Element ticketA_three=ticket_three.select("span").get(0);
         Element ticketB_three=ticket_three.select("span").get(1);
    
         //市场价
         Element shichangjia_three=tickets_three.select("div.price").first();
         String str_shichangjia_three="市场价："+ shichangjia_three.text();
  
         //驴妈妈价
         Element lvmamajia_three=tickets_three.select("div.lv-price").first();
         String str_lvmama_three="驴妈妈价："+ lvmamajia_three.text();

//         //第一条总的门票信息
         String Piao_three=ticketA_three.text()+"  "+ticketB_three.text()+"  "+str_shichangjia_three+" "+str_lvmama_three;
 
         //第四类门票
         Element tickets_four=tickets_li.select("li").get(4).select("div").first();
         // Log.i("ticket9999---:",tickets_two.text());
          Element ticket_four=tickets_four.select("div.name").first();
          Element ticketA_four=ticket_four.select("span").get(0);
          Element ticketB_four=ticket_four.select("span").get(1);
        
          //市场价
          Element shichangjia_four=tickets_four.select("div.price").first();
          String str_shichangjia_four="市场价："+ shichangjia_four.text();
 
          //驴妈妈价
          Element lvmamajia_four=tickets_four.select("div.lv-price").first();
          String str_lvmama_four="驴妈妈价："+ lvmamajia_four.text();
    //      Log.i("ticket---hhhhhh---:",str_lvmama_two);
//          //第一条总的门票信息
          String Piao_four=ticketA_four.text()+"  "+ticketB_four.text()+"  "+str_shichangjia_four+" "+str_lvmama_four;
          	 imgs[1]=img1;
	         names[1]=name1;
	         addrs[1]=addr;
	         times[1]=time;
	         jianjies[1]=tese;
	         tickey1[1]=Piao;
	         tickey2[1]=Piao_two;
	       	 	    
    }

	public void first_jingdian(){
    	// 第一个景点
        Element product1=div.select("div.product-item.product-ticket.searchTicket.clearfix[productid='172195']").first();
      //  Log.i("555",product1.html());
      
        Element img_ele=product1.select("div.product-regular.clearfix").first().select("div.product-left").first().select("a").first().select("img").first();
        //.select("div.product-left").first().select("img").first();
        //第一个景点图片
        String img1=img_ele.attr("src");
      //  Log.i("bbb---:",img1);
        		    
        //第一个景点名称
        Element name_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("h3").first();
        String name1= name_ele.text();
        
       // Log.i("zzzz---:",name1);
        //第一个景点地址
        Element addr_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(景点地址)").first().select("dd").first();
        String addr= addr_ele.text();  
        
      //  Log.i("www---:",addr);
        //第一个景点营业时间
        Element time_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(营业时间)").first().select("dd").first().select("div").first();
        String time= time_ele.text();
   
     //   Log.i("xxx---:",time);
        //第一个景点景点特色
        Element tese_ele=product1.select("div.product-regular.clearfix").first().select("div.product-section").first().select("dl.product-details.clearfix:contains(景点特色)").first().select("dd").first().select("div").first();
        String tese=  tese_ele.text();      
        
       // Log.i("sss---:",tese);
        //第一个景点门票
        Element tickets_li=product1.select("div.product-special").first().select("div.psh-tab-contents").first().select("div.psh-tab-content.active").first().select("ul").first();
        //Log.i("ul---:",tickets_li.html());
        //第一种类门票
        Element tickets=tickets_li.select("li").first().select("div").first();
        Element ticket=tickets.select("div.name").first();
        Element ticketA=ticket.select("span").get(0);
        Element ticketB=ticket.select("span").get(1);
        //市场价
        Element shichangjia=tickets.select("div.price").first();
        String str_shichangjia="市场价："+ shichangjia.text();
        //驴妈妈价
        Element lvmamajia=tickets.select("div.lv-price").first();
        String str_lvmama="驴妈妈价："+ lvmamajia.text();
        //第一条总的门票信息
        String Piao=ticketA.text()+"  "+ticketB.text()+"  "+str_shichangjia+" "+str_lvmama;
       // Log.i("ticket4444---:",Piao);	        
        
      //第二种类门票
        Element tickets_two=tickets_li.select("li").get(1).select("div").first();
       // Log.i("ticket9999---:",tickets_two.text());
        Element ticket_two=tickets_two.select("div.name").first();
        Element ticketA_two=ticket_two.select("span").get(0);
        Element ticketB_two=ticket_two.select("span").get(1);
     //   Log.i("ticket0000---:",ticketA_two.text()+ticketB_two.text());     
        //市场价
        Element shichangjia_two=tickets_two.select("div.price").first();
        String str_shichangjia_two="市场价："+ shichangjia_two.text();
  
        //驴妈妈价
        Element lvmamajia_two=tickets_two.select("div.lv-price").first();
        String str_lvmama_two="驴妈妈价："+ lvmamajia_two.text();
 
//        //第一条总的门票信息
        String Piao_two=ticketA_two.text()+"  "+ticketB_two.text()+"  "+str_shichangjia_two+" "+str_lvmama_two;
        
      //第三种类门票
        Element tickets_three=tickets_li.select("li").get(2).select("div").first();
       // Log.i("ticket9999---:",tickets_two.text());
        Element ticket_three=tickets_three.select("div.name").first();
        Element ticketA_three=ticket_three.select("span").get(0);
        Element ticketB_three=ticket_three.select("span").get(1);   
        //市场价
        Element shichangjia_three=tickets_three.select("div.price").first();
        String str_shichangjia_three="市场价："+ shichangjia_three.text();
        //驴妈妈价
        Element lvmamajia_three=tickets_three.select("div.lv-price").first();
        String str_lvmama_three="驴妈妈价："+ lvmamajia_three.text();
//        //第一条总的门票信息
        String Piao_three=ticketA_three.text()+"  "+ticketB_three.text()+"  "+str_shichangjia_three+" "+str_lvmama_three;  
        
        //第四类门票
        Element tickets_four=tickets_li.select("li").get(4).select("div").first();
        
         Element ticket_four=tickets_four.select("div.name").first();
         Element ticketA_four=ticket_four.select("span").get(0);
         Element ticketB_four=ticket_four.select("span").get(1);
      
         //市场价
         Element shichangjia_four=tickets_four.select("div.price").first();
         String str_shichangjia_four="市场价："+ shichangjia_four.text();
  
         //驴妈妈价
         Element lvmamajia_four=tickets_four.select("div.lv-price").first();
         String str_lvmama_four="驴妈妈价："+ lvmamajia_four.text();

//         //第一条总的门票信息
         String Piao_four=ticketA_four.text()+"  "+ticketB_four.text()+"  "+str_shichangjia_four+" "+str_lvmama_four;

  
         imgs[0]=img1;
         names[0]=name1;
         addrs[0]=addr;
         times[0]=time;
         jianjies[0]=tese;
         tickey1[0]=Piao;
         tickey2[0]=Piao_two;
        
	}
	
}
