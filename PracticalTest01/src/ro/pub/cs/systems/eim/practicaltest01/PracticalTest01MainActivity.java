package ro.pub.cs.systems.eim.practicaltest01;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


public class PracticalTest01MainActivity extends Activity {
	
	private class BtnListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			
			Button b = (Button)v;
			String buttonName =  b.getText().toString();
			int bId = b.getId();
			
			if( bId == R.id.button2 ){
				EditText editText1 = (EditText)findViewById(R.id.editText1);
				String value = editText1.getText().toString();
				int nr = Integer.parseInt(value);
				nr++;
				editText1.setText(nr + "");
			}else if( bId == R.id.button3 ){
				EditText editText2 = (EditText)findViewById(R.id.editText2);
				String value = editText2.getText().toString();
				int nr = Integer.parseInt(value);
				nr++;
				editText2.setText(nr + "");
			}
			if( bId == R.id.button1 ){
				Log.d("Apll", "intent");
				Log.d("Apll", "intent");
				EditText editText1 = (EditText)findViewById(R.id.editText1);
				String value1 = editText1.getText().toString();
				EditText editText2 = (EditText)findViewById(R.id.editText2);
				String value2 = editText2.getText().toString();
				
				Log.d("Apll", "intent");
				
				Intent intent;
				intent = new Intent("ro.pub.cs.systems.eim.intent.action.PracticalTest01SecondaryActivity");
				intent.putExtra(Constants.Value1, value1);
				intent.putExtra(Constants.Value2, value2);
      		  	startActivityForResult(intent,Constants.COD_INTENTIE);
      		  	
			}
	
			 
			
		}
		
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		
		
		
		  switch(requestCode) {
		    case Constants.COD_INTENTIE/*ANOTHER_ACTIVITY_REQUEST_CODE*/:
		      if (resultCode == Activity.RESULT_OK) {
		    	  Toast.makeText(this, "ok", Toast.LENGTH_LONG).show();
		    	  Log.d("APPL", "okokokok");
		    	 
		      } else {
		    	  Toast.makeText(this, "Cancel", Toast.LENGTH_LONG).show();
		    	  
		      }
		      break;
		  }
		
		}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_main);
		
		if( savedInstanceState != null ){
			if (savedInstanceState.containsKey(Constants.EditText1)) {
				EditText EditText1 = (EditText)findViewById(R.id.editText1);
				EditText1.setText(savedInstanceState.getString(Constants.EditText1));
			}
			if (savedInstanceState.containsKey(Constants.EditText2)) {
				EditText EditText2 = (EditText)findViewById(R.id.editText2);
				EditText2.setText(savedInstanceState.getString(Constants.EditText2));
			}
			
		}
		
		
		BtnListener btnListener = new BtnListener();
		
		Button b1,b2,b3;
		b1 = (Button)findViewById(R.id.button2);
		b1.setOnClickListener(btnListener);
		b2 = (Button)findViewById(R.id.button3);
		b2.setOnClickListener(btnListener);
		b3 = (Button)findViewById(R.id.button1);
		b3.setOnClickListener(btnListener);
		
		
		
		
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		//Log.d(Constants.TAG, "onRestoreInstanceState() method was invoked");
		
		if (savedInstanceState.containsKey(Constants.EditText1)) {
			EditText EditText1 = (EditText)findViewById(R.id.editText1);
			EditText1.setText(savedInstanceState.getString(Constants.EditText1));
		}
		if (savedInstanceState.containsKey(Constants.EditText2)) {
			EditText EditText2 = (EditText)findViewById(R.id.editText2);
			EditText2.setText(savedInstanceState.getString(Constants.EditText2));
		}
	}
	
	
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
	  super.onSaveInstanceState(savedInstanceState);
	  
	  EditText EditText1 = (EditText)findViewById(R.id.editText1);
	  EditText EditText2 = (EditText)findViewById(R.id.editText2);
	  
	  savedInstanceState.putString(Constants.EditText1,EditText1.getText().toString());
	  savedInstanceState.putString(Constants.EditText2,EditText2.getText().toString());

	 // Log.d(Constants.TAG, "onSaveInstanceState() method was invoked");
	  
	  
	  
	 
	  
	  	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
