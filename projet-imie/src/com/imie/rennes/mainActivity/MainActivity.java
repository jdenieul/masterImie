package com.imie.rennes.mainActivity;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.imie.rennes.classes.Groupe;
import com.imie.rennes.classes.ListMenuItemAdapter;
import com.imie.rennes.classes.MenuItem;
import com.imie.rennes.classes.Utilisateur;
import com.imie.rennes.imienetwork.AccueilEleveFragment;
import com.imie.rennes.imienetwork.DashboardFragment;
import com.imie.rennes.imienetwork.EvenementEnqueteFragment;
import com.imie.rennes.imienetwork.MessagerieFragment;
import com.imie.rennes.imienetwork.OffreFragment;
import com.imie.rennes.imienetwork.R;
import com.imie.rennes.imienetwork.RechercheFragment;
import com.imie.rennes.imienetwork.UpdatePasswordFragment;

public class MainActivity extends ActionBarActivity {
	
	int Tag = 0;
	private static long back_pressed;
	DrawerLayout drawerLayout;
	private ListView drawerListView;
	ListMenuItemAdapter adapter;
	ArrayList<MenuItem> items = new ArrayList<MenuItem>();
	ArrayList<Integer> tabImages = new ArrayList<Integer>();
	ActionBarDrawerToggle drawerToggle;
	Fragment fragment;
	Fragment fragmentback;
	SharedPreferences preferences;
	Utilisateur utilisateurCourant;
	Boolean groupeImie = false;
	MenuItem creationMenu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	  fragment = new DashboardFragment();
	  fragmentback = fragment;
      FragmentManager fm = getSupportFragmentManager();
      FragmentTransaction transaction = fm.beginTransaction();
      transaction.add(R.id.fragment_place, fragment);
      transaction.commit();
      getSupportActionBar().setTitle(changementTitre(fragmentback));
      Drawable background = this.getResources().getDrawable(R.drawable.background_popup);
      getSupportActionBar().setBackgroundDrawable(background);
		
		this.creationMenu = new MenuItem(this);
		// R�cup�ration de l'utilisateur connect�
		preferences = this.getSharedPreferences("DEFAULT",
				Activity.MODE_PRIVATE);
		utilisateurCourant = new Utilisateur(this);
		String userString = preferences.getString("CURRENT_USER", "");
		
		// S'il y a un utilisateur en cache
		if (userString != "") {
			try {
				utilisateurCourant.setWithSerializableString(userString);
			} catch (Exception e) {
				android.util.Log.e("monAppli", e.getMessage());
			}
		}
		
		// Générer le menu
		for (Groupe groupeCourant : utilisateurCourant.getGroupes()) {
			
			if (groupeCourant.getLibelle().equals(getResources().getString(R.string.text_groupe_imie))){
				groupeImie = true;
				this.creationMenu.genererMenuImie(items, tabImages);
			}
			
			if (groupeCourant.getLibelle().equals(getResources().getString(R.string.text_groupe_eleve))){
				this.creationMenu.genererMenuEleve(items, tabImages);
			}
			
			if (groupeCourant.getLibelle().equals(getResources().getString(R.string.text_groupe_entreprise))){
				this.creationMenu.genererMenuEntreprise(items, tabImages);
			}
			
		}

		// R�cup�ration du template
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		// R�cup�ration de la listView du menu
		drawerListView = (ListView) findViewById(R.id.left_drawer);

		// Attribution de l'adapter � la lisrView
		adapter = new ListMenuItemAdapter(getApplicationContext(), items,tabImages);
		drawerListView.setAdapter(adapter);

		// Initialisation du Item on click
		drawerListView.setOnItemClickListener(new DrawerItemClickListener());

		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
			}

			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
			}
		};

		drawerLayout.setDrawerListener(drawerToggle);

		// Activation support bar
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}

	// Fonction de recuperation du clic dans le menu
	public boolean onOptionsItemSelected(android.view.MenuItem item) {
		
		if (item.getItemId() == R.id.action_search) {
			fragment = new RechercheFragment();
			changeFragment(fragment);
		}
		if (drawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			
			if (groupeImie){
				selectImieItem(position);
			}else{
				selectItem(position);
			}
			
		}
	}

	// Action au clique menu
	private void selectItem(int position) {
		
		switch (position) {
		case 0:
			fragment = new DashboardFragment();
			//fragment = new AccueilEleveFragment();
			changeFragment(fragment);
			break;
		case 1:
			fragment = new OffreFragment();
			changeFragment(fragment);			
			break;
		case 2:
			fragment = new MessagerieFragment();
			changeFragment(fragment);
			break;
		case 3:
			fragment = new UpdatePasswordFragment();
			changeFragment(fragment);
			break;
		case 4:
			Intent intent = new Intent(MainActivity.this, LoginActivity.class);
			startActivity(intent);
			break;
		case 5:
			Intent homeIntent = new Intent(Intent.ACTION_MAIN);
			homeIntent.addCategory(Intent.CATEGORY_HOME);
			homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(homeIntent);
			break;
		default:
			break;
		}
		
	}
	
	// Action au clique menu pour un type IMIE
	private void selectImieItem(int position) {
		
		switch (position) {
		case 0:
			fragment = new DashboardFragment();
			//fragment = new AccueilEleveFragment();
			changeFragment(fragment);
			break;
		case 1:
			fragment = new EvenementEnqueteFragment();
			changeFragment(fragment);
			break;
		case 2:
			fragment = new RechercheFragment();
			changeFragment(fragment);			
			break;			
		case 3:
			fragment = new OffreFragment();
			changeFragment(fragment);			
			break;
		case 4:
			fragment = new MessagerieFragment();
			changeFragment(fragment);
			break;
		case 5:
			fragment = new UpdatePasswordFragment();
			changeFragment(fragment);
			break;
		case 6:
			Intent intent = new Intent(MainActivity.this, LoginActivity.class);
			startActivity(intent);
			break;
		case 7:
			Intent homeIntent = new Intent(Intent.ACTION_MAIN);
			homeIntent.addCategory(Intent.CATEGORY_HOME);
			homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(homeIntent);
			break;
		default:
			break;
		}
		
	}
		
	// Fonction generique de changement de fragment
	public void changeFragment(Fragment fragment){
		fragmentback = fragment;
		getSupportActionBar().setTitle(changementTitre(fragmentback));
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		transaction.replace(R.id.fragment_place, fragment);
		transaction.commit();
		drawerLayout.closeDrawers();		
	}
	
	public String changementTitre(Fragment fragmentback){
		String titre = "IMIE";
		if (fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.AccueilEleveFragment")){
			titre = "ACCUEIL";
		}
		if (fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.OffreFragment")){
			titre = "OFFRES";
		}
		if (fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.MessagerieFragment")){
			titre = "MESSAGERIE";
		}
		if (fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.UpdatePasswordFragment")){
			titre = "MODIFICATION COMPTE";
		}
		if (fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.RechercheFragment")){
			titre = "RECHERCHE";
		}
		if (fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.VisualiserCvFragment")){
			titre = "CV";
		}
		if (fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.EditionCVFragment")){
			titre = "EDITION CV";
		}
		if (fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.VisualiserCompetenceFragment")){
			titre = "COMPÉTENCE";
		}
		if (fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.VisualiserOffreFragment")){
			titre = "OFFRE";
		}
		if (fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.EditionOffreFragment")){
			titre = "EDITION OFFRE";
		}
		if (fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.DeposerOffreFragment")){
			titre = "NOUVELLE OFFRE";
		}
		if (fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.VisualiserMessageFragment")){
			titre = "MESSAGE";
		}
		if (fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.EnvoiMessageFragment")){
			titre = "NOUVEAU MESSAGE";
		}
		return titre;
	}

	@Override
	    public void onBackPressed(){
			//Attribution du tag en fonction de la classe actuel
			if (fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.AccueilEleveFragment"))
			{
				Tag = 0;
			}
			if (fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.OffreFragment") || 
					fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.MessagerieFragment") ||
					fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.UpdatePasswordFragment") ||
					fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.VisualiserCvFragment") ||
					fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.VisualiserCompetenceFragment") ||
					fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.EditionCVFragment"))
			{
				Tag = 10;
			}
			if (fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.DeposerOffreFragment") ||
					fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.VisualiserOffreFragment") ||
					fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.EditionOffreFragment"))
			{
				Tag = 11;
			}
			if (fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.EnvoiMessageFragment") ||
					fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.VisualiserMessageFragment"))
			{
				Tag = 12;
			}
			if (fragmentback.getClass().getName().equals("com.imie.rennes.imienetwork.RechercheFragment"))
			{
				Tag = 99;
			}

			//Envoie vers la bonne page en fonction du tag et gestion de la fermature de l'application à l'accueil
			switch (Tag){
	    		case 0:
	    			if (back_pressed + 2000 > System.currentTimeMillis()){
	    				Intent homeIntent = new Intent(Intent.ACTION_MAIN);
	    				homeIntent.addCategory( Intent.CATEGORY_HOME );
	    				homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    				startActivity(homeIntent);
	    			}
	    	        else Toast.makeText(getBaseContext(), "Appuyez de nouveau pour quitter!", Toast.LENGTH_SHORT).show();
	    			back_pressed = System.currentTimeMillis();
	    			break;
	    		case 10:
	    		case 99:
	    			fragment = new AccueilEleveFragment();
	    			changeFragment(fragment);
	    			break;
	    		case 11:
	    			fragment = new OffreFragment();
	    			changeFragment(fragment);
	    			break;
	    		case 12:
	    			fragment = new MessagerieFragment();
	    			changeFragment(fragment);
	    			break;    			
	    		default:
	    			fragment = new AccueilEleveFragment();
	    			changeFragment(fragment);
	    			break;
	    	}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity_actions, menu);
	    return super.onCreateOptionsMenu(menu);
	}

}