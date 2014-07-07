package com.imie.rennes.mainActivity;


import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.imie.rennes.classes.Reseau;
import com.imie.rennes.classes.Utilisateur;
import com.imie.rennes.imienetwork.R;

public class LoginActivity extends ActionBarActivity {

	Button boutonConnexion;
	EditText nom, mdp;
	private static long backPressed;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        if (metrics.heightPixels < 800) {
        	setContentView(R.layout.activity_login_low_res);
		}
        else
        {
        	setContentView(R.layout.activity_login);
        }
        Drawable background = this.getResources().getDrawable(R.drawable.background_popup);
        getSupportActionBar().setBackgroundDrawable(background);
        getSupportActionBar().setTitle(R.string.titre_login);
        

        boutonConnexion = (Button) this.findViewById(R.id.buttonConnexion);
		nom = (EditText) this.findViewById(R.id.editTextLogin);
		mdp = (EditText) this.findViewById(R.id.editTextMdp);
		
		boutonConnexion.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				validConnexion();
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
    
    @Override
    public void onBackPressed() {
    	if (backPressed + 2000 > System.currentTimeMillis()){
			Intent homeIntent = new Intent(Intent.ACTION_MAIN);
			homeIntent.addCategory( Intent.CATEGORY_HOME );
			homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(homeIntent);			
		}
    	else Toast.makeText(getBaseContext(), "Appuyez de nouveau pour quitter!", Toast.LENGTH_SHORT).show();
        backPressed = System.currentTimeMillis();
    }
    
    public void validConnexion(){
    	
    	Utilisateur utilisateur = new Utilisateur(this);    	
    	
    	// Stock l'utilisateur dans le cache
		SharedPreferences preferences = LoginActivity.this.getSharedPreferences("DEFAULT", Activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();
		editor.putString("CURRENT_USER", utilisateur.getSerializableString());
		editor.commit();
		adduUser();
		Intent monIntent = new Intent(LoginActivity.this, MainActivity.class);
		startActivity(monIntent);
    }
    
    public boolean verifUserMdp(Utilisateur utilsiateur){
    	String url = "http://imierennes.no-ip.biz:10080/imie-network-website/web/app_dev.php/api/utilisateur/2";    	
    	//Reseau.putInputStreamUrl(url);        	
    	return true;
    }    
    
    public boolean adduUser(){
    	String url = "http://imierennes.no-ip.biz:10080/imie-network-website/web/app_dev.php/api/utilisateur/5.json";
    	Reseau r = new Reseau();
    	r.execute("1",url);
    	//Reseau.putInputStreamUrl(url);        	
    	return true;
    }
    
}
