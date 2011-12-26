package com.dynastymasra.cybercat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class Splash extends Activity {
	   private static int progress = 0;
	   private int status = 0;
	   ProgressBar progressBar;
	   Handler handler = new Handler();
	   String msg;
	   
	   public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.splash);
	      progressBar = (ProgressBar) findViewById(R.id.progg);
	      
	      Intent intent = getIntent();
	      msg = intent.getStringExtra("value");
	     
	      new Thread(new Runnable() {
	         @Override
	         public void run() {
	            // TODO Auto-generated method stub
	            while(status < 100) {
	               status = loading();
	               handler.post(new Runnable() {
	                  @Override
	                  public void run() {
	                     // TODO Auto-generated method stub
	                  progressBar.setProgress(status);   
	                  }
	               });
	            }
	            handler.post(new Runnable() {
	               @Override
	               public void run() {
	                  // TODO Auto-generated method stub
	            	   Intent intent = new Intent(Splash.this, Index.class);
	            	   String dataUser = msg;
	            	   intent.putExtra("value", dataUser);
	            	   startActivity(intent);
	            	   status = 0;
	            	   progress = 0;
	            	   Splash.this.finish();
	               }
	            });
	         }
	         public int loading() {
	            try {
	               Thread.sleep(50);
	            } 
	            catch(InterruptedException ie) {
	               ie.printStackTrace();
	            }
	            return ++progress;
	         }
	      }).start();
	  }
}

