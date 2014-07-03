package com.imie.rennes.adapteur;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.imie.rennes.classes.ExperienceRow;
import com.imie.rennes.classes.ItemRow;
import com.imie.rennes.imienetwork.EditionOffreFragment;
import com.imie.rennes.imienetwork.OffreFragment;
import com.imie.rennes.imienetwork.ProfilFragment;
import com.imie.rennes.imienetwork.R;
import com.imie.rennes.mainActivity.MainActivity;
import com.jensdriller.libs.undobar.UndoBar.Listener;

public class ItemAdapterExperience extends ArrayAdapter<ExperienceRow> implements
		Listener {

	List<ExperienceRow> data;
	Context context;
	int layoutResID;

	public ItemAdapterExperience(Context context, int layoutResourceId,
			List<ExperienceRow> data) {
		super(context, layoutResourceId, data);

		this.data = data;
		this.context = context;
		this.layoutResID = layoutResourceId;

	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		NewsHolder holder = null;
		View row = convertView;
		holder = null;

		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResID, parent, false);

			holder = new NewsHolder();

			holder.nom = (TextView) row.findViewById(R.id.nomExp);
			holder.description = (TextView) row.findViewById(R.id.descriExp);
			holder.dateDebut = (TextView) row.findViewById(R.id.datedebut);
			holder.dateFin = (TextView) row.findViewById(R.id.datefin);
			holder.button1 = (ImageButton) row.findViewById(R.id.swipe_button1);
			holder.button2 = (ImageButton) row.findViewById(R.id.swipe_button2);
			row.setTag(holder);
		} else {
			holder = (NewsHolder) row.getTag();
		}

		ExperienceRow itemdata = data.get(position);
		holder.nom.setText(itemdata.getNom());
		holder.description.setText(itemdata.getDescription());
		holder.dateDebut.setText(itemdata.getDateDebut());
		holder.dateFin.setText(itemdata.getDateFin());

		holder.button1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				//modification expérience
				//TODO modif expérience
			}
		});

		holder.button2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				//suppression expérience
				//TODO appel BDD
				ProfilFragment.deleteSelectedItemExperience(position);
			}
		});

		return row;

	}

	static class NewsHolder {

		TextView nom;
		TextView description;
		TextView dateDebut;
		TextView dateFin;
		ImageButton button1;
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
