package com.imie.rennes.imienetwork;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class RechercheFragment extends Fragment {
	
	static LayoutInflater inflater;
	private AutoCompleteTextView actv;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View frag = inflater.inflate(R.layout.fragment_recherche, container, false);
		
		String[] countries = {"FRANCE", "ITALIE", "USA"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,countries);
		
		actv = (AutoCompleteTextView) frag.findViewById(R.id.editTextRecherche);
		
		actv.setAdapter(adapter);
			
		return frag;
	}

}
