package com.imie.rennes.imienetwork;

import java.util.ArrayList;

import network.ReseauCompetence;
import network.ReseauUser;

import com.imie.rennes.classes.Competence;
import com.imie.rennes.mainActivity.MainActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class CompetenceEleveFragment extends Fragment {	

	private Spinner spinnerCompetences;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View frag = inflater.inflate(R.layout.fragment_ajout_competence_eleve,container, false);
		// Récupération des objets de la View
		spinnerCompetences = (Spinner)frag.findViewById(R.id.spinnerListeCompetences);
		// Appel des compétences
		recupCompetences();
		//ArrayAdapter<String> a = new ArrayAdapter<String>(ObservationSubmit.this,android.R.layout.simple_spinner_item, choices);
		//a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//spinnerCompetences.setAdapter(a); 
		
		return frag;
		
	}
	
    public boolean recupCompetences(){
    	    	    
    	ReseauCompetence r = new ReseauCompetence(this.getActivity());
    	ArrayList<Competence> listeCompetences = new ArrayList<Competence>();
    	r.execute("3",listeCompetences);   
    	
    	return true;
    }   
	


}
