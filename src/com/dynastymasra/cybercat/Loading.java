package com.dynastymasra.cybercat;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class Loading extends Activity {
	public static int Time = 10000;
	MediaPlayer uefa;
	   
	   public void onCreate (Bundle savedInstanceState){
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.loading);
	      
	      uefa = MediaPlayer.create(this, R.raw.uefa);
	      uefa.start();
	      uefa.setLooping(true);
	      
	      new Handler().postDelayed(new Runnable() {
	         public void run() {
	            // TODO Auto-generated method stub
	            Intent intent = new Intent(Loading.this, StadiumArenaActivity.class); 
	            Loading.this.startActivity(intent);
	            Loading.this.finish();  
	         }
	      }, Time);
	   }
}