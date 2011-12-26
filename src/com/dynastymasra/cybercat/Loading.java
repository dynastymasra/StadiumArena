package com.dynastymasra.cybercat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Loading extends Activity {
	public static int Time = 10000;
	   
	   public void onCreate (Bundle savedInstanceState){
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.loading);
	      
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