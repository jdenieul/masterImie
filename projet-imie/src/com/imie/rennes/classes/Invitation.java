package com.imie.rennes.classes;

import java.util.GregorianCalendar;

public class Invitation extends Message {

	private Evenement evenement;

	/**
	 * @param evenement
	 */
	public Invitation(Evenement evenement) {
		super();
		this.evenement = evenement;
	}

	/**
	 * 
	 */
	public Invitation() {
		super();
	}

	/**
	 * @param id
	 * @param contenu
	 * @param date
	 * @param emetteur
	 * @param typeMessage
	 */
	public Invitation(int id, String contenu, GregorianCalendar date,
			Utilisateur emetteur, TypeMessage typeMessage) {
		super(id, contenu, date, emetteur, typeMessage);
	}

	/**
	 * @return the evenement
	 */
	public Evenement getEvenement() {
		return evenement;
	}

	/**
	 * @param evenement the evenement to set
	 */
	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}	
	
}
