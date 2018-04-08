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
    
    // 创建等待框
    private ProgressDialog dialog;
    // 返回的数据
    private String info;
    // 返回主线程更新数据
    private static Handler handler = new Handler();
    
    ComponentName cmp;
    
    TextView tv_list;
    final int LIST_DIALOG3 = 0x116;
    
    //自定义RadioButton样式
    private ArrayAdapter<String> adapter;  
    private String[] type=new String[]{"微信","腾讯微博","便签","分享","数据库更新"};
    private int[] img=new int[]{R.drawable.weixin1,R.drawable.weibo2,R.drawable.bianqian,R.drawable.yy,R.drawable.renew2};
    
    //默认spinner不选中任何项
    boolean isSpinnerFirst = true ;
    
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //隐藏标题
        setContentView(R.layout.tab);
        
        //获取控件
        group = (RadioGroup) findViewById(R.id.rg);
        tv_list=(TextView) findViewById(R.id.tv_list);
        
        tv_list.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				 showDialog(LIST_DIALOG3);
			}
		});
        
        // 给group设置监听事件，在监听事件实现fragment之间的切换
        OnCheckedChangeListener listener = new MyOnCheckedChangeListener();
        group.setOnCheckedChangeListener(listener);

        // 选中首页，否则开始启动的时候画面展示白板
        group.check(R.id.rb1);
    }
    
    
    public Dialog onCreateDialog(int id, Bundle state){
    	   //判断需要生成哪种类型的对话框  
        switch (id)  {
        	
            case LIST_DIALOG3:  
            	AlertDialog.Builder b = new AlertDialog.Builder(this); 
            	 //创建一个List对象，List对象的元素是Map  
                List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();  
                for (int i = 0; i < type.length; i++)  {  
                    Map<String, Object> listItem = new HashMap<String, Object>();  
                    listItem.put("imgs", img[i]);  
                    listItem.put("types", type[i]);  
                    listItems.add(listItem);  
                }               
              //创建一个SimpleAdapter  
                SimpleAdapter simpleAdapter = new SimpleAdapter(this  
                    , listItems   
                    , R.layout.row  
                    , new String[]{ "imgs", "types" }  
                    , new int[]{ R.id.img_spin,R.id.tv_spin}); 
             // 为对话框设置多个列表  
                b.setAdapter(simpleAdapter                
                    //为列表项的单击事件设置监听器  
                    , new DialogInterface.OnClickListener(){  
                        @Override  
                        public void onClick(DialogInterface dialog,  
                            int which)  {   
//                            // which代表哪个列表项被单击了  
//                            show.setText("您最喜欢的专辑为：" + names[which]);  
                        	switch (which) {
							case 0:
								openWeixin();//打开微信
								break;
							case 1:
								openTengxu();
								break;
                            case 2: //记事本
								Intent intent=new Intent(TabActivity.this,NotebookMain.class);
								startActivity(intent);
								break;
                            case 3://分享
                            	Intent intent2=new Intent(TabActivity.this,Login.class);
								startActivity(intent2);
                            	break;
                            case 4://数据库更新           	
                            	Intent intent3=new Intent(TabActivity.this,UserInfo.class);
								startActivity(intent3);
                            	break;
							}
                        }  
                    });  
                // 创建对话框  
                return b.create(); 
        }
		return null;
	}


    //打开微信应用
    public void openWeixin(){ 	
    	if(isInstallByread("com.tencent.mm")){
    		//ComponentName，就是组件名称，通过调用Intent中的setComponent方法，我们可以打开另外一个应用中的Activity或者服务。
    		//实例化一个ComponentName需要两个参数，第一个参数是要启动应用的包名称，这个包名称是指清单文件中列出的应用的包名称.
    		//第二个参数是你要启动的Activity或者Service的全称（包名+类名）
        	cmp = new ComponentName("com.tencent.mm","com.tencent.mm.ui.LauncherUI");
        	intentSomeAplication();
    	}else{
    		Toast.makeText(TabActivity.this, "没有安装微信客户端，请先下载该微信应用", Toast.LENGTH_SHORT).show(); 
    	}  	
    }

    //打开腾讯微博应用
    public void openTengxu(){ 	
    	if(isInstallByread("com.tencent.WBlog")){
        	cmp = new ComponentName("com.tencent.WBlog","com.tencent.WBlog.activity.MicroblogInput");
        	intentSomeAplication();
    	}else{
    		Toast.makeText(TabActivity.this, "没有安装腾讯微博客户端，请先下载该腾讯微博应用", Toast.LENGTH_SHORT).show(); 
    	}  	
    }
  //判断第三方应用是否安装
    private boolean isInstallByread(String packageName) {  
        return new File("/data/data/" + packageName).exists();  
    } 
    
    //根据包名，进入不同应用
    public void intentSomeAplication(){
    	Intent intent = new Intent();
    	intent.setAction(Intent.ACTION_MAIN);
    	intent.addCategory(Intent.CATEGORY_LAUNCHER);
    	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    	intent.setComponent(cmp);
    	startActivityForResult(intent, 0);
    }
    
    private class MyOnCheckedChangeListener implements OnCheckedChangeListener {
        // 在构造方法中创造fragment
        public MyOnCheckedChangeListener() {
            // 将new出来的fragment放置在集合中，以便后续取用
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
            // 当选中某一个radio的时候，就展现某一个fragment,用到fragment的事务
        	//FragmentManager提供了对Activity运行时的Fragment的添加、删除、替换的操作。
        	//如果要执行添加、删除、修改的操作，你必须通过FragmentManager的对象获得一个FragmentTransaction对象，通过它的API来执行这些操作。
        //	在Activity中你可以通过getFragmentManager()来获得FragmentManager对象，
        	//然后通过FragmentManager对象的beginFragmentTransaction()方法来获得FragmentTransaction对象。通过它的add()方法来添加一个Fragment到当前的Activity中。
        //	一个FragmentTransaction对象可以执行多个增删修的方法，如果你想把这些修改提交到Activity上，必须在最后调用一下这个对象的commit()方法。
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
            // 最后事务一定要提交
            ft.commit();
        }
    }
}
