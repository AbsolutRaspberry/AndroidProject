package de.lichtenberger.gottschalk.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SongAdapter extends ArrayAdapter<String> {
	 private final Context context;
	 private final String[] values;

	  public SongAdapter(Context context, String[] values) {
	    super(context, R.layout.list_row, values);
	    this.context = context;
	    this.values = values;
	  }

	  @Override
	  
	  public View getView(int position, View convertView, ViewGroup parent){
		  LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		  
		  View rowView = inflater.inflate(R.layout.list_row, parent, false);
		  ImageView imageView = (ImageView)rowView.findViewById(R.id.list_image);
		  TextView titelText = (TextView)rowView.findViewById(R.id.title);
		  TextView artistText = (TextView)rowView.findViewById(R.id.artist);
		  TextView duration = (TextView)rowView.findViewById(R.id.duration);
		  
		  
		  
		  
		  
		  
	  }
	  

}
