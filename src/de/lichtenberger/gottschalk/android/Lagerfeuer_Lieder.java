package de.lichtenberger.gottschalk.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;



public class Lagerfeuer_Lieder extends Activity {

	ImageButton navLyrics;
	ImageButton navTune;
	ImageButton navMusic;
	ImageButton navChords;
	ImageView guitar;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lagerfeuer__lieder);
        
        
        
        setupUI();
        setupOnClickListeners();
        
        
        
    }

	private void setupOnClickListeners() {
		
		navLyrics.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent navToLyrics = new Intent(Lagerfeuer_Lieder.this, Lyrics.class);
				startActivity(navToLyrics);
				
				
				
			}
		});
		
		navTune.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent navToTune = new Intent(Lagerfeuer_Lieder.this, Tune.class);
				startActivity(navToTune);
				
				
				
			}
		});
		
		navMusic.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent navToMusic = new Intent(Lagerfeuer_Lieder.this, Music.class);
				startActivity(navToMusic);
				
				
				
			}
		});
		
		navChords.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent navToChords = new Intent(Lagerfeuer_Lieder.this, Chords.class);
				startActivity(navToChords);
				
				
				
			}
		});
		
		
		
	}

	private void setupUI() {
		
		navLyrics = (ImageButton)findViewById(R.id.navlyrics);
		navTune = (ImageButton)findViewById(R.id.navtune);
		navMusic = (ImageButton)findViewById(R.id.navmusic);
		navChords = (ImageButton)findViewById(R.id.navchords);
		guitar = (ImageView)findViewById(R.id.guitar);
		
		Animation animation = new TranslateAnimation(0, 500,0, 0);
		animation.setDuration(1000);
		animation.setFillAfter(true);
		guitar.startAnimation(animation);
		guitar.setVisibility(0);
	    
		
	}

	private void animation() {
		// TODO Auto-generated method stub
		
	}

}
