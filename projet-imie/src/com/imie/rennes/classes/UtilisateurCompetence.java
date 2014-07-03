package com.imie.rennes.classes;

public class UtilisateurCompetence {

	private Utilisateur utilisateur;
	private Competence competence;
	private int note;
	
	/**
	 * @param utilisateur
	 * @param competence
	 * @param note
	 */
	public UtilisateurCompetence(Utilisateur utilisateur,
			Competence competence, int note) {
		super();
		this.utilisateur = utilisateur;
		this.competence = competence;
		this.note = note;
	}
	
	/**
	 * 
	 */
	public UtilisateurCompetence() {
		super();
		
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
	/**
	 * @return the competence
	 */
	public Competence getCompetence() {
		return competence;
	}
	/**
	 * @param competence the competence to set
	 */
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
	/**
	 * @return the note
	 */
	public int getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(int note) {
		this.note = note;
	}	
	
}
