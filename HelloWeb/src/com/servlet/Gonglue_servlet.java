package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Gonglue;
import com.dao.Gouwu;
import com.dao.Jingdian;
import com.dao.Jiudian;
import com.dao.Meishi;
import com.dao.Youji;
import com.service.Service_All;

public class Gonglue_servlet extends HttpServlet{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        // 接收客户端信息    	 
	        String tag = request.getParameter("tag");
	        
	        System.out.println("-----------------:"+tag);
	        
	        StringBuffer sb = new StringBuffer();       
	        // 新建服务对象
	        Service_All service=new Service_All();
	        		
	        if(tag.equals("gonglue")){
	          List<Gonglue> gonglueList=service.queryGonglue(); //查询方法调用
	          // \r return， 输入光标回到行的开头
	          // \n newline，换行
	          sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>").append("\r\n").append("<Gonglues>").append("\r\n");
	          
	          for(int i=0;i<gonglueList.size();i++){
	        	  sb.append("	<Gonglue>").append("\r\n")
					.append("		<titles>").append(gonglueList.get(i).getTitles()).append("</titles>").append("\r\n")
					.append("		<imgs>").append(gonglueList.get(i).getImgs()).append("</imgs>").append("\r\n")
					.append("		<author_time>").append(gonglueList.get(i).getAuthor_time()).append("</author_time>").append("\r\n")
					.append("		<profiles>").append(gonglueList.get(i).getProfiles()).append("</profiles>").append("\r\n")
				.append("	</Gonglue>").append("\r\n");
	          }
	          
	          sb.append("</Gonglues>").append("\r\n");
	 		 
				response.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				out.print(sb.toString());
				out.flush();
		        out.close();
	        }
	        
	        if(tag.equals("jingdian")){
	            List<Jingdian> jingdianList=service.queryJingdian(); //查询方法调用
	            // \r return， 输入光标回到行的开头
	            // \n newline，换行
	            sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>").append("\r\n").append("<Jingdians>").append("\r\n");
	            
	            for(int i=0;i<jingdianList.size();i++){
	          	  sb.append("	<Jingdian>").append("\r\n")
	  				.append("		<imgs>").append(jingdianList.get(i).getImgs()).append("</imgs>").append("\r\n")
	  				.append("		<names>").append(jingdianList.get(i).getNames()).append("</names>").append("\r\n")
	  				.append("		<times>").append(jingdianList.get(i).getTimes()).append("</times>").append("\r\n")
	  				.append("		<addrs>").append(jingdianList.get(i).getAddrs()).append("</addrs>").append("\r\n")
	  				.append("		<jianjies>").append(jingdianList.get(i).getJianjies()).append("</jianjies>").append("\r\n")
	  				.append("		<tickey1>").append(jingdianList.get(i).getTickey1()).append("</tickey1>").append("\r\n")
	  				.append("		<tickey2>").append(jingdianList.get(i).getTickey2()).append("</tickey2>").append("\r\n")
	  				
	  			.append("	</Jingdian>").append("\r\n");
	            }
	            
	            sb.append("</Jingdians>").append("\r\n");
	   		 
	  			response.setCharacterEncoding("utf-8");
	  			PrintWriter out = response.getWriter();
	  			out.print(sb.toString());
	  			out.flush();
	  	        out.close();        		        	
	        }
	        
	        if(tag.equals("gouwu")){
	        	
	        	 List<Gouwu> gouwuList=service.queryGouwu(); //查询方法调用
	             // \r return， 输入光标回到行的开头
	             // \n newline，换行
	             sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>").append("\r\n").append("<Gouwus>").append("\r\n");
	             
	             for(int i=0;i<gouwuList.size();i++){
	           	  sb.append("	<Gouwu>").append("\r\n")
	   				.append("		<imgs>").append(gouwuList.get(i).getImgs()).append("</imgs>").append("\r\n")
	   				.append("		<titles>").append(gouwuList.get(i).getTitles()).append("</titles>").append("\r\n")
	   				.append("		<addrs>").append(gouwuList.get(i).getAddrs()).append("</addrs>").append("\r\n")
	   	
	   			.append("	</Gouwu>").append("\r\n");
	             }
	             
	             sb.append("</Gouwus>").append("\r\n");
	    		 
	   			response.setCharacterEncoding("utf-8");
	   			PrintWriter out = response.getWriter();
	   			out.print(sb.toString());
	   			out.flush();
	   	        out.close();
	        }
	        
	        if(tag.equals("jiudian")){
	            List<Jiudian> jiudianList=service.queryJiudian(); //查询方法调用
	            // \r return， 输入光标回到行的开头
	            // \n newline，换行
	            sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>").append("\r\n").append("<Jiudians>").append("\r\n");
	            
	            for(int i=0;i<jiudianList.size();i++){
	          	  sb.append("	<Jiudian>").append("\r\n")
	  				.append("		<imgs>").append(jiudianList.get(i).getImgs()).append("</imgs>").append("\r\n")
	  				.append("		<names>").append(jiudianList.get(i).getNames()).append("</names>").append("\r\n")	
	  				.append("		<addrs>").append(jiudianList.get(i).getAddrs()).append("</addrs>").append("\r\n")	
	  			.append("	</Jiudian>").append("\r\n");
	            }
	            
	            sb.append("</Jiudians>").append("\r\n");
	   		 
	  			response.setCharacterEncoding("utf-8");
	  			PrintWriter out = response.getWriter();
	  			out.print(sb.toString());
	  			out.flush();
	  	        out.close();
	          }
	        
	        if(tag.equals("youji")){
	            List<Youji> youjiList=service.queryYouji(); //查询方法调用
	            // \r return， 输入光标回到行的开头
	            // \n newline，换行
	            sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>").append("\r\n").append("<Youjis>").append("\r\n");
	            
	            for(int i=0;i<youjiList.size();i++){
	          	  sb.append("	<Youji>").append("\r\n")
	  				.append("		<imgs>").append(youjiList.get(i).getImgs()).append("</imgs>").append("\r\n")
	  				.append("		<titles>").append(youjiList.get(i).getTitles()).append("</titles>").append("\r\n")
	  				.append("		<chapters>").append(youjiList.get(i).getChapters()).append("</chapters>").append("\r\n")
	  				.append("		<summarys>").append(youjiList.get(i).getSummarys()).append("</summarys>").append("\r\n")
	  				.append("		<anthor_times>").append(youjiList.get(i).getAnthor_times()).append("</anthor_times>").append("\r\n")
	  	
	  			.append("	</Youji>").append("\r\n");
	            }
	            
	            sb.append("</Youjis>").append("\r\n");
	   		 
	  			response.setCharacterEncoding("utf-8");
	  			PrintWriter out = response.getWriter();
	  			out.print(sb.toString());
	  			out.flush();
	  	        out.close();
	          }

	        if(tag.equals("meishi")){
	            List<Meishi> meishiList=service.queryMeishi(); //查询方法调用
	            // \r return， 输入光标回到行的开头
	            // \n newline，换行
	            sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>").append("\r\n").append("<Meishis>").append("\r\n");
	            
	            for(int i=0;i<meishiList.size();i++){
	          	  sb.append("	<Meishi>").append("\r\n")
	  				.append("		<imgs>").append(meishiList.get(i).getImgs()).append("</imgs>").append("\r\n")
	  				.append("		<names>").append(meishiList.get(i).getNames()).append("</names>").append("\r\n")
	  				.append("		<caixis>").append(meishiList.get(i).getCaixis()).append("</caixis>").append("\r\n")
	  				.append("		<summarys>").append(meishiList.get(i).getSummarys()).append("</summarys>").append("\r\n")
	  				
	  			.append("	</Meishi>").append("\r\n");
	            }
	            
	            sb.append("</Meishis>").append("\r\n");
	   		 
	  			response.setCharacterEncoding("utf-8");
	  			PrintWriter out = response.getWriter();
	  			out.print(sb.toString());
	  			out.flush();
	  	        out.close();
	          }
	        

	    }
}
