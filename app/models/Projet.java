package models;

import java.io.File;

import models.tools.XMLTools;

import play.db.jpa.Model;

public class Projet extends Model{

	/** Nom du projet.*/
	public String nomProjet=null;
	
	/** Chemin vers le fichier de sauvegarde du projet */
	public File cheminProjet = null;
	
	/**
	 * Constructeur
	 * @param nomProjet
	 * @param cheminProjet
	 */
	public Projet(String nomProjet, File cheminProjet) {
		this.nomProjet = nomProjet;
		this.cheminProjet = cheminProjet;
	}
	
	/**Cosntructeur vide. */
	public Projet() {}
	
	//METHODES
	public void sauvegarder(){
		//TODO sauvegarder le projet
		//XMLTools.encodeToFile(object, fileName)
	}
	
	public void charger(File fProjet){
		//TODO sauvegarder le projet
		//XMLTools.decodeToFile(fileName)
	}
	
}
