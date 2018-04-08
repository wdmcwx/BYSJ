package com.example.wdm;


import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
/**

 * @����������ViewPager�����������������ݺ�view 
 */
//�Զ���PagerAdapter���Ա㽫Views���ݼ��ص�ViewPager������
public class ViewPagerAdapter extends PagerAdapter{
	
	//�����б�  
    private ArrayList<View> views;  
    
    //����һ�����캯������Ҫʵ������������ʱ����Ҫ����һ��ArrayList����
    public ViewPagerAdapter(ArrayList<View> views){
    	 this.views = views; 
    }
    
    /**
     * ��õ�ǰ������
     */
	@Override
	public int getCount() { 
		 if (views != null) {  
             return views.size();  
         }        
		 else return 0;  
	}

	/**
	 * �ж��Ƿ��ɶ������ɽ��� 
	 */
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return (arg0 == arg1);  
	}

	/**
	 * ����positionλ�õĽ��� 
	 */
	@Override
	public void destroyItem(View container, int position, Object object) {
		((ViewPager) container).removeView(views.get(position));     
	}

	/**
	 * ��ʼ��positionλ�õĽ��� 
	 */
	@Override
	public Object instantiateItem(View container, int position) {
		((ViewPager) container).addView(views.get(position), 0);  
		return views.get(position);  
	}
	
}
