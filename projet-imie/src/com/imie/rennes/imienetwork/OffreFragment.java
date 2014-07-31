package com.imie.rennes.imienetwork;

import java.util.ArrayList;
import java.util.List;

import network.ReseauOffre;
import network.ReseauUser;

import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;
import com.imie.rennes.adapteur.ItemAdapterOffre;
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

public class OffreFragment extends Fragment {
	
	Button buttonDeposerOffre;
	static SwipeListView listViewOffre;
	List<ItemRow> itemData;
	ItemAdapterOffre adapter;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View frag = inflater.inflate(R.layout.fragment_offre,container, false);
		
		buttonDeposerOffre = (Button)frag.findViewById(R.id.buttonDeposerOffre);
		listViewOffre = (SwipeListView)frag.findViewById(R.id.listViewOffre);
		
		buttonDeposerOffre.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				Fragment fragment = new DeposerOffreFragment();
				((MainActivity) getActivity()).changeFragment(fragment);
			}
		});
		
		itemData=new ArrayList<ItemRow>();
		
		adapter=new ItemAdapterOffre(getActivity(),R.layout.custom_row,itemData);
		
		listViewOffre.setSwipeListViewListener(new BaseSwipeListViewListener() {
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
		         Fragment fragment = new VisualiserOffreFragment();
				((MainActivity) getActivity()).changeFragment(fragment);
            }

            public void onClickBackView(int position) {
                Log.d("swipe", String.format("onClickBackView %d", position));
                
                listViewOffre.closeAnimate(position);//when you touch back view it will close
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
		listViewOffre.setSwipeMode(SwipeListView.SWIPE_MODE_BOTH); // there are five swiping modes
		listViewOffre.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_REVEAL); //there are four swipe actions
		listViewOffre.setSwipeActionRight(SwipeListView.SWIPE_ACTION_REVEAL);
		listViewOffre.setOffsetLeft(convertDpToPixel(0f)); // left side offset
		listViewOffre.setOffsetRight(convertDpToPixel(0f)); // right side offset
		listViewOffre.setAnimationTime(500); // Animation time
		listViewOffre.setSwipeOpenOnLongPress(false); // enable or disable SwipeOpenOnLongPress
	
		listViewOffre.setAdapter(adapter);
        
		ReseauOffre r = new ReseauOffre(getActivity());
    	r.execute("2"); 
        for(int i=0;i<10;i++)
        {
        	//itemData.add(new ItemRow("Offre "+i, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "10/04/2014" ));
        	
        }
        
        adapter.notifyDataSetChanged();
		
		return frag;
	}
	
	public static void deleteSelectedItemOffre(int position){
		listViewOffre.closeOpenedItems();
		listViewOffre.dismiss(position);
	}
	
	public int convertDpToPixel(float dp) {
	    DisplayMetrics metrics = getResources().getDisplayMetrics();
	    float px = dp * (metrics.densityDpi / 160f);
	    return (int) px;
	}

}
