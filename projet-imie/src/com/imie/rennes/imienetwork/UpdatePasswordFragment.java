package com.imie.rennes.imienetwork;

import com.google.gson.Gson;
import com.imie.rennes.classes.Utilisateur;
import com.imie.rennes.mainActivity.MainActivity;

import android.app.Activity;
import android.content.Context;
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
		this.preferences = this.getActivity().getApplicationContext().getSharedPreferences("DEFAULT", Activity.MODE_PRIVATE);
		
		//recup user
		currentUser = new Utilisateur();
		Gson gson = new Gson();
		if(preferences.contains("CURRENT_USER")){
			currentUser = gson.fromJson(preferences.getString("CURRENT_USER", ""), Utilisateur.class);
		}else{
			//TODO retour login ?
		}
		
		
		String test = "";
		
		buttonEnvoyer.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				//Verif ancien mot de passe
				
				//Verif champs non vides
				if(!String.valueOf(newMDP.getText()).equals("")){
					//Vérif concordance des 2 mots de passe
					if (String.valueOf(newMDP.getText()).equals(String.valueOf(newAgainMDP.getText()))) {
						Fragment fragment = new AccueilEleveFragment();
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

}
