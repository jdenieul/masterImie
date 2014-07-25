package network;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.imie.rennes.classes.Competence;
import com.imie.rennes.classes.Utilisateur;
import com.imie.rennes.imienetwork.AccueilEleveFragment;
import com.imie.rennes.imienetwork.R;

import android.app.Activity;
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
	
	public ReseauCompetence(Context context){
		this.context = context;
		this.progDailog = new ProgressDialog(context);
	}


	@Override
	protected Integer doInBackground(Object... params) {
		int result = 0;
		param = Integer.parseInt((String)params[0]);
		switch (param){
		//Creation competence
			case 1:
				
				result = CreateCompetence((Competence)params[0]);
				break;
			case 2:
				
				break;
			case 3:				
				result = listeCompetences((ArrayList<Competence>)params[1]);
				 
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
	
	//Creation d'une competence
	public int CreateCompetence(Competence competence){
		try {
			
			// R�cup�ration de l'utilisateur connect�
			preferences = this.context.getSharedPreferences("DEFAULT",
					Activity.MODE_PRIVATE);
			
	  		String url = this.context.getResources().getString(R.string.text_adresse_api_webservice) + "competence/";
	  		  
            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
 
            // 2. make POST request to the given URL
            HttpPut httpPut = new HttpPut(url);
 
            // 3. build jsonObject	                 
            JSONObject jsonObject = new JSONObject();                       
            jsonObject.put("token", preferences.getString("TOKEN_USER", ""));
            jsonObject.put("competence", competence);
            
            
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
	
	public int listeCompetences(ArrayList<Competence> listCompetences){
		
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
				listCompetences = gson.fromJson(jsonListeCompetences.getString("competences"), ArrayList.class);
		        			
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
		
		//return listCompetences;
		return value;
	}

}
