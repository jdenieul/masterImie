package com.imie.rennes.classes;

public class Promotion {
	
	private int id;
	private String libelle;
	private int annee;
	private String email;
	
	public Promotion() {
		super();
	}

	
	/**
	 * @param id
	 * @param libelle
	 * @param annee
	 * @param email
	 */
	public Promotion(int id, String libelle, int annee, String email) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.annee = annee;
		this.email = email;
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
	 * @return the annee
	 */
	public int getAnnee() {
		return annee;
	}


	/**
	 * @param annee the annee to set
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
