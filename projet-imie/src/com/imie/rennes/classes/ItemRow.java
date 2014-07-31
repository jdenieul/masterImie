package com.imie.rennes.classes;

public class ItemRow {

	private int idItem;
	private String itemName;
	private String body;
	private String date;
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	
	/**
	 * Constructeur
	 * @param idItem
	 * @param itemName
	 * @param body
	 * @param date
	 */
	public ItemRow(int idItem, String itemName, String body, String date) {
		super();
		this.idItem = idItem;
		this.itemName = itemName;
		this.body = body;
		this.date = date;
	}
	
	
	
	
	
}
