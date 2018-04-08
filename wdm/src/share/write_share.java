package share;


import httpUtil.WebService;
import com.example.wdm.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class write_share extends Activity {
	
	TextView tv_username,tv_password,tv_article_info;
	String username,password,article,article_info;
	Button btn;
	EditText ed_article;
	
	// �����ȴ���
    private ProgressDialog dialog;
    // ���ص�����
    private String info;
    // �������̸߳�������
    private static Handler handler = new Handler();
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.write_share);
		
		tv_username=(TextView) findViewById(R.id.name_share);
		tv_password=(TextView) findViewById(R.id.pwd_share);
		tv_article_info=(TextView) findViewById(R.id.article_info);
		btn=(Button) findViewById(R.id.save_btn);
		ed_article=(EditText) findViewById(R.id.ed_share);
		
		//������һ��ҳ�洫�ݵ�����
		Intent intent=getIntent();
		Bundle bundle=intent.getExtras();
				
		username=bundle.getString("username");
		password=bundle.getString("password");
	
		tv_username.setText(username);
		tv_password.setText(password);
		
		btn.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				 // ������磬�޷����wifi
	            if (!checkNetwork()) {
	                Toast toast = Toast.makeText(write_share.this,"����δ����", Toast.LENGTH_SHORT);
	                toast.setGravity(Gravity.CENTER, 0, 0);
	                toast.show();
	                return;
	            }
	            
	            //��ȡ����༭���ֵ
	    		article=ed_article.getText().toString();	    		
	    //		Toast.makeText(write_share.this, article, 1).show();
	    		
				  // ��ʾ��
	            dialog = new ProgressDialog(write_share.this);
	            dialog.setTitle("��ʾ");
	            dialog.setMessage("���ڵ�½�����Ժ�...");
	            dialog.setCancelable(false);
	            dialog.show();
	          
	            // �������̣߳��ֱ����Get��Post����
	            new Thread(new MyThread()).start();
			}
		});
	}
	
	   //���ݲ���
    // ���߳̽������ݣ����߳��޸�����
    public class MyThread implements Runnable {
        @Override
        public void run() {
        	
            info = WebService.executeHttpGet2(username, article);
           
            handler.post(new Runnable() {
                @Override
                public void run() {
                	tv_article_info.setText(info);
                    dialog.dismiss();
                    finish();// �رյ�ǰҳ��
                 
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
