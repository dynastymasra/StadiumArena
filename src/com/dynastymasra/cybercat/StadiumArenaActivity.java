package com.dynastymasra.cybercat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StadiumArenaActivity extends Activity {
    /** Called when the activity is first created. */
	TextView date, time, match;
	EditText user, pass;
	Button login, exit;
	ArrayList<NameValuePair> authentication;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        date = (TextView) findViewById(R.id.date);
        time = (TextView) findViewById(R.id.time);
        match = (TextView) findViewById(R.id.macth);
        exit = (Button) findViewById(R.id.exit);
        user = (EditText) findViewById(R.id.username);
		login =(Button) findViewById(R.id.login);
		pass = (EditText) findViewById(R.id.password);
        
		cek();
		
        exit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		login.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				try {
					this.sendAuthenticationData(user.getText().toString(),pass.getText().toString());
				} 
				catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 public void sendAuthenticationData(String username, String password) throws ClientProtocolException, IOException {
				 authentication = new ArrayList<NameValuePair>();
				 authentication.add(new BasicNameValuePair("username", username));
				 authentication.add(new BasicNameValuePair("password", password));
				 this.sendData(authentication);
			 }
			 public void sendData(ArrayList<NameValuePair> data) throws ClientProtocolException, IOException {
				 Read read;	
				 @SuppressWarnings("unused")
				 String temp="";
				 HttpClient httpclient = new DefaultHttpClient();
				 HttpPost httppost = new HttpPost("http://10.0.2.2/football/login.php");
				 httppost.setEntity(new UrlEncodedFormEntity(data));
				 try {
					 HttpResponse response = httpclient.execute(httppost);
					 HttpEntity entity = response.getEntity();
					 temp = EntityUtils.toString(entity); 
					 try {
					      read = new Read("http://10.0.2.2/football/login.php?username=" + user.getText().toString() + "&password=" + pass.getText().toString());
					      String auth = read.getHtml();
						  if(auth.equals("TRUE")) {
							  Toast.makeText(getBaseContext(), "Welcome " + user.getText(), Toast.LENGTH_LONG).show();
							  Intent i = new Intent(StadiumArenaActivity.this, Splash.class);
							  String dataUser = user.getText().toString();
							  i.putExtra("value", dataUser);
							  startActivity(i);
						  }
						  else {
							  Toast.makeText(getBaseContext(), "Check Your ID!", Toast.LENGTH_LONG).show();
						  }     
					 }
					 catch(Exception ex) {
						 System.out.println("Error=" + ex.getMessage());
					 }
				 }
				 catch(Exception e) {
					 Toast.makeText(getBaseContext(), "Check Your Connection!", Toast.LENGTH_LONG).show();
				 }	   
			 }	
		});
	}
    
    public void cek() {
        String url = "http://10.0.2.2/football/check.php";
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();
        try {
        	httpPost.setEntity(new UrlEncodedFormEntity(param));
            HttpResponse httpRespose = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpRespose.getEntity();
            
            InputStream in = httpEntity.getContent();
            BufferedReader read = new BufferedReader(new InputStreamReader(in));
            String content = "";
            String line = "";
            while((line = read.readLine())!=null) {
            	content += line;
            }
            
            Log.d("event", "content: "+content);
            if(!content.equals("null")) {
            	try {
            		JSONArray jArr = new JSONArray(content);
                    String fecha="";
                    String tiempo="";
                    String partido="";
                    for(int i=0; i<jArr.length(); i++) {
	                    JSONObject jObj = jArr.getJSONObject(i);
	                    String datum = jObj.getString("date");
	                    String zeit = jObj.getString("time");
	                    String entsprechen = jObj.getString("versus");
	                    fecha += datum+"\n";
	                    tiempo += zeit+"\n";
	                    partido += entsprechen+"\n";
                    }
                date.setText(fecha);
                time.setText(tiempo);
                match.setText(partido);
                } 
                catch (JSONException e) {
                	// TODO Auto-generated catch block
                	e.printStackTrace();
                }
            }
            else {
            	Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
            }  
        } 
        catch (ClientProtocolException e) {
        	// TODO Auto-generated catch block
        	Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
        } 
        catch (IOException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
       }
    }   
}