package com.imie.rennes.classes;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import com.imie.rennes.mainActivity.LoginActivity;
import com.imie.rennes.mainActivity.MainActivity;

import android.R.bool;
import android.R.string;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Switch;

public class Reseau extends AsyncTask<Object,Void,bool>{
	Context context;


	@Override
	protected bool doInBackground(Object... params) {
		try {
			int param = Integer.parseInt((String)params[0]);
			switch (param){
				case 1:
					String string = IOUtils.toString(CreateUser((String)params[1]));
					context = (Context)params[2];
					break;
				default:
					break;
			}
			//String string = IOUtils.toString(getInputStreamFromUrl(params[0]));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static InputStream getInputStreamFromUrl(Object url) {
  	  InputStream content = null;
  	  try {
  	    HttpClient httpclient = new DefaultHttpClient();
  	    HttpResponse response = httpclient.execute(new HttpGet((String)url));
  	    content = response.getEntity().getContent();
  	  } catch (Exception e) {
  	    Log.e("[GET REQUEST]", "Network exception", e);
  	  }
  	    return content;
  	}
	
	
	public InputStream CreateUser(String url) {
		
	  	  InputStream content = null;
	  	  try {
	  		  
	  		  
	            // 1. create HttpClient
	            HttpClient httpclient = new DefaultHttpClient();
	 
	            // 2. make POST request to the given URL
	            HttpPut httpPut = new HttpPut(url);
	 
	            String json = "";
	 
	            // 3. build jsonObject
	            Utilisateur utilisateur = new Utilisateur();
	            utilisateur.setId(5);
	            utilisateur.setNom("DENIEUL");
	            utilisateur.setPrenom("Jeremy");
	            utilisateur.setAdresse("48 rue Jean-Francois Millet");
	            utilisateur.setTelephone("06060606");
	            utilisateur.setStatus(1);
	            utilisateur.setLogin("j.denieul@gmail.com");
	            utilisateur.setEmail("j.denieul@gmail.com");
	            utilisateur.setLangue("FR");
	            utilisateur.setPassword("1234");
	                 
	            JSONObject jsonObject = new JSONObject();
	            jsonObject.put("id", utilisateur.getId());
	            jsonObject.put("nom", utilisateur.getNom());
	            jsonObject.put("prenom", utilisateur.getPrenom());
	            jsonObject.put("adresse", utilisateur.getAdresse());
	            jsonObject.put("telephone", utilisateur.getTelephone());
	            jsonObject.put("status", utilisateur.getStatus());
	            jsonObject.put("login", utilisateur.getLogin());
	            jsonObject.put("email", utilisateur.getEmail());
	            jsonObject.put("langue", utilisateur.getLangue());
	            jsonObject.put("password", utilisateur.getPassword());
	            
	            
	            // 4. convert JSONObject to JSON to String
	            json = jsonObject.toString();
	            Log.e("json", json);
	 
	            // 5. set httpPost Entity
	            httpPut.setEntity(new StringEntity(json, "UTF8"));
	 
	            // 6. Set some headers to inform server about the type of the content   
	            httpPut.setHeader("Content-type", "application/json");
	            
	            // 7. Execute POST request to the given URL
	            HttpResponse httpResponse = httpclient.execute(httpPut);
	 
	            // 8. receive response as inputStream
	            int value = (int)httpResponse.getStatusLine().getStatusCode();
	            Log.e("code", Integer.toString(value));
	            content = httpResponse.getEntity().getContent();
	            Intent monIntent = new Intent(context, MainActivity.class);
	    		context.startActivity(monIntent);
	            
	  		  
	  	  } catch (Exception e) {
	  	    Log.e("[PUT REQUEST]", "Network exception", e);
	  	  }
	  	    return content;
  	}

}
