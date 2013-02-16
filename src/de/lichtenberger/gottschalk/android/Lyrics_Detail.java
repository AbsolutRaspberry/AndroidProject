package de.lichtenberger.gottschalk.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class Lyrics_Detail extends Activity {

	ImageButton back;
	
	TextView textAnzeige;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_lyrics);
	        
	        Parse.initialize(this, "hGxasGU6e0WQAOh5JIOGDfvFBKrYyBJKXIzxBfAG", "WsOPsXerpsFjsjekKKbZnnjAHvXy5PQHVQEB8Cqu");
	        
	        
	        
	        
	        
	        
	        
	        
	        setupUI();
	        setupOnClickListeners();
	       
	        String text;
	      
	      
	        
	        ParseQuery query = new ParseQuery("SongDatenbank");
	        query.getInBackground("P642qeYf69", new GetCallback() {
	          public void done(ParseObject object, ParseException e) {
	            if (e == null) {
	            	ParseObject gt = object;
	            	String text;
					 
				
	            } else {
	              Log.d("fail", "fail");
	            }
	          }
	        });
	        
	       
	        
	    }

	
	 
	 
	private void setupOnClickListeners() {
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent back = new Intent(Lyrics_Detail.this, Lagerfeuer_Lieder.class);
				startActivity(back);
				
			}
		});
		
	}

	private void setupUI() {
		
		back = (ImageButton)findViewById(R.id.back);
		textAnzeige = (TextView)findViewById(R.id.lyricsView);
		
	}


	
	}
