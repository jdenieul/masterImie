package com.imie.rennes.imienetwork;

import java.util.Calendar;
import java.util.Date;
import network.ReseauOffre;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import com.imie.rennes.classes.Offre;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

public class DeposerOffreFragment extends Fragment {
	
	Button buttonEnvoyer;
	Button buttonAnnuler;
	EditText datepicker, datepickerfin ,editTexttitre, datepickerdatedebut, edittextdetailcontact, edittextemailcontact, edittextdescription;
	Spinner spinnertypedecontrat;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View frag = inflater.inflate(R.layout.fragment_deposer_offre,container, false);
		
		buttonEnvoyer = (Button)frag.findViewById(R.id.buttonEnvoyer);
		datepicker = (EditText)frag.findViewById(R.id.datepickerdatedebut);
		datepickerfin = (EditText)frag.findViewById(R.id.datepickerdatefin);
		editTexttitre = (EditText)frag.findViewById(R.id.editTexttitre);
		datepickerdatedebut = (EditText)frag.findViewById(R.id.datepickerdatedebut);
		edittextdetailcontact = (EditText)frag.findViewById(R.id.edittextdetailcontact);
		edittextemailcontact = (EditText)frag.findViewById(R.id.edittextemailcontact);
		edittextdescription = (EditText)frag.findViewById(R.id.edittextdescription);
		spinnertypedecontrat = (Spinner)frag.findViewById(R.id.spinnertypedecontrat);
		
		datepicker.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
	            // TODO Auto-generated method stub
	            //To show current date in the datepicker
	            Calendar mcurrentDate=Calendar.getInstance();
	            int mYear = mcurrentDate.get(Calendar.YEAR);
	            int mMonth = mcurrentDate.get(Calendar.MONTH);
	            int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

	            DatePickerDialog mDatePicker=new DatePickerDialog(getActivity(), new OnDateSetListener() {                  
	                public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
	                    // TODO Auto-generated method stub     
	                	String date = String.valueOf(String.valueOf(selectedday) + '/' + String.valueOf(selectedmonth) + '/' + String.valueOf(selectedyear));
	                    DeposerOffreFragment.this.datepicker.setText(date);
	                }
	            },mYear, mMonth, mDay);
	            mDatePicker.setTitle("Selectionner une date");                
	            mDatePicker.show();  }
	    });
		
		datepickerfin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
	            // TODO Auto-generated method stub
	            //To show current date in the datepicker
	            Calendar mcurrentDate=Calendar.getInstance();
	            int mYear = mcurrentDate.get(Calendar.YEAR);
	            int mMonth = mcurrentDate.get(Calendar.MONTH);
	            int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

	            DatePickerDialog mDatePicker=new DatePickerDialog(getActivity(), new OnDateSetListener() {                  
	                public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
	                    // TODO Auto-generated method stub     
	                	String date = String.valueOf(String.valueOf(selectedday) + '/' + String.valueOf(selectedmonth) + '/' + String.valueOf(selectedyear));
	                    DeposerOffreFragment.this.datepickerfin.setText(date);
	                }
	            },mYear, mMonth, mDay);
	            mDatePicker.setTitle("Selectionner une date");                
	            mDatePicker.show();  }
	    });
		
		buttonEnvoyer.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				CreationOffre();
			}
		});
				
		return frag;
	}
	
	public void CreationOffre(){
		Offre offre = new Offre();
		offre.setId(1);
		offre.setTitre(editTexttitre.getText().toString());
		offre.setDescription(edittextdescription.getText().toString());
		offre.setDetailsContact(edittextdetailcontact.getText().toString());
		offre.setEmailContact(edittextemailcontact.getText().toString());
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy").withOffsetParsed();
		DateTime dateTime = formatter.parseDateTime(datepicker.getText().toString());
		Date cal = dateTime.toDate();
		offre.setDateDebut(cal);
		DateTime dateTimefin = formatter.parseDateTime(datepickerfin.getText().toString());
		Date calfin = dateTimefin.toDate();
		offre.setDateFin(calfin);
		offre.setTypePoste(spinnertypedecontrat.getSelectedItem().toString());
		ReseauOffre r = new ReseauOffre(getActivity());
    	r.execute("1", offre);
	}

	

}
