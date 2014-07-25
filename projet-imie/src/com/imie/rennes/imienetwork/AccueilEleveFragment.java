package com.imie.rennes.imienetwork;

import java.util.ArrayList;
import java.util.List;

import network.UploadToServer;

import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;
import com.imie.rennes.adapteur.ItemAdapterCV;
import com.imie.rennes.adapteur.ItemAdapterCompetence;
import com.imie.rennes.mainActivity.MainActivity;
import com.imie.rennes.classes.CV;
import com.imie.rennes.classes.ItemRow;
import com.jensdriller.libs.undobar.UndoBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class AccueilEleveFragment extends Fragment {

	static SwipeListView listViewCv;
	static SwipeListView listViewCompetence;
	static List<ItemRow> itemDataComp;
	List<ItemRow> itemDataCV;
	static ItemAdapterCompetence adapterComp;
	ItemAdapterCV adapteurCv;
	ImageButton imageButtonAjouterCompetence;
	ImageButton imageButtonAjouterCV;
	static LayoutInflater inflater;
	static CV monCV;
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View frag = inflater.inflate(R.layout.fragment_accueil_eleve,container, false);
		
		listViewCv = (SwipeListView)frag.findViewById(R.id.listViewCv);
		listViewCompetence = (SwipeListView)frag.findViewById(R.id.listViewCompetence);
		imageButtonAjouterCompetence = (ImageButton)frag.findViewById(R.id.imageButtonAjouterCompetence);
		imageButtonAjouterCV = (ImageButton)frag.findViewById(R.id.imageButtonAjouterCv);
		
		/*************************************/
		/*   Slide list view of Competence   */
		/*************************************/
		
		itemDataComp=new ArrayList<ItemRow>();
		
		adapterComp=new ItemAdapterCompetence(getActivity(),R.layout.custom_row,itemDataComp);
		
		listViewCompetence.setSwipeListViewListener(new BaseSwipeListViewListener() {
			@Override
            public void onOpened(int position, boolean toRight) {
            }

			@Override
            public void onClosed(int position, boolean fromRight) {
            }

			@Override
            public void onListChanged() {
            }

			@Override
            public void onMove(int position, float x) {
            }

			@Override
            public void onStartOpen(int position, int action, boolean right) {
                Log.d("swipe", String.format("onStartOpen %d - action %d", position, action));
            }

			@Override
            public void onStartClose(int position, boolean right) {
                Log.d("swipe", String.format("onStartClose %d", position));
            }

			@Override
            public void onClickFrontView(int position) {
				super.onClickFrontView(position);
		         Fragment fragment = new VisualiserCompetenceFragment();
			    ((MainActivity) getActivity()).changeFragment(fragment);
            }

			@Override
            public void onClickBackView(int position) {
                Log.d("swipe", String.format("onClickBackView %d", position));
                
                listViewCompetence.closeAnimate(position);//when you touch back view it will close
            }

			@Override
            public void onDismiss(int[] reverseSortedPositions) {
            	new UndoBar.Builder(getActivity())
            	  .setMessage(R.string.text_supp_Competence)
            	  .setListener(adapterComp)
            	  .show();
            }

        });
        
        //These are the swipe listview settings. you can change these
        //setting as your requirement 
		listViewCompetence.setSwipeMode(SwipeListView.SWIPE_MODE_BOTH); // there are five swiping modes
		listViewCompetence.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_REVEAL); //there are four swipe actions
		listViewCompetence.setSwipeActionRight(SwipeListView.SWIPE_ACTION_REVEAL);
		listViewCompetence.setOffsetLeft(convertDpToPixel(0f)); // left side offset
		listViewCompetence.setOffsetRight(convertDpToPixel(0f)); // right side offset
		listViewCompetence.setAnimationTime(500); // Animation time
		listViewCompetence.setSwipeOpenOnLongPress(false); // enable or disable SwipeOpenOnLongPress
	
		listViewCompetence.setAdapter(adapterComp);
        
        
        for(int i=0;i<10;i++)
        {
        	itemDataComp.add(new ItemRow("Competence "+i, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "10/04/2014" ));
        }
        
        adapterComp.notifyDataSetChanged();
        
        /*************************************/
		/*   Slide list view of CV   */
		/*************************************/
        
        itemDataCV=new ArrayList<ItemRow>();
		
        adapteurCv=new ItemAdapterCV(getActivity(),R.layout.custom_row,itemDataCV);
		
        listViewCv.setSwipeListViewListener(new BaseSwipeListViewListener() {
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
		         Fragment fragment = new VisualiserCvFragment();
			    ((MainActivity) getActivity()).changeFragment(fragment);
            }

            public void onClickBackView(int position) {
                Log.d("swipe", String.format("onClickBackView %d", position));
                
                listViewCv.closeAnimate(position);//when you touch back view it will close
            }

            public void onDismiss(int[] reverseSortedPositions) {
            	new UndoBar.Builder(getActivity())
          	  .setMessage(R.string.text_supp_Cv)
          	  .setListener(adapteurCv)
          	  .show();
            }

        });
        
        //These are the swipe listview settings. you can change these
        //setting as your requirement
        listViewCv.setSwipeMode(SwipeListView.SWIPE_MODE_BOTH); // there are five swiping modes
        listViewCv.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_REVEAL); //there are four swipe actions
        listViewCv.setSwipeActionRight(SwipeListView.SWIPE_ACTION_REVEAL);
        listViewCv.setOffsetLeft(convertDpToPixel(0f)); // left side offset
        listViewCv.setOffsetRight(convertDpToPixel(0f)); // right side offset
        listViewCv.setAnimationTime(500); // Animation time
        listViewCv.setSwipeOpenOnLongPress(false); // enable or disable SwipeOpenOnLongPress
        listViewCv.setAdapter(adapteurCv);
        
        monCV.setDateCreation("10/04/2014");
        monCV.setEmplacement("/sdcard/example.pdf");
        monCV.setId(1);
        
        itemDataCV.add(new ItemRow("Curriculum Vitae", "Cliquez ici pour accéder à votre Curriculum Vitae.", monCV.getDateCreation() ));
        
        adapteurCv.notifyDataSetChanged();
		
		imageButtonAjouterCompetence.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				dialogueAjoutCompetence();
			}
		});
		imageButtonAjouterCV.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				dialogueAjoutCV();
			}
		});
		
		return frag;

	}
	
public static void deleteSelectedItemCompetence(int position) {
	listViewCompetence.closeOpenedItems();
	listViewCompetence.dismiss(position);
}

public static void deleteSelectedItemCv(int position){
	listViewCv.closeOpenedItems();
	listViewCv.dismiss(position);
}
	
public void dialogueAjoutCompetence(){
	
		Drawable background = getResources().getDrawable(R.drawable.background_popup);
	
		//Creation nouvelle alerte dialogue
    	AlertDialog.Builder DialogueComp = new AlertDialog.Builder(getActivity());
    	DialogueComp.setCancelable(true);
        
    	DialogueComp.setTitle(R.string.text_ajout_comp);
        
        //Creation d'un layout
        LinearLayout layout = new LinearLayout(getActivity());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(10, 10, 10, 10);
        setRes(layout, background);
        
        //Creation champ
        final Spinner spinner_comp = new Spinner(getActivity());
        final RadioGroup rg = new RadioGroup(getActivity());
        final RadioButton radiobutton_comp_deb = new RadioButton(getActivity());
        radiobutton_comp_deb.setText(R.string.text_debutant);
        rg.addView(radiobutton_comp_deb);
        final RadioButton radiobutton_comp_conf = new RadioButton(getActivity());
        radiobutton_comp_conf.setText(R.string.text_confirmer);
        rg.addView(radiobutton_comp_conf);
        final RadioButton radiobutton_comp_app = new RadioButton(getActivity());
        radiobutton_comp_app.setText(R.string.text_apprentit);
        rg.addView(radiobutton_comp_app);
        final RadioButton radiobutton_comp_mai = new RadioButton(getActivity());
        radiobutton_comp_mai.setText(R.string.text_maitrise);
        rg.addView(radiobutton_comp_mai);
        
        //Ajout des champs au layout
        layout.addView(spinner_comp);
        layout.addView(rg);
        
        
        //Ajout du layout a l'alerte dialogue
        DialogueComp.setView(layout);
        
        //Bouton
        DialogueComp.setPositiveButton(R.string.text_envoie,
                new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        DialogueComp.setNegativeButton(R.string.text_annulation,
                new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
 
        //Creation et affichage
        AlertDialog alert11 = DialogueComp.create();
        alert11.show();
    }

public void dialogueAjoutCV(){
    	Intent monIntent = new Intent(getActivity(), UploadToServer.class);
		this.startActivity(monIntent);
    }


	public int convertDpToPixel(float dp) {
	    DisplayMetrics metrics = getResources().getDisplayMetrics();
	    float px = dp * (metrics.densityDpi / 160f);
	    return (int) px;
	}
	
	@SuppressWarnings("deprecation")
    private void setRes(LinearLayout iv,Drawable drawable){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            iv.setBackground(drawable);
        else
            iv.setBackgroundDrawable(drawable);
    }

}
