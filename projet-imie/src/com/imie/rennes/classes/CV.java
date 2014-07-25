package com.imie.rennes.classes;

import android.media.Image;

public class CV {

	private int id;
	private String emplacement;
	private String dateCreation;

	/**
	 * 
	 */
	public CV() {
		super();
	}
	/**
	 * @param id
	 * @param emplacement
	 * @param dateCreation
	 */
	public CV(int id, String emplacement, String dateCreation) {
		super();
		this.id = id;
		this.emplacement = emplacement;
		this.dateCreation = dateCreation;
	}



	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public String getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
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

}
