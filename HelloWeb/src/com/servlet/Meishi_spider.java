package com.servlet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.service.Service;

public class Meishi_spider {
	//��ʳ
		Document document_meishi;
		Element div_meishi ;
	    
	    String[] imgs=new String[8];//��������ͼƬ
		String[] names=new String[8]; //������������
		String[] caixis=new String[8]; //���������ϵ
		String[] summarys=new String[8];; //�����������
		
		public void crawlHtml(String url) throws Exception {
			//��ȡ�����෵�ص�html,����Jsoup����
			String result = AbstractSpider.getResult(url);
			document_meishi = Jsoup.parse(result);
			document_meishi.setBaseUri(url);
			
			//��ȡ���е�imgԪ��
			div_meishi= document_meishi.getElementById("elite_trip");
			
			meishi();
			// �½��������
	        Service service=new Service();
	        
			for(int i=0;i<imgs.length;i++){
				service.insertMeishi(imgs[i],names[i],caixis[i],summarys[i]);
			}
		}
		
		private void meishi() {
			// TODO �Զ����ɵķ������
			first_meishi();
	        second_meishi();
	        three_meishi();
	        four_meishi();
	        five_meishi();
	        six_meishi();
	        sevent_meishi();
	        eighth_meishi();   
		}
		public void first_meishi(){
			Element dl=div_meishi.select("dl").get(0);
			Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
			//ͼƬ
			String str_img=img.attr("src");

			Element detail_dd=dl.select("dd").get(0);
			Element title=detail_dd.select("div.title").get(0).select("a").get(0);
			//����
			String str_title=title.text();
		
			Element ms_box=detail_dd.select("div.ms-box").get(0);
			
			//��ϵ
			Element caixi=ms_box.select("p").get(0);
			String str_caixi=caixi.text();
	
			
			//��Ʒ����
			Element ms_tripInfo=ms_box.select("p").get(1);
			String str_ms_tripInfo=ms_tripInfo.text();
		
			imgs[0]=str_img;
			names[0]=str_title;
			caixis[0]=str_caixi;
			summarys[0]=str_ms_tripInfo;
		}
		public void second_meishi(){
			Element dl=div_meishi.select("dl").get(1);
			Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
			//ͼƬ
			String str_img=img.attr("src");
			
			Element detail_dd=dl.select("dd").get(0);
			Element title=detail_dd.select("div.title").get(0).select("a").get(0);
			//����
			String str_title=title.text();

			Element ms_box=detail_dd.select("div.ms-box").get(0);
			
			//��ϵ
			Element caixi=ms_box.select("p").get(0);
			String str_caixi=caixi.text();
			
			//��Ʒ����
			Element ms_tripInfo=ms_box.select("p").get(1);
			String str_ms_tripInfo=ms_tripInfo.text();
		
			imgs[1]=str_img;
			names[1]=str_title;
			caixis[1]=str_caixi;
			summarys[1]=str_ms_tripInfo;
		}
		public void three_meishi(){
			Element dl=div_meishi.select("dl").get(2);
			Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
			//ͼƬ
			String str_img=img.attr("src");
		
			Element detail_dd=dl.select("dd").get(0);
			Element title=detail_dd.select("div.title").get(0).select("a").get(0);
			//����
			String str_title=title.text();

			Element ms_box=detail_dd.select("div.ms-box").get(0);
			
			//��ϵ
			Element caixi=ms_box.select("p").get(0);
			String str_caixi=caixi.text();
			
			//��Ʒ����
			Element ms_tripInfo=ms_box.select("p").get(1);
			String str_ms_tripInfo=ms_tripInfo.text();
			
			imgs[2]=str_img;
			names[2]=str_title;
			caixis[2]=str_caixi;
			summarys[2]=str_ms_tripInfo;
		}
		public void four_meishi(){
			Element dl=div_meishi.select("dl").get(3);
			Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
			//ͼƬ
			String str_img=img.attr("src");
		
			Element detail_dd=dl.select("dd").get(0);
			Element title=detail_dd.select("div.title").get(0).select("a").get(0);
			//����
			String str_title=title.text();
			
			Element ms_box=detail_dd.select("div.ms-box").get(0);
			
			//��ϵ
			Element caixi=ms_box.select("p").get(0);
			String str_caixi=caixi.text();
			
			//��Ʒ����
			Element ms_tripInfo=ms_box.select("p").get(1);
			String str_ms_tripInfo=ms_tripInfo.text();
			
			imgs[3]=str_img;
			names[3]=str_title;
			caixis[3]=str_caixi;
			summarys[3]=str_ms_tripInfo;
		}
		public void five_meishi(){
			Element dl=div_meishi.select("dl").get(4);
			Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
			//ͼƬ
			String str_img=img.attr("src");
			
			Element detail_dd=dl.select("dd").get(0);
			Element title=detail_dd.select("div.title").get(0).select("a").get(0);
			//����
			String str_title=title.text();
	
			Element ms_box=detail_dd.select("div.ms-box").get(0);
			
			//��ϵ
			Element caixi=ms_box.select("p").get(0);
			String str_caixi=caixi.text();
			
			//��Ʒ����
			Element ms_tripInfo=ms_box.select("p").get(1);
			String str_ms_tripInfo=ms_tripInfo.text();
			
			imgs[4]=str_img;
			names[4]=str_title;
			caixis[4]=str_caixi;
			summarys[4]=str_ms_tripInfo;
		}
		public void six_meishi(){
			Element dl=div_meishi.select("dl").get(5);
			Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
			//ͼƬ
			String str_img=img.attr("src");
			
			Element detail_dd=dl.select("dd").get(0);
			Element title=detail_dd.select("div.title").get(0).select("a").get(0);
			//����
			String str_title=title.text();
			Element ms_box=detail_dd.select("div.ms-box").get(0);
			
			//��ϵ
			Element caixi=ms_box.select("p").get(0);
			String str_caixi=caixi.text();
			//��Ʒ����
			Element ms_tripInfo=ms_box.select("p").get(1);
			String str_ms_tripInfo=ms_tripInfo.text();
		
			imgs[5]=str_img;
			names[5]=str_title;
			caixis[5]=str_caixi;
			summarys[5]=str_ms_tripInfo;
		}
		public void sevent_meishi(){
			Element dl=div_meishi.select("dl").get(6);
			Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
			//ͼƬ
			String str_img=img.attr("src");
		
			Element detail_dd=dl.select("dd").get(0);
			Element title=detail_dd.select("div.title").get(0).select("a").get(0);
			//����
			String str_title=title.text();
			
			Element ms_box=detail_dd.select("div.ms-box").get(0);
			
			//��ϵ
			Element caixi=ms_box.select("p").get(0);
			String str_caixi=caixi.text();
		
			//��Ʒ����
			Element ms_tripInfo=ms_box.select("p").get(1);
			String str_ms_tripInfo=ms_tripInfo.text();
				
			imgs[6]=str_img;
			names[6]=str_title;
			caixis[6]=str_caixi;
			summarys[6]=str_ms_tripInfo;
		}
		public void eighth_meishi(){
			Element dl=div_meishi.select("dl").get(7);
			Element img=dl.select("dt").get(0).select("a").get(0).select("img").get(0);
			//ͼƬ
			String str_img=img.attr("src");

			Element detail_dd=dl.select("dd").get(0);
			Element title=detail_dd.select("div.title").get(0).select("a").get(0);
			//����
			String str_title=title.text();
			
			Element ms_box=detail_dd.select("div.ms-box").get(0);
			
			//��ϵ
			Element caixi=ms_box.select("p").get(0);
			String str_caixi=caixi.text();
		
			//��Ʒ����
			Element ms_tripInfo=ms_box.select("p").get(1);
			String str_ms_tripInfo=ms_tripInfo.text();
			
			imgs[7]=str_img;
			names[7]=str_title;
			caixis[7]=str_caixi;
			summarys[7]=str_ms_tripInfo;
		}
}
