package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Service;


public class UserInfo extends HttpServlet {
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        // ���տͻ�����Ϣ
	        String username = request.getParameter("username");
	        username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
	        String password = request.getParameter("password");
	        password = new String(password.getBytes("ISO-8859-1"), "UTF-8");
	        
	        System.out.println(username + "--" + password);
	           
	        // �½��������
	        Service serv = new Service();

	        // ��֤����  �ɹ�����־λ
	        String loged = null ;
	        loged = serv.UserInfo(username, password);   
	        // ������Ϣ���ͻ���
	        response.setCharacterEncoding("UTF-8");
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        out.print(loged);	       
	        out.flush();
	        out.close();

	    }

}
