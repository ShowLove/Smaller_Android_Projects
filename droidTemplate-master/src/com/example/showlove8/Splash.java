package com.example.showlove8;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity{
	
	MediaPlayer ourSong; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.splash); //activates the layout xml file
		ourSong = MediaPlayer.create(Splash.this, R.raw.realnes); 
		ourSong.start(); //we want to do this bellow setContentView
		Thread timer = new Thread(){
			public void run(){  //all inside these brackets must be in order to start new activity
				try{
					sleep(10000);  //miliseconds 
				} catch(InterruptedException e){
					e.printStackTrace(); //dont need to understand 
				} finally{
					//this is what actually opens the activity 
					Intent openStartingPoint = new Intent("com.example.showlove8.MENUE"); 
					startActivity(openStartingPoint); 
				}
			}
		};
		timer.start(); //starts the thread 
	}

	@Override  //do on pause to get rid of splash stuff after ive transferd to new activity 
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish(); 
	}
	

}
