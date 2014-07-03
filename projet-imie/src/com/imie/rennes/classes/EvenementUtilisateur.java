package com.imie.rennes.classes;

public class EvenementUtilisateur {

	private Evenement evenement;
	private Utilisateur utilisateur;
	private Boolean participe;
	
	/**
	 * @param evenement
	 * @param utilisateur
	 * @param participe
	 */
	public EvenementUtilisateur(Evenement evenement, Utilisateur utilisateur,
			Boolean participe) {
		super();
		this.evenement = evenement;
		this.utilisateur = utilisateur;
		this.participe = participe;
	}
	
	/**
	 * 
	 */
	public EvenementUtilisateur() {
		super();
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
	 * @return the participe
	 */
	public Boolean getParticipe() {
		return participe;
	}
	/**
	 * @param participe the participe to set
	 */
	public void setParticipe(Boolean participe) {
		this.participe = participe;
	}		
	
}
