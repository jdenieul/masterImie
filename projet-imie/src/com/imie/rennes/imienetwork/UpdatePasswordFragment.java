package com.imie.rennes.imienetwork;

import network.ReseauUser;

import com.google.gson.Gson;
import com.imie.rennes.classes.Utilisateur;
import com.imie.rennes.mainActivity.MainActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdatePasswordFragment extends Fragment {
	
	EditText newMDP;
	EditText newAgainMDP;
	EditText oldMDP;
	Button buttonEnvoyer;
	Button buttonAnnuler;
	Button buttonSupprimer;
	
	private SharedPreferences preferences;
	Utilisateur currentUser;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View frag = inflater.inflate(R.layout.fragment_updatelogin,container, false);
		
		newMDP = (EditText)frag.findViewById(R.id.editTextNewMdp);
		newAgainMDP = (EditText)frag.findViewById(R.id.editTextNewAgainMdp);
		oldMDP = (EditText)frag.findViewById(R.id.editTextLastMdp);
		buttonEnvoyer = (Button)frag.findViewById(R.id.buttonEnvoyer);
		buttonAnnuler = (Button)frag.findViewById(R.id.buttonAnnuler);
		buttonSupprimer = (Button)frag.findViewById(R.id.buttonSupprimer);
		
		//Récupération des préférences
		this.preferences = this.getActivity().getSharedPreferences("DEFAULT", Activity.MODE_PRIVATE);
		
		//recup user
		currentUser = new Utilisateur();
		Gson gson = new Gson();
		if(preferences.contains("CURRENT_USER")){
			String jsonCurrentUser = preferences.getString("CURRENT_USER", "");
			currentUser = gson.fromJson(jsonCurrentUser, Utilisateur.class);
		}else{
			//TODO retour login ?
		}
		
		buttonEnvoyer.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				
				String oldPwdString = String.valueOf(oldMDP.getText());
				String newPwdString = String.valueOf(newMDP.getText());
				String secondNewMdp = String.valueOf(newAgainMDP.getText());
				
				//Verif champs non vides
				if(!newPwdString.equals("")){
					//Vérif concordance des 2 mots de passe
					if (newPwdString.equals(secondNewMdp)) {
						
						//Envoi webservice pour verif et modification
						validNewPassword(oldPwdString, newPwdString);
						
						//Retour accueil
						Fragment fragment = new DashboardFragment();
						((MainActivity) getActivity()).changeFragment(fragment);
						
					}else{
						Toast.makeText(getActivity(), R.string.text_toast_different_password,Toast.LENGTH_SHORT).show();
					}
				}else{
					Toast.makeText(getActivity(), R.string.text_toast_blank_password,Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		buttonAnnuler.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				Fragment fragment = new DashboardFragment();
				((MainActivity) getActivity()).changeFragment(fragment);
			}
		});
		
		buttonSupprimer.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				Fragment fragment = new DashboardFragment();
				((MainActivity) getActivity()).changeFragment(fragment);
			}
		});
		
		return frag;
	}
	
	/**
	 * Récupération des passwords et envoi modifications REseauUser qui gère enbackground
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	 public boolean validNewPassword(String oldPwd, String newPwd){
	    	
    	String url = getString(R.string.url_base_api);
    	ReseauUser r = new ReseauUser(this.getActivity());    	
    	r.execute("3",url, nom.getText().toString(), mdp.getText().toString());   
    	
    	return true;
	}   

}
