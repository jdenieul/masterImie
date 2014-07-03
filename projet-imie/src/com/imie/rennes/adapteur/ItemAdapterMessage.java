package com.imie.rennes.adapteur;

import java.util.List;

import com.imie.rennes.classes.ItemRow;
import com.imie.rennes.imienetwork.MessagerieFragment;
import com.imie.rennes.imienetwork.R;
import com.jensdriller.libs.undobar.UndoBar.Listener;
import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapterMessage extends ArrayAdapter<ItemRow> implements Listener{

	List<ItemRow> data; 
	Context context;
	int layoutResID;

public ItemAdapterMessage(Context context, int layoutResourceId,List<ItemRow> data) {
	super(context, layoutResourceId, data);
	
	this.data=data;
	this.context=context;
	this.layoutResID=layoutResourceId;

}
 
@Override
public View getView(final int position, View convertView, ViewGroup parent) {
	
	NewsHolder holder = null;
	   View row = convertView;
	    holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResID, parent, false);
            
            holder = new NewsHolder();
           
            holder.itemName = (TextView)row.findViewById(R.id.itemname);
            holder.body = (TextView)row.findViewById(R.id.body);
            holder.date = (TextView)row.findViewById(R.id.date);
            holder.button2=(ImageButton)row.findViewById(R.id.swipe_button2);
            row.setTag(holder);
        }
        else
        {
            holder = (NewsHolder)row.getTag();
        }
        
        ItemRow itemdata = data.get(position);
        holder.itemName.setText(itemdata.getItemName());
        holder.body.setText(itemdata.getBody());
        holder.date.setText(itemdata.getDate());
      
		 holder.button2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						MessagerieFragment.deleteSelectedItemMessage(position);
					}
				});
        
        
        return row;
	
}

	static class NewsHolder{
	
		TextView itemName;
		TextView body;
		TextView date;
		ImageButton button2;
	}
	

	@Override
	public void onHide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUndo(Parcelable token) {
		// TODO Auto-generated method stub
		
	}
	
	
}




