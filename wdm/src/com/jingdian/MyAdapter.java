package com.jingdian;

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

public class MyAdapter extends BaseAdapter {

    private List<Map<String, Object>> data;
    private LayoutInflater layoutInflater;
    private Context context;

    public MyAdapter(Context context, List<Map<String, Object>> data) {
    //�����data����������Ҫ��listview����ʾ����Ϣ
        this.context = context;
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
    }
    //���ﶨ����һ���࣬������ʾһ��item��������Ķ��������ҵľ���һ��imageView������TextView�����Լ���Ҫ��
    public class Info {
        public ImageView img;
        public TextView name;
        public TextView addr;
        public TextView time;
        public TextView jianjie;
        public TextView  tickey1;
        public TextView  tickey2;
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
        convertView = layoutInflater.inflate(R.layout.jingdian_list, null);
        
        info.img = (ImageView) convertView.findViewById(R.id.img);
        info.name= (TextView) convertView
                .findViewById(R.id.name5);
        info.addr = (TextView) convertView
                .findViewById(R.id.addr);
        info.jianjie = (TextView) convertView
                .findViewById(R.id.tese);
        info.time = (TextView) convertView
                .findViewById(R.id.time);
        info.tickey1 = (TextView) convertView
                .findViewById(R.id.tickey1);
        info.tickey2 = (TextView) convertView
                .findViewById(R.id.tickey2);


        //��������
  //      info.img.setImageResource((Integer) data.get(position).get("imgs"));
        info.name.setText((String) data.get(position).get(
                "names"));
        info.addr.setText((String) data.get(position).get(
                "addrs"));
        info.jianjie.setText((String) data.get(position)
                .get("jianjies"));
        info.time.setText((String) data.get(position)
                .get("times"));
        info.tickey1.setText((String) data.get(position)
                .get("tickey1"));
        info.tickey2.setText((String) data.get(position)
                .get("tickey2"));
        
//        //�õ����õ�ͼƬ
        Bitmap bitmap = getHttpBitmap( (String) data.get(position).get("imgs"));	      
        //��ʾ
        info.img.setImageBitmap(bitmap);
        
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
	            //�����п��ޣ�û��Ӱ��
	            //conn.connect();
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