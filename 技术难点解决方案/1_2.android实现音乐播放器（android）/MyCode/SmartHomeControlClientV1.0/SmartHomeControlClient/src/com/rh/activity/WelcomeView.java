package com.rh.activity;

import com.rh.activity.WelcomeView;
import com.rh.activity.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * @Title:		欢迎界面
 * @Fution:		实现开机界面
 * @Author: 	rh_Jameson
 * @date:		2014/10/24
 */

/*
 *SurfaceHolder: 可以把它当成surface的控制器，用来操纵surface
 *SurfaceHolder.Callback接口: 	surfaceChanged + surfaceCreated + surfaceDestroyed
 */
public class WelcomeView extends SurfaceView implements SurfaceHolder.Callback{
	//添加一个主程序的引用
	MainActivity mainActivity;
	
	//添加一些必要的变量 
	
	//当前的不透明值
	int currentAlpha=0;		
	
	//背景图片的引用
	Bitmap backgroundImg;
	//手机分辨率的变量
	int screenWidth;
	int screenHeight;	
	int sleepSpan=60;//动画的时延ms
	
	//画笔变量 
	Paint paint;
	
	//当前的作图坐标
	int currentX;
	int currentY;
	
	public WelcomeView(Context context) {
		super(context);
	}
	//构造函数，初始化View
	public WelcomeView(MainActivity mainActivity) {
		super(mainActivity);
		// TODO Auto-generated constructor stub
		this.mainActivity=mainActivity;
		
		//获取屏幕分辨率
		DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        //System.out.println(screenHeight+","+screenWidth);
		
        //设置背景
        backgroundImg=BitmapFactory.decodeResource(mainActivity.getResources(), R.drawable.client_welcome_ui);
				
		paint=new Paint();

		//获取surfaceView中内嵌的surface,并给SurfaceView当前的持有者一个回调对象
		this.getHolder().addCallback(this);
	}
	
	public void Draw(Canvas canvas){	
		//绘制黑填充矩形清背景
		paint.setColor(Color.BLACK);//设置画笔颜色
		paint.setAlpha(255);
		canvas.drawRect(0, 0, screenWidth, screenHeight, paint);
		
		//进行平面贴图
		if(backgroundImg==null)return;
		paint.setAlpha(currentAlpha);		
		canvas.drawBitmap(backgroundImg, currentX, currentY, paint);	
	}
	
	

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		new Thread()
		{
	
			@Override
			public void run() {
				// TODO Auto-generated method stub
					
				//计算图片位置
				currentX=screenWidth/2-backgroundImg.getWidth()/2;
				currentY=screenHeight/2-backgroundImg.getHeight()/2;
				
				for(int i=255;i>-20;i=i-20)
				{//动态更改图片的透明度值并不断重绘	
					currentAlpha=i;
					if(currentAlpha<0)
					{
						currentAlpha=0;
					}
					SurfaceHolder myholder=WelcomeView.this.getHolder();
					Canvas canvas = myholder.lockCanvas();//获取画布
					try{
						synchronized(myholder){
							Draw(canvas);//绘制
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}
					finally{
						if(canvas != null){
							myholder.unlockCanvasAndPost(canvas);
						}
					}						
					try
					{
						if(i==255)
						{//若是新图片，多等待一会
							Thread.sleep(1000);
						}
						Thread.sleep(sleepSpan);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}	
				
				//向主程序发送事件，提醒切换状态
				mainActivity.sendMessage(WhatMessage.gotoLoginActivity);
			}
		
		
		}.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

}
