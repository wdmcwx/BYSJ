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

        // ���տͻ�����Ϣ
    	 //tag 1�ǲ��룬2�ǲ�ѯ
        String username = request.getParameter("username");
        username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
        String password = request.getParameter("password");
        String tag=request.getParameter("tag");
        
        System.out.println(username + "--" + password+"----"+tag);
           
        // �½��������
        Service serv = new Service();

        // ��֤����  �ɹ�����־λ
        String loged = null ;
        Boolean reged = null;
        
        StringBuffer sb = new StringBuffer();
        int a=0;
        
        if(tag.equals("1")){
        	//ע�����
        	reged=serv.register(username, password);
        	a=1;
        }else if(tag.equals("2")){
        	//��¼����
        	loged = serv.login(username, password);
        	a=2;
        }else if(tag.equals("3")){
        	//���·����ѯ����
        	sb=serv.login2();
        	a=3;
        }
        
        // ������Ϣ���ͻ���
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(a==1){
        	if(reged){
        		 out.print("ע��ɹ�");
        	}else{
        		 out.print("ע��ʧ��");
        	}
        	
        }else if(a==2){
        	if(loged.equals("1")){
        		out.print("1");
        	}else{
        		out.print("2");
        	}
        }else if(a==3){
        	//StringBuffer������һ����д��toString()������������ڲ�ʵ�־��Ƿ�������append���ַ���
        	 out.print("" + sb.toString());
        }
       
        out.flush();
        out.close();

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}