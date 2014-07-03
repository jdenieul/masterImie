package com.imie.rennes.imienetwork;

import java.util.ArrayList;
import java.util.List;

import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;
import com.imie.rennes.adapteur.ItemAdapterDashboard;
import com.imie.rennes.classes.ItemRow;
import com.imie.rennes.mainActivity.MainActivity;
import com.jensdriller.libs.undobar.UndoBar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DashboardFragment extends Fragment{

	//Boutons
	Button buttonOffres;
	Button buttonMessages;
	Button buttonProfil;
	TextView nombreMessage;
	
	//SwypeListView
	static SwipeListView listViewEvenements;
	List<ItemRow> itemData;
	ItemAdapterDashboard adapter;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View frag = inflater.inflate(R.layout.fragment_dashboard,container, false);
		
		//Récupération id
		buttonMessages = (Button)frag.findViewById(R.id.btnMessage);
		buttonOffres = (Button)frag.findViewById(R.id.btnOffres);
		buttonProfil = (Button)frag.findViewById(R.id.btnCompteProfil);
		listViewEvenements = (SwipeListView)frag.findViewById(R.id.listViewEvenement);
		nombreMessage = (TextView)frag.findViewById(R.id.tvNombreMessages);
		
		/**
		 * Gestion évnéments
		 */
		buttonMessages.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				Fragment fragment = new MessagerieFragment();
				((MainActivity) getActivity()).changeFragment(fragment);
			}
		});
		
		buttonOffres.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				Fragment fragment = new OffreFragment();
				((MainActivity) getActivity()).changeFragment(fragment);
			}
		});
		
		buttonProfil.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				Fragment fragment = new ProfilFragment();
				((MainActivity) getActivity()).changeFragment(fragment);
			}
		});
		/**
		 * Fin gestion événmenent
		 */
		
		/**
		 * Gestion badge nombre message
		 * Si = 0 : visibility GONE
		 * Si < 0 : modification padding pour garder cercle( 15 left, right, 5 top, bottom)
		 * si < 0 : padding normal
		 */
		//TODO R2cupération nb message en bdd
		int nbMessage = 7;
		
		nombreMessage.setText(String.valueOf(nbMessage));
		
		if(nbMessage == 0){
			nombreMessage.setVisibility(View.GONE);
		}else if (nbMessage < 10){
			nombreMessage.setPadding(15, 5, 15, 5);
		}
        
		itemData=new ArrayList<ItemRow>();
		
		adapter=new ItemAdapterDashboard(getActivity(),R.layout.custom_event_row,itemData);
		
		listViewEvenements.setSwipeListViewListener(new BaseSwipeListViewListener() {
            public void onOpened(int position, boolean toRight) {
            }

            public void onClosed(int position, boolean fromRight) {
            }

            public void onListChanged() {
            }

            public void onMove(int position, float x) {
            }

            public void onStartOpen(int position, int action, boolean right) {
                Log.d("swipe", String.format("onStartOpen %d - action %d", position, action));
            }

            public void onStartClose(int position, boolean right) {
                Log.d("swipe", String.format("onStartClose %d", position));
            }

            public void onClickFrontView(int position) {
            	super.onClickFrontView(position);
		         Fragment fragment = new EvenementEnqueteFragment();
				((MainActivity) getActivity()).changeFragment(fragment);
            }

            public void onClickBackView(int position) {
                Log.d("swipe", String.format("onClickBackView %d", position));
                
                listViewEvenements.closeAnimate(position);//when you touch back view it will close
            }

            public void onDismiss(int[] reverseSortedPositions) {
            	new UndoBar.Builder(getActivity())
            	  .setMessage(R.string.text_supp_Offre)
            	  .setListener(adapter)
            	  .show();
            }

        });
        
        //These are the swipe listview settings. you can change these
        //setting as your requirement 
		listViewEvenements.setSwipeMode(SwipeListView.SWIPE_MODE_BOTH); // there are five swiping modes
		listViewEvenements.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_REVEAL); //there are four swipe actions
		listViewEvenements.setSwipeActionRight(SwipeListView.SWIPE_ACTION_REVEAL);
		listViewEvenements.setOffsetLeft(convertDpToPixel(0f)); // left side offset
		listViewEvenements.setOffsetRight(convertDpToPixel(0f)); // right side offset
		listViewEvenements.setAnimationTime(500); // Animation time
		listViewEvenements.setSwipeOpenOnLongPress(false); // enable or disable SwipeOpenOnLongPress
	
		listViewEvenements.setAdapter(adapter);
        
        //TODO Récupération event bdd
        for(int i=0;i<3;i++)
        {
        	itemData.add(new ItemRow(getString(R.string.text_exemple_descri_event)+i, 
        			getString(R.string.text_exemple_addresse_event), getString(R.string.text_exemple_date_event) ));
        	
        }
        
        adapter.notifyDataSetChanged();
		
		return frag;
	}
	
	public int convertDpToPixel(float dp) {
	    DisplayMetrics metrics = getResources().getDisplayMetrics();
	    float px = dp * (metrics.densityDpi / 160f);
	    return (int) px;
	}
	
}
