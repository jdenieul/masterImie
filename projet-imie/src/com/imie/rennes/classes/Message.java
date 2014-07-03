package com.imie.rennes.classes;

import java.util.GregorianCalendar;

public class Message {
	
	private int id;
	private String contenu;
	private GregorianCalendar date;
	private Utilisateur emetteur;
	private TypeMessage typeMessage;
	
	/**
	 * 
	 */
	public Message() {
		super();
	}
	/**
	 * @param id
	 * @param contenu
	 * @param date
	 * @param emetteur
	 * @param typeMessage
	 */
	public Message(int id, String contenu, GregorianCalendar date,
			Utilisateur emetteur, TypeMessage typeMessage) {
		super();
		this.id = id;
		this.contenu = contenu;
		this.date = date;
		this.emetteur = emetteur;
		this.typeMessage = typeMessage;
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
	 * @return the contenu
	 */
	public String getContenu() {
		return contenu;
	}
	/**
	 * @param contenu the contenu to set
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	/**
	 * @return the date
	 */
	public GregorianCalendar getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	/**
	 * @return the emetteur
	 */
	public Utilisateur getEmetteur() {
		return emetteur;
	}
	/**
	 * @param emetteur the emetteur to set
	 */
	public void setEmetteur(Utilisateur emetteur) {
		this.emetteur = emetteur;
	}
	/**
	 * @return the typeMessage
	 */
	public TypeMessage getTypeMessage() {
		return typeMessage;
	}
	/**
	 * @param typeMessage the typeMessage to set
	 */
	public void setTypeMessage(TypeMessage typeMessage) {
		this.typeMessage = typeMessage;
	}
	

}
