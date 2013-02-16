package de.lichtenberger.gottschalk.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Tune extends Activity {

	ImageButton back;
	
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_tune);
	        
	        
	        
	        setupUI();
	        setupOnClickListeners();
	        
	    }

	private void setupOnClickListeners() {
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent back = new Intent(Tune.this, Lagerfeuer_Lieder.class);
				startActivity(back);
				
			}
		});
		
	}

	private void setupUI() {
		
		back = (ImageButton)findViewById(R.id.back);
		
	}
	
}
