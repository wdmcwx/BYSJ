package com.example.wdm;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SplashActivity  extends Activity{
	
	ImageView iv;
	TextView tv;
	
	//ʹ�ö�������ʱ�䣬���������������ת
	@Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_splash);
	    
	    iv =(ImageView)findViewById(R.id.splash_iv);
	    tv=(TextView) findViewById(R.id.title);
	      
	  //  iv.setImageResource(R.mipmap.splash);
	    //����͸���ȶ������޵���
	    AlphaAnimation alphaAnimation=new AlphaAnimation(0.0f,1.0f);
	    //���ö�������ʱ��
	    alphaAnimation.setDuration(2000);
	    //��ʼ��ʾ����
	    iv.startAnimation(alphaAnimation);
	    tv.startAnimation(alphaAnimation);
	    
	    //���������ü������ڶ���������ʱ�������ת
	    alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
	      @Override
	      public void onAnimationStart(Animation animation) {
	        //������ʼʱִ��
	        Log.e("TAG", "onAnimationStart: " );
	      }
	 
	      @Override
	      public void onAnimationEnd(Animation animation) {
	        //��������ʱִ��
	        Log.e("TAG", "onAnimationEnd: " );
	        Intent intent=new Intent(SplashActivity.this,TabActivity.class);
	        startActivity(intent);
	        finish();
	      }
	 
	      @Override
	      public void onAnimationRepeat(Animation animation) {
	        //�����ظ�����ʱִ��
	        Log.e("TAG", "onAnimationRepeat: " );
	      }
	    });
	  }
}
