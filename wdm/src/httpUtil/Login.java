package httpUtil;

import share.share_activity;

import com.example.wdm.R;

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
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener {

    // ��½��ť
    private Button logbtn,register_btn;
    // �����ı���ע���ı�
    private TextView infotv, regtv;
    // ��ʾ�û���������
    EditText username, password;
    // �����ȴ���
    private ProgressDialog dialog;
    // ���ص�����
    private String info;
    // �������̸߳�������
    private static Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_test);

        // ��ȡ�ؼ�
        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        logbtn = (Button) findViewById(R.id.login_test);
        register_btn=(Button) findViewById(R.id.register_test);
        infotv = (TextView) findViewById(R.id.info);

        // ���ð�ť������
        logbtn.setOnClickListener(this);
      //  regtv.setOnClickListener(this);
        register_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
	        case R.id.login_test:
	        	 // ������磬�޷����wifi
	            if (!checkNetwork()) {
	                Toast toast = Toast.makeText(Login.this,"����δ����", Toast.LENGTH_SHORT);
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
	            // �������̣߳��ֱ����Get��Post����
	            new Thread(new MyThread2()).start();
	            break;
	        case R.id.register_test:
	        	 // ������磬�޷����wifi
	            if (!checkNetwork()) {
	                Toast toast = Toast.makeText(Login.this,"����δ����", Toast.LENGTH_SHORT);
	                toast.setGravity(Gravity.CENTER, 0, 0);
	                toast.show();
	                break;
	            }
	            // ��ʾ��
	            dialog = new ProgressDialog(this);
	            dialog.setTitle("��ʾ");
	            dialog.setMessage("����ע�ᣬ���Ժ�...");
	            dialog.setCancelable(false);
	            dialog.show();
	            // �������̣߳��ֱ����Get��Post����
	            new Thread(new MyThread()).start();
	            break;
	        }
        ;
    }

    //���ݲ���
    // ���߳̽������ݣ����߳��޸�����
    public class MyThread implements Runnable {
        @Override
        public void run() {
            info = WebService.executeHttpGet(username.getText().toString(), password.getText().toString(),"1");
            handler.post(new Runnable() {
                @Override
                public void run() {
                    infotv.setText(info);
                    //���ݲ���ɹ�
                	if(info.equals("ע��ɹ�")){
                		infotv.setText("�û�ע��ɹ�");
                	}else{
                		infotv.setText("�û�ע��ʧ��");
                	}
                    dialog.dismiss();
                }
            });
        }
    }
    
    // ���߳̽������ݣ����߳��޸�����
    //���ݲ�ѯ
    public class MyThread2 implements Runnable {
        @Override
        public void run() {
            info = WebService.executeHttpGet(username.getText().toString(), password.getText().toString(),"2");
            handler.post(new Runnable() {
                @Override
                public void run() {              	
                	if(info.equals("2")){
                		infotv.setText("�û������������");
                	}else{
                		Intent intent=new Intent(Login.this,share_activity.class);
                		Bundle bundle=new Bundle();
                		bundle.putCharSequence("username", username.getText().toString());
                		bundle.putCharSequence("password", password.getText().toString());
                		intent.putExtras(bundle);
                		startActivity(intent);
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