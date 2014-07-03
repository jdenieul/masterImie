package com.imie.rennes.classes;

import java.util.ArrayList;

public class TypeMessage {
	
	private int id;
	private String libelle;
	private ArrayList<Message> messages;
	
	
	/**
	 * 
	 */
	public TypeMessage() {
		super();
		this.messages = new ArrayList<Message>();
	}


	/**
	 * @param id
	 * @param libelle
	 * @param messages
	 */
	public TypeMessage(int id, String libelle, ArrayList<Message> messages) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.messages = messages;
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
	 * @return the messages
	 */
	public ArrayList<Message> getMessages() {
		return messages;
	}


	/**
	 * @param messages the messages to set
	 */
	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}				

}
