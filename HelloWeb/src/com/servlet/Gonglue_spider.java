package com.servlet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.service.Service;


public class Gonglue_spider {
	
	Element element;
	String[] titles=new String[8]; //���ڱ������
	String[] imgs=new String[8];  //���ڱ�����Ƭ
	String[] author_time=new String[8]; //���ڱ������ߺͷ���ʱ��
	String[] profiles=new String[8];  //���ڷ�����
	
	public void crawlHtml(String url) throws Exception {
		//��ȡ�����෵�ص�html,����Jsoup����
		String result = AbstractSpider.getResult(url);
		//����html�ַ���
		Document document = Jsoup.parse(result);
		//setBaseUri(String baseUri)��ָ����URL�������ȡ������URLֻ���ǿ��ַ���
		document.setBaseUri(url);
		//��ȡ���е�imgԪ��
		element= document.getElementById("new_guide");
		// ʹ��jsoup��ȡ��Ϣ
		gl();	
		 // �½��������
        Service service=new Service();
       // ��ȡ�������ݿ���� 
        for(int i=0;i<titles.length;i++){
        	service.insertGonglue(titles[i],imgs[i],author_time[i],profiles[i]);
        }
        
	}
	
	 public void gl(){
   	    first_gl();
        second_gl(); 
        three_gl();
        four_gl();
        five_gl();
        six_gl();
        seven_gl();
        eighth_gl();
     }
	 public void first_gl(){
	    	Element dl=element.getElementById("guide_elite_202726");
	    	Element img_ele=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
	    	//��ȡ��Ƭ
	    	String str_img=img_ele.attr("src");
	    	
	    	Element details=dl.select("dd").get(0);
	    	Element title=details.select("div").get(0).select("a").get(0);
	    	//����
	    	String str_title=title.text();
	    	
	    	Element anthor_time=details.select("p").get(0);
	    	//���ߡ�������ʱ��
	    	String str_anthor_time=anthor_time.text();
	    	
	    	//����
	    	Element profile=details.select("p").get(1);
	    	String str_profile=profile.text();	
	    	
	    	titles[0]=str_title;
	    	imgs[0]=str_img;
	    	author_time[0]=str_anthor_time;
	    	profiles[0]=str_profile;
	    }
	 
	 public void second_gl(){
	    	Element dl=element.getElementById("guide_elite_202441");
	    	Element img_ele=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
	    	//��ȡ��Ƭ
	    	String str_img=img_ele.attr("src");
	    
	    	//Toast.makeText(MainActivity.this, str_img, Toast.LENGTH_LONG).show();
	    	
	    	Element details=dl.select("dd").get(0);
	    	Element title=details.select("div").get(0).select("a").get(0);
	    	//����
	    	String str_title=title.text();
	    
	    	//Toast.makeText(MainActivity.this, str_title, Toast.LENGTH_LONG).show();
	    	Element anthor_time=details.select("p").get(0);
	    	//���ߡ�������ʱ��
	    	String str_anthor_time=anthor_time.text();
	    	
	    	
	    	//����
	    	Element profile=details.select("p").get(1);
	    	String str_profile=profile.text();
	    
	    	
	    	titles[1]=str_title;
	    	imgs[1]=str_img;
	    	author_time[1]=str_anthor_time;
	    	profiles[1]=str_profile;
	    }
		public void three_gl(){
			Element dl=element.getElementById("guide_elite_202378");
	    	Element img_ele=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
	    	//��ȡ��Ƭ
	    	String str_img=img_ele.attr("src");
	    
	    	//Toast.makeText(MainActivity.this, str_img, Toast.LENGTH_LONG).show();
	    	
	    	Element details=dl.select("dd").get(0);
	    	Element title=details.select("div").get(0).select("a").get(0);
	    	//����
	    	String str_title=title.text();
	    
	    	//Toast.makeText(MainActivity.this, str_title, Toast.LENGTH_LONG).show();
	    	Element anthor_time=details.select("p").get(0);
	    	//���ߡ�������ʱ��
	    	String str_anthor_time=anthor_time.text();
	    	
	    	
	    	//����
	    	Element profile=details.select("p").get(1);
	    	String str_profile=profile.text();
	    	
	    	
	    	titles[2]=str_title;
	    	imgs[2]=str_img;
	    	author_time[2]=str_anthor_time;
	    	profiles[2]=str_profile;
		}
		public void four_gl(){
			Element dl=element.getElementById("guide_elite_202173");
	    	Element img_ele=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
	    	//��ȡ��Ƭ
	    	String str_img=img_ele.attr("src");
	
	    	Element details=dl.select("dd").get(0);
	    	Element title=details.select("div").get(0).select("a").get(0);
	    	//����
	    	String str_title=title.text();
	 
	    	Element anthor_time=details.select("p").get(0);
	    	//���ߡ�������ʱ��
	    	String str_anthor_time=anthor_time.text();
	    	
	    	
	    	//����
	    	Element profile=details.select("p").get(1);
	    	String str_profile=profile.text();
	   	
	    	titles[3]=str_title;
	    	imgs[3]=str_img;
	    	author_time[3]=str_anthor_time;
	    	profiles[3]=str_profile;
		}
		public void five_gl(){
			Element dl=element.getElementById("guide_elite_202076");
	    	Element img_ele=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
	    	//��ȡ��Ƭ
	    	String str_img=img_ele.attr("src");
	    	
	    	Element details=dl.select("dd").get(0);
	    	Element title=details.select("div").get(0).select("a").get(0);
	    	//����
	    	String str_title=title.text();
	  
	    	Element anthor_time=details.select("p").get(0);
	    	//���ߡ�������ʱ��
	    	String str_anthor_time=anthor_time.text();
	    	
	    	
	    	//����
	    	Element profile=details.select("p").get(1);
	    	String str_profile=profile.text();	
	    	
	    	titles[4]=str_title;
	    	imgs[4]=str_img;
	    	author_time[4]=str_anthor_time;
	    	profiles[4]=str_profile;
		}
		public void six_gl(){
			Element dl=element.getElementById("guide_elite_201728");
	    	Element img_ele=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
	    	//��ȡ��Ƭ
	    	String str_img=img_ele.attr("src");
	   
	    	
	    	Element details=dl.select("dd").get(0);
	    	Element title=details.select("div").get(0).select("a").get(0);
	    	//����
	    	String str_title=title.text();
	    	
	    	Element anthor_time=details.select("p").get(0);
	    	//���ߡ�������ʱ��
	    	String str_anthor_time=anthor_time.text();
	    
	    	
	    	//����
	    	Element profile=details.select("p").get(1);
	    	String str_profile=profile.text();
	    
	    	
	    	titles[5]=str_title;
	    	imgs[5]=str_img;
	    	author_time[5]=str_anthor_time;
	    	profiles[5]=str_profile;
		}
		public void seven_gl(){
			Element dl=element.getElementById("guide_elite_201599");
	    	Element img_ele=dl.select("dt").get(0).select("a").get(0).select("img").get(0 );
	    	//��ȡ��Ƭ
	    	String str_img=img_ele.attr("src");

	    	Element details=dl.select("dd").get(0);
	    	Element title=details.select("div").get(0).select("a").get(0);
	    	//����
	    	String str_title=title.text();

	    	Element anthor_time=details.select("p").get(0);
	    	//���ߡ�������ʱ��
	    	String str_anthor_time=anthor_time.text();
	    	
	    	
	    	//����
	    	Element profile=details.select("p").get(1);
	    	String str_profile=profile.text();
	   
	    	
	    	titles[6]=str_title;
	    	imgs[6]=str_img;
	    	author_time[6]=str_anthor_time;
	    	profiles[6]=str_profile;
		}
		public void eighth_gl(){
			Element dl=element.getElementById("guide_elite_200874");
	    	Element img_ele=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
	    	//��ȡ��Ƭ
	    	String str_img=img_ele.attr("src");

	    	
	    	Element details=dl.select("dd").get(0);
	    	Element title=details.select("div").get(0).select("a").get(0);
	    	//����
	    	String str_title=title.text();
	
	    	Element anthor_time=details.select("p").get(0);
	    	//���ߡ�������ʱ��
	    	String str_anthor_time=anthor_time.text();
	  
	    	
	    	//����
	    	Element profile=details.select("p").get(1);
	    	String str_profile=profile.text();

	    	
	    	titles[7]=str_title;
	    	imgs[7]=str_img;
	    	author_time[7]=str_anthor_time;
	    	profiles[7]=str_profile;
		}
}
