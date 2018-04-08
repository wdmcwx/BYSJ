package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.DBManager;

public class Service {

    public String login(String username, String password) {
    	
    	String sb ="" ;
        // 获取Sql查询语句
        String logSql = "select * from user where username ='" + username
                + "' and password ='" + password + "'";

        // 获取DB对象
        DBManager sql = DBManager.createInstance();
        sql.connectDB();

        // 操作DB对象
        try {
            ResultSet rs = sql.executeQuery(logSql);
            
            if(rs.next()){
            	sb="1"; //1 表示有数值
            }else{
            	sb="2";
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.closeDB();     
		return sb;
    }
    
public String UserInfo(String username, String password) {
    	
    	String sb ="" ;
        // 获取Sql查询语句
        String logSql = "select * from userinfo where u_name ='" + username
                + "' and u_password ='" + password + "'";

        // 获取DB对象
        DBManager sql = DBManager.createInstance();
        sql.connectDB();

        // 操作DB对象
        try {
            ResultSet rs = sql.executeQuery(logSql);
            
            if(rs.next()){
            	sb="1"; //1 表示有数值
            }else{
            	sb="2";
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.closeDB();     
		return sb;
 }
    
 public StringBuffer login2() {
    	
	 	StringBuffer sb = new StringBuffer() ;
	 	
        // 获取Sql查询语句
        String logSql = "select * from  sharearticle";

        // 获取DB对象
        DBManager sql = DBManager.createInstance();
        sql.connectDB();

        // 操作DB对象
        try {
            ResultSet rs = sql.executeQuery(logSql);
   
            while(rs.next()){
            	
            	sb.append("\n"+"id:"+rs.getInt("id")+"\n");
            	sb.append("username:"+rs.getString("username")+"\n");
            	sb.append("article:"+rs.getString("article")+"\n");
            	sb.append("*****************************");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.closeDB();     
		return sb;
    }


    public Boolean register(String username, String password) {
    
        // 获取Sql查询语句
        String regSql = "insert into user(username,password) values('"+ username+ "','"+ password+ "') ";

        // 获取DB对象
        DBManager sql = DBManager.createInstance();
        sql.connectDB();

        int ret = sql.executeUpdate(regSql);
        if (ret != 0) {
            sql.closeDB();
            return true;
        }
        sql.closeDB();
        
        return false;
    }
    
    public Boolean saveArticle(String username, String article) {
        
        // 获取Sql查询语句
        String regSql = "insert into  shareArticle(username,article) values('"+ username+ "','"+ article+ "') ";

        // 获取DB对象
        DBManager sql = DBManager.createInstance();
        sql.connectDB();

        int ret = sql.executeUpdate(regSql);
        if (ret != 0) {
            sql.closeDB();
            return true;
        }
        sql.closeDB();
        
        return false;
    }
    
    
	  public Boolean insertGonglue(String titles, String imgs,String author_time, String profiles) {
	        
	        // 获取Sql查询语句
	        String regSql = "insert into  gonglue(titles,imgs,author_time,profiles) values('"+ titles+ "','"+ imgs+ "','"+author_time+"','"+profiles+"') ";
	
	        // 获取DB对象
	        DBManager sql = DBManager.createInstance();
	        sql.connectDB();
	
	        int ret = sql.executeUpdate(regSql);
	        if (ret != 0) {
	            sql.closeDB();
	            return true;
	        }
	        sql.closeDB();
	        
	        return false;
	  }
	  
	  public Boolean insertYouji(String imgs, String titles,String chapters, String summarys,String anthor_times) {
	        
	        // 获取Sql查询语句
	        String regSql = "insert into  youji(imgs,titles,chapters,summarys,anthor_times) values('"+ imgs+ "','"+ titles+ "','"+chapters+"','"+summarys+"','"+anthor_times+"') ";
	
	        // 获取DB对象
	        DBManager sql = DBManager.createInstance();
	        sql.connectDB();
	
	        int ret = sql.executeUpdate(regSql);
	        if (ret != 0) {
	            sql.closeDB();
	            return true;
	        }
	        sql.closeDB();
	        
	        return false;
	  }
	  
	  public Boolean insertJiudian(String imgs, String names,String addrs) {
	        
	        // 获取Sql查询语句
	        String regSql = "insert into  jiudian(imgs,names,addrs) values('"+ imgs+ "','"+ names+ "','"+addrs+"') ";
	
	        // 获取DB对象
	        DBManager sql = DBManager.createInstance();
	        sql.connectDB();
	
	        int ret = sql.executeUpdate(regSql);
	        if (ret != 0) {
	            sql.closeDB();
	            return true;
	        }
	        sql.closeDB();
	        
	        return false;
	  }
  
	  public Boolean insertMeishi(String imgs, String names,String caixis, String summarys) {
	        
	        // 获取Sql查询语句
	        String regSql = "insert into  meishi(imgs,names,caixis,summarys) values('"+ imgs+ "','"+ names+ "','"+caixis+"','"+summarys+"') ";
	
	        // 获取DB对象
	        DBManager sql = DBManager.createInstance();
	        sql.connectDB();
	
	        int ret = sql.executeUpdate(regSql);
	        if (ret != 0) {
	            sql.closeDB();
	            return true;
	        }
	        sql.closeDB();
	        
	        return false;
	  }

	  public Boolean insertGouwu(String imgs, String titles,String addrs) {
	      
	      // 获取Sql查询语句
	      String regSql = "insert into  gouwu(imgs,titles,addrs) values('"+  imgs+ "','"+titles+ "','"+addrs+"') ";
	
	      // 获取DB对象
	      DBManager sql = DBManager.createInstance();
	      sql.connectDB();
	
	      int ret = sql.executeUpdate(regSql);
	      if (ret != 0) {
	          sql.closeDB();
	          return true;
	      }
	      sql.closeDB();
	      
	      return false;
	  }
	  
	  public Boolean insertJingdian(String imgs, String names,String times,String addrs, String jianjies,String tickey1,String tickey2) {
	      
	      // 获取Sql查询语句
	      String regSql = "insert into  jingdian(imgs,names,times,addrs,jianjies,tickey1,tickey2) values('"+ imgs+ "','"+ names+ "','"+times+"','"+addrs+"','"+jianjies+"','"+tickey1+"','"+tickey2+"') ";
	
	      // 获取DB对象
	      DBManager sql = DBManager.createInstance();
	      sql.connectDB();
	
	      int ret = sql.executeUpdate(regSql);
	      if (ret != 0) {
	          sql.closeDB();
	          return true;
	      }
	      sql.closeDB();
	      
	      return false;
	  }
}