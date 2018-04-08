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
    // 创建等待框
    private ProgressDialog dialog;
    // 返回的数据
    private String info;
    // 返回主线程更新数据
    private static Handler handler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.article_detail);
		
		tv=(TextView) findViewById(R.id.tv_article_detail);;
		
		  // 提示框
        dialog = new ProgressDialog(this);
        dialog.setTitle("提示");
        dialog.setMessage("正在查询，请稍后...");
        dialog.setCancelable(false);
        dialog.show();
        // 创建子线程，分别进行Get和Post传输
        new Thread(new MyThread()).start();
	}
	
	 // 子线程接收数据，主线程修改数据
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
                	
                	tv.setText(info); //获取服务器返回信息
             //   	Toast.makeText(article_detail.this, info, 1).show();
                    dialog.dismiss();
                }
            });
        }
    }
}
