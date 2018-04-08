package com.jiudian;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
 
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

 
import android.util.Xml;
public class PullService_jiudian {
	// ����XmlPullParser������XML�ļ�
	   public static List<jiudian_bean> getJiudians(InputStream inStream)
	       throws Throwable {
	     List<jiudian_bean> list = null;
	     jiudian_bean jiudian = null;
	 
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
	    	   list = new ArrayList<jiudian_bean>();
	        break;
	      // ������ʼԪ���¼�
	       case XmlPullParser.START_TAG:
	         // ��ȡ��������ǰָ���Ԫ�ص�����
	         String name = parser.getName();
	         if ("Jiudian".equals(name)) {
	           // ͨ����������ȡid��Ԫ��ֵ��������student��id
	        	 jiudian = new jiudian_bean();
	          // mStudent.setId(parser.getAttributeValue(0));
	         }
	         if (jiudian != null) {
	           if ("imgs".equals(name)) {
	             // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
	          //   mStudent.setName(parser.nextText());
	        	   jiudian.setImgs(parser.nextText());
	           }
	           if ("names".equals(name)) {
	             // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
	        	   jiudian.setNames(parser.nextText());
	           }
	           if ("addrs".equals(name)) {
	               // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
	        	   jiudian.setAddrs(parser.nextText());
	           }
	         }
	         break;
	       // ��������Ԫ���¼�
	       case XmlPullParser.END_TAG:
	         //
	         if ("Jiudian".equals(parser.getName())) {
	        	 list.add(jiudian);
	        	 jiudian = null;
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
