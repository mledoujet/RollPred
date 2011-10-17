/**
 * 
 */
package test;

import junit.framework.Assert;
import models.metier.Recette;
import models.tools.XMLTools;

import org.junit.Test;

import play.test.UnitTest;

/**
 * @author mLedoujet
 * 
 */
public class XMLToolsTU extends UnitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * sauvegarde une etape et la recharge
	 */
	@Test
	public void saveAndChargeEtape() {
		try {
			Recette receipe = new Recette(4, "Omelette", "Melanger les oeufs",
					40, 100, "poele");
			XMLTools.encodeToFile(receipe, "receipe.xml");

			Recette recetteDecoded = (Recette) XMLTools
					.decodeToFile("receipe.xml");

			Assert.assertEquals(recetteDecoded.libellePlat,
					receipe.libellePlat);
			Assert.assertEquals(recetteDecoded.modeOperatoire,
					receipe.modeOperatoire);
			Assert.assertEquals(recetteDecoded.dureeCuisson,
					receipe.dureeCuisson);
			Assert.assertEquals(recetteDecoded.typeCuisson,
					receipe.typeCuisson);
			Assert.assertEquals(recetteDecoded.tempCuisson,
					receipe.tempCuisson);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * sauvegarde une session et la recharge
	 */
	@Test
	public void saveAndChargeSession() {
		try {
			// TODO

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
