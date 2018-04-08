package share;

import com.example.wdm.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class share_activity extends Activity {
	
	Button btn,btn_article;
	String password,username,info;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.share);
		
		btn=(Button) findViewById(R.id.button_share);
		btn_article=(Button) findViewById(R.id.btn_article);
		//������һ��ҳ�洫�ݵ�����
		Intent intent=getIntent();
		Bundle bundle=intent.getExtras();
		
		username=bundle.getString("username");
		password=bundle.getString("password");
		//info=bundle.getString("info");
		
	//	tv.setText(info);
		
		//ҳ����ת
		btn.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				Intent intent=new Intent(share_activity.this,write_share.class);
				Bundle bundle=new Bundle();
        		bundle.putCharSequence("username", username);
        		bundle.putCharSequence("password", password);
        		intent.putExtras(bundle);
				startActivity(intent);			
			}
		});
		
		btn_article.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				Intent intent=new Intent(share_activity.this,article_detail.class);
				startActivity(intent);	
			}
		});
	}
}
