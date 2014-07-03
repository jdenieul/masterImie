package com.imie.rennes.classes;

import java.util.GregorianCalendar;

public class Enquete extends Message {

	private String url;

	/**
	 * 
	 */
	public Enquete() {
		super();

	}

	/**
	 * @param id
	 * @param contenu
	 * @param date
	 * @param emetteur
	 * @param typeMessage
	 */
	public Enquete(int id, String contenu, GregorianCalendar date,
			Utilisateur emetteur, TypeMessage typeMessage) {
		super(id, contenu, date, emetteur, typeMessage);
		
	}

	/**
	 * @param url
	 */
	public Enquete(String url) {
		super();
		this.url = url;
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
				
	
}
