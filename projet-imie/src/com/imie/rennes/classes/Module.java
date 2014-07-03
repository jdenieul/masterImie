package com.imie.rennes.classes;

import java.util.ArrayList;

public class Module {

	private int id;
	private String libelle;
	private String code;
	private ArrayList<Groupe> groupes;
	
	/**
	 * @param id
	 * @param libelle
	 * @param code
	 * @param groupes
	 */
	public Module(int id, String libelle, String code, ArrayList<Groupe> groupes) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.code = code;
		this.groupes = groupes;
	}
	/**
	 * 
	 */
	public Module() {
		super();
		this.groupes= new ArrayList<Groupe>();
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the groupes
	 */
	public ArrayList<Groupe> getGroupes() {
		return groupes;
	}
	/**
	 * @param groupes the groupes to set
	 */
	public void setGroupes(ArrayList<Groupe> groupes) {
		this.groupes = groupes;
	}
			
}
