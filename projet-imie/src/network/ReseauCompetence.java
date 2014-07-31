package network;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.imie.rennes.classes.ArrayListCompetence;
import com.imie.rennes.classes.ArrayListCompetenceUtilisateur;
import com.imie.rennes.classes.Competence;
import com.imie.rennes.classes.ItemRow;
import com.imie.rennes.classes.Utilisateur;
import com.imie.rennes.classes.UtilisateurCompetence;
import com.imie.rennes.imienetwork.MessagerieFragment;
import com.imie.rennes.imienetwork.ProfilFragment;
import com.imie.rennes.imienetwork.R;
import com.imie.rennes.mainActivity.MainActivity;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources.NotFoundException;
import android.os.AsyncTask;
import android.util.Log;

public class ReseauCompetence extends AsyncTask<Object,Void,Integer>{
	
	Context context;
	Integer param;
	ProgressDialog progDailog;
	SharedPreferences preferences;
	ProfilFragment fragmentParent;
	
	public ReseauCompetence(Context context,ProfilFragment f){
		this.context = context;
		this.progDailog = new ProgressDialog(context);
		this.fragmentParent = f;
	}


	@Override
	protected Integer doInBackground(Object... params) {
		int result = 0;
		param = Integer.parseInt((String)params[0]);
		switch (param){
		
		//Creation competence
			case 1:
				
				result = addCompetenceToUser((Competence)params[1],(Float) params[2]);
				break;
			case 2:
				result = listeCompetenceOfUser();
				break;
			case 3:			
				
				result = listeCompetences();				
				break;
			default:
				break;
		}
		
		//String string = IOUtils.toString(getInputStreamFromUrl(params[0]));
		return result;
	}
	
	@Override
	protected void onPostExecute(Integer result) {
		//Creation Competence
		if((param == 1  && result == 200) || (param == 1 && result == 201)){
			/*Intent monIntent = new Intent(context, ProfilFragment.class);
			this.context.startActivity(monIntent);*/

			ProfilFragment fragment = new ProfilFragment();
			((MainActivity) this.fragmentParent.getActivity()).changeFragment(fragment);
		}
		
		if((param == 2  && result == 200) || (param == 2 && result == 201)){
			
			// Remplie la liste de compétences de l'utilisateur
			for (UtilisateurCompetence compet : this.fragmentParent.getListeCompetencesUtilisateur().getCompetences()) {
				
				this.fragmentParent.getItemCompetence().add(new ItemRow(compet.getCompetence().getId(),compet.getCompetence().getLibelle() ,"Niveau : " + compet.getNote(),"" ));
				
			}
			
			this.fragmentParent.getCompetenceAdapter().notifyDataSetChanged();
			
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
	
	//Creation d'une competence
	public int addCompetenceToUser(Competence competence,float niveauCompetence){
		
		try {
			
			// Récupération de l'utilisateur connecté
			preferences = this.context.getSharedPreferences("DEFAULT",
					Activity.MODE_PRIVATE);
	  		
			// Récupération de l'utilisateur
			Utilisateur currentUser = new Utilisateur();
			Gson gson = new Gson();
			if(preferences.contains("CURRENT_USER")){
				String jsonCurrentUser = preferences.getString("CURRENT_USER", "");
				currentUser = gson.fromJson(jsonCurrentUser, Utilisateur.class);
			}else{
				//TODO retour login ?
			}

			
	  		String url = this.context.getResources().getString(R.string.url_base_api) + 
	  				this.context.getResources().getString(R.string.url_utilisateur) + currentUser.getId() + "/" +
	  				this.context.getResources().getString(R.string.url_competence) +  competence.getId() + ".json";
	  		
            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
 
            // 2. make POST request to the given URL
            HttpPut httpPut = new HttpPut(url);
 
            // 3. build jsonObject	                 
            JSONObject jsonObject = new JSONObject();                       
            jsonObject.put("token", preferences.getString("TOKEN_USER", ""));
            jsonObject.put("note", niveauCompetence);
            
            
            // 4. convert JSONObject to JSON to String
            String json = jsonObject.toString();
            Log.e("json", json);
 
            // 5. set httpPost Entity
            httpPut.setEntity(new StringEntity(json));
 
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
	
	public int listeCompetences(){
		 	
		preferences = this.context.getSharedPreferences("DEFAULT",
				Activity.MODE_PRIVATE);
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet request = new HttpGet();
        URI webService;
        int value = 0;
		try {
			
			webService = new URI(this.context.getResources().getString(R.string.text_adresse_api_webservice) + "competences.json?token="+preferences.getString("TOKEN_USER", ""));
	        request.setURI(webService);
            
	        HttpResponse response = httpclient.execute(request);
	        value = (int)response.getStatusLine().getStatusCode();
	        
	        // Si le résultat est OK
	        if (value == 200){
	        	
		        JSONObject jsonListeCompetences = new JSONObject(EntityUtils.toString(response.getEntity()));
				Gson gson = new Gson();	
				ArrayListCompetence arrListCompetenceTemp = new ArrayListCompetence();
				arrListCompetenceTemp = gson.fromJson(jsonListeCompetences.toString(), ArrayListCompetence.class);				
				
				this.fragmentParent.setListeCompetences(arrListCompetenceTemp);
		        			
		        Log.e("code", Integer.toString(value));
		        
	        }

		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
				
		return value;
	}

	
	public int listeCompetenceOfUser(){
		
		preferences = this.context.getSharedPreferences("DEFAULT",
				Activity.MODE_PRIVATE);
		
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet request = new HttpGet();
        URI webService;
        int value = 0;
        Gson gson = new Gson();
		try {			
	  		
			// Récupération de l'utilisateur
			Utilisateur currentUser = new Utilisateur();
			
			if(preferences.contains("CURRENT_USER")){
				String jsonCurrentUser = preferences.getString("CURRENT_USER", "");
				currentUser = gson.fromJson(jsonCurrentUser, Utilisateur.class);
			}else{
				//TODO retour login ?
			}
			
			webService = new URI(this.context.getResources().getString(R.string.url_base_api) +
					 			this.context.getResources().getString(R.string.url_utilisateur) + currentUser.getId() + 
					 			"/competences.json?token="+preferences.getString("TOKEN_USER", ""));
	        request.setURI(webService);
            
	        HttpResponse response = httpclient.execute(request);
	        value = (int)response.getStatusLine().getStatusCode();
	        
	        // Si le résultat est OK
	        if (value == 200){
	        	
		        JSONObject jsonListeCompetences = new JSONObject(EntityUtils.toString(response.getEntity()));
		        // Récupère l'objet json et le parse en liste de compétences d'utilisateur
		        ArrayListCompetenceUtilisateur arrListCompetenceTemp = new ArrayListCompetenceUtilisateur();
				arrListCompetenceTemp = gson.fromJson(jsonListeCompetences.toString(), ArrayListCompetenceUtilisateur.class);				
				
				this.fragmentParent.setListeCompetencesUtilisateur(arrListCompetenceTemp);				
		        			
		        Log.e("code", Integer.toString(value));
		        
	        }

		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
		
		return value;
	}
	
}
