package com.jiudian;

import httpUtil.WebService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.wdm.R;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class jiudian_search  extends Activity{
	   // �������̸߳�������
    private static Handler handler = new Handler();
    // ���ص�����
    private String info=new String();
    
    ListView lv;
    List<String> names = new ArrayList<String>();
	List<String> imgs = new ArrayList<String>();
	List<String> addrs = new ArrayList<String>();
	
	   @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.jiudian_list);
	        
	      //��� android.os.StrictMode$AndroidBlockGuardPolicy.onNetwork �����ϸ�����
	        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
	        StrictMode.setThreadPolicy(policy);
	        
	        lv=(ListView) findViewById(R.id.jiudian_listview);
	        
			 // ������磬�޷����wifi
		    if (!checkNetwork()) {
		        Toast toast = Toast.makeText(jiudian_search.this,"����δ����", Toast.LENGTH_SHORT);
		        toast.setGravity(Gravity.CENTER, 0, 0);
		        toast.show();
		    }
		    
		    // �������̣߳�����Get����
		    new Thread(new MyThread()).start();
	    }
	   	
	   public class MyThread implements Runnable {
	        @Override
	        public void run() {
	            String tag = "jiudian";
				info = WebService.executeHttpGet_all(tag);	
				
	            handler.post(new Runnable() {
	                @Override
	                public void run() {
	         //          tv.setText(info);
	                   // String str = "<?xml version='1.0' encoding='utf-8'?><Gonglues><Gonglue id='1'><titles>�Ļ�����1111</titles><imgs>2222</imgs><author_time>4444</author_time><profiles>�����������</profiles></Gonglue><Gonglue id='2'><titles>�Ļ�����</titles><imgs>2222</imgs><author_time>4444</author_time><profiles>555</profiles></Gonglue><Gonglue id='3'><titles>11111</titles><imgs>2222</imgs><author_time>4444</author_time><profiles>555</profiles></Gonglue><Gonglue id='4'><titles>11111</titles><imgs>2222</imgs><author_time>4444</author_time><profiles>555</profiles></Gonglue></Gonglues>";    		
	                   	InputStream input = null;
	           			try {
	           				input = new   ByteArrayInputStream(info.getBytes("UTF-8"));
	           			    List<jiudian_bean> list = null;
	           			    
	           			    list = PullService_jiudian.getJiudians(input);
	           			    for (jiudian_bean stu : list) {
		                       	imgs.add(stu.getImgs());
		                       	names.add(stu.getNames());
		                       	addrs.add(stu.getAddrs());
		                       }
	           			} catch (Exception e) {
	           				// TODO �Զ����ɵ� catch ��
	           				e.printStackTrace();
	           			} catch (Throwable e) {
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						}
	           			
	           			MyAdapter_jiudian adapter=new MyAdapter_jiudian(jiudian_search.this, getData());
	                       //����������
	                    lv.setAdapter(adapter);
	         //           dialog.dismiss();
	                    
	                    final Intent intent=new Intent(jiudian_search.this,jiudian_detail.class);
	        			final Bundle bundle=new Bundle();
	        			
	                    lv.setOnItemClickListener(new OnItemClickListener() {

							@Override
							public void onItemClick(AdapterView<?> parent,
									View view, int position, long id) {
								// TODO �Զ����ɵķ������
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
	  
	   private List<Map<String, Object>> getData() {
			// TODO �Զ����ɵķ������
	    	  List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			   for (int i = 0; i <imgs.size(); i++) {
		             Map<String, Object> map = new HashMap<String, Object>();
		             map.put("imgs", imgs.get(i).toString());
		             map.put("names",names.get(i).toString());
		             map.put("addrs", addrs.get(i).toString());
		             list.add(map);
		         }
		      return list;
	  }
	    // �������
	    private boolean checkNetwork() {
	        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	        if (connManager.getActiveNetworkInfo() != null) {
	            return connManager.getActiveNetworkInfo().isAvailable();
	        }
	        return false;
	    }
	  
}
