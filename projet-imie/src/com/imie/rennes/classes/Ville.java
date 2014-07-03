package com.imie.rennes.classes;

import java.util.ArrayList;

public class Ville {

	/** declarations variables **/
	
	private int id;
	private String libelle;
	private int codePostal;
	private ArrayList<Offre> mesOffres;
	
	/**
	 * 
	 */
	public Ville() {
		super();
		this.mesOffres = new ArrayList<Offre>();
	}
	/**
	 * @param id
	 * @param libelle
	 * @param codePostal
	 * @param mesOffres
	 */
	public Ville(int id, String libelle, int codePostal,
			ArrayList<Offre> mesOffres) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.codePostal = codePostal;
		this.mesOffres = mesOffres;
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
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}
	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * @return the mesOffres
	 */
	public ArrayList<Offre> getMesOffres() {
		return mesOffres;
	}
	/**
	 * @param mesOffres the mesOffres to set
	 */
	public void setMesOffres(ArrayList<Offre> mesOffres) {
		this.mesOffres = mesOffres;
	}
	


	
}
