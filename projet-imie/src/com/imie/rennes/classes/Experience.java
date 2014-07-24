package com.imie.rennes.classes;

import java.util.GregorianCalendar;

public class Experience {

	private int id;
	private String libelle;
	private String description;
	private GregorianCalendar dateDebut;
	private GregorianCalendar dateFin;
	private Utilisateur	utilisateurCreateur;
	
	/**
	 * 
	 * @param id
	 * @param libelle
	 * @param description
	 * @param dateDebut
	 * @param dateFin
	 * @param utilisateurCreateur
	 */
	public Experience(int id, String libelle, String description,
			GregorianCalendar dateDebut, GregorianCalendar dateFin,
			Utilisateur utilisateurCreateur) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.utilisateurCreateur = utilisateurCreateur;
	}

	/**
	 * 
	 */
	public Experience() {
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the dateDebut
	 */
	public GregorianCalendar getDateDebut() {
		return dateDebut;
	}
	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(GregorianCalendar dateDebut) {
		this.dateDebut = dateDebut;
	}
	/**
	 * @return the dateFin
	 */
	public GregorianCalendar getDateFin() {
		return dateFin;
	}
	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(GregorianCalendar dateFin) {
		this.dateFin = dateFin;
	}
	
	public Utilisateur getUtilisateurCreateur() {
		return utilisateurCreateur;
	}

	public void setUtilisateurCreateur(Utilisateur utilisateurCreateur) {
		this.utilisateurCreateur = utilisateurCreateur;
	}	
		
}
