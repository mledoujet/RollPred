package models.metier;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Aliment extends Model{

	/**
	 * nom de l'aliment
	 */
	public String nomAliment;

	/**
	 * fruit ou legume ou laitage
	 */
	public String typeAliment;

}
