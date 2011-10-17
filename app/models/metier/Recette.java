package models.metier;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.Entity;

@Entity
public class Recette extends Plat {

	/**
	 * Nombre de Personne pour la recette
	 */
	public int nombrePersonne;

	/**
	 * Liste des ingr�dients n�c�ssaires � la recette
	 */
	public ArrayList<Ingredient> listeDesIngredients;

	/**
	 * texte du mode operatoire de l'etape
	 */
	public String modeOperatoire;

	/**
	 * dur�e de la cuisson
	 */
	public int dureeCuisson;

	/**
	 * temp�rature de cuisson
	 */
	public int tempCuisson;

	/**
	 * type de Cuisson (Four, bain marie, micor ondes, poele)
	 */
	public String typeCuisson;

	/**
	 * Constructeur vide
	 */
	public Recette() {
	}

	/**
	 * Constructeur complet avec touts les attributs
	 * 
	 * @param nombrePersonne
	 * @param plat
	 * @param listeDesIngredients
	 * @param modeOperatoire
	 * @param dureeCuisson
	 * @param tempCuisson
	 * @param typeCuisson
	 */
	public Recette(int nombrePersonne, String libellePlat,
			ArrayList<Ingredient> listeDesIngredients, String modeOperatoire,
			int dureeCuisson, int tempCuisson, String typeCuisson,
			TypeRepas typeRepas, CuissonPlat cuissonPlat) {
		this.nombrePersonne = nombrePersonne;
		this.libellePlat = libellePlat;
		this.listeDesIngredients = listeDesIngredients;
		this.modeOperatoire = modeOperatoire;
		this.dureeCuisson = dureeCuisson;
		this.tempCuisson = tempCuisson;
		this.typeCuisson = typeCuisson;
		this.typeRepas = typeRepas;
		this.cuissonPlat = cuissonPlat;
	}

	/**
	 * @description Constructeur sans liste des ingr�dients
	 * @param nombrePersonne
	 * @param libellePlat
	 * @param modeOperatoire
	 * @param dureeCuisson
	 * @param tempCuisson
	 * @param typeCuisson
	 */
	public Recette(int nombrePersonne, String libellePlat,
			String modeOperatoire, int dureeCuisson, int tempCuisson,
			String typeCuisson) {
		this.nombrePersonne = nombrePersonne;
		this.libellePlat = libellePlat;
		this.modeOperatoire = modeOperatoire;
		this.dureeCuisson = dureeCuisson;
		this.tempCuisson = tempCuisson;
		this.typeCuisson = typeCuisson;
	}

	/* methodes */
	@Override
	public String toString() {
		return MessageFormat.format("{0}{1}:{2}{3}{4}{5}", libellePlat,
				modeOperatoire, nombrePersonne, tempCuisson);
	}

	/**
	 * 
	 * @param recette
	 */
	public ArrayList<Ingredient> parseIngredients(String strListeIngredients) {

		String lineSeparator = System.getProperty("line.separator");
		strListeIngredients = strListeIngredients.concat(lineSeparator);
		ArrayList<Ingredient> listeResultat = new ArrayList<Ingredient>();
		Ingredient ingredient = null;
		String ligne = null;

		StringBuffer nom = new StringBuffer();
		int quantite = 0;
		String unite = null;
		String[] splitResult = null;

		// on parcours le String en d�pilant la 1ere ligne une fois trait�e.
		while ((strListeIngredients.substring(0,
				strListeIngredients.indexOf(lineSeparator)) != null)
				&& strListeIngredients.indexOf(lineSeparator) < strListeIngredients
						.lastIndexOf(lineSeparator)) {

			ligne = strListeIngredients.substring(0,
					strListeIngredients.indexOf(lineSeparator));
			System.out.println(ligne.toString());
			nom.setLength(0);
			unite = "";

			splitResult = ligne.split(" ");

			for (int i = 0; i < splitResult.length; i++) {
				try {
					if (Integer.parseInt(splitResult[i]) > 0) {
						quantite = Integer.parseInt(splitResult[i]);
					}
				} catch (NumberFormatException ex) {

					if (Arrays.asList(Ingredient.valeursUnite).contains(
							splitResult[i])) {
						unite = splitResult[i];
					} else {
						nom.append(splitResult[i]).append(" ");
					}
				}
			}
			ingredient = new Ingredient(nom.toString(), quantite, unite);
			listeResultat.add(ingredient);
			strListeIngredients = strListeIngredients
					.substring(strListeIngredients.indexOf(lineSeparator) + 1);
		}
		return listeResultat;

		// 1 par cours du texte
		// a chquae ligne,
		// on cherche le digit qui est la quantit�
		// on cherche l'unit� (a partir d'une liste enum�r�e)
		// le reste est le nom de l'ingr�dient
	}

}
