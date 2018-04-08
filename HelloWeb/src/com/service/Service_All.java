package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.Gonglue;
import com.dao.Gouwu;
import com.dao.Jingdian;
import com.dao.Jiudian;
import com.dao.Meishi;
import com.dao.Youji;
import com.db.DBManager;

public class Service_All {
	
	public List<Gonglue> queryGonglue(){
		
		List<Gonglue> gonglueList = new ArrayList<Gonglue>();
		
        // ��ȡSql��ѯ���
        String logSql = "select * from gonglue";

        // ��ȡDB����
        DBManager sql = DBManager.createInstance();
        sql.connectDB();
        
        // ����DB����
        try {
            ResultSet rs = sql.executeQuery(logSql);
            
            while(rs.next()){
            	Gonglue gonglue=new Gonglue();
            	gonglue.setTitles(rs.getString("titles"));
            	gonglue.setAuthor_time(rs.getString("author_time"));
            	gonglue.setImgs(rs.getString("imgs"));
            	gonglue.setProfiles(rs.getString("profiles"));
            	gonglueList.add(gonglue);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.closeDB();  
		return gonglueList;
	}
	
	
	
	public List<Jingdian> queryJingdian(){
		
		List<Jingdian> jingdianList = new ArrayList<Jingdian>();
		
        // ��ȡSql��ѯ���
        String logSql = "select * from jingdian";

        // ��ȡDB����
        DBManager sql = DBManager.createInstance();
        sql.connectDB();
        
        // ����DB����
        try {
            ResultSet rs = sql.executeQuery(logSql);
            
            while(rs.next()){
            	Jingdian jingdian=new Jingdian();
            	
            	jingdian.setNames(rs.getString("names"));
            	jingdian.setTimes(rs.getString("times"));
            	jingdian.setImgs(rs.getString("imgs"));
            	jingdian.setAddrs(rs.getString("addrs"));
            	jingdian.setJianjies(rs.getString("jianjies"));
            	jingdian.setTickey1(rs.getString("tickey1"));
            	jingdian.setTickey2(rs.getString("tickey2"));
            	jingdianList.add(jingdian);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.closeDB();  
		return jingdianList;
	}
	
	public List<Jiudian> queryJiudian(){
		
		List<Jiudian> jiudianList = new ArrayList<Jiudian>();
		
        // ��ȡSql��ѯ���
        String logSql = "select * from jiudian";

        // ��ȡDB����
        DBManager sql = DBManager.createInstance();
        sql.connectDB();
        
        // ����DB����
        try {
            ResultSet rs = sql.executeQuery(logSql);
            
            while(rs.next()){
            	Jiudian jiudian=new Jiudian();
            	
            	jiudian.setNames(rs.getString("names"));
            	jiudian.setImgs(rs.getString("imgs"));
            	jiudian.setAddrs(rs.getString("addrs"));
            	
            	jiudianList.add(jiudian);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.closeDB();  
		return jiudianList;
	}
	
	public List<Youji> queryYouji(){
		
		List<Youji> youjiList = new ArrayList<Youji>();
		
        // ��ȡSql��ѯ���
        String logSql = "select * from youji";

        // ��ȡDB����
        DBManager sql = DBManager.createInstance();
        sql.connectDB();
        
        // ����DB����
        try {
            ResultSet rs = sql.executeQuery(logSql);
            
            while(rs.next()){
            	Youji youji=new Youji();
            	
            	youji.setTitles(rs.getString("titles"));
            	youji.setImgs(rs.getString("imgs"));
            	youji.setChapters(rs.getString("chapters"));
            	youji.setSummarys(rs.getString("summarys"));
            	youji.setAnthor_times(rs.getString("anthor_times"));
            	
            	youjiList .add(youji);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.closeDB();  
		return youjiList ;
	}
	
	
	public List<Meishi> queryMeishi(){
		
		List<Meishi> meishiList = new ArrayList<Meishi>();
		
        // ��ȡSql��ѯ���
        String logSql = "select * from meishi";

        // ��ȡDB����
        DBManager sql = DBManager.createInstance();
        sql.connectDB();
        
        // ����DB����
        try {
            ResultSet rs = sql.executeQuery(logSql);
            
            while(rs.next()){
            	Meishi meishi=new Meishi();
            	
            	meishi.setNames(rs.getString("names"));
            	meishi.setImgs(rs.getString("imgs"));
            	meishi.setCaixis(rs.getString("caixis"));
            	meishi.setSummarys(rs.getString("summarys"));
            	
            	meishiList .add(meishi);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.closeDB();  
		return meishiList ;
	}
	
	
	public List<Gouwu> queryGouwu(){
		
		List<Gouwu> gouwuList = new ArrayList<Gouwu>();
		
        // ��ȡSql��ѯ���
        String logSql = "select * from gouwu";

        // ��ȡDB����
        DBManager sql = DBManager.createInstance();
        sql.connectDB();
        
        // ����DB����
        try {
            ResultSet rs = sql.executeQuery(logSql);
            
            while(rs.next()){
            	Gouwu gouwu=new Gouwu();
            	
            	gouwu.setTitles(rs.getString("titles"));
            	gouwu.setImgs(rs.getString("imgs"));
            	gouwu.setAddrs(rs.getString("addrs"));
            	
            	 gouwuList .add(gouwu);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.closeDB();  
		return  gouwuList ;
	}
}
