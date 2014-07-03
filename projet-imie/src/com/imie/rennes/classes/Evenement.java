package com.imie.rennes.classes;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Evenement {
	
	private int id;
	private String libelle;
	private String description;
	private GregorianCalendar dateDebut;
	private GregorianCalendar dateFin;
	private int status;
	private GregorianCalendar dateCreation;
	private GregorianCalendar dateModification;
	private ArrayList<Invitation> invitations;
	private Utilisateur utilisateur;
	
	
	/**
	 * 
	 */
	public Evenement() {
		super();
		
	}
	/**
	 * @param id
	 * @param libelle
	 * @param description
	 * @param dateDebut
	 * @param dateFin
	 * @param status
	 * @param dateCreation
	 * @param dateModification
	 * @param invitations
	 * @param utilisateur
	 */
	public Evenement(int id, String libelle, String description,
			GregorianCalendar dateDebut, GregorianCalendar dateFin, int status,
			GregorianCalendar dateCreation, GregorianCalendar dateModification,
			ArrayList<Invitation> invitations, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.status = status;
		this.dateCreation = dateCreation;
		this.dateModification = dateModification;
		this.invitations = invitations;
		this.utilisateur = utilisateur;
	}
	/**
	 * @return the dateCreation
	 */
	public GregorianCalendar getDateCreation() {
		return dateCreation;
	}
	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(GregorianCalendar dateCreation) {
		this.dateCreation = dateCreation;
	}
	/**
	 * @return the dateModification
	 */
	public GregorianCalendar getDateModification() {
		return dateModification;
	}
	/**
	 * @param dateModification the dateModification to set
	 */
	public void setDateModification(GregorianCalendar dateModification) {
		this.dateModification = dateModification;
	}
	/**
	 * @return the invitations
	 */
	public ArrayList<Invitation> getInvitations() {
		return invitations;
	}
	/**
	 * @param invitations the invitations to set
	 */
	public void setInvitations(ArrayList<Invitation> invitations) {
		this.invitations = invitations;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public GregorianCalendar getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(GregorianCalendar dateDebut) {
		this.dateDebut = dateDebut;
	}
	public GregorianCalendar getDateFin() {
		return dateFin;
	}
	public void setDateFin(GregorianCalendar dateFin) {
		this.dateFin = dateFin;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
		
}
