package com.gonglue;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
 
 import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
 
import android.util.Xml;
 
 public class PullService2 {
 
   // ����XmlPullParser������XML�ļ�
   public static List<Gonglue> getStudents(InputStream inStream)
       throws Throwable {
     List<Gonglue> students = null;
     Gonglue mStudent = null;
 
     // ========����XmlPullParser,�����ַ�ʽ=======
     // ��ʽһ:ʹ�ù�����XmlPullParserFactory
     XmlPullParserFactory pullFactory = XmlPullParserFactory.newInstance();
     XmlPullParser parser = pullFactory.newPullParser();

    // �����ļ�������
     parser.setInput(inStream, "UTF-8");
     // ������һ���¼�
     int eventType = parser.getEventType();
     // ֻҪ�����ĵ������¼�����һֱѭ��
    while (eventType != XmlPullParser.END_DOCUMENT) {
       switch (eventType) {
      // ������ʼ�ĵ��¼�
       case XmlPullParser.START_DOCUMENT:
         students = new ArrayList<Gonglue>();
        break;
      // ������ʼԪ���¼�
       case XmlPullParser.START_TAG:
         // ��ȡ��������ǰָ���Ԫ�ص�����
         String name = parser.getName();
         if ("Gonglue".equals(name)) {
           // ͨ����������ȡid��Ԫ��ֵ��������student��id
           mStudent = new Gonglue();
          // mStudent.setId(parser.getAttributeValue(0));
         }
         if (mStudent != null) {
           if ("titles".equals(name)) {
             // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
          //   mStudent.setName(parser.nextText());
        	   mStudent.setTitles(parser.nextText());
           }
           if ("imgs".equals(name)) {
             // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
             mStudent.setImgs(parser.nextText());
           }
           if ("author_time".equals(name)) {
             // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
             mStudent.setAuthor_time(parser.nextText());
           }
           if ("profiles".equals(name)) {
               // ��ȡ��������ǰָ��Ԫ�ص���һ���ı��ڵ��ֵ
               mStudent.setProfiles(parser.nextText());
             }
         }
         break;
       // ��������Ԫ���¼�
       case XmlPullParser.END_TAG:
         //
         if ("Gonglue".equals(parser.getName())) {
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