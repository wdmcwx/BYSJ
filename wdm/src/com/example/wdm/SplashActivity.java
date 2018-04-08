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
	
	//使用动画持续时间，动画结束后进行跳转
	@Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_splash);
	    
	    iv =(ImageView)findViewById(R.id.splash_iv);
	    tv=(TextView) findViewById(R.id.title);
	      
	  //  iv.setImageResource(R.mipmap.splash);
	    //设置透明度动画从无到有
	    AlphaAnimation alphaAnimation=new AlphaAnimation(0.0f,1.0f);
	    //设置动画持续时间
	    alphaAnimation.setDuration(2000);
	    //开始显示动画
	    iv.startAnimation(alphaAnimation);
	    tv.startAnimation(alphaAnimation);
	    
	    //给动画设置监听，在动画结束的时候进行跳转
	    alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
	      @Override
	      public void onAnimationStart(Animation animation) {
	        //动画开始时执行
	        Log.e("TAG", "onAnimationStart: " );
	      }
	 
	      @Override
	      public void onAnimationEnd(Animation animation) {
	        //动画结束时执行
	        Log.e("TAG", "onAnimationEnd: " );
	        Intent intent=new Intent(SplashActivity.this,TabActivity.class);
	        startActivity(intent);
	        finish();
	      }
	 
	      @Override
	      public void onAnimationRepeat(Animation animation) {
	        //动画重复播放时执行
	        Log.e("TAG", "onAnimationRepeat: " );
	      }
	    });
	  }
}
