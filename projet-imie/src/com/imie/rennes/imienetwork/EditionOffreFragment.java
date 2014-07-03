package com.imie.rennes.imienetwork;

import java.util.Calendar;

import com.imie.rennes.mainActivity.MainActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class EditionOffreFragment extends Fragment {
	
	EditText datepicker;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View frag = inflater.inflate(R.layout.fragment_editer_offre,container, false);
		
		datepicker = (EditText)frag.findViewById(R.id.datepickerdatedebut);
		
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
	                    EditionOffreFragment.this.datepicker.setText(date);
	                }
	            },mYear, mMonth, mDay);
	            mDatePicker.setTitle("Select date");                
	            mDatePicker.show();  }
	    });
		
		return frag;
	}
	
}
