package com.imie.rennes.classes;

import java.util.List;

public class Offres {
	
	private List<Offre> listOffre;

	public Offres(List<Offre> listOffre) {
		super();
		this.listOffre = listOffre;
	}

	public Offres() {
		super();
	}

	public final List<Offre> getListOffre() {
		return listOffre;
	}

	public final void setListOffre(List<Offre> listOffre) {
		this.listOffre = listOffre;
	}
	
	

}
