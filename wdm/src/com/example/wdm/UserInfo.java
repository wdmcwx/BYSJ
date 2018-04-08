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
	  // �����ȴ���
    private ProgressDialog dialog;
    // ���ص�����
    private String info;
    // �������̸߳�������
    private static Handler handler = new Handler();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinfo);
        
        username=(EditText) findViewById(R.id.u_info);
        password=(EditText) findViewById(R.id.u_password);
        login=(Button) findViewById(R.id.u_btn);
        reset=(Button) findViewById(R.id.u_reset);

        //���з������˵����ݿ����
        login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				 // ������磬�޷����wifi
	            if (!checkNetwork()) {
	                Toast toast = Toast.makeText(UserInfo.this,"����δ����", Toast.LENGTH_SHORT);
	                toast.setGravity(Gravity.CENTER, 0, 0);
	                toast.show();
	               return;
	            }
	            // ��ʾ��
	            dialog = new ProgressDialog(UserInfo.this);
	            dialog.setTitle("��ʾ");
	            dialog.setMessage("���ڵ�½�����Ժ�...");
	            dialog.setCancelable(false);
	            dialog.show();
	            // �������̣߳��ֱ����Get��Post����
	            new Thread(new MyThread()).start();
			}
		});
        
        //������һ��
        reset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				Intent intent=new Intent(UserInfo.this,TabActivity.class);
				startActivity(intent);
			}
		});
    }
    
    // ���߳̽������ݣ����߳��޸�����
    public class MyThread implements Runnable {
        @Override
        public void run() {
            info = WebService.executeHttpGet_UserInfo(username.getText().toString(), password.getText().toString());
            handler.post(new Runnable() {
                @Override
                public void run() {                  
                	if(info.equals("1")){ //�û�Ա����
                	//����ҳ�����ת
                		Intent intent=new Intent(UserInfo.this,updateData.class);
        				startActivity(intent);
                	}else{ //��Ա������
                		Toast.makeText(UserInfo.this, "���û�����Ա", 1).show();
                		finish();
                	}
                    dialog.dismiss();
                }
            });
        }
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
