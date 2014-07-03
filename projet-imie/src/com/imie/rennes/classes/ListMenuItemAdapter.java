package com.imie.rennes.classes;

import java.util.ArrayList;

import com.imie.rennes.imienetwork.R;



import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ImageView;

public class ListMenuItemAdapter extends BaseAdapter{
	
	private ArrayList<Integer> tabImages ;
	private Context context;
	private ArrayList<MenuItem> items;
	
	public ListMenuItemAdapter(Context context, ArrayList<MenuItem> items,ArrayList<Integer> tabImages) {
		super();
		this.context = context;
		this.items = items;
		this.tabImages = tabImages;
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.liste_ligne_menu, null);
        }
        
		TextView txtTitle = (TextView) convertView.findViewById(R.id.textViewElementMenu);
		txtTitle.setText(items.get(position).getTitle());
		
		ImageView Image = (ImageView) convertView.findViewById(R.id.imageViewElementMenu);
		Image.setImageResource(this.tabImages.get(position));
		
        return convertView;
	}

}
