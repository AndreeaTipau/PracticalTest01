package ro.pub.cs.systems.eim.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01SecondaryActivity extends Activity {
	
	
	private class BtnListener implements OnClickListener{

		
		
		@Override
		public void onClick(View v) {
		
			Button b = (Button)v;
			String buttonName =  b.getText().toString();
			int bId = b.getId();
			
			if( bId == R.id.button5 ){
				//ok
				Intent intentToParent = new Intent();
				setResult(Activity.RESULT_OK, intentToParent);
				Log.d("APPL","am trimis intentia");
				finish();

				
			}else if( bId == R.id.button6 ){
				//cancel
				Intent intentToParent = new Intent();
				setResult(Activity.RESULT_CANCELED, intentToParent);
				finish();
				
			}

	
			 
			
		}
		
	}
	
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_secondary);
		
		Log.d("Secondary", "intra aici");
		 // intent from parent
		Intent intentFromParent = getIntent();
		if( intentFromParent != null ){
			 Bundle data = intentFromParent.getExtras();
			  if( data != null ){
				  String value1 = data.getString(Constants.Value1);
				  String value2 = data.getString(Constants.Value2);
				  
				  if( value1 == null )
					  value1 = "0";
				  
				  if( value2 == null )
					  value2 = "0";
				  
				  Log.d("APPL", value1 + " + " + value2);
				  int v1 = Integer.parseInt(value1);
				  int v2 = Integer.parseInt(value2);
				  Log.d("APPL", v1 + " + " + v2);
				   v1 = v1 + v2;
				  final EditText number = (EditText)findViewById(R.id.editText5);
				  number.setText( v1  + "" );
		  
				  BtnListener btnListener = new BtnListener();
					
					Button b5,b6;
					b5 = (Button)findViewById(R.id.button5);
					b5.setOnClickListener(btnListener);
					b6 = (Button)findViewById(R.id.button6);
					b6.setOnClickListener(btnListener);  
			  }
		}
		
		/*
		 Intent intentFromParent = getIntent();
		  if( intentFromParent != null ){
			  
			  
			  Bundle data = intentFromParent.getExtras();
			  if( data != null ){
				  
				  //iau numarul de telefon
				  String phoneNumber = data.getString("ro.pub.cs.systems.eim.lab04.contactsmanager.PHONE_NUMBER_KEY");
				  final EditText number = (EditText)findViewById(R.id.editText2);
				  
				  if (phoneNumber != null) {
					//il setez
					  number.setText(phoneNumber);
				  		} else {
				  			// anunt eroarea
				  			Toast.makeText(this, getResources().getString(R.string.phone_error), Toast.LENGTH_LONG).show();
				  			}
			  }
		
		  */

		  
		 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_secondary, menu);
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
