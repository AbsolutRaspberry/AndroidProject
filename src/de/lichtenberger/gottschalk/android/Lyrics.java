package de.lichtenberger.gottschalk.android;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class Lyrics extends Activity {

	ImageButton back;
	ListView songList;
	TextView textAnzeige;
	private ArrayList<String> Titelliste;
	private ArrayAdapter<String> aa;
	
		
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_lyrics);
	        
	        Parse.initialize(this, "hGxasGU6e0WQAOh5JIOGDfvFBKrYyBJKXIzxBfAG", "WsOPsXerpsFjsjekKKbZnnjAHvXy5PQHVQEB8Cqu");
	        	        	      
	        setupUI();
	        setupOnClickListeners();
	       	     	        
	        getSongs();
	        initDataToView();  
	        
	    }




	private void initDataToView() {
		aa = new ArrayAdapter<String>(Lyrics.this, android.R.layout.simple_list_item_1, Titelliste);
		songList = (ListView)findViewById(R.id.SongView);
		songList.setAdapter(aa);
	}




	private void getSongs() {
		ParseQuery pq = new ParseQuery("SongDatenbank");
		
		pq.whereExists("SessionID");
      
		pq.findInBackground(new FindCallback() {
			
			@Override
			public void done(List<ParseObject> objects, ParseException e) {
				if (e==null){
					
					
					
					for(int i = 0; i<objects.size();i++){
						Object object = objects.get(i);
						String titel = ((ParseObject)object).getString("Titel").toString();
						Titelliste.add(titel);
						
					}
					aa.setNotifyOnChange(true);
					songList.setAdapter(aa);
				}
				else {
					
				}
			}
		});
	}

	
	 
	 
	private void setupOnClickListeners() {
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent back = new Intent(Lyrics.this, Lagerfeuer_Lieder.class);
				startActivity(back);
				
			}
		});
	}

	private void setupUI() {
		
		back = (ImageButton)findViewById(R.id.back);
		textAnzeige = (TextView)findViewById(R.id.lyricsView);
				
	}	
}
