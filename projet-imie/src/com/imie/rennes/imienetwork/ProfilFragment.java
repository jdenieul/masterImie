package com.imie.rennes.imienetwork;

import java.util.ArrayList;
import java.util.List;

import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;
import com.imie.rennes.adapteur.ItemAdapterCompetence;
import com.imie.rennes.adapteur.ItemAdapterExperience;
import com.imie.rennes.adapteur.ItemAdapterOffre;
import com.imie.rennes.classes.ExperienceRow;
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

public class ProfilFragment extends Fragment {
	
	Button btnVoirCV;
	static SwipeListView listViewCompetence;
	static SwipeListView listViewExperience;
	List<ExperienceRow> itemExperience;
	List<ItemRow> itemCompetence;
	ItemAdapterCompetence competenceAdapter;
	ItemAdapterExperience experienceAdapter;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View frag = inflater.inflate(R.layout.fragment_profil,container, false);
		
		btnVoirCV = (Button)frag.findViewById(R.id.btnVoirCV);
		listViewCompetence = (SwipeListView)frag.findViewById(R.id.lvCompetences);
		listViewExperience = (SwipeListView)frag.findViewById(R.id.lvExperiences);
		
		/**
		 * Gestion événements
		 */
		btnVoirCV.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				Fragment fragment = new VisualiserCvFragment();
				((MainActivity) getActivity()).changeFragment(fragment);
			}
		});
		
		/**
		 * Fin Gestion événements
		 */
		
		/**
		 * SwypeListView Competences
		 */
		itemCompetence = new ArrayList<ItemRow>();
		
		competenceAdapter = new ItemAdapterCompetence(getActivity(),R.layout.custom_row,itemCompetence);
		
		listViewCompetence.setSwipeListViewListener(new BaseSwipeListViewListener() {
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
		         Fragment fragment = new CompetenceEleveFragment();
				((MainActivity) getActivity()).changeFragment(fragment);
            }

            public void onClickBackView(int position) {
                Log.d("swipe", String.format("onClickBackView %d", position));
                
                listViewCompetence.closeAnimate(position);//when you touch back view it will close
            }

            public void onDismiss(int[] reverseSortedPositions) {
            	new UndoBar.Builder(getActivity())
            	  .setMessage(R.string.text_supp_Offre)
            	  .setListener(competenceAdapter)
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
	
		listViewCompetence.setAdapter(competenceAdapter);
        
        //TODO Récupération compétences
        for(int i=0;i<5;i++)
        {
        	itemCompetence.add(new ItemRow("Compétence "+i,"NIveau 2","Ajoutée le 14 juin 2014" ));
        }
        
        competenceAdapter.notifyDataSetChanged();
		
        /**
         * Fin swypelistview compétence
         */
        
        /**
         * SwypeListView Experience
         */
        itemExperience = new ArrayList<ExperienceRow>();
		
		experienceAdapter = new ItemAdapterExperience(getActivity(),R.layout.custom_experience_row,itemExperience);
		
		listViewExperience.setSwipeListViewListener(new BaseSwipeListViewListener() {
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
		         Fragment fragment = new CompetenceEleveFragment();
				((MainActivity) getActivity()).changeFragment(fragment);
            }

            public void onClickBackView(int position) {
                Log.d("swipe", String.format("onClickBackView %d", position));
                
                listViewExperience.closeAnimate(position);//when you touch back view it will close
            }

            public void onDismiss(int[] reverseSortedPositions) {
            	new UndoBar.Builder(getActivity())
            	  .setMessage(R.string.text_supp_Offre)
            	  .setListener(experienceAdapter)
            	  .show();
            }

        });
        
        //These are the swipe listview settings. you can change these
        //setting as your requirement 
		listViewExperience.setSwipeMode(SwipeListView.SWIPE_MODE_BOTH); // there are five swiping modes
		listViewExperience.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_REVEAL); //there are four swipe actions
		listViewExperience.setSwipeActionRight(SwipeListView.SWIPE_ACTION_REVEAL);
		listViewExperience.setOffsetLeft(convertDpToPixel(0f)); // left side offset
		listViewExperience.setOffsetRight(convertDpToPixel(0f)); // right side offset
		listViewExperience.setAnimationTime(500); // Animation time
		listViewExperience.setSwipeOpenOnLongPress(false); // enable or disable SwipeOpenOnLongPress
	
		listViewExperience.setAdapter(experienceAdapter);
        
        //TODO Récupération expériences
        for(int i=0;i<5;i++)
        {
        	itemExperience.add(new ExperienceRow("Expérience "+i,"Assistant chef de projet","janv. 2014","Sept 2014" ));
        }
        
        experienceAdapter.notifyDataSetChanged();
        
		return frag;
	}
	
	
	
	public static void deleteSelectedItem(int position){
		listViewCompetence.closeOpenedItems();
		listViewCompetence.dismiss(position);
	}
	
	public static void deleteSelectedItemExperience(int position){
		listViewExperience.closeOpenedItems();
		listViewExperience.dismiss(position);
	}
	
	public int convertDpToPixel(float dp) {
	    DisplayMetrics metrics = getResources().getDisplayMetrics();
	    float px = dp * (metrics.densityDpi / 160f);
	    return (int) px;
	}

}
