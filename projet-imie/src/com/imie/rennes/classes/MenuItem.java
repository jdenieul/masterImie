package com.imie.rennes.classes;

import java.util.ArrayList;

import com.imie.rennes.imienetwork.MenuFragment;
import com.imie.rennes.imienetwork.R;

import android.content.Context;
import android.support.v4.app.Fragment;

public class MenuItem {

	private Fragment fragment;
	private String title;
	private int icon;	
	private MenuItem itemHome;
	private MenuItem itemEvenements;
	private MenuItem itemMessagerie;
	private MenuItem itemOffre;
	private MenuItem itemlogout;
	private MenuItem itemQuitter;
	private MenuItem itemMajMdp;
	private MenuItem itemRecherche;
	private Context context;
	
	/**
	 * @param title
	 */
	public MenuItem(String title){
		this.title = title;
	}
	
	/**
	 * @param title
	 * @param icon
	 */
	public MenuItem(String title, int icon){
		this.title = title;
		this.icon = icon;
	}
	
	/**
	 * @param title
	 * @param fragment
	 */
	public MenuItem(Fragment fragment, String title) {
		super();
		this.fragment = fragment;
		this.title = title;
	}
	
	/**
	 * @param title
	 * @param fragment
	 * @param icon
	 */
	public MenuItem(Fragment fragment, String title, int icon) {
		super();
		this.fragment = fragment;
		this.title = title;
		this.icon = icon;
	}
	
	public MenuItem(Context context) {
		this.context = context;
		
	}
	
	/**
	 * @return the fragment
	 */
	public Fragment getFragment() {
		return fragment;
	}
	/**
	 * @param fragment the fragment to set
	 */
	public void setFragment(Fragment fragment) {
		this.fragment = fragment;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the icon
	 */
	public int getIcon() {
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(int icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return title;
	}
	
	@Override
	public boolean equals(Object o) {
		MenuItem item = (MenuItem)o;
		
		if(item.getTitle().equals(getTitle()))
			return true;
		
		return false;
	}
	
	/**
	 * G�n�ration du menu de groupe IMIE
	 * @param items
	 */
	public void genererMenuImie(ArrayList<MenuItem> items,ArrayList<Integer> tabImages){
		
		
		if (this.itemHome == null){
			itemHome = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.text_accueil), R.drawable.ic_drawer);
			items.add(itemHome);
			tabImages.add(R.drawable.accueil);			
		}
		
		// Items sp�cifique au groupe IMIE
		if (this.itemEvenements == null){
			itemEvenements = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.menu_evenement), R.drawable.ic_drawer);
			items.add(itemEvenements);	
			tabImages.add(R.drawable.evenement);
		}

		if (this.itemRecherche == null){
			itemRecherche = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.text_rechercher), R.drawable.ic_drawer);
			items.add(itemRecherche);
			tabImages.add(R.drawable.recherche);
		}
				
		if (this.itemOffre == null){
			itemOffre = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.text_offre), R.drawable.ic_drawer);
			items.add(itemOffre);
			tabImages.add(R.drawable.offre);
		}
		
		if (this.itemMessagerie == null){
			itemMessagerie = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.text_messagerie), R.drawable.ic_drawer);
			items.add(itemMessagerie);	
			tabImages.add(R.drawable.messagerie);
		}
		
		if (this.itemMajMdp == null){
			itemMajMdp = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.text_gerer_mon_compte), R.drawable.ic_drawer);
			items.add(itemMajMdp);			
			tabImages.add(R.drawable.gererprofilutilisateur);
		}
		
		if (this.itemlogout == null){
			itemlogout = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.text_logout), R.drawable.ic_drawer);
			items.add(itemlogout);
			tabImages.add(R.drawable.deconnexion);	
		}
		
		if (this.itemQuitter == null){
			itemQuitter = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.text_quitter), R.drawable.ic_drawer);
			items.add(itemQuitter);
			tabImages.add(R.drawable.fermerappli);
		}				
		
	}
	
	/**
	 * G�n�ration du menu de groupe ENTREPRISE
	 * @param items
	 */
	public void genererMenuEntreprise(ArrayList<MenuItem> items,ArrayList<Integer> tabImages){
		
		
		if (this.itemHome == null){
			itemHome = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.text_accueil), R.drawable.ic_drawer);
			items.add(itemHome);
			tabImages.add(R.drawable.accueil);			
		}

		
		if (this.itemOffre == null){
			itemOffre = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.text_offre), R.drawable.ic_drawer);
			items.add(itemOffre);
			tabImages.add(R.drawable.offre);
		}
		
		if (this.itemMessagerie == null){
			itemMessagerie = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.text_messagerie), R.drawable.ic_drawer);
			items.add(itemMessagerie);	
			tabImages.add(R.drawable.messagerie);
		}
		
		if (this.itemMajMdp == null){
			itemMajMdp = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.text_gerer_mon_compte), R.drawable.ic_drawer);
			items.add(itemMajMdp);			
			tabImages.add(R.drawable.gererprofilutilisateur);
		}
		
		if (this.itemlogout == null){
			itemlogout = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.text_logout), R.drawable.ic_drawer);
			items.add(itemlogout);
			tabImages.add(R.drawable.deconnexion);	
		}
		
		if (this.itemQuitter == null){
			itemQuitter = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.text_quitter), R.drawable.ic_drawer);
			items.add(itemQuitter);
			tabImages.add(R.drawable.fermerappli);
		}
	}
	
	/**
	 * G�n�ration du menu de groupe ELEVE
	 * @param items
	 */
	public void genererMenuEleve(ArrayList<MenuItem> items,ArrayList<Integer> tabImages){
		
		if (this.itemHome == null){
			itemHome = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.text_accueil), R.drawable.ic_drawer);
			items.add(itemHome);
			tabImages.add(R.drawable.accueil);			
		}		

		
		if (this.itemOffre == null){
			itemOffre = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.text_offre), R.drawable.ic_drawer);
			items.add(itemOffre);
			tabImages.add(R.drawable.offre);
		}
		
		if (this.itemMessagerie == null){
			itemMessagerie = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.text_messagerie), R.drawable.ic_drawer);
			items.add(itemMessagerie);	
			tabImages.add(R.drawable.messagerie);
		}
		
		if (this.itemMajMdp == null){
			itemMajMdp = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.text_gerer_mon_compte), R.drawable.ic_drawer);
			items.add(itemMajMdp);			
			tabImages.add(R.drawable.gererprofilutilisateur);
		}
		
		if (this.itemlogout == null){
			itemlogout = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.text_logout), R.drawable.ic_drawer);
			items.add(itemlogout);
			tabImages.add(R.drawable.deconnexion);	
		}
		
		if (this.itemQuitter == null){
			itemQuitter = new MenuItem(new MenuFragment(),
					this.context.getResources().getString(R.string.text_quitter), R.drawable.ic_drawer);
			items.add(itemQuitter);
			tabImages.add(R.drawable.fermerappli);
		}
	}
	
}
