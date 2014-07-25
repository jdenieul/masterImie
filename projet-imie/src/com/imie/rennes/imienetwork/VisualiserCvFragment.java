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
import android.widget.TextView;
import android.widget.Toast;

public class VisualiserCvFragment extends Fragment {
		static TextView textPasPDF;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View frag = inflater.inflate(R.layout.fragment_visualiser_cv,container, false);
		
		File file = new File("/sdcard/example.pdf");
		 
        if (file.exists()) {
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
		
        }

		return frag;
	}
}
