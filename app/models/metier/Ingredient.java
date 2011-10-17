package models.metier;

import javax.persistence.Entity;

import play.db.jpa.Model;
 
@Entity
public class Ingredient extends Model{

	public String nom;

	public int quantite;

	public String unite;

	public static final String[] valeursUnite = { "g", "gr", "grammes",
			"a café", "cuillère à café", "c à soupe", "cuillère à soupe",
			"pincée", "sachet", "cl", "L", "litre", "ml" };

	/**
	 * Constructeur.
	 * 
	 * @param nom
	 * @param quantite
	 * @param unite
	 */
	public Ingredient(String nom, int quantite, String unite) {
		super();
		this.nom = nom;
		this.quantite = quantite;
		this.unite = unite;
	}

	
}
