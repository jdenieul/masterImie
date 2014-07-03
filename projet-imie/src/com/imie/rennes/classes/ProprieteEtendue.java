package com.imie.rennes.classes;

import java.util.ArrayList;

public class ProprieteEtendue {

	private int id;
	private String cle;
	private String valeur;
	private ArrayList<Groupe> groupes;
	private ArrayList<UtilisateurProprietesEtendues> utilisateurProprietesEtendues;
	
	/**
	 * 
	 */
	public ProprieteEtendue() {
		super();
		this.groupes = new ArrayList<Groupe>();
		this.utilisateurProprietesEtendues = new ArrayList<UtilisateurProprietesEtendues>();
		
	}
	
	/**
	 * @param id
	 * @param cle
	 * @param valeur
	 * @param groupe
	 */
	public ProprieteEtendue(int id, String cle, String valeur, ArrayList<Groupe> groupes) {
		super();
		this.id = id;
		this.cle = cle;
		this.valeur = valeur;
		this.groupes = groupes;
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
	 * @return the cle
	 */
	public String getCle() {
		return cle;
	}
	/**
	 * @param cle the cle to set
	 */
	public void setCle(String cle) {
		this.cle = cle;
	}
	/**
	 * @return the valeur
	 */
	public String getValeur() {
		return valeur;
	}
	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	/**
	 * @return the groupes
	 */
	public ArrayList<Groupe> getGroupes() {
		return groupes;
	}

	/**
	 * @param groupes the groupes to set
	 */
	public void setGroupes(ArrayList<Groupe> groupes) {
		this.groupes = groupes;
	}

	/**
	 * @return the utilisateurProprietesEtendues
	 */
	public ArrayList<UtilisateurProprietesEtendues> getUtilisateurProprietesEtendues() {
		return utilisateurProprietesEtendues;
	}

	/**
	 * @param utilisateurProprietesEtendues the utilisateurProprietesEtendues to set
	 */
	public void setUtilisateurProprietesEtendues(
			ArrayList<UtilisateurProprietesEtendues> utilisateurProprietesEtendues) {
		this.utilisateurProprietesEtendues = utilisateurProprietesEtendues;
	}		
	
}
