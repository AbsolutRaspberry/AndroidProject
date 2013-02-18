package de.lichtenberger.gottschalk.android;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class Lyrics extends ListActivity {
	
	
	
	ImageButton back;
	ListView songList;
	TextView textAnzeige;
	private ArrayList<String> Titelliste = new ArrayList<String>();
	private ArrayAdapter<String> aa;
	
	
		
	
	 @Override
	   public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_lyrics);
	        
	        Parse.initialize(this, "hGxasGU6e0WQAOh5JIOGDfvFBKrYyBJKXIzxBfAG", "WsOPsXerpsFjsjekKKbZnnjAHvXy5PQHVQEB8Cqu");
	        	        	      
	        setupUI();
	        setupOnClickListeners();
	           	        
	        getSongs();
	          
	        
	    }

	private void initDataToView() {
		
		
		aa = new ArrayAdapter<String>(Lyrics.this, android.R.layout.simple_list_item_1, Titelliste);
		songList = (ListView)findViewById(R.id.SongView);
		songList.setAdapter(aa);
		aa.notifyDataSetChanged();
	}

	private void getSongs() {
		ParseQuery pq = new ParseQuery("SongDatenbank");
		pq.whereExists("Titel");
		pq.findInBackground(new FindCallback() {
			
			@Override
			public void done(List<ParseObject> liederListe, ParseException e) {
				if(e==null){
					Log.d("Parse", "Objektliste empfangen");
					
						ParseObject x;
					
					for(int i=0;i<liederListe.size();i++){
						x = liederListe.get(i);
						Titelliste.add(x.getString("Titel"));
							
					}
					initDataToView(); 
					
					x = liederListe.get(0);
					
					Log.d("Parse", x.getString("Titel"));
					
					
				}else{
					
					Log.d("Parse", "Objektliste nicht empfangen");
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
