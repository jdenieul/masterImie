package com.imie.rennes.classes;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import android.content.Context;

import com.imie.rennes.imienetwork.R;

public class Utilisateur {
	
	/** declarations variables **/
	
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String login;
	private String password;	
	private String email;
	private String langue;	
	private int status;	
	private GregorianCalendar dateCreation;
	private GregorianCalendar dateModification;	
	private Context context;

	private Conversation[] mesConversations;
	private Evenement[] mesEvenements;
	private SecteurActivite[] mesSecteursActivite;
	private Promotion[] mesPromotions;
	private ReferenceChamps[] mesReferencesChamps;
	private ArrayList<Groupe> groupes;
	private Competence[] mesCompetences;
	
			

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param telephone
	 * @param login
	 * @param password
	 * @param email
	 * @param langue
	 * @param status
	 * @param dateCreation
	 * @param dateModification
	 * @param mesConversations
	 * @param mesEvenements
	 * @param mesSecteursActivite
	 * @param mesPromotions
	 * @param mesReferencesChamps
	 * @param groupes
	 * @param mesCompetences
	 */
	public Utilisateur(int id, String nom, String prenom, String adresse,
			String telephone, String login, String password, String email,
			String langue, int status, GregorianCalendar dateCreation,
			GregorianCalendar dateModification,
			Conversation[] mesConversations, Evenement[] mesEvenements,
			SecteurActivite[] mesSecteursActivite, Promotion[] mesPromotions,
			ReferenceChamps[] mesReferencesChamps, ArrayList<Groupe> groupes,
			Competence[] mesCompetences) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.login = login;
		this.password = password;
		this.email = email;
		this.langue = langue;
		this.status = status;
		this.dateCreation = dateCreation;
		this.dateModification = dateModification;
		this.mesConversations = mesConversations;
		this.mesEvenements = mesEvenements;
		this.mesSecteursActivite = mesSecteursActivite;
		this.mesPromotions = mesPromotions;
		this.mesReferencesChamps = mesReferencesChamps;
		this.groupes = groupes;
		this.mesCompetences = mesCompetences;
	}
	
	


	/**
	 * 
	 */
	public Utilisateur(Context context) {
		super();
		this.context = context;
		
		ArrayList<Module> modules = new ArrayList<Module>();
		/*modules.add(new Module(0, "Accueil", "ACCUE", null));
		modules.add(new Module(1, "Messagerie", "MESSA", null));
		modules.add(new Module(2, "Newsletter", "NEWS", null));
		modules.add(new Module(3, "Evenènement", "EVENT", null));
		modules.add(new Module(4, "Offre", "OFFRE", null));
		modules.add(new Module(5, "AdministrationCompte", "CPTE", null));
		modules.add(new Module(6, "Recherche", "SEARCH", null));
		modules.add(new Module(7, "Embauches", "EMB", null));
		modules.add(new Module(8, "Gestion CV", "GESCV", null));*/
		Groupe imie = new Groupe(0, this.context.getResources().getString(R.string.text_groupe_imie), null, modules);
		this.groupes = new ArrayList<Groupe>();
		this.groupes.add(imie);		
	}		
	
	


	public Utilisateur() {

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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}


	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}


	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}


	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}


	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the langue
	 */
	public String getLangue() {
		return langue;
	}


	/**
	 * @param langue the langue to set
	 */
	public void setLangue(String langue) {
		this.langue = langue;
	}


	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}


	/**
	 * @return the dateCreation
	 */
	public GregorianCalendar getDateCreation() {
		return dateCreation;
	}


	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(GregorianCalendar dateCreation) {
		this.dateCreation = dateCreation;
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
	 * @param groupes the groupes to set
	 */
	public void setGroupes(ArrayList<Groupe> groupes) {
		this.groupes = groupes;
	}


	public void setMesConversations(Conversation[] mesConversations) {
		this.mesConversations = mesConversations;
	}


	public Evenement[] getMesEvenements() {
		return mesEvenements;
	}


	public void setMesEvenements(Evenement[] mesEvenements) {
		this.mesEvenements = mesEvenements;
	}


	public SecteurActivite[] getMesSecteursActivite() {
		return mesSecteursActivite;
	}


	public void setMesSecteursActivite(SecteurActivite[] mesSecteursActivite) {
		this.mesSecteursActivite = mesSecteursActivite;
	}


	public Promotion[] getMesPromotions() {
		return mesPromotions;
	}


	public void setMesPromotions(Promotion[] mesPromotions) {
		this.mesPromotions = mesPromotions;
	}


	public ReferenceChamps[] getMesReferencesChamps() {
		return mesReferencesChamps;
	}


	public void setMesReferencesChamps(ReferenceChamps[] mesReferencesChamps) {
		this.mesReferencesChamps = mesReferencesChamps;
	}


	public ArrayList<Groupe> getGroupes() {
		return this.groupes;
	}


	public void setMesGroupe(ArrayList<Groupe> mesGroupes) {
		this.groupes = mesGroupes;
	}


	public Competence[] getMesCompetences() {
		return mesCompetences;
	}


	public void setMesCompetences(Competence[] mesCompetences) {
		this.mesCompetences = mesCompetences;
	}
	
	public void addGroupeUser(Groupe groupe){
		
		this.groupes.add(groupe);
	}
	

	public Conversation[] getMesConversations() {
		return mesConversations;				
		
	}	
	
	
	/**
	 * Serialise l'objet en string
	 * @return
	 */
	public String getSerializableString(){
		
		StringBuilder sb = new StringBuilder();
		String separator = "~";
		String separatorGroupe = "-";	
		
		sb.append(getId());
		sb.append(separator);
		sb.append(getNom());			
		
		for (Groupe groupeCourant : this.groupes) {
			
			sb.append(separatorGroupe);
			sb.append(groupeCourant.getLibelle());
			
		}
		
		return sb.toString();
	}
	
	/**
	 * R�cup�re l'objet utilisateur s�rialis�
	 * @param str
	 * @throws Exception
	 */
	public void setWithSerializableString(String str) throws Exception{
		
		String[] utilisateurStr = str.split("~");
		String nom = utilisateurStr[1];
	
		this.setNom(nom);
				
		// Parcours les propri�t�s de l'objet
		for (String groupeString : utilisateurStr) {
			
				if (groupeString.contains("-")){
					
					String[] groupesStr = groupeString.split("-");
					
					for (String groupe : groupesStr) {
						
						// Si le groupe n'est pas vide						
						if (!groupe.equals("null")){
							
							Groupe groupeUtil =  new Groupe();
							
							if (groupe.equals(this.context.getResources().getString(R.string.text_groupe_imie))){
								
								groupeUtil.setLibelle(groupe);
								
							}else if (groupe.equals(this.context.getResources().getString(R.string.text_groupe_eleve))){
																
								groupeUtil.setLibelle(groupe);
								
							}else{
																
								groupeUtil.setLibelle(groupe);
								
							}
							
							this.addGroupeUser(groupeUtil);
							
						}
					}
					
				}		
		}
	}	
}
