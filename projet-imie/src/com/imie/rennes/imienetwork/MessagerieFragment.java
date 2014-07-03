package com.imie.rennes.imienetwork;
import java.util.ArrayList;
import java.util.List;

import com.fortysevendeg.swipelistview.BaseSwipeListViewListener;
import com.fortysevendeg.swipelistview.SwipeListView;
import com.imie.rennes.adapteur.ItemAdapterMessage;
import com.imie.rennes.classes.ItemRow;
import com.imie.rennes.mainActivity.*;
import com.jensdriller.libs.undobar.UndoBar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MessagerieFragment extends Fragment {
	
	Button buttonNouveauMessage;
	static SwipeListView listViewDernierMessage;
	List<ItemRow> itemData;
	ItemAdapterMessage adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View frag = inflater.inflate(R.layout.fragment_messagerie,container, false);
		
		buttonNouveauMessage = (Button)frag.findViewById(R.id.buttonEnvoyerMessage);
		listViewDernierMessage = (SwipeListView)frag.findViewById(R.id.listViewDernierMessage);
		
		
		itemData=new ArrayList<ItemRow>();
		
		adapter=new ItemAdapterMessage(getActivity(),R.layout.custom_row_1_button,itemData);
		
		listViewDernierMessage.setSwipeListViewListener(new BaseSwipeListViewListener() {
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
		         Fragment fragment = new VisualiserMessageFragment();
				((MainActivity) getActivity()).changeFragment(fragment);
            }

            public void onClickBackView(int position) {
                Log.d("swipe", String.format("onClickBackView %d", position));
                
                listViewDernierMessage.closeAnimate(position);//when you touch back view it will close
            }

            public void onDismiss(int[] reverseSortedPositions) {
            	new UndoBar.Builder(getActivity())
          	  .setMessage(R.string.text_supp_Message)
          	  .setListener(adapter)
          	  .show();
            }

        });
        
        //These are the swipe listview settings. you can change these
        //setting as your requirement 
		listViewDernierMessage.setSwipeMode(SwipeListView.SWIPE_MODE_BOTH); // there are five swiping modes
		listViewDernierMessage.setSwipeActionLeft(SwipeListView.SWIPE_ACTION_REVEAL); //there are four swipe actions
		listViewDernierMessage.setSwipeActionRight(SwipeListView.SWIPE_ACTION_REVEAL);
		listViewDernierMessage.setOffsetLeft(convertDpToPixel(0f)); // left side offset
		listViewDernierMessage.setOffsetRight(convertDpToPixel(0f)); // right side offset
		listViewDernierMessage.setAnimationTime(500); // Animation time
		listViewDernierMessage.setSwipeOpenOnLongPress(false); // enable or disable SwipeOpenOnLongPress
	
		listViewDernierMessage.setAdapter(adapter);
        
        
        for(int i=0;i<10;i++)
        {
        	itemData.add(new ItemRow("Message "+i, "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "10/04/2014" ));
        	
        }
        
        adapter.notifyDataSetChanged();
		
		buttonNouveauMessage.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				Fragment fragment = new EnvoiMessageFragment();
				((MainActivity) getActivity()).changeFragment(fragment);
			}
		});
				
		return frag;
	}
	
	public static void deleteSelectedItemMessage(int position){
		listViewDernierMessage.closeOpenedItems();
		listViewDernierMessage.dismiss(position);
	}
	
	public int convertDpToPixel(float dp) {
	    DisplayMetrics metrics = getResources().getDisplayMetrics();
	    float px = dp * (metrics.densityDpi / 160f);
	    return (int) px;
	}

}
