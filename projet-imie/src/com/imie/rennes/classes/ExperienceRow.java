package com.imie.rennes.classes;

/**
 * Gestion des rows concernant la swypeListView Expériences dans le profil
 */

public class ExperienceRow {

	private String nom;
	private String description;
	private String dateDebut;
	private String dateFin;
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
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
	public String getDateDebut() {
		return dateDebut;
	}
	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	/**
	 * @return the dateFin
	 */
	public String getDateFin() {
		return dateFin;
	}
	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	/**
	 * @param nom
	 * @param description
	 * @param dateDebut
	 * @param dateFin
	 */
	public ExperienceRow(String nom, String description, String dateDebut,
			String dateFin) {
		super();
		this.nom = nom;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
}
