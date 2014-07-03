package com.imie.rennes.classes;

import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Offre {

	/** declarations variables **/
	
	private int id;
	private String titre;
	private String description;
	private String detailContact;
	private int duree;
	private GregorianCalendar dateDebut;
	private String detailsContact;	
	private String typePoste;
	private GregorianCalendar dateModification;
	private GregorianCalendar datePublication;
	private String emailContact;
	
	private ArrayList<Ville> villes;
	private ArrayList<Competence> competences;
	private TypeContrat typeContrat;
	
	/**
	 * @param id
	 * @param titre
	 * @param description
	 * @param detailContact
	 * @param duree
	 * @param dateDebut
	 * @param detailsContact
	 * @param typePoste
	 * @param dateModification
	 * @param datePublication
	 * @param emailContact
	 * @param villes
	 * @param competences
	 * @param typeContrat
	 */
	public Offre(int id, String titre, String description,
			String detailContact, int duree, GregorianCalendar dateDebut,
			String detailsContact, String typePoste,
			GregorianCalendar dateModification,
			GregorianCalendar datePublication, String emailContact,
			ArrayList<Ville> villes, ArrayList<Competence> competences,
			TypeContrat typeContrat) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.detailContact = detailContact;
		this.duree = duree;
		this.dateDebut = dateDebut;
		this.detailsContact = detailsContact;
		this.typePoste = typePoste;
		this.dateModification = dateModification;
		this.datePublication = datePublication;
		this.emailContact = emailContact;
		this.villes = villes;
		this.competences = competences;
		this.typeContrat = typeContrat;
	}
	/**
	 * 
	 */
	public Offre() {
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
	 * @return the detailContact
	 */
	public String getDetailContact() {
		return detailContact;
	}
	/**
	 * @param detailContact the detailContact to set
	 */
	public void setDetailContact(String detailContact) {
		this.detailContact = detailContact;
	}
	/**
	 * @return the duree
	 */
	public int getDuree() {
		return duree;
	}
	/**
	 * @param duree the duree to set
	 */
	public void setDuree(int duree) {
		this.duree = duree;
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
	 * @return the detailsContact
	 */
	public String getDetailsContact() {
		return detailsContact;
	}
	/**
	 * @param detailsContact the detailsContact to set
	 */
	public void setDetailsContact(String detailsContact) {
		this.detailsContact = detailsContact;
	}
	/**
	 * @return the typePoste
	 */
	public String getTypePoste() {
		return typePoste;
	}
	/**
	 * @param typePoste the typePoste to set
	 */
	public void setTypePoste(String typePoste) {
		this.typePoste = typePoste;
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
	 * @return the datePublication
	 */
	public GregorianCalendar getDatePublication() {
		return datePublication;
	}
	/**
	 * @param datePublication the datePublication to set
	 */
	public void setDatePublication(GregorianCalendar datePublication) {
		this.datePublication = datePublication;
	}
	/**
	 * @return the emailContact
	 */
	public String getEmailContact() {
		return emailContact;
	}
	/**
	 * @param emailContact the emailContact to set
	 */
	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}
	/**
	 * @return the villes
	 */
	public ArrayList<Ville> getVilles() {
		return villes;
	}
	/**
	 * @param villes the villes to set
	 */
	public void setVilles(ArrayList<Ville> villes) {
		this.villes = villes;
	}
	/**
	 * @return the competences
	 */
	public ArrayList<Competence> getCompetences() {
		return competences;
	}
	/**
	 * @param competences the competences to set
	 */
	public void setCompetences(ArrayList<Competence> competences) {
		this.competences = competences;
	}
	/**
	 * @return the typeContrat
	 */
	public TypeContrat getTypeContrat() {
		return typeContrat;
	}
	/**
	 * @param typeContrat the typeContrat to set
	 */
	public void setTypeContrat(TypeContrat typeContrat) {
		this.typeContrat = typeContrat;
	}

}
