package de.lichtenberger.gottschalk.android;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class Start extends Activity {

		TextView Auswahl;
		
		
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_start);
	    
	        
	        
	        setupUI();
	        
	        
	        
	        
	        
	        
}

		private void setupUI() {
			
			Auswahl = (TextView)findViewById(R.id.wahl);
			Typeface face = Typeface.createFromAsset(getAssets(), "fonts/VINERITC.TTF");
			Auswahl.setTypeface(face);
			
			
			
		}}
	    
	    

