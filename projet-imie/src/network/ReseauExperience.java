package network;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import com.imie.rennes.classes.Competence;
import com.imie.rennes.classes.Experience;
import com.imie.rennes.imienetwork.AccueilEleveFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public class ReseauExperience extends AsyncTask<Object,Void,Integer>{
	Context context;
	Integer param;
	ProgressDialog progDailog;
	
	public ReseauExperience(Context context){
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
			result = createExperience((Experience)params[1]);
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
	public int createExperience(Experience	experience){
		try {
	  		String url = "http://imierennes.no-ip.biz:10080/imie-network-website/web/app_dev.php/api/experience/"+experience.getId()+".json";
	  		  
            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
 
            // 2. make POST request to the given URL
            HttpPut httpPut = new HttpPut(url);
            // Date début & date de fin
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date dateDebut = new Date(experience.getDateDebut().getTimeInMillis());
            String sDateDebut = formatter.format(dateDebut);
            Date dateFin = new Date(experience.getDateFin().getTimeInMillis());
            String sDateFin = formatter.format(dateFin);
            // 3. build jsonObject	                 
           
            JSONObject jsonObjectUser = new JSONObject();
            jsonObjectUser.put("utilisateur", experience.getUtilisateurCreateur());
            
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("libelle", experience.getLibelle());            
            jsonObject.put("description", experience.getDescription());
            jsonObject.put("dateDebut", sDateDebut);
            jsonObject.put("dateFin", sDateFin);
            jsonObject.put("utilisateur", jsonObjectUser);
            
            
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

}
