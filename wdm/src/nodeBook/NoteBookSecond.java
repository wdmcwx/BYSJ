package nodeBook;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.wdm.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NoteBookSecond extends Activity {

	EditText ed1,ed2;
	Button bt1;
	MyDataBase myDatabase;
	Cuns cun;
	int ids;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notebook_second);
		ed1=(EditText) findViewById(R.id.editText1);
		ed2=(EditText) findViewById(R.id.editText2);
		bt1=(Button) findViewById(R.id.button1);
		
		// 设置编辑框的不透明度
		ed1.setAlpha(0.5f);
		ed2.setAlpha(0.5f);
		
		myDatabase=new MyDataBase(this);
		
		Intent intent=this.getIntent();
		ids=intent.getIntExtra("ids", 0);
		if(ids!=0){
			cun=myDatabase.getTiandCon(ids);
			ed1.setText(cun.getTitle());
			ed2.setText(cun.getContent());
		}		
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				isSave();
			}
		});
	}

	private void isSave(){
				SimpleDateFormat   formatter   =   new   SimpleDateFormat   ("yyyy.MM.dd  HH:mm:ss");     
				Date   curDate   =   new   Date(System.currentTimeMillis());     
				String times   =   formatter.format(curDate);      
				String title=ed1.getText().toString();
				String content=ed2.getText().toString();
				
				if(ids!=0){ //ids 是标识位，用于决定数据库的修改还是插入操作。
					cun=new Cuns(title,ids, content, times);
					myDatabase.toUpdate(cun);
					Intent intent=new Intent(NoteBookSecond.this,NotebookMain.class);
					startActivity(intent);
					NoteBookSecond.this.finish();
				}
			
				else{
					cun=new Cuns(title,content,times);
					myDatabase.toInsert(cun);
					//进行页面的跳转，跳转至便签首页
					Intent intent=new Intent(NoteBookSecond.this,NotebookMain.class);
					startActivity(intent);
					NoteBookSecond.this.finish();
				}
	}

}
