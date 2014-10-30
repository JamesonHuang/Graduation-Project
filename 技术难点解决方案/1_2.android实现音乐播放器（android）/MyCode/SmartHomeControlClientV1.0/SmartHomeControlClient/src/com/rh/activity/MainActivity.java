package com.rh.activity;



import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;

/**
 * @Title:		主控制跳转界面
 * @Fution:		主控制跳转界面，枢纽界面
 * @Author: 	rh_Jameson
 * @date:		2014/10/24
 */

//跳转
class WhatMessage{
	public static final int gotoLoginActivity=0;	
}


public class MainActivity extends Activity {
	Handler handler;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        
		/////////////////////////////////////////
		//跳转线程
		handler=new Handler(){		
			@Override
			public void handleMessage(Message msg) {
			// TODO Auto-generated method stub		
				switch(msg.what){
					case WhatMessage.gotoLoginActivity:
					gotoLoginActivity();
					break;
							
				}
			}
		};
		
		///////////////////////////////////////////////	
		//实例化开始界面动画
		WelcomeView welcomView=new WelcomeView(this);		
		setContentView(welcomView);
	        
    }
    
    //跳转到登录Activity
  	private void gotoLoginActivity() {
  		// TODO Auto-generated method stub
  		Intent intent=new Intent();
  		intent.setClass(MainActivity.this,LoginActivity.class);
  		
  		startActivity(intent);
  	}


  	//给线程传递消息
  	public void sendMessage(int what) {
  		// TODO Auto-generated method stub
  		//创建一个消息体
	  	Message msg=handler.obtainMessage(what);
	  	handler.sendMessage(msg);
  	}
    
}
