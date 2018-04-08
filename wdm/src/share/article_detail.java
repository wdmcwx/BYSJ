package share;

import httpUtil.WebService;
import httpUtil.Login.MyThread;

import com.example.wdm.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

public class article_detail extends Activity {
	
	TextView tv;
    // �����ȴ���
    private ProgressDialog dialog;
    // ���ص�����
    private String info;
    // �������̸߳�������
    private static Handler handler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.article_detail);
		
		tv=(TextView) findViewById(R.id.tv_article_detail);;
		
		  // ��ʾ��
        dialog = new ProgressDialog(this);
        dialog.setTitle("��ʾ");
        dialog.setMessage("���ڲ�ѯ�����Ժ�...");
        dialog.setCancelable(false);
        dialog.show();
        // �������̣߳��ֱ����Get��Post����
        new Thread(new MyThread()).start();
	}
	
	 // ���߳̽������ݣ����߳��޸�����
    public class MyThread implements Runnable {
        @Override
        public void run() {
        	
            String username = "";
			String password = "";
			
			info = WebService.executeHttpGet(username, password,"3");
            // info = WebServicePost.executeHttpPost(username.getText().toString(), password.getText().toString());
            handler.post(new Runnable() {
                @Override
                public void run() {
                	
                	tv.setText(info); //��ȡ������������Ϣ
             //   	Toast.makeText(article_detail.this, info, 1).show();
                    dialog.dismiss();
                }
            });
        }
    }
}
