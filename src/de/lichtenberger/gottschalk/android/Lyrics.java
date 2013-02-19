package de.lichtenberger.gottschalk.android;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
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
	private ArrayList<String> Interpretliste = new ArrayList<String>();
	private ArrayList<String> Dauerliste = new ArrayList<String>();
	private ArrayAdapter<String> aa;
	private SongAdapter sA;
	ProgressDialog dialog;
	
		
	
	 @Override
	   public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_lyrics);
	        
	        Parse.initialize(this, "hGxasGU6e0WQAOh5JIOGDfvFBKrYyBJKXIzxBfAG", "WsOPsXerpsFjsjekKKbZnnjAHvXy5PQHVQEB8Cqu");
	        	        	      
	        setupUI();
	        setupOnClickListeners();
	           	        
	        new getData().execute();
	          
	        
	    }

	private void initDataToView() {
		
		
		sA = new SongAdapter(Lyrics.this, Titelliste, Interpretliste, Dauerliste);
		songList = (ListView)findViewById(android.R.id.list);
		
	}

	private class getData extends AsyncTask<Void, Void, SongAdapter>{

		ProgressDialog dialog;
		@Override
		protected void onPreExecute() {
	        dialog = new ProgressDialog(Lyrics.this);
	        dialog.setMessage("Please wait, while loading!");
	        dialog.setIndeterminate(true);
	        dialog.setCancelable(false);
	        dialog.show();
	    }
		
		@Override
		protected SongAdapter doInBackground(Void... params) {
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
							Dauerliste.add(x.getString("Dauer"));
							Interpretliste.add(x.getString("Interpret"));
						}
						initDataToView(); 
						
						x = liederListe.get(0);
						
						Log.d("Parse", x.getString("Titel"));
						
						
					}else{
						
						Log.d("Parse", "Objektliste nicht empfangen");
					}
				}
			});
			return null;
		}
		
		protected void onPostExecute(SongAdapter result) {
	        sA = result;
			songList.setAdapter(sA);
	        dialog.dismiss();
	    }
		
		
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

	private class SongAdapter extends ArrayAdapter<String> {
		 private final Context context;
		 private final ArrayList<String> valuesTitel;
		 private final ArrayList<String> valuesInterpret;
		 private final ArrayList<String> valuesDauer;
		 

		  public SongAdapter(Context context, ArrayList<String> valuesTitel, ArrayList<String> valuesInterpret, ArrayList<String> valuesDauer) {
		    super(context, R.layout.list_row);
		    this.context = context;
		    this.valuesTitel = valuesTitel;
		    this.valuesInterpret = valuesInterpret;
		    this.valuesDauer = valuesDauer;
		  }

		  @Override
		  
		  public View getView(int position, View convertView, ViewGroup parent){
			  LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			  
			  View rowView = inflater.inflate(R.layout.list_row, parent, false);
			  ImageView imageView = (ImageView)rowView.findViewById(R.id.list_image);
			  TextView titelText = (TextView)rowView.findViewById(R.id.title);
			  TextView artistText = (TextView)rowView.findViewById(R.id.artist);
			  TextView duration = (TextView)rowView.findViewById(R.id.duration);
			  
			 
			  
			  titelText.setText(valuesTitel.get(position));
			  artistText.setText(valuesInterpret.get(position));
			  duration.setText(valuesDauer.get(position));
			  
			  return rowView;
			  
			  
			  
		  }
		  

	}

	
	
}
