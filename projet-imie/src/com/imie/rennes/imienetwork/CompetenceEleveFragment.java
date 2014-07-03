package com.imie.rennes.imienetwork;

import com.imie.rennes.mainActivity.MainActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CompetenceEleveFragment extends Fragment {
	
	Button buttonEnvoyer;
	Button buttonAnnuler;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View frag = inflater.inflate(R.layout.fragment_competence,container, false);
		
		buttonEnvoyer = (Button)frag.findViewById(R.id.buttonEnvoyer);
		buttonAnnuler = (Button)frag.findViewById(R.id.buttonAnnuler);
		
		buttonEnvoyer.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				Fragment fragment = new AccueilEleveFragment();
				((MainActivity) getActivity()).changeFragment(fragment);
			}
		});
		
		buttonEnvoyer.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				Fragment fragment = new AccueilEleveFragment();
				((MainActivity) getActivity()).changeFragment(fragment);
			}
		});
		
		return frag;
	}

}
