package com.gouwu;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;


public class PullService_gouwu {
	  // ����XmlPullParser������XML�ļ�
	   public static List<gouwu_bean> getGouwus(InputStream inStream)
	       throws Throwable {
	     List<gouwu_bean> list = null;
	     gouwu_bean gouwu = null;
	 
	     // ========����XmlPullParser,�����ַ�ʽ=======
	     // ��ʽһ:ʹ�ù�����XmlPullParserFactory
	     XmlPullParserFactory pullFactory = XmlPullParserFactory.newInstance();
	     XmlPullParser parser = pullFactory.newPullParser();
	     // ��ʽ��:ʹ��Android�ṩ��ʵ�ù�����android.util.Xml
	     // XmlPullParser parser = Xml.newPullParser();
	 
	    // �����ļ�������
	     parser.setInput(inStream, "UTF-8");
	     // ������һ���¼�
	     int eventType = parser.getEventType();
	     // ֻҪ�����ĵ������¼�����һֱѭ��
	    while (eventType != XmlPullParser.END_DOCUMENT) {
	       switch (eventType) {
	      // ������ʼ�ĵ��¼�
	       case XmlPullParser.START_DOCUMENT:
	    	   list = new ArrayList<gouwu_bean>();
	        break;
	      // ������ʼԪ���¼�
	       case XmlPullParser.START_TAG:
	         // ��ȡ��������ǰָ���Ԫ�ص�����
	         String name = parser.getName();
	         if ("Gouwu".equals(name)) {
	           // ͨ����������ȡid��Ԫ��ֵ��������student��id
	        	 gouwu = new gouwu_bean();
	          // mStudent.setId(parser.getAttributeValue(0));
	         }
	         if (gouwu != null) {
	           if ("imgs".equals(name)) {
	             // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
	          //   mStudent.setName(parser.nextText());
	        	   gouwu.setImgs(parser.nextText());
	           }
	           if ("titles".equals(name)) {
	             // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
	        	   gouwu.setTitles(parser.nextText());
	           }
	           if ("addrs".equals(name)) {
	             // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
	        	   gouwu.setAddrs(parser.nextText());
	           }
	         }
	         break;
	       // ��������Ԫ���¼�
	       case XmlPullParser.END_TAG:
	         //
	         if ("Gouwu".equals(parser.getName())) {
	        	 list.add(gouwu);
	        	 gouwu = null;
	         }
	        break;
	       default:
	         break;
	       }
	       eventType = parser.next();
	     }
	     return list;
	   }
}
