package com.imie.rennes.imienetwork;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import com.imie.rennes.classes.Document;
import com.imie.rennes.classes.Message;
import com.imie.rennes.classes.TypeMessage;
import com.imie.rennes.classes.Utilisateur;
import com.imie.rennes.mainActivity.LoginActivity;
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
import android.widget.TextView;

public class EnvoiMessageFragment extends Fragment {
	
	Button buttonEnvoyer;
	Button buttonAnnuler;
	EditText editTextCorpsMessage;
	String corpsMessage ;
	SharedPreferences preferences;
	String userString;
	Utilisateur utilisateurCourant;
	Utilisateur recupEtudiant;
	TypeMessage typeMessage;
	Document cvEtudiant;
	ArrayList<Utilisateur> destinaraires;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View frag = inflater.inflate(R.layout.fragment_envoi_message,container, false);
				
		/*buttonEnvoyer = (Button)frag.findViewById(R.id.buttonSupprimerCompte);
		buttonAnnuler = (Button)frag.findViewById(R.id.buttonAnnuler);
		Bundle extra = EnvoiMessageFragment.this.getArguments();
		editTextCorpsMessage = (EditText)frag.findViewById(R.id.editTextMessage);
		ArrayList<Utilisateur> destinaraires = new ArrayList<Utilisateur>();
		// Récupère l'utilisateur courant
		preferences = getActivity().getSharedPreferences("DEFAULT", Activity.MODE_PRIVATE);
		userString = preferences.getString("CURRENT_USER", "");
		try {
			utilisateurCourant.setWithSerializableString(userString);
		} catch (Exception e) {			
			e.printStackTrace();
		}

		// Si le bundle est différent de null, c'est qu'une recherche a été
		// effectuée
		if (extra != null) {
			recupEtudiant = (Utilisateur) extra.getSerializable("etudiant");
			corpsMessage = "Profil partagé : " + recupEtudiant.getNom() + " " + recupEtudiant.getPrenom();
			editTextCorpsMessage.setText(corpsMessage);			
		}
		
		buttonEnvoyer.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				// Création du message
				// récupération du type de message
				if (recupEtudiant != null){
					typeMessage = new TypeMessage();
					typeMessage.setLibelle("Partage CV");
					cvEtudiant = new Document();
					cvEtudiant.setLibelle("CV  + " + recupEtudiant.getNom() + " " + recupEtudiant.getPrenom());
					cvEtudiant.setStatut(1);
					cvEtudiant.setUrl("");	
				}
				//destinaraires
			
				Message nouveauMessage = new Message();
				nouveauMessage.setContenu(corpsMessage);
				nouveauMessage.setDate(new GregorianCalendar());
				nouveauMessage.setTypeMessage(typeMessage);
				nouveauMessage.setEmetteur(utilisateurCourant);				
				Fragment fragment = new MessagerieFragment();
				((MainActivity) getActivity()).changeFragment(fragment);
			}
		});
		
		buttonAnnuler.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				Fragment fragment = new MessagerieFragment();
				((MainActivity) getActivity()).changeFragment(fragment);
			}
		});*/
		
		return frag;
	}

}
