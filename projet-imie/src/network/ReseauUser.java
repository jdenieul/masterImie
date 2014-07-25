package network;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.imie.rennes.imienetwork.R;
import com.imie.rennes.mainActivity.LoginActivity;
import com.imie.rennes.mainActivity.MainActivity;

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
		this.param = Integer.parseInt((String)params[0]);
		switch (this.param){
			//Vide
			case 1:
				break;
			//Login
			case 2:
				result = Login((String)params[1], (String)params[2], (String)params[3]);
				break;
			//Modification mot de passe
			case 3:
				result = editPassword((String)params[1], (String)params[2], (String)params[3], (String)params[4], (String)params[5]);
				break;
				
			default:
				break;
		}
		return result;
	}
	
	@Override
	protected void onPostExecute(Integer result) {
		
		//Récupération ressources pour affichage strings
		Resources r = context.getResources();
		
		//Vérification codes retour
		switch(this.param){
		//Retour Creation user
		case 1:
			if(result == 200 || result == 201){
				Intent monIntent = new Intent(context, MainActivity.class);
				context.startActivity(monIntent);
			}
			break;
		//Retour Login
		case 2:
			//Connexion ok
			if(result == 200 ){
				Intent monIntent = new Intent(context, MainActivity.class);
				context.startActivity(monIntent);
			}else if(result == 204 || result == 226){//Erreur login / mot de passe
				Toast.makeText(context, r.getString(R.string.text_toast_wrong_login_mdp), Toast.LENGTH_SHORT).show();
			}
			break;
		//Retour Modification mot de passe
		case 3:
			if(result == 200){//Edit ok
				Toast.makeText(context, r.getString(R.string.text_toast_edit_mdp), Toast.LENGTH_SHORT).show();
				Intent monIntent = new Intent(context, MainActivity.class);
				context.startActivity(monIntent);
			}else if(result == 206){//Ancien mot de passe éroné
				Toast.makeText(context, r.getString(R.string.text_toast_wrong_oldpwd), Toast.LENGTH_SHORT).show();
			}else if (result == 204 || result == 207){
				Toast.makeText(context, r.getString(R.string.text_toast_pb_connexion), Toast.LENGTH_SHORT).show();
				Intent monIntent = new Intent(context, LoginActivity.class);
				context.startActivity(monIntent);
			}
			break;
			
		default:
			break;
		}
		
		progDailog.dismiss();
	}
	
	@Override
    protected void onPreExecute() {
        super.onPreExecute();
        progDailog.setMessage(this.context.getResources().getString(R.string.text_toast_loading));
        progDailog.setIndeterminate(false);
        progDailog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progDailog.setCancelable(false);
        progDailog.show();
    }
	
	/**
	 * Connexion au webservice, récupération de l'user si connexion ok
	 * @param url
	 * @param login
	 * @param mdp
	 * @return valeur retour webservice
	 */
	
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
	        nameValuePairs.add(new BasicNameValuePair("password", base64)); 

	        // Add your data
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

	        // Execute HTTP Post Request
	        HttpResponse response = httpclient.execute(httppost);
	        int value = (int)response.getStatusLine().getStatusCode();
	        
	        // Si le code = 200 alors tout est OK
	        if (value == 200){
	        	
		        // RÃ©cupÃ¨re le token renvoyÃ© par l'api
		        JSONObject jsonPref = new JSONObject(EntityUtils.toString(response.getEntity()));	        	 
		        addTokenToPref(jsonPref);
		        addUserToPref(jsonPref);
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
	
	/**
	 * Modification du password de l'user. Avec nouveau et ancien mot de passe récupérés de la vue
	 * @param url
	 * @param oldPassword
	 * @param newPassword
	 * @param idUser
	 * @param token
	 * @return valeur retour webservice
	 */
	public int editPassword(String url, String oldPassword, String newPassword, String idUser, String token){
		
		byte[] oldPwdBytes=null;
		byte[] newPwdBytes=null;
		
		//gestion mot de passe en base64
    	try {
    		oldPwdBytes = oldPassword.getBytes("UTF-8");
    		newPwdBytes = newPassword.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e1) {
        e1.printStackTrace();
        }
    	
    	String oldPwd64 = Base64.encodeToString(oldPwdBytes, Base64.DEFAULT);
    	String newPwd64 = Base64.encodeToString(newPwdBytes, Base64.DEFAULT);
		
		try{
			Resources r = this.context.getResources();
			
			 // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
 
            // make PUT request to the given URL
            HttpPut httpPut = new HttpPut(url);
            
            //Récupération des paramètres
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	        nameValuePairs.add(new BasicNameValuePair(r.getString(R.string.gen_id_user), idUser)); 
	        nameValuePairs.add(new BasicNameValuePair(r.getString(R.string.gen_token), token)); 
	        nameValuePairs.add(new BasicNameValuePair(r.getString(R.string.edit_pwd_new_pwd), newPwd64.substring(0, newPwd64.length()-1))); 
	        nameValuePairs.add(new BasicNameValuePair(r.getString(R.string.edit_pwd_old_pwd), oldPwd64.substring(0,oldPwd64.length()-1))); 
	        
            //set httpPost Entity
            httpPut.setEntity(new UrlEncodedFormEntity(nameValuePairs));
  
            //Execute PUT request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPut);
            
            //receive response as inputStream
            int value = (int)httpResponse.getStatusLine().getStatusCode();
            
            Log.e("code", Integer.toString(value));
            return value;
			
		}catch(Exception e){
			Log.e("[PUT REQUEST] Editing password", "Network exception", e);
		}
		
		return 0;
	}
	
	/**
	 * Ajout du stirng token dans les préférences de l'application
	 * @param json
	 */
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
	
	/**
	 * Ajout du string json de l'user dans les préférences
	 * @param json
	 */
	private void addUserToPref(JSONObject json){
    	
		try {
			editor.putString("CURRENT_USER", json.getString("utilisateur"));
			editor.putInt("UNREAD_MSG", json.getInt("message_count"));
			editor.putString("LIST_EVENT", json.getString("evenements"));
			editor.commit();
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
			messageRetour = "Connexion effectuÃ©e.";
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
}
