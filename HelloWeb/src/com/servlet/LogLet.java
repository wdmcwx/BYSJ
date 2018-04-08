package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Service;

public class LogLet extends HttpServlet {

    private static final long serialVersionUID = 369840050351775312L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 接收客户端信息
    	 //tag 1是插入，2是查询
        String username = request.getParameter("username");
        username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
        String password = request.getParameter("password");
        String tag=request.getParameter("tag");
        
        System.out.println(username + "--" + password+"----"+tag);
           
        // 新建服务对象
        Service serv = new Service();

        // 验证处理  成功与否标志位
        String loged = null ;
        Boolean reged = null;
        
        StringBuffer sb = new StringBuffer();
        int a=0;
        
        if(tag.equals("1")){
        	//注册操作
        	reged=serv.register(username, password);
        	a=1;
        }else if(tag.equals("2")){
        	//登录操作
        	loged = serv.login(username, password);
        	a=2;
        }else if(tag.equals("3")){
        	//文章分享查询操作
        	sb=serv.login2();
        	a=3;
        }
        
        // 返回信息到客户端
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(a==1){
        	if(reged){
        		 out.print("注册成功");
        	}else{
        		 out.print("注册失败");
        	}
        	
        }else if(a==2){
        	if(loged.equals("1")){
        		out.print("1");
        	}else{
        		out.print("2");
        	}
        }else if(a==3){
        	//StringBuffer对象有一个重写了toString()这个方法，其内部实现就是返回你所append的字符串
        	 out.print("" + sb.toString());
        }
       
        out.flush();
        out.close();

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}