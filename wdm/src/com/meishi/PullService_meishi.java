package com.meishi;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;


public class PullService_meishi {
	// ����XmlPullParser������XML�ļ�
	   public static List<meishi_bean> getMeishis(InputStream inStream)
	       throws Throwable {
	     List<meishi_bean> list = null;
	     meishi_bean meishi = null;
	 
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
	    	   list = new ArrayList<meishi_bean>();
	        break;
	      // ������ʼԪ���¼�
	       case XmlPullParser.START_TAG:
	         // ��ȡ��������ǰָ���Ԫ�ص�����
	         String name = parser.getName();
	         if ("Meishi".equals(name)) {
	           // ͨ����������ȡid��Ԫ��ֵ��������student��id
	        	 meishi = new meishi_bean();
	          // mStudent.setId(parser.getAttributeValue(0));
	         }
	         if (meishi != null) {
	           if ("imgs".equals(name)) {
	             // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
	          //   mStudent.setName(parser.nextText());
	        	   meishi.setImgs(parser.nextText());
	           }
	           if ("names".equals(name)) {
	             // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
	        	   meishi.setNames(parser.nextText());
	           }
	           if ("caixis".equals(name)) {
	               // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
	        	   meishi.setCaixis(parser.nextText());
	           }
	           if ("summarys".equals(name)) {
	               // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
	        	   meishi.setSummarys(parser.nextText());
	           }
	         }
	         break;
	       // ��������Ԫ���¼�
	       case XmlPullParser.END_TAG:
	         //
	         if ("Meishi".equals(parser.getName())) {
	        	 list.add(meishi);
	        	 meishi = null;
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
