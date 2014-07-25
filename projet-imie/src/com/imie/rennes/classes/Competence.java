package com.imie.rennes.classes;

public class Competence {

	private int id;
	private String libelle;
	
	/**
	 * @param id
	 * @param libelle
	 */
	public Competence(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
	/**
	 * 
	 */
	public Competence() {
		super();
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

	@Override
	public String toString() {
		return this.libelle;
	}
	
	

}
