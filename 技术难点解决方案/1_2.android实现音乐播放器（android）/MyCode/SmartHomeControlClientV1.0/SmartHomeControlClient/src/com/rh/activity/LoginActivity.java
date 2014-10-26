package com.rh.activity;

import com.special.ResideMenuDemo.MenuActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;


public class LoginActivity extends Activity {
	Button btn_login = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		btn_login = (Button)findViewById(R.id.btn_login);
		
		//ÉèÖÃµÇÂ¼°´Å¥¼àÌý
		btn_login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this,MenuActivity.class);
				startActivity(intent);
			}
		});
	}
	
	


}
