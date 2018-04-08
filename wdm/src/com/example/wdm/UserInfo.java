package com.example.wdm;

import httpUtil.WebService;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserInfo extends Activity{
	EditText username,password;
	Button login,reset;
	  // 创建等待框
    private ProgressDialog dialog;
    // 返回的数据
    private String info;
    // 返回主线程更新数据
    private static Handler handler = new Handler();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinfo);
        
        username=(EditText) findViewById(R.id.u_info);
        password=(EditText) findViewById(R.id.u_password);
        login=(Button) findViewById(R.id.u_btn);
        reset=(Button) findViewById(R.id.u_reset);

        //进行服务器端的数据库操作
        login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				 // 检测网络，无法检测wifi
	            if (!checkNetwork()) {
	                Toast toast = Toast.makeText(UserInfo.this,"网络未连接", Toast.LENGTH_SHORT);
	                toast.setGravity(Gravity.CENTER, 0, 0);
	                toast.show();
	               return;
	            }
	            // 提示框
	            dialog = new ProgressDialog(UserInfo.this);
	            dialog.setTitle("提示");
	            dialog.setMessage("正在登陆，请稍后...");
	            dialog.setCancelable(false);
	            dialog.show();
	            // 创建子线程，分别进行Get和Post传输
	            new Thread(new MyThread()).start();
			}
		});
        
        //返回上一级
        reset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent=new Intent(UserInfo.this,TabActivity.class);
				startActivity(intent);
			}
		});
    }
    
    // 子线程接收数据，主线程修改数据
    public class MyThread implements Runnable {
        @Override
        public void run() {
            info = WebService.executeHttpGet_UserInfo(username.getText().toString(), password.getText().toString());
            handler.post(new Runnable() {
                @Override
                public void run() {                  
                	if(info.equals("1")){ //该会员存在
                	//进行页面的跳转
                		Intent intent=new Intent(UserInfo.this,updateData.class);
        				startActivity(intent);
                	}else{ //会员不存在
                		Toast.makeText(UserInfo.this, "该用户不会员", 1).show();
                		finish();
                	}
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
