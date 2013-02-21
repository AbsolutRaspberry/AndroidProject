package de.lichtenberger.gottschalk.android;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;


public class Lyrics extends ListActivity {
	
	
	
	ImageButton back;
	ListView songList;
	TextView textAnzeige;
	private ArrayList<String> Titelliste = new ArrayList<String>();
	private ArrayList<String> Interpretliste = new ArrayList<String>();
	private ArrayList<String> Dauerliste = new ArrayList<String>();
	
	ProgressDialog dialog;
	
		
	
	 @Override
	   public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_lyrics);
	        
	        Parse.initialize(this, "hGxasGU6e0WQAOh5JIOGDfvFBKrYyBJKXIzxBfAG", "WsOPsXerpsFjsjekKKbZnnjAHvXy5PQHVQEB8Cqu");
	        	        	      
	        
	           	        
	       
	        initDataToView();
	       
	        
	    }

	private void initDataToView() {
		
		
		new getData().execute();
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
	        Log.d("Parse", "PreExecute");
	    }
		
		@Override
		protected SongAdapter doInBackground(Void... params) {
			
			
			
			ParseQuery pq = new ParseQuery("SongDatenbank");
			pq.whereExists("Titel");
			pq.findInBackground(new FindCallback() {

				@Override
				public void done(List<ParseObject> liederListe,
						com.parse.ParseException e) {
					if(e==null){
						Log.d("Parse", "Objektliste empfangen");
						
							ParseObject x;
						
						for(int i=0;i<liederListe.size();i++){
							x = liederListe.get(i);
							Titelliste.add(x.getString("Titel"));
							Dauerliste.add(x.getString("Dauer"));
							Interpretliste.add(x.getString("Interpret"));
						}
						 
						
						x = liederListe.get(0);
						
						Log.d("Parse", x.getString("Titel"));
						Log.d("Parse", x.getString("Dauer"));
						Log.d("Parse", x.getString("Interpret"));
						
						
					}else{
						
						Log.d("Parse", "Objektliste nicht empfangen");
					}
				}
				
				
			});
			
			SongAdapter adapter1 = new SongAdapter(Lyrics.this, Titelliste, Interpretliste, Dauerliste);
			
			return adapter1;
		}
		
		protected void onPostExecute(SongAdapter result) {
	        
			songList.setAdapter(result);
			
	        dialog.dismiss();
	        Log.d("Parse", "Postexecute");
	    }
		
		
	}
	

		 	 


	public class SongAdapter extends ArrayAdapter<String> {
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

		  	
		  
		  public View getView(int position, View convertView, ViewGroup parent){
			  LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			  
			  View list_row = inflater.inflate(R.layout.list_row, parent, false);
			  ImageView imageView = (ImageView)list_row.findViewById(R.id.list_image);
			  TextView titelText = (TextView)list_row.findViewById(R.id.title);
			  TextView artistText = (TextView)list_row.findViewById(R.id.artist);
			  TextView duration = (TextView)list_row.findViewById(R.id.duration);
			  
			 
			  
			  titelText.setText(valuesTitel.get(position));
			  artistText.setText(valuesInterpret.get(position));
			  duration.setText(valuesDauer.get(position));
			  Log.d("Parse", valuesTitel.get(position));
			  return list_row;
			  
			  
			  
		  }
		  }
	
	





}
