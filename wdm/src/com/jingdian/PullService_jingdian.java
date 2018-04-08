package com.jingdian;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
 
 import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

 
import android.util.Xml;

public class PullService_jingdian {
	  // ����XmlPullParser������XML�ļ�
	   public static List<Jingdian_bean> getJingdians(InputStream inStream)
	       throws Throwable {
	     List<Jingdian_bean> students = null;
	     Jingdian_bean mStudent = null;
	 
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
	         students = new ArrayList<Jingdian_bean>();
	        break;
	      // ������ʼԪ���¼�
	       case XmlPullParser.START_TAG:
	         // ��ȡ��������ǰָ���Ԫ�ص�����
	         String name = parser.getName();
	         if ("Jingdian".equals(name)) {
	           // ͨ����������ȡid��Ԫ��ֵ��������student��id
	           mStudent = new Jingdian_bean();
	          // mStudent.setId(parser.getAttributeValue(0));
	         }
	         if (mStudent != null) {
	           if ("imgs".equals(name)) {
	             // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
	          //   mStudent.setName(parser.nextText());
	        	   mStudent.setImgs(parser.nextText());
	           }
	           if ("names".equals(name)) {
	             // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
	             mStudent.setNames(parser.nextText());
	           }
	           if ("times".equals(name)) {
	             // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
	             mStudent.setTimes(parser.nextText());
	           }
	           if ("addrs".equals(name)) {
	               // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
	               mStudent.setAddrs(parser.nextText());
	           }
	           if ("jianjies".equals(name)) {
	               // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
	               mStudent.setJianjies(parser.nextText());
	           }
	           if ("tickey1".equals(name)) {
	               // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
	               mStudent.setTickey1(parser.nextText());
	           }
	           if ("tickey2".equals(name)) {
	               // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
	               mStudent.setTickey2(parser.nextText());
	           }
	         }
	         break;
	       // ��������Ԫ���¼�
	       case XmlPullParser.END_TAG:
	         //
	         if ("Jingdian".equals(parser.getName())) {
	           students.add(mStudent);
	           mStudent = null;
	         }
	        break;
	       default:
	         break;
	       }
	       eventType = parser.next();
	     }
	     return students;
	   }
}
