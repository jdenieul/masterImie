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
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

public class Reseau extends AsyncTask<String,String,String>{


	@Override
	protected String doInBackground(String... params) {
		try {
			String string = IOUtils.toString(getInputStreamFromUrl(params[0]));
			Log.e("returnrequest",string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static InputStream getInputStreamFromUrl(String url) {
  	  InputStream content = null;
  	  try {
  	    HttpClient httpclient = new DefaultHttpClient();
  	    HttpResponse response = httpclient.execute(new HttpGet(url));
  	    content = response.getEntity().getContent();
  	  } catch (Exception e) {
  	    Log.e("[GET REQUEST]", "Network exception", e);
  	  }
  	    return content;
  	}
	
	
	public static InputStream putInputStreamUrl(String url) {
		
	  	  InputStream content = null;
	  	  try {
	  		  
	  		  
	            // 1. create HttpClient
	            HttpClient httpclient = new DefaultHttpClient();
	 
	            // 2. make POST request to the given URL
	            HttpPost httpPost = new HttpPost(url);
	 
	            String json = "";
	 
	            // 3. build jsonObject
	            Utilisateur utilisateur = new Utilisateur();
	            utilisateur.setNom("DENIEUL");
	            utilisateur.setPrenom("Jérémy");
	            utilisateur.setAdresse("48 rue Jean-François Millet");
	            utilisateur.setTelephone("06060606");
	            utilisateur.setStatus(1);
	            utilisateur.setLogin("j.denieul@gmail.com");
	            utilisateur.setEmail("j.denieul@gmail.com");
	            utilisateur.setLangue("FR");
	            JSONObject jsonObject = new JSONObject();
	            jsonObject.accumulate("nom", utilisateur.getNom());
	            jsonObject.accumulate("prenom", utilisateur.getPrenom());
	            jsonObject.accumulate("adresse", utilisateur.getAdresse());
	            jsonObject.accumulate("telephone", utilisateur.getTelephone());
	            jsonObject.accumulate("status", utilisateur.getStatus());
	            jsonObject.accumulate("login", utilisateur.getLogin());	           
	            jsonObject.accumulate("email", utilisateur.getEmail());
	            jsonObject.accumulate("langue", utilisateur.getLangue());
	            // 4. convert JSONObject to JSON to String
	            json = jsonObject.toString();
	 
	            // ** Alternative way to convert Person object to JSON string usin Jackson Lib 
	            // ObjectMapper mapper = new ObjectMapper();
	            // json = mapper.writeValueAsString(person); 
	 
	            // 5. set json to StringEntity
	            StringEntity se = new StringEntity(json);
	 
	            // 6. set httpPost Entity
	            httpPost.setEntity(se);
	 
	            // 7. Set some headers to inform server about the type of the content   
	            httpPost.setHeader("Accept", "application/json");
	            httpPost.setHeader("Content-type", "application/json");
	            
	            // 8. Execute POST request to the given URL
	            HttpResponse httpResponse = httpclient.execute(httpPost);
	 
	            // 9. receive response as inputStream
	            content = httpResponse.getEntity().getContent();
	  		  
	  	  } catch (Exception e) {
	  	    Log.e("[PUT REQUEST]", "Network exception", e);
	  	  }
	  	    return content;
  	}

}
