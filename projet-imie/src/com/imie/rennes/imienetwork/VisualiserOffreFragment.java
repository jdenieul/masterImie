package com.imie.rennes.imienetwork;

import java.util.Calendar;

import com.fortysevendeg.swipelistview.SwipeListView;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

public class VisualiserOffreFragment extends Fragment {
	
	EditText datepicker;
	

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View frag = inflater.inflate(R.layout.fragment_visualiser_offre,container, false);
		
		return frag;
	}
	
}
