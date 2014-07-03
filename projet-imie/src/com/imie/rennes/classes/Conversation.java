package com.imie.rennes.classes;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Conversation {
	
	private int id;
	private String titre;
	private GregorianCalendar date;
	private ArrayList<Utilisateur> mesUtilisateurs;
	
	/**
	 * 
	 */
	public Conversation() {
		super();
		this.mesUtilisateurs = new ArrayList<Utilisateur>();
	}
	
	/**
	 * @param id
	 * @param titre
	 * @param date
	 * @param mesUtilisateurs
	 */
	public Conversation(int id, String titre, GregorianCalendar date,
			ArrayList<Utilisateur> mesUtilisateurs) {
		super();
		this.id = id;
		this.titre = titre;
		this.date = date;
		this.mesUtilisateurs = mesUtilisateurs;
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
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
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
	 * @return the mesUtilisateurs
	 */
	public ArrayList<Utilisateur> getMesUtilisateurs() {
		return mesUtilisateurs;
	}
	/**
	 * @param mesUtilisateurs the mesUtilisateurs to set
	 */
	public void setMesUtilisateurs(ArrayList<Utilisateur> mesUtilisateurs) {
		this.mesUtilisateurs = mesUtilisateurs;
	}
	
}
