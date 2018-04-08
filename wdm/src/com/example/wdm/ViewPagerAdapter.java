package com.example.wdm;


import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
/**

 * @功能描述：ViewPager适配器，用来绑定数据和view 
 */
//自定义PagerAdapter，以便将Views数据加载到ViewPager容器中
public class ViewPagerAdapter extends PagerAdapter{
	
	//界面列表  
    private ArrayList<View> views;  
    
    //这是一个构造函数，当要实例化该适配器时候，需要传递一个ArrayList对象。
    public ViewPagerAdapter(ArrayList<View> views){
    	 this.views = views; 
    }
    
    /**
     * 获得当前界面数
     */
	@Override
	public int getCount() { 
		 if (views != null) {  
             return views.size();  
         }        
		 else return 0;  
	}

	/**
	 * 判断是否由对象生成界面 
	 */
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return (arg0 == arg1);  
	}

	/**
	 * 销毁position位置的界面 
	 */
	@Override
	public void destroyItem(View container, int position, Object object) {
		((ViewPager) container).removeView(views.get(position));     
	}

	/**
	 * 初始化position位置的界面 
	 */
	@Override
	public Object instantiateItem(View container, int position) {
		((ViewPager) container).addView(views.get(position), 0);  
		return views.get(position);  
	}
	
}
