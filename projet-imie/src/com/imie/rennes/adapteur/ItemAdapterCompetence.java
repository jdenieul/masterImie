package com.imie.rennes.adapteur;

import java.util.List;

import com.imie.rennes.classes.ItemRow;
import com.imie.rennes.imienetwork.AccueilEleveFragment;
import com.imie.rennes.imienetwork.R;
import com.jensdriller.libs.undobar.UndoBar.Listener;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class ItemAdapterCompetence extends ArrayAdapter<ItemRow> implements Listener{

	List<ItemRow> data; 
	Context context;
	int layoutResID;

public ItemAdapterCompetence(Context context, int layoutResourceId,List<ItemRow> data) {
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
            holder.button1=(ImageButton)row.findViewById(R.id.swipe_button1);
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
      
        holder.button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialogueModifierCompetence();
			}
		});
        
		 holder.button2.setOnClickListener(new View.OnClickListener() {
					
			@Override
			public void onClick(View v) {
				deleteSelectedItem(position);
			}
		});
        
        
        return row;
	
}

	static class NewsHolder{
	
		TextView itemName;
		TextView body;
		TextView date;
		ImageButton button1;
		ImageButton button2;
	}
	
public void dialogueModifierCompetence(){
	
		Drawable background = context.getResources().getDrawable(R.drawable.background_front);
		
		//Creation nouvelle alerte dialogue
		AlertDialog.Builder DialogueComp = new AlertDialog.Builder(context);
		DialogueComp.setCancelable(true);
	    
		DialogueComp.setTitle(R.string.text_modif_comp);
	    
	    //Creation d'un layout
	    LinearLayout layout = new LinearLayout(context);
	    layout.setOrientation(LinearLayout.VERTICAL);
	    layout.setPadding(10, 10, 10, 10);
	    setRes(layout, background);
	    
	    //Creation champ
	    final Spinner spinner_comp = new Spinner(context);
	    final RadioGroup rg = new RadioGroup(context);
	    final RadioButton radiobutton_comp_deb = new RadioButton(context);
	    radiobutton_comp_deb.setText(R.string.text_debutant);
	    rg.addView(radiobutton_comp_deb);
	    final RadioButton radiobutton_comp_conf = new RadioButton(context);
	    radiobutton_comp_conf.setText(R.string.text_confirmer);
	    rg.addView(radiobutton_comp_conf);
	    final RadioButton radiobutton_comp_app = new RadioButton(context);
	    radiobutton_comp_app.setText(R.string.text_apprentit);
	    rg.addView(radiobutton_comp_app);
	    final RadioButton radiobutton_comp_mai = new RadioButton(context);
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
	
	
	//Fonction pour le background de l'alertdialog en fonction du SDK
	@SuppressWarnings("deprecation")
	private void setRes(LinearLayout iv,Drawable drawable){
	    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
	        //iv.setBackground(drawable);
	    }else{
	        iv.setBackgroundDrawable(drawable);
	    }
	}
	
	private void deleteSelectedItem(int position) {
		data.remove(position);
		AccueilEleveFragment.deleteSelectedItemCompetence(position);
		//this.notifyDataSetChanged();
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




