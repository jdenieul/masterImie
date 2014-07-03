package com.imie.rennes.classes;

public class Document {
	
	private int id;
	private String libelle;
	private String url;
	private int statut;
	
	/**
	 * @param id
	 * @param libelle
	 * @param url
	 * @param statut
	 */
	public Document(int id, String libelle, String url, int statut) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.url = url;
		this.statut = statut;
	}

	/**
	 * 
	 */
	public Document() {
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

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the statut
	 */
	public int getStatut() {
		return statut;
	}

	/**
	 * @param statut the statut to set
	 */
	public void setStatut(int statut) {
		this.statut = statut;
	}
	
}
