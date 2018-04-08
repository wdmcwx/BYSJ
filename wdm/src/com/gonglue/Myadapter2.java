package com.gonglue;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.example.wdm.R;
import com.example.wdm.R.id;
import com.example.wdm.R.layout;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Myadapter2  extends BaseAdapter {
	 private List<Map<String, Object>> data;
	    private LayoutInflater layoutInflater;
	    private Context context;

	    public Myadapter2(Context context, List<Map<String, Object>> data) {
	    //�����data����������Ҫ��listview����ʾ����Ϣ
	        this.context = context;
	        this.data = data;
	        this.layoutInflater = LayoutInflater.from(context);
	    }
	    //���ﶨ����һ���࣬������ʾһ��item��������Ķ��������ҵľ���һ��imageView������TextView�����Լ���Ҫ��
	    public class Info {
	        public ImageView imgs;
	        public TextView titles;
	        public TextView author_time;
	        public TextView profiles;
	    }
	    //����Ҫ���ص�������Id����Ϣ�ȣ�����data���棬��data����ȡ�ͺ�
	    @Override
	    public int getCount() {
	        // TODO Auto-generated method stub
	        return data.size();
	    }

	    @Override
	    public Object getItem(int position) {
	        // TODO Auto-generated method stub
	        return data.get(position);
	    }

	    @Override
	    public long getItemId(int position) {
	        // TODO Auto-generated method stub
	        return position;
	    }
	    //��actvity�е�oncreat()��࣬Ŀ�ľ��Ǹ�item�����еĸ����ؼ���Ӧ�ã����������
	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        // TODO Auto-generated method stub
	        Info info = new Info();
	        convertView = layoutInflater.inflate(R.layout.gonglue_list, null);
	        
	        info.imgs = (ImageView) convertView.findViewById(R.id.gl_img);
	        info.titles= (TextView) convertView
	                .findViewById(R.id.gl_title);
	        info.author_time = (TextView) convertView
	                .findViewById(R.id.author_time);
	        info.profiles = (TextView) convertView
	                .findViewById(R.id.profiles);

	        //��������
	        
	        info.titles.setText((String) data.get(position).get(
	                "titles"));
	        info.author_time.setText((String) data.get(position).get(
	                "author_time"));
	        info.profiles.setText((String) data.get(position)
	                .get("profiles"));
	        
//	        //�õ����õ�ͼƬ
	        Bitmap bitmap = getHttpBitmap( (String) data.get(position).get("imgs"));	      	      
	        //��ʾ
	       info.imgs.setImageBitmap(bitmap);	        
	        return convertView;
	    }
	    
	    
	// * ��ȡ����ͼƬ��Դ 
		private Bitmap getHttpBitmap(String url) {
			// TODO �Զ����ɵķ������
			 URL myFileURL;
		        Bitmap bitmap=null;
		        try{
		            myFileURL = new URL(url);
		            //�������
		            HttpURLConnection conn=(HttpURLConnection)myFileURL.openConnection();
		            //���ó�ʱʱ��Ϊ6000���룬conn.setConnectionTiem(0);��ʾû��ʱ������
		            conn.setConnectTimeout(6000);
		            //�������û��������
		            conn.setDoInput(true);
		            //��ʹ�û���
		            conn.setUseCaches(false);
		            //�õ�������
		            InputStream is = conn.getInputStream();
		            //�����õ�ͼƬ
		            bitmap = BitmapFactory.decodeStream(is);
		            //�ر�������
		            is.close();
		        }catch(Exception e){
		            e.printStackTrace();
		        }	         
		        return bitmap;		         
		}

}
