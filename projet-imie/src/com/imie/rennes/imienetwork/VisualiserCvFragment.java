package com.imie.rennes.imienetwork;

import java.io.File;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class VisualiserCvFragment extends Fragment {
		TextView textPasPDF;
		//Button boutonTelechargerCV;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View frag = inflater.inflate(R.layout.fragment_visualiser_cv,container, false);
		textPasPDF = (TextView)frag.findViewById(R.id.textPasPDF);
		//boutonTelechargerCV = (Button)frag.findViewById(R.id.boutonTelechargerCV);
		
		/**
		File file = new File("example.pdf");
		 
        if (file.exists()) {
        	/ **
            Uri path = Uri.fromFile(file);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(path, "application/pdf");
            //optionnel a toi de voir quel flag tu souhaites
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            try {
                startActivity(intent);
            	
            } 
            catch (ActivityNotFoundException e) {
            	textPasPDF.setText("Pas de viewer PDF disponible.");
            }
            ** /
        }
        else{
        	textPasPDF.setText("Pas de CV enregistré. Téléchargez-en un maintenant !");
        	//boutonTelechargerCV.setVisibility(0);
        }
        **/

    	textPasPDF.setText("Pas de CV enregistré. Téléchargez-en un maintenant !");
		return frag;
	}
}
