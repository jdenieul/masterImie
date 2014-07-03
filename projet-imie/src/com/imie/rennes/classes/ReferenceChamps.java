package com.imie.rennes.classes;

public class ReferenceChamps {
	
	private int id;
	private String libelle;
	
	/**
	 * @param id
	 * @param libelle
	 */
	public ReferenceChamps(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	/**
	 * 
	 */
	public ReferenceChamps() {
		super();
		// TODO Auto-generated constructor stub
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
	
}
