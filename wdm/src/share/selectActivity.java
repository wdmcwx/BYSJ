package share;

import com.example.wdm.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class selectActivity extends Activity {
	
	String info;
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select);
		
		tv=(TextView) findViewById(R.id.info_tv);
		
		//������һ��ҳ�洫�ݵ�����
		Intent intent=getIntent();
		Bundle bundle=intent.getExtras();
		info=bundle.getString("info");
		tv.setText(info);
	}
}
