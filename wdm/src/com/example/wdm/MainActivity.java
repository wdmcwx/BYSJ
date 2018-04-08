package com.example.wdm;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;

/**
 * @���������������������
 */
public class MainActivity extends Activity implements OnClickListener,
		OnPageChangeListener{
	// ����ViewPager����
	private ViewPager viewPager;
	// ����ViewPager������
	private ViewPagerAdapter vpAdapter;
	// ����һ��ArrayList�����View
	private ArrayList<View> views;
	// ����ͼƬ��Դ
	private static final int[] pics = { R.drawable.yy1, R.drawable.yy2,
			R.drawable.yy3, R.drawable.yy5};
	// �ײ�С���ͼƬ
	private ImageView[] points;
	// ��¼��ǰѡ��λ��
	private int currentIndex;
	
	private static final float MIN_SCALE = 0.75f;
	
    Button btn_guide;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yindaoye);
		initView();
		initData();
	}

	/**
	 * ��ʼ�����
	 */
	private void initView() {
		// ʵ����ArrayList����
		views = new ArrayList<View>();
		// ʵ����ViewPager
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		// ʵ����ViewPager������
		vpAdapter = new ViewPagerAdapter(views);
		
		btn_guide=(Button) findViewById(R.id.btn_guide);
		
	}
	
	/**
	 * ��ʼ������
	 */
	private void initData() {
		// ����һ�����ֲ����ò���
		LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT);

		// ��ʼ������ͼƬ�б�
		for (int i = 0; i < pics.length; i++) {
			ImageView iv = new ImageView(this);
			//iv.setLayoutParams(mParams);
			//��ֹͼƬ����������Ļ
			iv.setScaleType(ScaleType.FIT_XY);
			//����ͼƬ��Դ
			iv.setImageResource(pics[i]);
			views.add(iv);  
			//��Activity�м���Ҫ��ʾ��Views��ͨ����̬���ز��ֵõ�һ����View
		}
		//ViewPager����Ҫһ��PagerAdapter������������ṩ����
		// �������� //��ViewPager���Զ����PagerAdapter��������
		viewPager.setAdapter(vpAdapter);
		
		// ���ü���
		viewPager.setOnPageChangeListener(this);

		// ��ʼ���ײ�С��
		initPoint();
	}

	   
	/**
	 * ��ʼ���ײ�С��
	 */
	private void initPoint() {
		
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll);

		points = new ImageView[pics.length];

		// ѭ��ȡ��С��ͼƬ
		for (int i = 0; i < pics.length; i++) {
			// �õ�һ��LinearLayout�����ÿһ����Ԫ��
			points[i] = (ImageView) linearLayout.getChildAt(i);
			// Ĭ�϶���Ϊ��ɫ
			points[i].setEnabled(true);
			// ��ÿ��С�����ü���
			points[i].setOnClickListener(this);
			// ����λ��tag������ȡ���뵱ǰλ�ö�Ӧ
			points[i].setTag(i);
		}

		// ���õ���Ĭ�ϵ�λ��
		currentIndex = 0;
		// ����Ϊ��ɫ����ѡ��״̬
		points[currentIndex].setEnabled(false);
	}

	/**
	 * ����״̬�ı�ʱ����
	 */
	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	/**
	 * ��ǰҳ�滬��ʱ����
	 */
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	/**
	 * �µ�ҳ�汻ѡ��ʱ����
	 */
	@Override
	public void onPageSelected(int arg0) {
		// ���õײ�С��ѡ��״̬
		setCurDot(arg0);
	}

	@Override
	public void onClick(View v) {
		//��102�� setTag(i);���Ӧ��ȡ���뵱ǰλ�ö�Ӧ
		int position = (Integer) v.getTag();
		
		setCurView(position);
		setCurDot(position);
	}

	/**
	 * ���õ�ǰҳ���λ��
	 */
	private void setCurView(int position) {
		if (position < 0 || position >= pics.length) {
			return;
		}
		viewPager.setCurrentItem(position);
	}

	/**
	 * ���õ�ǰ��С���λ��
	 */
	private void setCurDot(int positon) {
		if (positon < 0 || positon > pics.length - 1 || currentIndex == positon) {
			return;
		}
		points[positon].setEnabled(false);
		points[currentIndex].setEnabled(true);

		currentIndex = positon;
		//currentIndex ��ǰ��ѡ�е�λ��	
		// currentIndex Ϊ3��ʱ�������һ��ͼ
		
		if(currentIndex==3){				
			btn_guide.setText("��ӭʹ��");
			//btn_guide.setBackground(getWallpaper());
			btn_guide.setOnClickListener(new OnClickListener() {			
				@Override
				public void onClick(View v) {
					// TODO �Զ����ɵķ������
				//	Toast.makeText(MainActivity.this,"11", 1).show();
					Intent intent=new Intent(MainActivity.this,SplashActivity .class);
					startActivity(intent);
				}
			});
		}else{
			btn_guide.setText("");
		}
		
	}
}
