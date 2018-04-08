package com.meishi;

import httpUtil.WebService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.wdm.R;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class meishi_search extends Fragment {
	 // �������̸߳�������
    private static Handler handler = new Handler();
    // ���ص�����
    private String info=new String();
    View view=null;
    ListView lv;
    List<String> names = new ArrayList<String>();
	List<String> imgs = new ArrayList<String>();
	List<String> caixis = new ArrayList<String>();
	List<String> summarys = new ArrayList<String>();
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle saveInstanceState){
		view = inflater.inflate(R.layout.f3, null);
		return view;	
	}
	
	public void onActivityCreated(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        lv=(ListView) view.findViewById(R.id.listView_meishi);
        
        
		 // ������磬�޷����wifi
	    if (!checkNetwork()) {
	        Toast toast = Toast.makeText(getActivity(),"����δ����", Toast.LENGTH_SHORT);
	        toast.setGravity(Gravity.CENTER, 0, 0);
	        toast.show();
	    }
       // �������̣߳�����Get����
		new Thread(new MyThread()).start();
	}
	
	  
	  public class MyThread implements Runnable {
	        @Override
	        public void run() {
	            String tag = "meishi";
				info = WebService.executeHttpGet_all(tag);	
				
	            handler.post(new Runnable() {
	                @Override
	                public void run() {
	         //          tv.setText(info);
	                   // String str = "<?xml version='1.0' encoding='utf-8'?><Gonglues><Gonglue id='1'><titles>�Ļ�����1111</titles><imgs>2222</imgs><author_time>4444</author_time><profiles>�����������</profiles></Gonglue><Gonglue id='2'><titles>�Ļ�����</titles><imgs>2222</imgs><author_time>4444</author_time><profiles>555</profiles></Gonglue><Gonglue id='3'><titles>11111</titles><imgs>2222</imgs><author_time>4444</author_time><profiles>555</profiles></Gonglue><Gonglue id='4'><titles>11111</titles><imgs>2222</imgs><author_time>4444</author_time><profiles>555</profiles></Gonglue></Gonglues>";    		
	                   	InputStream input = null;
	           			try {
	           				input = new   ByteArrayInputStream(info.getBytes("UTF-8"));
	           			    List<meishi_bean> list = null;
	           			    
	           			    list = PullService_meishi.getMeishis(input);
	           			    for (meishi_bean stu : list) {
		                       	imgs.add(stu.getImgs());
		                       	names.add(stu.getNames());
		                       	caixis.add(stu.getCaixis());
		                       	summarys.add(stu.getSummarys());
		                    }
	           			} catch (Exception e) {
	           				// TODO �Զ����ɵ� catch ��
	           				e.printStackTrace();
	           			} catch (Throwable e) {
							// TODO �Զ����ɵ� catch ��
							e.printStackTrace();
						}
	           			
	           			MyAdapter_meishi adapter=new MyAdapter_meishi(getActivity(), getData());
	                       //����������
	                    lv.setAdapter(adapter);
	         //           dialog.dismiss();
	                    
	                    final Intent intent=new Intent(getActivity(),meishi_detail.class);
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
		             map.put("caixis",caixis.get(i).toString());
		             map.put("summarys", summarys.get(i).toString());
		           
		             list.add(map);
		         }
		      return list;
	  }
	  // �������
	  private boolean checkNetwork() {
	      ConnectivityManager connManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
	      if (connManager.getActiveNetworkInfo() != null) {
	          return connManager.getActiveNetworkInfo().isAvailable();
	      }
	      return false;
	  }
}
