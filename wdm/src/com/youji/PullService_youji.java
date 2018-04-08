package com.youji;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class PullService_youji {
	// ����XmlPullParser������XML�ļ�
	   public static List<youji_bean> getYoujis(InputStream inStream)
	       throws Throwable {
	     List<youji_bean> list = null;
	     youji_bean youji = null;
	 
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
	    	   list = new ArrayList<youji_bean>();
	        break;
	      // ������ʼԪ���¼�
	       case XmlPullParser.START_TAG:
	         // ��ȡ��������ǰָ���Ԫ�ص�����
	         String name = parser.getName();
	         if ("Youji".equals(name)) {
	           // ͨ����������ȡid��Ԫ��ֵ��������student��id
	        	 youji = new youji_bean();
	          // mStudent.setId(parser.getAttributeValue(0));
	         }
	         if (youji != null) {
		           if ("imgs".equals(name)) {
		             // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
		          //   mStudent.setName(parser.nextText());
		        	   youji.setImgs(parser.nextText());
		           }
		           if ("titles".equals(name)) {
		             // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
		        	   youji.setTitles(parser.nextText());
		           }
		           if ("chapters".equals(name)) {
		               // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
		        	   youji.setChapters(parser.nextText());
		           }
		           if ("summarys".equals(name)) {
		               // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
		        	   youji.setSummarys(parser.nextText());
		           }
		           if ("anthor_times".equals(name)) {
		               // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
		        	   youji.setAnthor_times(parser.nextText());
		           }
	         }
	         break;
	       // ��������Ԫ���¼�
	       case XmlPullParser.END_TAG:
	         //
	         if ("Youji".equals(parser.getName())) {
	        	 list.add(youji);
	        	 youji = null;
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
