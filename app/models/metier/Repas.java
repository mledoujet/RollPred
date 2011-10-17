package models.metier;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Repas extends Model{

	/** */
	public Plat entree;

	/** */
	public Plat platPrincipal;

	/** */
	public Plat dessert;

	/** */
	public Aliment fruit;

	/* constructeurs */
	/**
	 * 
	 * @param entree
	 * @param platPrincipal
	 * @param dessert
	 * @param fruit
	 */
	public Repas(Plat entree, Plat platPrincipal, Plat dessert, Aliment fruit) {
		super();
		this.entree = entree;
		this.platPrincipal = platPrincipal;
		this.dessert = dessert;
		this.fruit = fruit;
	}

	/**
	 * 
	 * @param entree
	 * @param platPrincipal
	 * @param dessert
	 */
	public Repas(String entree, String platPrincipal, String dessert) {
		super();
		this.entree = new Plat(entree);
		this.platPrincipal = new Plat(platPrincipal);
		this.dessert = new Plat(dessert);
	}

	/**
		 * 
		 */
	public Repas() {
		super();
	}

	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("<html><center>").append(entree.toString())
				.append("<br> ------ <br>").append(platPrincipal.toString())
				.append("<br> ------ <br>").append(dessert.toString())
				.append("</center></html>");

		return sb.toString();
	}

}
