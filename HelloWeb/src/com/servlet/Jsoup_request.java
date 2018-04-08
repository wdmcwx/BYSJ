package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Service;

public class Jsoup_request extends HttpServlet {

    private static final long serialVersionUID = 369840050351775312L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 接收客户端信息
        String tag = request.getParameter("tag");
        tag = new String(tag.getBytes("ISO-8859-1"), "UTF-8");
        
        if(tag.equals("gonglue")){
        	Gonglue_spider spider=new Gonglue_spider();
     		try {
     			spider.crawlHtml("http://www.lvmama.com/lvyou/youji/d-shenzhen231.html");
     		} catch (Exception e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
        }else if(tag.equals("jingdian")){
        	Jingdian_spider jingdian=new Jingdian_spider();
        	try {
        		jingdian.crawlHtml("http://s.lvmama.com/ticket/H324K440300?keyword=%E6%B7%B1%E5%9C%B3&tabType=route#list");
     		} catch (Exception e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
        	
        }else if(tag.equals("jiudian")){
        	Jiudian_spider jiudian=new Jiudian_spider();
        	try {
        		jiudian.crawlHtml("http://hotel.mangocity.com/list-1-szx.html");
     		} catch (Exception e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
        	
        }else if(tag.equals("youji")){
        	
        	Youji_spider youji=new Youji_spider();
        	try {
        		youji.crawlHtml("http://www.lvmama.com/lvyou/youji/d-shenzhen231.html");
     		} catch (Exception e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
        	
        }else if(tag.equals("meishi")){
        	Meishi_spider meishi=new Meishi_spider();
        	try {
        		meishi.crawlHtml("http://www.lvmama.com/lvyou/food/d-shenzhen231.html");
     		} catch (Exception e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
        }else if(tag.equals("gouwu")){
        	Gouwu_spider gouwu=new Gouwu_spider();
        	try {
        		gouwu.crawlHtml("http://www.lvmama.com/lvyou/shop/d-shenzhen231.html");
     		} catch (Exception e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
        }

        // 返回信息到客户端
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.print("用户名：" + username);
//        out.print("密码：" + password);
//        out.flush();
//        out.close();

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}