package network;

import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import com.imie.rennes.classes.Offre;
import com.imie.rennes.imienetwork.OffreFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public class ReseauOffre extends AsyncTask<Object,Void,Integer>{
	Context context;
	Integer param;
	ProgressDialog progDailog;
	
	public ReseauOffre(Context context){
		this.context = context;
		this.progDailog = new ProgressDialog(context);
	}


	@Override
	protected Integer doInBackground(Object... params) {
		int result = 0;
		param = Integer.parseInt((String)params[0]);
		switch (param){
			//Creation offre
			case 1:
				result = CreateOffre((Offre)params[0]);
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

}
