package nodeBook;

import java.util.ArrayList;

import com.example.wdm.R;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;

public class NotebookMain extends Activity {
	
	Button bt;
	ListView lv;
	LayoutInflater inflater;
	ArrayList<Cuns> array;
	MyDataBase mdb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notebook_main);
		
		lv=(ListView) findViewById(R.id.listView1);
		bt=(Button) findViewById(R.id.button1);
		inflater=getLayoutInflater();//��ȡ����
		
		mdb=new MyDataBase(this);
		array=mdb.getArray();//��ȡ���еı�ǩ��Ϣ
		MyAdapter adapter=new MyAdapter(inflater,array); //ͨ��������ʹ���Զ���Ĳ����ļ�
		lv.setAdapter(adapter);
	
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
								
				Intent intent=new Intent(getApplicationContext(),NoteBookSecond.class);
				intent.putExtra("ids",array.get(position).getIds() );
				startActivity(intent);
				NotebookMain.this.finish();
			}
		});
		
		lv.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					final int position, long id) {
				
				new AlertDialog.Builder(NotebookMain.this)
				.setTitle("ɾ��")
				.setMessage("�Ƿ�ɾ���ʼ�")
				.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						
					}
				})
				.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {			
						mdb.toDelete(array.get(position).getIds());
						array=mdb.getArray();
						MyAdapter adapter=new MyAdapter(inflater,array);
						lv.setAdapter(adapter);
					}
				})
				.create().show();
				return true;
			}
		});
		
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				Intent intent=new Intent(getApplicationContext(),NoteBookSecond.class);
				startActivity(intent);
				NotebookMain.this.finish();
			}
		});
			
	}
	
}
