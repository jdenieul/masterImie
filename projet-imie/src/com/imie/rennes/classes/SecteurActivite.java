package com.imie.rennes.classes;

import java.util.ArrayList;

public class SecteurActivite {
	
	private int id;
	private String libelle;
	private ArrayList<Utilisateur> utilisateurs;
	
	/**
	 * 
	 */
	public SecteurActivite() {
		super();
		this.utilisateurs = new ArrayList<Utilisateur>();
	}
	
	/**
	 * @param id
	 * @param libelle
	 * @param utilisateurs
	 */
	public SecteurActivite(int id, String libelle,
			ArrayList<Utilisateur> utilisateurs) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.utilisateurs = utilisateurs;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the utilisateurs
	 */
	public ArrayList<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	/**
	 * @param utilisateurs the utilisateurs to set
	 */
	public void setUtilisateurs(ArrayList<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
}
