package de.lichtenberger.gottschalk.android;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
