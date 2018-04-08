package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Service;

public class SaveArticle extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        // ���տͻ�����Ϣ
	    	
	        String article = request.getParameter("article");
	        article = new String(article.getBytes("ISO-8859-1"), "UTF-8");
	        String username=request.getParameter("username");
	        username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
	        System.out.println(article +"----"+username);
	        
	       
	        // �½��������
	        Service serv = new Service();
	        serv.saveArticle(username, article);

	        // ������Ϣ���ͻ���
	        response.setCharacterEncoding("UTF-8");
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
            out.println("�û�����" + username);
	        out.println("���£�" + article);
	    //     out.print("" + loged);
	        out.flush();
	        out.close();

	    }
}
