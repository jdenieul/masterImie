package network;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.imie.rennes.classes.Utilisateur;
import com.imie.rennes.mainActivity.MainActivity;

import android.R.string;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

public class ReseauUser extends AsyncTask<Object,Void,Integer>{
	Context context;
	Integer param;
	ProgressDialog progDailog;
	private SharedPreferences preferences;
	private SharedPreferences.Editor editor;
	
	public ReseauUser(Context context){
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
				result = CreateUser((Utilisateur)params[1]);
				break;
			//Login
			case 2:
				result = Login((String)params[1], (String)params[2], (String)params[3]);
				break;
			//Modification mot de passe
			case 3:
				
			default:
				break;
		}
		return result;
	}
	
	@Override
	protected void onPostExecute(Integer result) {
		//En cas d'utilisateur creer ou mise � jour
		if((param == 1  && result == 200) || (param == 1 && result == 201)){
			Intent monIntent = new Intent(context, MainActivity.class);
			context.startActivity(monIntent);
		}
		//Login
		if(param == 2  && result == 200){
			Intent monIntent = new Intent(context, MainActivity.class);
			context.startActivity(monIntent);
		}
		if((param == 2 && result == 204) || (param == 2 && result == 226)){
			Toast.makeText(context, "Erreur dans le login ou le mot de passe", Toast.LENGTH_SHORT).show();
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
	
	
	
	//Creation of a User
	public int CreateUser(Utilisateur utilisateur) {
		
		  String url = "http://imierennes.no-ip.biz:10080/imie-network-website/web/app_dev.php/api/utilisateur/"+utilisateur.getId()+".json";
		
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
		        String token = "c8cce43de370cf5bcd6b5a86f3acc71a7366c9afde842ea8d441a1828ad6b88a";
		        nameValuePairs.add(new BasicNameValuePair("token", token)); 
		        
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
	
	//Login
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
	        nameValuePairs.add(new BasicNameValuePair("password", base64.substring(0,base64.length()-1))); 

	        // Add your data
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

	        // Execute HTTP Post Request
	        HttpResponse response = httpclient.execute(httppost);
	        int value = (int)response.getStatusLine().getStatusCode();
	        
	        // Si le code = 200 alors tout est OK
	        if (value == 200){
	        	
		        // Récupère le token renvoyé par l'api
		        JSONObject jsonPref = new JSONObject(EntityUtils.toString(response.getEntity()));	        	 
		        addTokenToPref(jsonPref);
		        createUserFromJson(jsonPref);
		        Log.e("code", Integer.toString(value));
		        
	        }

	        return value;
	        
	    } catch (ClientProtocolException e) {
	        // TODO Auto-generated catch block
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	    } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return 0;
	}
	
	//Modification du mot de passe
	public int editPassword(String url, String oldPassword, String newPassword, int idUser, String token){
		
		
		
		return 0;
	}
	
	private void addTokenToPref(JSONObject json){
    	
    	this.preferences = this.context.getSharedPreferences("DEFAULT", Activity.MODE_PRIVATE);
		this.editor = preferences.edit();
		try {
			editor.putString("TOKEN_USER", json.getString("token"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		editor.commit();		
	}	
	
	/*
	 * Retourne le message selon le code de retour
	 */
	private String verifCode(int valueRetour){
		
		String messageRetour = "";
		
		switch (valueRetour) {
		
		case 200:
			messageRetour = "Connexion effectuée.";
			break;		
		
		case 204:
			messageRetour = "Le login ou le mot de passe est incorrect.";
			break;
			
		case 226:
			messageRetour = "Le login ou le mot de passe est manquant.";
			break;			

		default:			
			break;
		}
		
		return messageRetour;
		
	}

	/**
	 * Enregistre le json du current_user dans les pr�f�rences
	 * @param json
	 */
	private void createUserFromJson(JSONObject json){
		
		try {
			Gson gson = new Gson();
			editor.putString("CURRENT_USER", json.getString("utilisateur"));
			editor.commit();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
