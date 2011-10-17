package models.metier;

/**
 * @author mLedoujet
 * 
 */
import javax.persistence.Entity;

import play.db.jpa.Model;
 
@Entity
public class Plat extends Model{

	/**
	 * décrit le type du repas valeurs possibles : {entr�e,plat,dessert}
	 */
	public enum TypeRepas {
		entree, plat, dessert
	}

	protected TypeRepas typeRepas;

	/**
	 * décrit le type du repas valeurs possibles : {froid, chaud}
	 */
	public enum CuissonPlat {
		chaud, froid, glace
	}

	public CuissonPlat cuissonPlat;

	/**
	 * libell� du plat
	 */
	public String libellePlat;

	/**
	 * Recette du plat
	 */
	public Recette recette;

	
	// CONSTRUCTEURS
	/**
	 * constructeur vide
	 */
	public Plat() {
	}

	/**
	 * @param typeRepas
	 * @param cuissonPlat
	 * @param libellePlat
	 */
	public Plat(TypeRepas typeRepas, CuissonPlat cuissonPlat, String libellePlat) {
		this.typeRepas = typeRepas;
		this.cuissonPlat = cuissonPlat;
		this.libellePlat = libellePlat;
	}

	/**
	 * @param libellePlat
	 */
	public Plat(String libellePlat) {
		this.libellePlat = libellePlat;
	}

}