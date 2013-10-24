package com.example.staticuserinterfaces;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener, OnItemSelectedListener{

	public final static String EXTRA_MESSAGE = "com.example.staticuserinterfaces.MESSAGE";
	TextView ageTextView;
	SeekBar ageSeekBar;
	final int MAX_VALUE = 104;
	final int MIN_VALUE = 4;
	EditText nameTextField;
	RadioButton maleRadio;
	RadioButton femaleRadio;
	Spinner colourSpinner;
	View colourView;
	
	//New comment!
	

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Link widgets
		ageTextView = (TextView) findViewById(R.id.ageTextView);
		ageSeekBar = (SeekBar) findViewById(R.id.ageSeekBar);
		nameTextField = (EditText) findViewById(R.id.nameTextField);
		maleRadio = (RadioButton) findViewById(R.id.maleRadio);
		femaleRadio = (RadioButton) findViewById(R.id.femaleRadio);
		colourSpinner = (Spinner) findViewById(R.id.colourSpinner);
		colourView = (View) findViewById(R.id.colorView);

		//SeekBar listener
		ageSeekBar.setOnSeekBarChangeListener(this);
		
		//Set values for seekBar
		ageSeekBar.setMax(MAX_VALUE);

		colourSpinner.setOnItemSelectedListener(this);
		//Add new feature here
		///
		///
		
		changeViewColour();
		
	}

	
	//Switch to next activity
	public void nextButton(View view) {
		Intent intent = new Intent(this, SecondActivity.class);
		
		String gender;
		
		if(maleRadio.isChecked()){
			gender = "Male";
		}
		else{
			gender = "Female";
		}
		
		//System.out.println(gender);
		
		String userInfo = "Name: " + nameTextField.getText().toString() 
				+ "\n" + "Gender: " + gender 
				+ "\n" +  "Age: " + ageSeekBar.getProgress()
				+ "\n" + "Favourite Colour: " + colourSpinner.getSelectedItem().toString();
	
		//System.out.println(userInfo);
		
		intent.putExtra(EXTRA_MESSAGE, userInfo);
		startActivity(intent);
		
		//This is a comment
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	//change the text view to the seekbar value
	public void changeAgeTextView(){
		
		if(ageSeekBar.getProgress() < 4){
		
			ageSeekBar.setProgress(4);
			
		}
		
		ageTextView.setText("Age: " + ageSeekBar.getProgress());
		System.out.println(ageSeekBar.getProgress());
	}

	public void changeViewColour(){
		colourView.setBackgroundColor(Color.parseColor(colourSpinner.getSelectedItem().toString()));
	}

	//call the the method to change the seekbar value
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {

		changeAgeTextView();
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}


	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
	changeViewColour();
	}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}


}
