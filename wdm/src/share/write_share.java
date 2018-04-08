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
	
	// 创建等待框
    private ProgressDialog dialog;
    // 返回的数据
    private String info;
    // 返回主线程更新数据
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
		
		//接受上一个页面传递的数据
		Intent intent=getIntent();
		Bundle bundle=intent.getExtras();
				
		username=bundle.getString("username");
		password=bundle.getString("password");
	
		tv_username.setText(username);
		tv_password.setText(password);
		
		btn.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				 // 检测网络，无法检测wifi
	            if (!checkNetwork()) {
	                Toast toast = Toast.makeText(write_share.this,"网络未连接", Toast.LENGTH_SHORT);
	                toast.setGravity(Gravity.CENTER, 0, 0);
	                toast.show();
	                return;
	            }
	            
	            //获取分享编辑框的值
	    		article=ed_article.getText().toString();	    		
	    //		Toast.makeText(write_share.this, article, 1).show();
	    		
				  // 提示框
	            dialog = new ProgressDialog(write_share.this);
	            dialog.setTitle("提示");
	            dialog.setMessage("正在登陆，请稍后...");
	            dialog.setCancelable(false);
	            dialog.show();
	          
	            // 创建子线程，分别进行Get和Post传输
	            new Thread(new MyThread()).start();
			}
		});
	}
	
	   //数据插入
    // 子线程接收数据，主线程修改数据
    public class MyThread implements Runnable {
        @Override
        public void run() {
        	
            info = WebService.executeHttpGet2(username, article);
           
            handler.post(new Runnable() {
                @Override
                public void run() {
                	tv_article_info.setText(info);
                    dialog.dismiss();
                    finish();// 关闭当前页面
                 
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
