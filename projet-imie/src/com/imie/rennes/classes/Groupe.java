package com.imie.rennes.classes;

import java.util.ArrayList;

public class Groupe {
	
	private int id;
	private String libelle;
	private ArrayList<ProprieteEtendue> proprietesEtendues;
	private ArrayList<Module> modules;
	
	
	public Groupe() {
		super();
		this.proprietesEtendues = new ArrayList<ProprieteEtendue>();
		this.modules = new ArrayList<Module>();
	}
	
	/**
	 * @param id
	 * @param libelle
	 * @param proprietesEtendues
	 * @param modules
	 */
	public Groupe(int id, String libelle,
			ArrayList<ProprieteEtendue> proprietesEtendues,
			ArrayList<Module> modules) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.proprietesEtendues = proprietesEtendues;
		this.modules = modules;
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
	 * @return the proprietesEtendues
	 */
	public ArrayList<ProprieteEtendue> getProprietesEtendues() {
		return proprietesEtendues;
	}

	/**
	 * @param proprietesEtendues the proprietesEtendues to set
	 */
	public void setProprietesEtendues(ArrayList<ProprieteEtendue> proprietesEtendues) {
		this.proprietesEtendues = proprietesEtendues;
	}

	/**
	 * @return the modules
	 */
	public ArrayList<Module> getModules() {
		return modules;
	}

	/**
	 * @param modules the modules to set
	 */
	public void setModules(ArrayList<Module> modules) {
		this.modules = modules;
	}	
	
}
