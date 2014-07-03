package com.imie.rennes.classes;

public class UtilisateurProprietesEtendues {

	private Utilisateur utilisateur;
	private ProprieteEtendue proprieteEtendue;
	private String valeur;
	
	/**
	 * 
	 */
	public UtilisateurProprietesEtendues() {
		super();
	}

	/**
	 * @param utilisateur
	 * @param proprieteEtendue
	 * @param valeur
	 */
	public UtilisateurProprietesEtendues(Utilisateur utilisateur,
			ProprieteEtendue proprieteEtendue, String valeur) {
		super();
		this.utilisateur = utilisateur;
		this.proprieteEtendue = proprieteEtendue;
		this.valeur = valeur;
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
	 * @return the proprieteEtendue
	 */
	public ProprieteEtendue getProprieteEtendue() {
		return proprieteEtendue;
	}

	/**
	 * @param proprieteEtendue the proprieteEtendue to set
	 */
	public void setProprieteEtendue(ProprieteEtendue proprieteEtendue) {
		this.proprieteEtendue = proprieteEtendue;
	}

	/**
	 * @return the valeur
	 */
	public String getValeur() {
		return valeur;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}				
	
}
