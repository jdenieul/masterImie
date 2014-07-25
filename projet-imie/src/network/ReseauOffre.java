package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.imie.rennes.classes.Offre;
import com.imie.rennes.imienetwork.OffreFragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

public class ReseauOffre extends AsyncTask<Object,Void,Integer>{
	Context context;
	Integer param;
	ProgressDialog progDailog;
	SharedPreferences preferences;
	
	public ReseauOffre(Context context){
		this.context = context;
		this.progDailog = new ProgressDialog(context);
		this.preferences = context.getSharedPreferences("DEFAULT",Activity.MODE_PRIVATE);
	}


	@Override
	protected Integer doInBackground(Object... params) {
		int result = 0;
		param = Integer.parseInt((String)params[0]);
		switch (param){
			//Creation offre
			case 1:
				result = CreateOffre((Offre)params[1]);
				break;
			case 2:
				result = RecupOffre();
			//Suppression Offre
			case 3:
				result = DeleteOffre((String)params[1]);
				break;
			default:
				break;
		}
		//String string = IOUtils.toString(getInputStreamFromUrl(params[0]));
		return result;
	}
	
	@Override
	protected void onPostExecute(Integer result) {
		//Creation Offre
		if((param == 1  && result == 200) || (param == 1 && result == 201)){
			Intent monIntent = new Intent(context, OffreFragment.class);
			context.startActivity(monIntent);
		}
		if((param == 2  && result == 200) || (param == 2 && result == 201)){
			
		}
		//Suppression Offre
		if((param == 3  && result == 200) || (param == 3 && result == 201)){
			Intent monIntent = new Intent(context, OffreFragment.class);
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
	
	//Creation dune offre
	public int CreateOffre(Offre offre){
		try {
	  		String url = "http://imierennes.no-ip.biz:10080/imie-network-website/web/app_dev.php/api/offre/"+offre.getId()+".json";
	  		  
            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
 
            // 2. make POST request to the given URL
            HttpPut httpPut = new HttpPut(url);
 
            // 3. build jsonObject	                 
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("titre", offre.getTitre());
            jsonObject.put("description", offre.getDescription());
            jsonObject.put("details_contact", offre.getDetailsContact());
            //jsonObject.put("duree", offre.getDuree());
            jsonObject.put("type_poste", offre.getTypePoste());
            jsonObject.put("email_contact", offre.getEmailContact());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = offre.getDateDebut();
            String Date = formatter.format(date);
            jsonObject.put("dateDebut", Date);
            jsonObject.put("typePoste", offre.getTypePoste());
            Date dateFin = offre.getDateFin();
            String DateFin = formatter.format(dateFin);
            jsonObject.put("dateFin", DateFin);
            String currentUser = preferences.getString("CURRENT_USER", "");
            jsonObject.put("createur", currentUser);
            String token = preferences.getString("TOKEN_USER", "");
            
            
            // 4. convert JSONObject to JSON to String
            String json = jsonObject.toString();
            Log.e("json", json);
            
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	        nameValuePairs.add(new BasicNameValuePair("object", json)); 
	        nameValuePairs.add(new BasicNameValuePair("token", token)); 
	        nameValuePairs.add(new BasicNameValuePair("offre_id", Integer.toString(offre.getId()))); 
 
            // 5. set httpPost Entity
            httpPut.setEntity(new UrlEncodedFormEntity(nameValuePairs));
 
            // 6. Set some headers to inform server about the type of the content   
            //httpPut.setHeader("Content-type", "application/json");
            
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
	
	public int RecupOffre(){
		int status = 0;
		String url = "http://imierennes.no-ip.biz:10080/imie-network-website/web/app_dev.php/api/offres.json?token=" + preferences.getString("TOKEN_USER", "");
		// Create a new HttpClient and Post Header
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpGet httpget = new HttpGet(url);

	    try {
	        // Execute HTTP Post Request
	        HttpResponse response = httpclient.execute(httpget);
	        int value = (int)response.getStatusLine().getStatusCode();
	        
	        // Si le code = 200 alors tout est OK
	        if (value == 200){
	        	HttpEntity httpentity = response.getEntity();
	        	InputStream instream = httpentity.getContent();
	        	String result = instream.toString();
	        	JSONObject json = new JSONObject(result);
	        	String offres = json.getString("offres");
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
		return status;
	}
	
	public int DeleteOffre(String id){
		int status = 0;
		URL url;
		try {
			url = new URL("http://imierennes.no-ip.biz:10080/imie-network-website/web/app_dev.php/api/offre/"+id+".json");
			HttpURLConnection httpCon;
			httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpCon.setRequestMethod("DELETE");
			httpCon.connect();
			status = ((HttpURLConnection) httpCon).getResponseCode();
		} 
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return status;
		
	}

}
