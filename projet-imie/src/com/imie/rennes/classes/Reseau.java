package com.imie.rennes.classes;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import com.imie.rennes.imienetwork.AccueilEleveFragment;
import com.imie.rennes.imienetwork.OffreFragment;
import com.imie.rennes.mainActivity.MainActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

public class Reseau extends AsyncTask<Object,Void,Integer>{
	Context context;
	Integer param;
	ProgressDialog progDailog;
	
	public Reseau(Context context){
		this.context = context;
		this.progDailog = new ProgressDialog(context);
	}


	@Override
	protected Integer doInBackground(Object... params) {
		int result = 0;
		param = Integer.parseInt((String)params[0]);
		switch (param){
			//Creation user
			case 1:
				result = CreateUser((String)params[1], (Utilisateur)params[2]);
				break;
			//Login
			case 2:
				result = Login((String)params[1], (String)params[2], (String)params[3]);
				break;
			//Creation offre
			case 3:
				result = CreateOffre((Offre)params[0]);
				break;
			//Creation competence
			case 4:
				result = CreateCompetence((Competence)params[0]);
				break;
			default:
				break;
		}
		//String string = IOUtils.toString(getInputStreamFromUrl(params[0]));
		return result;
	}
	
	@Override
	protected void onPostExecute(Integer result) {
		//En cas d'utilisateur creer ou mise à jour
		if((param == 1  && result == 200) || (param == 1 && result == 201)){
			Intent monIntent = new Intent(context, MainActivity.class);
			context.startActivity(monIntent);
		}
		//Login
		if(param == 2  && result == 200){
			Intent monIntent = new Intent(context, MainActivity.class);
			context.startActivity(monIntent);
		}
		//Creation Offre
		if((param == 3  && result == 200) || (param == 3 && result == 201)){
			Intent monIntent = new Intent(context, OffreFragment.class);
			context.startActivity(monIntent);
		}
		//Creation Competence
		if((param == 4  && result == 200) || (param == 4 && result == 201)){
			Intent monIntent = new Intent(context, AccueilEleveFragment.class);
			context.startActivity(monIntent);
		}
		progDailog.dismiss();
	}
	
	@Override
    protected void onPreExecute() {
        super.onPreExecute();
        progDailog.setMessage("Chargement...");
        progDailog.setIndeterminate(false);
        progDailog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progDailog.setCancelable(false);
        progDailog.show();
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
	
	
	public int CreateUser(String url, Utilisateur utilisateur) {
		
	  	  try {
	  		  
	  		  
	            // 1. create HttpClient
	            HttpClient httpclient = new DefaultHttpClient();
	 
	            // 2. make POST request to the given URL
	            HttpPut httpPut = new HttpPut(url);
	 
	            // 3. build jsonObject	                 
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
	            
	            
	            // 4. convert JSONObject to JSON to String
	            String json = jsonObject.toString();
	            Log.e("json", json);
	            
	            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		        nameValuePairs.add(new BasicNameValuePair("object", json)); 
	 
	            // 5. set httpPost Entity
	            httpPut.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	 
	            // 6. Set some headers to inform server about the type of the content   
	            httpPut.setHeader("Content-type", "application/json");
	            
	            // 7. Execute POST request to the given URL
	            HttpResponse httpResponse = httpclient.execute(httpPut);
	 
	            // 8. receive response as inputStream
	            int value = (int)httpResponse.getStatusLine().getStatusCode();
	            Log.e("code", Integer.toString(value));
	            return value;
	            
	  		  
	  	  } catch (Exception e) {
	  	    Log.e("[PUT REQUEST]", "Network exception", e);
	  	  }
		return 0;
  	}
	
	public int CreateOffre(Offre offre){
		try {
	  		String url = "http://imierennes.no-ip.biz:10080/imie-network-website/web/app_dev.php/api/offre/"+offre.getId()+".json";
	  		  
            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
 
            // 2. make POST request to the given URL
            HttpPut httpPut = new HttpPut(url);
 
            // 3. build jsonObject	                 
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", offre.getId());
            jsonObject.put("titre", offre.getTitre());
            jsonObject.put("description", offre.getDescription());
            jsonObject.put("dateDebut", offre.getDateDebut());
            jsonObject.put("detailsContact", offre.getDetailsContact());
            jsonObject.put("departement", offre.getCompetences());
            jsonObject.put("duree", offre.getDuree());
            jsonObject.put("typePoste", offre.getTypePoste());
            
            
            // 4. convert JSONObject to JSON to String
            String json = jsonObject.toString();
            Log.e("json", json);
            
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	        nameValuePairs.add(new BasicNameValuePair("object", json)); 
 
            // 5. set httpPost Entity
            httpPut.setEntity(new UrlEncodedFormEntity(nameValuePairs));
 
            // 6. Set some headers to inform server about the type of the content   
            httpPut.setHeader("Content-type", "application/json");
            
            // 7. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPut);
 
            // 8. receive response as inputStream
            int value = (int)httpResponse.getStatusLine().getStatusCode();
            Log.e("code", Integer.toString(value));
            return value;
            
  		  
  	  } catch (Exception e) {
  	    Log.e("[PUT REQUEST]", "Network exception", e);
  	  }
	return 0;
	}
	
	public int CreateCompetence(Competence competence){
		try {
	  		String url = "http://imierennes.no-ip.biz:10080/imie-network-website/web/app_dev.php/api/competence/"+competence.getId()+".json";
	  		  
            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
 
            // 2. make POST request to the given URL
            HttpPut httpPut = new HttpPut(url);
 
            // 3. build jsonObject	                 
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", competence.getId());
            jsonObject.put("libelle", competence.getLibelle());
            
            
            // 4. convert JSONObject to JSON to String
            String json = jsonObject.toString();
            Log.e("json", json);
            
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	        nameValuePairs.add(new BasicNameValuePair("object", json)); 
 
            // 5. set httpPost Entity
            httpPut.setEntity(new UrlEncodedFormEntity(nameValuePairs));
 
            // 6. Set some headers to inform server about the type of the content   
            httpPut.setHeader("Content-type", "application/json");
            
            // 7. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPut);
 
            // 8. receive response as inputStream
            int value = (int)httpResponse.getStatusLine().getStatusCode();
            Log.e("code", Integer.toString(value));
            return value;
            
  		  
  	  } catch (Exception e) {
  	    Log.e("[PUT REQUEST]", "Network exception", e);
  	  }
	return 0;
	}
	
	public int Login(String url, String login, String mdp){
    	byte[] data = null;
    	try {
            data = mdp.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e1) {
        e1.printStackTrace();
        }
    	String base64 = Base64.encodeToString(data, Base64.DEFAULT);
		// Create a new HttpClient and Post Header
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost(url);

	    try {
	    	ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	        nameValuePairs.add(new BasicNameValuePair("login", login)); 
	        nameValuePairs.add(new BasicNameValuePair("password", base64)); 

	        // Add your data
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

	        // Execute HTTP Post Request
	        HttpResponse response = httpclient.execute(httppost);
	        int value = (int)response.getStatusLine().getStatusCode();
	        Log.e("code", Integer.toString(value));
	        return value;
	        
	    } catch (ClientProtocolException e) {
	        // TODO Auto-generated catch block
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	    }
	    return 0;
	}

}
