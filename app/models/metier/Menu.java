package models.metier;

import java.util.ArrayList;

import javax.persistence.Entity;

import play.db.jpa.Model;
 
@Entity
public class Menu extends Model{

	public ArrayList<Repas> menusDelaSemaine;

	public int nombrePersonne;

	public int nbJours;
	
	public int nbRepas;

	// TODO : ajout periodicit�

	// CONSTRUCTEUR
	/**
	 * Constructeur de classe
	 * 
	 * @param etapes
	 * @param nombrePersonne
	 */
	public Menu(ArrayList<Repas> menusDelaSemaine,
			int nombrePersonne) {
		this.menusDelaSemaine = menusDelaSemaine;
		this.nombrePersonne = nombrePersonne;
	}

	/**
	 * Constructeur sans dimension
	 * 
	 * @param Plats
	 */
	public Menu(ArrayList<Repas> menusDelaSemaine) {
		this.menusDelaSemaine = menusDelaSemaine;
	}

	/**
	 * Constructeur vide
	 */
	public Menu() {
		this.menusDelaSemaine = new ArrayList<Repas>();
	}

	// METHODES
	public void ajouterRepas(Repas repas) {
		this.menusDelaSemaine.add(repas);
	}

	public void supprimerTouslesPlats() {
		this.menusDelaSemaine.clear();
	}

	public void supprimerPlat(Repas menu) {
		if (this.menusDelaSemaine.contains(menu)) {
			this.menusDelaSemaine.remove(menu);
		}
	}

	public int getNombrePlats() {
		return this.menusDelaSemaine.size();
	}


}
