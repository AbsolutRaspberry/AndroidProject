package de.lichtenberger.gottschalk.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Chords extends Activity {

	ImageButton back;
	
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_lyrics);
	        
	        
	        
	        setupUI();
	        setupOnClickListeners();
	        
	    }

	private void setupOnClickListeners() {
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent back = new Intent(Chords.this, Lagerfeuer_Lieder.class);
				startActivity(back);
				
			}
		});
		
	}

	private void setupUI() {
		
		back = (ImageButton)findViewById(R.id.back);
		
	}
	
}
