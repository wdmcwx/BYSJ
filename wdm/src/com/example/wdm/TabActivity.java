package com.example.wdm;

import httpUtil.Login;
import httpUtil.WebService;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gouwu.gouwu_search;

import com.meishi.meishi_search;

import com.youji.youji_search;


import nodeBook.NotebookMain;



import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TabActivity extends Activity{
	private ArrayList<Fragment> fragmentsList = new ArrayList<Fragment>();
    private RadioGroup group;
    
    // �����ȴ���
    private ProgressDialog dialog;
    // ���ص�����
    private String info;
    // �������̸߳�������
    private static Handler handler = new Handler();
    
    ComponentName cmp;
    
    TextView tv_list;
    final int LIST_DIALOG3 = 0x116;
    
    //�Զ���RadioButton��ʽ
    private ArrayAdapter<String> adapter;  
    private String[] type=new String[]{"΢��","��Ѷ΢��","��ǩ","����","���ݿ����"};
    private int[] img=new int[]{R.drawable.weixin1,R.drawable.weibo2,R.drawable.bianqian,R.drawable.yy,R.drawable.renew2};
    
    //Ĭ��spinner��ѡ���κ���
    boolean isSpinnerFirst = true ;
    
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //���ر���
        setContentView(R.layout.tab);
        
        //��ȡ�ؼ�
        group = (RadioGroup) findViewById(R.id.rg);
        tv_list=(TextView) findViewById(R.id.tv_list);
        
        tv_list.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				 showDialog(LIST_DIALOG3);
			}
		});
        
        // ��group���ü����¼����ڼ����¼�ʵ��fragment֮����л�
        OnCheckedChangeListener listener = new MyOnCheckedChangeListener();
        group.setOnCheckedChangeListener(listener);

        // ѡ����ҳ������ʼ������ʱ����չʾ�װ�
        group.check(R.id.rb1);
    }
    
    
    public Dialog onCreateDialog(int id, Bundle state){
    	   //�ж���Ҫ�����������͵ĶԻ���  
        switch (id)  {
        	
            case LIST_DIALOG3:  
            	AlertDialog.Builder b = new AlertDialog.Builder(this); 
            	 //����һ��List����List�����Ԫ����Map  
                List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();  
                for (int i = 0; i < type.length; i++)  {  
                    Map<String, Object> listItem = new HashMap<String, Object>();  
                    listItem.put("imgs", img[i]);  
                    listItem.put("types", type[i]);  
                    listItems.add(listItem);  
                }               
              //����һ��SimpleAdapter  
                SimpleAdapter simpleAdapter = new SimpleAdapter(this  
                    , listItems   
                    , R.layout.row  
                    , new String[]{ "imgs", "types" }  
                    , new int[]{ R.id.img_spin,R.id.tv_spin}); 
             // Ϊ�Ի������ö���б�  
                b.setAdapter(simpleAdapter                
                    //Ϊ�б���ĵ����¼����ü�����  
                    , new DialogInterface.OnClickListener(){  
                        @Override  
                        public void onClick(DialogInterface dialog,  
                            int which)  {   
//                            // which�����ĸ��б��������  
//                            show.setText("����ϲ����ר��Ϊ��" + names[which]);  
                        	switch (which) {
							case 0:
								openWeixin();//��΢��
								break;
							case 1:
								openTengxu();
								break;
                            case 2: //���±�
								Intent intent=new Intent(TabActivity.this,NotebookMain.class);
								startActivity(intent);
								break;
                            case 3://����
                            	Intent intent2=new Intent(TabActivity.this,Login.class);
								startActivity(intent2);
                            	break;
                            case 4://���ݿ����           	
                            	Intent intent3=new Intent(TabActivity.this,UserInfo.class);
								startActivity(intent3);
                            	break;
							}
                        }  
                    });  
                // �����Ի���  
                return b.create(); 
        }
		return null;
	}


    //��΢��Ӧ��
    public void openWeixin(){ 	
    	if(isInstallByread("com.tencent.mm")){
    		//ComponentName������������ƣ�ͨ������Intent�е�setComponent���������ǿ��Դ�����һ��Ӧ���е�Activity���߷���
    		//ʵ����һ��ComponentName��Ҫ������������һ��������Ҫ����Ӧ�õİ����ƣ������������ָ�嵥�ļ����г���Ӧ�õİ�����.
    		//�ڶ�����������Ҫ������Activity����Service��ȫ�ƣ�����+������
        	cmp = new ComponentName("com.tencent.mm","com.tencent.mm.ui.LauncherUI");
        	intentSomeAplication();
    	}else{
    		Toast.makeText(TabActivity.this, "û�а�װ΢�ſͻ��ˣ��������ظ�΢��Ӧ��", Toast.LENGTH_SHORT).show(); 
    	}  	
    }

    //����Ѷ΢��Ӧ��
    public void openTengxu(){ 	
    	if(isInstallByread("com.tencent.WBlog")){
        	cmp = new ComponentName("com.tencent.WBlog","com.tencent.WBlog.activity.MicroblogInput");
        	intentSomeAplication();
    	}else{
    		Toast.makeText(TabActivity.this, "û�а�װ��Ѷ΢���ͻ��ˣ��������ظ���Ѷ΢��Ӧ��", Toast.LENGTH_SHORT).show(); 
    	}  	
    }
  //�жϵ�����Ӧ���Ƿ�װ
    private boolean isInstallByread(String packageName) {  
        return new File("/data/data/" + packageName).exists();  
    } 
    
    //���ݰ��������벻ͬӦ��
    public void intentSomeAplication(){
    	Intent intent = new Intent();
    	intent.setAction(Intent.ACTION_MAIN);
    	intent.addCategory(Intent.CATEGORY_LAUNCHER);
    	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    	intent.setComponent(cmp);
    	startActivityForResult(intent, 0);
    }
    
    private class MyOnCheckedChangeListener implements OnCheckedChangeListener {
        // �ڹ��췽���д���fragment
        public MyOnCheckedChangeListener() {
            // ��new������fragment�����ڼ����У��Ա����ȡ��
            fragmentsList.add(new Fragment1());
      //      fragmentsList.add(new Fragment2());
            fragmentsList.add(new youji_search());
    //        fragmentsList.add(new Fragment3());
            fragmentsList.add(new meishi_search());
      //      fragmentsList.add(new Fragment4());
            fragmentsList.add(new gouwu_search());
            fragmentsList.add(new Fragment5());
        }

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            // ��ѡ��ĳһ��radio��ʱ�򣬾�չ��ĳһ��fragment,�õ�fragment������
        	//FragmentManager�ṩ�˶�Activity����ʱ��Fragment����ӡ�ɾ�����滻�Ĳ�����
        	//���Ҫִ����ӡ�ɾ�����޸ĵĲ����������ͨ��FragmentManager�Ķ�����һ��FragmentTransaction����ͨ������API��ִ����Щ������
        //	��Activity�������ͨ��getFragmentManager()�����FragmentManager����
        	//Ȼ��ͨ��FragmentManager�����beginFragmentTransaction()���������FragmentTransaction����ͨ������add()���������һ��Fragment����ǰ��Activity�С�
        //	һ��FragmentTransaction�������ִ�ж����ɾ�޵ķ���������������Щ�޸��ύ��Activity�ϣ�������������һ����������commit()������
            FragmentTransaction ft = getFragmentManager() .beginTransaction();
            switch (checkedId) {
            case R.id.rb1:
                ft.replace(R.id.fl, fragmentsList.get(0));
                break;
            case R.id.rb2:
                ft.replace(R.id.fl, fragmentsList.get(1));
                break;
            case R.id.rb3:
                ft.replace(R.id.fl, fragmentsList.get(2));
                break;
            case R.id.rb4:
                ft.replace(R.id.fl, fragmentsList.get(3));
                break;
            default:
                break;
            }
            // �������һ��Ҫ�ύ
            ft.commit();
        }
    }
}
