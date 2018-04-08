package com.gonglue;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
 
 import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
 
import android.util.Xml;
 
 public class PullService2 {
 
   // 采用XmlPullParser来解析XML文件
   public static List<Gonglue> getStudents(InputStream inStream)
       throws Throwable {
     List<Gonglue> students = null;
     Gonglue mStudent = null;
 
     // ========创建XmlPullParser,有两种方式=======
     // 方式一:使用工厂类XmlPullParserFactory
     XmlPullParserFactory pullFactory = XmlPullParserFactory.newInstance();
     XmlPullParser parser = pullFactory.newPullParser();

    // 解析文件输入流
     parser.setInput(inStream, "UTF-8");
     // 产生第一个事件
     int eventType = parser.getEventType();
     // 只要不是文档结束事件，就一直循环
    while (eventType != XmlPullParser.END_DOCUMENT) {
       switch (eventType) {
      // 触发开始文档事件
       case XmlPullParser.START_DOCUMENT:
         students = new ArrayList<Gonglue>();
        break;
      // 触发开始元素事件
       case XmlPullParser.START_TAG:
         // 获取解析器当前指向的元素的名称
         String name = parser.getName();
         if ("Gonglue".equals(name)) {
           // 通过解析器获取id的元素值，并设置student的id
           mStudent = new Gonglue();
          // mStudent.setId(parser.getAttributeValue(0));
         }
         if (mStudent != null) {
           if ("titles".equals(name)) {
             // 获取解析器当前指向元素的下一个文本节点的值
          //   mStudent.setName(parser.nextText());
        	   mStudent.setTitles(parser.nextText());
           }
           if ("imgs".equals(name)) {
             // 获取解析器当前指向元素的下一个文本节点的值
             mStudent.setImgs(parser.nextText());
           }
           if ("author_time".equals(name)) {
             // 获取解析器当前指向元素的下一个文本节点的值
             mStudent.setAuthor_time(parser.nextText());
           }
           if ("profiles".equals(name)) {
               // 获取解析器当前指向元素的下一个文本节点的值
               mStudent.setProfiles(parser.nextText());
             }
         }
         break;
       // 触发结束元素事件
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