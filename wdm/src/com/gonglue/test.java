package com.gonglue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.wdm.R;
import com.example.wdm.R.id;
import com.example.wdm.R.layout;

import httpUtil.WebService;

import android.app.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import android.widget.Toast;

public class test  extends Activity{

    // 创建等待框
    private ProgressDialog dialog;
    // 返回的数据
    private String info=new String();
    // 返回主线程更新数据
    private static Handler handler = new Handler();
    
   // TextView tv;
    ListView lv;
    List<String> titles = new ArrayList<String>();
	List<String> imgs = new ArrayList<String>();
	List<String> author_time = new ArrayList<String>();
	List<String> profiles = new ArrayList<String>();
	
	  @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.test_gonglue);
	        //解决 android.os.StrictMode$AndroidBlockGuardPolicy.onNetwork 网络严格限制
	        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
	        StrictMode.setThreadPolicy(policy);
	        
	        lv=(ListView) findViewById(R.id.list_gonglue);
					
					 // 检测网络，无法检测wifi
		    if (!checkNetwork()) {
		        Toast toast = Toast.makeText(test.this,"网络未连接", Toast.LENGTH_SHORT);
		        toast.setGravity(Gravity.CENTER, 0, 0);
		        toast.show();
		    }

		    new Thread(new MyThread2()).start();
	   }

	  private List<Map<String, Object>> getData() {
			// TODO 自动生成的方法存根
	    	  List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			   for (int i = 0; i <titles.size(); i++) {
		             Map<String, Object> map = new HashMap<String, Object>();
		             map.put("titles", titles.get(i).toString());
		             map.put("imgs",imgs.get(i).toString());
		             map.put("author_time",author_time.get(i).toString());
		             map.put("profiles", profiles.get(i).toString());
		             list.add(map);
		         }
		      return list;
		}
	  
	  public class MyThread2 implements Runnable {
	        @Override
	        public void run() {
	            String tag = "gonglue";
				info = WebService.executeHttpGet_all(tag);	
	            handler.post(new Runnable() {
	                @Override
	                public void run() {
	         //          tv.setText(info);
	                   // String str = "<?xml version='1.0' encoding='utf-8'?><Gonglues><Gonglue id='1'><titles>文化苦旅1111</titles><imgs>2222</imgs><author_time>4444</author_time><profiles>你哈哈哈哈哈</profiles></Gonglue><Gonglue id='2'><titles>文化苦旅</titles><imgs>2222</imgs><author_time>4444</author_time><profiles>555</profiles></Gonglue><Gonglue id='3'><titles>11111</titles><imgs>2222</imgs><author_time>4444</author_time><profiles>555</profiles></Gonglue><Gonglue id='4'><titles>11111</titles><imgs>2222</imgs><author_time>4444</author_time><profiles>555</profiles></Gonglue></Gonglues>";    		
	                   	InputStream input = null;
	           			try {
	           				input = new   ByteArrayInputStream(info.getBytes("UTF-8"));
	           			    List<Gonglue> list = null;
	           			    list = PullService2.getStudents(input);
	           			    for (Gonglue stu : list) {
		                       	titles.add(stu.getTitles());
		                       	imgs.add(stu.getImgs());
		                       	author_time.add(stu.getAuthor_time());
		                       	profiles.add(stu.getProfiles());
		                       }
	           			} catch (Exception e) {
	           				// TODO 自动生成的 catch 块
	           				e.printStackTrace();
	           			} catch (Throwable e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
	           			
	                    Myadapter2 adapter=new Myadapter2(test.this, getData());
	                       //设置适配器
	                    lv.setAdapter(adapter);
	               //     dialog.dismiss();
	                    
	                    final Intent intent=new Intent(test.this,gonglue_detiial.class);
	        			final Bundle bundle=new Bundle();
	        			
	                    lv.setOnItemClickListener(new OnItemClickListener() {

							@Override
							public void onItemClick(AdapterView<?> parent,
									View view, int position, long id) {
								// TODO 自动生成的方法存根
							//	Toast.makeText(test.this, position+"", 1).show();
								switch (position) {
								case 0: 
									bundle.putInt("index", 1);
									intent.putExtras(bundle);
									startActivity(intent);
									break;
								case 1:
									bundle.putInt("index", 2);
									intent.putExtras(bundle);
									startActivity(intent);
									break;
								case 2: 
									bundle.putInt("index", 3);
									intent.putExtras(bundle);
									startActivity(intent);
									break;
								case 3: 
									bundle.putInt("index", 4);
									intent.putExtras(bundle);
									startActivity(intent);
									break;
								case 4: 
									bundle.putInt("index", 5);
									intent.putExtras(bundle);
									startActivity(intent);
									break;
								case 5: 
									bundle.putInt("index", 6);
									intent.putExtras(bundle);
									startActivity(intent);
									break;
								case 6:
									bundle.putInt("index", 7);
									intent.putExtras(bundle);
									startActivity(intent);
									break;
								case 7: 
									bundle.putInt("index", 8);
									intent.putExtras(bundle);
									startActivity(intent);
									break;
								}
							
							}
						});
	                }
	            });
	        }
	    }
	  
	    // 检测网络
	    private boolean checkNetwork() {
	        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	        if (connManager.getActiveNetworkInfo() != null) {
	            return connManager.getActiveNetworkInfo().isAvailable();
	        }
	        return false;
	    }
}
