package com.example.staticuserinterfaces;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class SecondActivity extends Activity{

	TextView userDataText;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	
		userDataText = (TextView) findViewById(R.id.userDataText);
		
		Intent intent = getIntent();
		String userInfo = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		
		userDataText.setText(userInfo);
		userDataText.setTextSize(40);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
