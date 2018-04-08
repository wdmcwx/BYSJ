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
	   // �������̸߳�������
    private static Handler handler = new Handler(); 
    String i="";
    // �����ȴ���
    private ProgressDialog dialog;
    
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //���ر���
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
		// TODO �Զ����ɵķ������
		switch (v.getId()) {
		case R.id.update_gonglue:
			// ������磬�޷����wifi
            if (!checkNetwork()) {
                Toast toast = Toast.makeText(updateData.this,"����δ����", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            }
            
            // ��ʾ��
            dialog = new ProgressDialog(this);
            dialog.setTitle("��ʾ");
            dialog.setMessage("���ڵ�½�����Ժ�...");
            dialog.setCancelable(false);
            dialog.show();
			i="gonglue";
            // �������̣߳��ֱ����Get��Post����
            new Thread(new MyThread()).start();
			break;
		case R.id.update_gouwu:
			// ������磬�޷����wifi
            if (!checkNetwork()) {
                Toast toast = Toast.makeText(updateData.this,"����δ����", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            }
            
            // ��ʾ��
            dialog = new ProgressDialog(this);
            dialog.setTitle("��ʾ");
            dialog.setMessage("���ڵ�½�����Ժ�...");
            dialog.setCancelable(false);
            dialog.show();
            
            i="gouwu";
            // �������̣߳��ֱ����Get��Post����
            new Thread(new MyThread()).start();
			break;
		case R.id.update_jingdian:
			// ������磬�޷����wifi
            if (!checkNetwork()) {
                Toast toast = Toast.makeText(updateData.this,"����δ����", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            }
            
            // ��ʾ��
            dialog = new ProgressDialog(this);
            dialog.setTitle("��ʾ");
            dialog.setMessage("���ڵ�½�����Ժ�...");
            dialog.setCancelable(false);
            dialog.show();
            
            i="jingdian";
            // �������̣߳��ֱ����Get��Post����
            new Thread(new MyThread()).start();
			break;
		case R.id.update_jiudian:
			// ������磬�޷����wifi
            if (!checkNetwork()) {
                Toast toast = Toast.makeText(updateData.this,"����δ����", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            }
            
            // ��ʾ��
            dialog = new ProgressDialog(this);
            dialog.setTitle("��ʾ");
            dialog.setMessage("���ڵ�½�����Ժ�...");
            dialog.setCancelable(false);
            dialog.show();
            
            i="jiudian";
        
            // �������̣߳��ֱ����Get��Post����
            new Thread(new MyThread()).start();
			break;
		case R.id.update_meishi:
			// ������磬�޷����wifi
            if (!checkNetwork()) {
                Toast toast = Toast.makeText(updateData.this,"����δ����", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            }
            
            // ��ʾ��
            dialog = new ProgressDialog(this);
            dialog.setTitle("��ʾ");
            dialog.setMessage("���ڵ�½�����Ժ�...");
            dialog.setCancelable(false);
            dialog.show();
            
            i="meishi";
            // �������̣߳��ֱ����Get��Post����
            new Thread(new MyThread()).start();
			break;
		case R.id.update_youji:
			// ������磬�޷����wifi
            if (!checkNetwork()) {
                Toast toast = Toast.makeText(updateData.this,"����δ����", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                break;
            }
            
            // ��ʾ��
            dialog = new ProgressDialog(this);
            dialog.setTitle("��ʾ");
            dialog.setMessage("���ڵ�½�����Ժ�...");
            dialog.setCancelable(false);
            dialog.show();
            
            i="youji";
            // �������̣߳��ֱ����Get��Post����
            new Thread(new MyThread()).start();
			break;
		default:
			break;
		}
	}
	

    // ���߳̽������ݣ����߳��޸�����
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

    // �������
    private boolean checkNetwork() {
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager.getActiveNetworkInfo() != null) {
            return connManager.getActiveNetworkInfo().isAvailable();
        }
        return false;
    }
}
