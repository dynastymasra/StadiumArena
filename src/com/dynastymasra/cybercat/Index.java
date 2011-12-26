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

public class Index extends Activity {
    /** Called when the activity is first created. */
	TextView id, event, userLogin, textDeposit, tribuneOne, tribuneTwo, tribuneThree;
	String msg, asset, tribuneUno, tribuneDos, tribuneTres, idUser, newTotal, newTotalDeposit;
	Button exit, tribuneEine, tribuneDrei, tribuneZwei;
	EditText jumlahEdit, eventId;
	double eineTribuneTotal, zwei, drei, total, hasil, jumlahTicket, newDeposit, finalDeposit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        
        eventId = (EditText) findViewById(R.id.eventId);
        jumlahEdit = (EditText) findViewById(R.id.eventTotal);
        tribuneEine = (Button) findViewById(R.id.OrderOne);
        tribuneZwei = (Button) findViewById(R.id.OrderTwo);
        tribuneDrei = (Button) findViewById(R.id.OrderThree);
        tribuneOne = (TextView) findViewById(R.id.tribuneOne);
        tribuneTwo = (TextView) findViewById(R.id.tribuneTwo);
        tribuneThree = (TextView) findViewById(R.id.tribuneThree);
        exit = (Button) findViewById(R.id.exitEvent);
        id = (TextView) findViewById(R.id.id);
        event = (TextView) findViewById(R.id.event);
        userLogin = (TextView) findViewById(R.id.userLogin);
        textDeposit = (TextView) findViewById(R.id.textDeposit);
        
        tribuneDrei.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				eineTribuneTotal = Double.parseDouble(tribuneTres);
				jumlahTicket = Double.parseDouble(jumlahEdit.getText().toString());
				total = eineTribuneTotal * jumlahTicket;
				newDeposit = Double.parseDouble(asset);
				finalDeposit = newDeposit - total;
				newTotalDeposit = String.valueOf(finalDeposit);
				newTotal = String.valueOf(total);
				if(finalDeposit < 0 ) {
					Toast.makeText(getBaseContext(), "Your savings are not enough!", Toast.LENGTH_LONG).show();
				}
				else if (jumlahTicket > 5) {
					Toast.makeText(getBaseContext(), "Your Over Buying Ticket!", Toast.LENGTH_LONG).show();
				}
				else {
					String input_data= "http://10.0.2.2/football/insert.php";  
			           HttpClient httpClient = new DefaultHttpClient();
			           HttpPost httpPost = new HttpPost(input_data);
			           ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();
			           param.add(new BasicNameValuePair("username", msg));
			           param.add(new BasicNameValuePair("id_event", eventId.getText().toString()));
			           param.add(new BasicNameValuePair("total", jumlahEdit.getText().toString()));
			           param.add(new BasicNameValuePair("price", newTotal));
			           param.add(new BasicNameValuePair("deposit", newTotalDeposit));
			           try {
			        	   httpPost.setEntity(new UrlEncodedFormEntity(param));
			        	   HttpResponse httpRespose = httpClient.execute(httpPost);
			               HttpEntity httpEntity = httpRespose.getEntity();
			               InputStream in = httpEntity.getContent();
			               BufferedReader read = new BufferedReader(new InputStreamReader(in));
			            
			               String isi= "";
			               String baris= "";
			            
			               while((baris = read.readLine())!=null) {
			                  isi+= baris;
			               }
			               if(!isi.equals("null")) {                  
			            	   Toast.makeText(getBaseContext(), "Success Buying Ticket", Toast.LENGTH_LONG).show();
			               }
			               else {
			            	   Toast.makeText(getBaseContext(), "Failed Buying Ticket", Toast.LENGTH_LONG).show();
			               }
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
				checkData();
			}
		});
        
        tribuneZwei.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				eineTribuneTotal = Double.parseDouble(tribuneDos);
				jumlahTicket = Double.parseDouble(jumlahEdit.getText().toString());
				total = eineTribuneTotal * jumlahTicket;
				newDeposit = Double.parseDouble(asset);
				finalDeposit = newDeposit - total;
				newTotalDeposit = String.valueOf(finalDeposit);
				newTotal = String.valueOf(total);
				if(finalDeposit < 0 ) {
					Toast.makeText(getBaseContext(), "Your savings are not enough!", Toast.LENGTH_LONG).show();
				}
				else if (jumlahTicket > 5) {
					Toast.makeText(getBaseContext(), "Your Over Buying Ticket!", Toast.LENGTH_LONG).show();
				}
				else {
					String input_data= "http://10.0.2.2/football/insert.php";  
			           HttpClient httpClient = new DefaultHttpClient();
			           HttpPost httpPost = new HttpPost(input_data);
			           ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();
			           param.add(new BasicNameValuePair("username", msg));
			           param.add(new BasicNameValuePair("id_event", eventId.getText().toString()));
			           param.add(new BasicNameValuePair("total", jumlahEdit.getText().toString()));
			           param.add(new BasicNameValuePair("price", newTotal));
			           param.add(new BasicNameValuePair("deposit", newTotalDeposit));
			           try {
			        	   httpPost.setEntity(new UrlEncodedFormEntity(param));
			        	   HttpResponse httpRespose = httpClient.execute(httpPost);
			               HttpEntity httpEntity = httpRespose.getEntity();
			               InputStream in = httpEntity.getContent();
			               BufferedReader read = new BufferedReader(new InputStreamReader(in));
			            
			               String isi= "";
			               String baris= "";
			            
			               while((baris = read.readLine())!=null) {
			                  isi+= baris;
			               }
			               if(!isi.equals("null")) {                  
			            	   Toast.makeText(getBaseContext(), "Success Buying Ticket", Toast.LENGTH_LONG).show();
			               }
			               else {
			            	   Toast.makeText(getBaseContext(), "Failed Buying Ticket", Toast.LENGTH_LONG).show();
			               }
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
				checkData();
			}
		});
        
        tribuneEine.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				eineTribuneTotal = Double.parseDouble(tribuneUno);
				jumlahTicket = Double.parseDouble(jumlahEdit.getText().toString());
				total = eineTribuneTotal * jumlahTicket;
				newDeposit = Double.parseDouble(asset);
				finalDeposit = newDeposit - total;
				newTotalDeposit = String.valueOf(finalDeposit);
				newTotal = String.valueOf(total);
				if(finalDeposit < 0 ) {
					Toast.makeText(getBaseContext(), "Your savings are not enough!", Toast.LENGTH_LONG).show();
				}
				else if (jumlahTicket > 5) {
					Toast.makeText(getBaseContext(), "Your Over Buying Ticket!", Toast.LENGTH_LONG).show();
				}
				else {
					String input_data= "http://10.0.2.2/football/insert.php";  
			           HttpClient httpClient = new DefaultHttpClient();
			           HttpPost httpPost = new HttpPost(input_data);
			           ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();
			           param.add(new BasicNameValuePair("username", msg));
			           param.add(new BasicNameValuePair("id_event", eventId.getText().toString()));
			           param.add(new BasicNameValuePair("total", jumlahEdit.getText().toString()));
			           param.add(new BasicNameValuePair("price", newTotal));
			           param.add(new BasicNameValuePair("deposit", newTotalDeposit));
			           try {
			        	   httpPost.setEntity(new UrlEncodedFormEntity(param));
			        	   HttpResponse httpRespose = httpClient.execute(httpPost);
			               HttpEntity httpEntity = httpRespose.getEntity();
			               InputStream in = httpEntity.getContent();
			               BufferedReader read = new BufferedReader(new InputStreamReader(in));
			            
			               String isi= "";
			               String baris= "";
			            
			               while((baris = read.readLine())!=null) {
			                  isi+= baris;
			               }
			               if(!isi.equals("null")) {                  
			            	   Toast.makeText(getBaseContext(), "Success Buying Ticket", Toast.LENGTH_LONG).show();
			               }
			               else {
			            	   Toast.makeText(getBaseContext(), "Failed Buying Ticket", Toast.LENGTH_LONG).show();
			               }
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
				checkData();
			}
		});
        			
        exit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        inIntent();
        cek();
        checkData();
        tribunePrice();
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
                    String de="";
                    String evento="";
                    for(int i=0; i<jArr.length(); i++) {
	                    JSONObject jObj = jArr.getJSONObject(i);
	                    String identitat = jObj.getString("id");
	                    String ereignis = jObj.getString("versus");
	                    evento += ereignis +"\n";
	                    de += identitat +"\n";
                    }
                event.setText(evento);
                id.setText(de);
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
    
    public void checkData() {
    	String url = "http://10.0.2.2/football/deposit.php";
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();
        param.add(new BasicNameValuePair("username", msg));
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
                    asset = "";
                    idUser = "";
                    for(int i=0; i<jArr.length(); i++) {
	                    JSONObject jObj = jArr.getJSONObject(i);
	                    String identitat = jObj.getString("deposit");
	                    String usuario = jObj.getString("id");
	                    asset += identitat +"\n";
	                    idUser += usuario;
                    }
                textDeposit.setText("Your Deposit: "+ asset);
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
    
    public void tribunePrice() {
    	String url = "http://10.0.2.2/football/tribune.php";
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
                    tribuneUno = "";
                    tribuneDos = "";
                    tribuneTres = "";
                    for(int i=0; i<jArr.length(); i++) {
	                    JSONObject jObj = jArr.getJSONObject(i);
	                    String uno = jObj.getString("tribuneOne");
	                    String two = jObj.getString("tribuneTwo");
	                    String tres = jObj.getString("tribuneThree");
	                    tribuneUno += uno +"\n";
	                    tribuneDos += two +"\n";
	                    tribuneTres += tres +"\n";
                    }
                tribuneOne.setText(tribuneUno);
                tribuneTwo.setText(tribuneDos);
                tribuneThree.setText(tribuneTres);
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
    
    public void inIntent() {
    	Intent intent = getIntent();
    	msg = intent.getStringExtra("value");
    	userLogin.setText("Hello "+ msg);
    }
}