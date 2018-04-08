package com.jiudian;

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

public class MyAdapter_jiudian extends BaseAdapter{
	private List<Map<String, Object>> data;
    private LayoutInflater layoutInflater;
    private Context context;

    public MyAdapter_jiudian(Context context, List<Map<String, Object>> data) {
    //传入的data，就是我们要在listview中显示的信息
        this.context = context;
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
    }
    //这里定义了一个类，用来表示一个item里面包含的东西，像我的就是一个imageView和三个TextView，按自己需要来
    public class Info {
        public ImageView imgs;
        public TextView names;
    
        public TextView addrs;
    }
    //所有要返回的数量，Id，信息等，都在data里面，从data里面取就好
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
    //跟actvity中的oncreat()差不多，目的就是给item布局中的各个控件对应好，并添加数据
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Info info = new Info();
        convertView = layoutInflater.inflate(R.layout.jiudian_item, null);
        
        info.imgs = (ImageView) convertView.findViewById(R.id.jd_img);
        info.names= (TextView) convertView
                .findViewById(R.id.jd_names);

        info.addrs = (TextView) convertView
                .findViewById(R.id.jd_addrs);

        //设置数据
  //      info.img.setImageResource((Integer) data.get(position).get("imgs"));
        info.names.setText((String) data.get(position).get(
                "names"));

        info.addrs.setText((String) data.get(position)
                .get("addrs"));
        
//        //得到可用的图片
        Bitmap bitmap = getHttpBitmap( (String) data.get(position).get("imgs"));	      
        //显示
        info.imgs.setImageBitmap(bitmap);
        
        return convertView;
    }
    
    
// * 获取网落图片资源 
	private Bitmap getHttpBitmap(String url) {
		// TODO 自动生成的方法存根
		 URL myFileURL;
	        Bitmap bitmap=null;
	        try{
	            myFileURL = new URL(url);
	            //获得连接
	            HttpURLConnection conn=(HttpURLConnection)myFileURL.openConnection();
	            //设置超时时间为6000毫秒，conn.setConnectionTiem(0);表示没有时间限制
	            conn.setConnectTimeout(6000);
	            //连接设置获得数据流
	            conn.setDoInput(true);
	            //不使用缓存
	            conn.setUseCaches(false);
	            //这句可有可无，没有影响
	            //conn.connect();
	            //得到数据流
	            InputStream is = conn.getInputStream();
	            //解析得到图片
	            bitmap = BitmapFactory.decodeStream(is);
	            //关闭数据流
	            is.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	         
	        return bitmap;
	         
	}
}
