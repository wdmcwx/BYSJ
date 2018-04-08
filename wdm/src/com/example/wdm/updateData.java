package com.example.wdm;

import httpUtil.WebService;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class updateData extends Activity implements OnClickListener{
	
	Button gonglue,jingdian,jiudian,youji,meishi,gouwu;
	   // 返回主线程更新数据
    private static Handler handler = new Handler(); 
    String i="";
    // 创建等待框
    private ProgressDialog dialog;
    
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //隐藏标题
        setContentView(R.layout.update);
        
        gonglue=(Button) findViewById(R.id.update_gonglue);
        jingdian=(Button) findViewById(R.id.update_jingdian);
        jiudian=(Button) findViewById(R.id.update_jiudian);
        youji=(Button) findViewById(R.id.update_youji);
        meishi=(Button) findViewById(R.id.update_meishi);
        gouwu=(Button) findViewById(R.id.update_gouwu);
        
        gonglue.setOnClickListener(this);
        jingdian.setOnClickListener(this);
        jiudian.setOnClickListener(this);
        youji.setOnClickListener(this);
        meishi.setOnClickListener(this);
        gouwu.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		switch (v.getId()) {
		case R.id.update_gonglue:
			// 检测网络，无法检测wifi
            if (!checkNetwork()) {
                Toast toast = Toast.makeText(updateData.this,"网络未连接", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            }
            
            // 提示框
            dialog = new ProgressDialog(this);
            dialog.setTitle("提示");
            dialog.setMessage("正在登陆，请稍后...");
            dialog.setCancelable(false);
            dialog.show();
			i="gonglue";
            // 创建子线程，分别进行Get和Post传输
            new Thread(new MyThread()).start();
			break;
		case R.id.update_gouwu:
			// 检测网络，无法检测wifi
            if (!checkNetwork()) {
                Toast toast = Toast.makeText(updateData.this,"网络未连接", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            }
            
            // 提示框
            dialog = new ProgressDialog(this);
            dialog.setTitle("提示");
            dialog.setMessage("正在登陆，请稍后...");
            dialog.setCancelable(false);
            dialog.show();
            
            i="gouwu";
            // 创建子线程，分别进行Get和Post传输
            new Thread(new MyThread()).start();
			break;
		case R.id.update_jingdian:
			// 检测网络，无法检测wifi
            if (!checkNetwork()) {
                Toast toast = Toast.makeText(updateData.this,"网络未连接", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            }
            
            // 提示框
            dialog = new ProgressDialog(this);
            dialog.setTitle("提示");
            dialog.setMessage("正在登陆，请稍后...");
            dialog.setCancelable(false);
            dialog.show();
            
            i="jingdian";
            // 创建子线程，分别进行Get和Post传输
            new Thread(new MyThread()).start();
			break;
		case R.id.update_jiudian:
			// 检测网络，无法检测wifi
            if (!checkNetwork()) {
                Toast toast = Toast.makeText(updateData.this,"网络未连接", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            }
            
            // 提示框
            dialog = new ProgressDialog(this);
            dialog.setTitle("提示");
            dialog.setMessage("正在登陆，请稍后...");
            dialog.setCancelable(false);
            dialog.show();
            
            i="jiudian";
        
            // 创建子线程，分别进行Get和Post传输
            new Thread(new MyThread()).start();
			break;
		case R.id.update_meishi:
			// 检测网络，无法检测wifi
            if (!checkNetwork()) {
                Toast toast = Toast.makeText(updateData.this,"网络未连接", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            }
            
            // 提示框
            dialog = new ProgressDialog(this);
            dialog.setTitle("提示");
            dialog.setMessage("正在登陆，请稍后...");
            dialog.setCancelable(false);
            dialog.show();
            
            i="meishi";
            // 创建子线程，分别进行Get和Post传输
            new Thread(new MyThread()).start();
			break;
		case R.id.update_youji:
			// 检测网络，无法检测wifi
            if (!checkNetwork()) {
                Toast toast = Toast.makeText(updateData.this,"网络未连接", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            }
            
            // 提示框
            dialog = new ProgressDialog(this);
            dialog.setTitle("提示");
            dialog.setMessage("正在登陆，请稍后...");
            dialog.setCancelable(false);
            dialog.show();
            
            i="youji";
            // 创建子线程，分别进行Get和Post传输
            new Thread(new MyThread()).start();
			break;
		default:
			break;
		}
	}
	

    // 子线程接收数据，主线程修改数据
    public class MyThread implements Runnable {
        @Override
        public void run() {
        	
        	if(i.equals("gonglue")){
        		 WebService.executeHttpGet("gonglue");
        	}else if(i.equals("jingdian")){
        		 WebService.executeHttpGet("jingdian");
        	}else if(i.equals("jiudian")){
        		 WebService.executeHttpGet("jiudian");
        	}else if(i.equals("youji")){
        		 WebService.executeHttpGet("youji");
        	} else if(i.equals("meishi")){
        		 WebService.executeHttpGet("meishi");
        	}else if(i.equals("gouwu")){
        		 WebService.executeHttpGet("gouwu");
        	}
        	
            handler.post(new Runnable() {
                @Override
                public void run() {
                    dialog.dismiss();
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
