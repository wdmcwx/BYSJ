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

    // 登陆按钮
    private Button logbtn,register_btn;
    // 调试文本，注册文本
    private TextView infotv, regtv;
    // 显示用户名和密码
    EditText username, password;
    // 创建等待框
    private ProgressDialog dialog;
    // 返回的数据
    private String info;
    // 返回主线程更新数据
    private static Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_test);

        // 获取控件
        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        logbtn = (Button) findViewById(R.id.login_test);
        register_btn=(Button) findViewById(R.id.register_test);
        infotv = (TextView) findViewById(R.id.info);

        // 设置按钮监听器
        logbtn.setOnClickListener(this);
      //  regtv.setOnClickListener(this);
        register_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
	        case R.id.login_test:
	        	 // 检测网络，无法检测wifi
	            if (!checkNetwork()) {
	                Toast toast = Toast.makeText(Login.this,"网络未连接", Toast.LENGTH_SHORT);
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
	            // 创建子线程，分别进行Get和Post传输
	            new Thread(new MyThread2()).start();
	            break;
	        case R.id.register_test:
	        	 // 检测网络，无法检测wifi
	            if (!checkNetwork()) {
	                Toast toast = Toast.makeText(Login.this,"网络未连接", Toast.LENGTH_SHORT);
	                toast.setGravity(Gravity.CENTER, 0, 0);
	                toast.show();
	                break;
	            }
	            // 提示框
	            dialog = new ProgressDialog(this);
	            dialog.setTitle("提示");
	            dialog.setMessage("正在注册，请稍后...");
	            dialog.setCancelable(false);
	            dialog.show();
	            // 创建子线程，分别进行Get和Post传输
	            new Thread(new MyThread()).start();
	            break;
	        }
        ;
    }

    //数据插入
    // 子线程接收数据，主线程修改数据
    public class MyThread implements Runnable {
        @Override
        public void run() {
            info = WebService.executeHttpGet(username.getText().toString(), password.getText().toString(),"1");
            handler.post(new Runnable() {
                @Override
                public void run() {
                    infotv.setText(info);
                    //数据插入成功
                	if(info.equals("注册成功")){
                		infotv.setText("用户注册成功");
                	}else{
                		infotv.setText("用户注册失败");
                	}
                    dialog.dismiss();
                }
            });
        }
    }
    
    // 子线程接收数据，主线程修改数据
    //数据查询
    public class MyThread2 implements Runnable {
        @Override
        public void run() {
            info = WebService.executeHttpGet(username.getText().toString(), password.getText().toString(),"2");
            handler.post(new Runnable() {
                @Override
                public void run() {              	
                	if(info.equals("2")){
                		infotv.setText("用户名、密码错误");
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

    // 检测网络
    private boolean checkNetwork() {
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager.getActiveNetworkInfo() != null) {
            return connManager.getActiveNetworkInfo().isAvailable();
        }
        return false;
    }

}