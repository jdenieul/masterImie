package com.imie.rennes.imienetwork;

import com.imie.rennes.mainActivity.MainActivity;

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
	Button buttonEnvoyer;
	Button buttonAnnuler;
	Button buttonSupprimer;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View frag = inflater.inflate(R.layout.fragment_updatelogin,container, false);
		
		newMDP = (EditText)frag.findViewById(R.id.editTextNewMdp);
		newAgainMDP = (EditText)frag.findViewById(R.id.editTextNewAgainMdp);
		buttonEnvoyer = (Button)frag.findViewById(R.id.buttonEnvoyer);
		buttonAnnuler = (Button)frag.findViewById(R.id.buttonAnnuler);
		buttonSupprimer = (Button)frag.findViewById(R.id.buttonSupprimer);
		
		buttonEnvoyer.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				if (String.valueOf(newMDP.getText()).equals(String.valueOf(newAgainMDP.getText()))) {
					Fragment fragment = new AccueilEleveFragment();
					((MainActivity) getActivity()).changeFragment(fragment);
				}
				else
				{
					Toast.makeText(getActivity(), "Les mots de passe ne correspondent pas",Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		buttonAnnuler.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				Fragment fragment = new AccueilEleveFragment();
				((MainActivity) getActivity()).changeFragment(fragment);
			}
		});
		
		buttonSupprimer.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				Fragment fragment = new AccueilEleveFragment();
				((MainActivity) getActivity()).changeFragment(fragment);
			}
		});
		
		return frag;
	}

}
