package test;

import java.util.ArrayList;

import junit.framework.Assert;
import models.metier.Ingredient;
import models.metier.Recette;

import org.junit.Test;

import play.test.UnitTest;

public class RecetteTestU extends UnitTest {
		
	/**
	 * 
	 */
	 @Test
	public void parseIngredientsTest(){
		
		String strRecette="- 120 g de chocolat noir + 8 carrés (5 g) à réserver\r\n"+
			"- 120 g de chocolat noir + 8 carrés (5 g) à réserver \r\n"+
			"- 3 oeufs\r\n"+
			"- 80 g de sucre\r\n"+
			"- 35 g de beurre\r\n"+
			"- 1 cuillère à soupe de farine\r\n"+
			"- 3 gros oeufs\r\n"+
			"- 100 g de sucre roux\r\n"+
			"- 1 sachet de sucre vanillée\r\n"+
			"- 250 g de mascarpone\r\n"+
			"- 24 biscuits à la cuillère\r\n"+
			"- 1/2 litre de café noir non sucré\r\n"+
			"- 30 g de poudre de cacao amer\r\n"+
			"- 6 belles pommes (des Canada par exemple)\r\n"+
			"- 150 g de cassonade\r\n"+
			"- 150 g de farine de bl�\r\n"+
			"- 125 g de beurre (le sortir 1/2 heure avant de commencer la recette)\r\n"+
			"- 1 petite cuillère de cannelle en poudre\r\n"+
			"- 1 sachet de sucre vanill�\r\n"+
			"- le jus d'un citron\r\n\r\n"+
			"P�TE SABL�E:\r\n"+
			"- 250 g de farine\r\n"+
			"- 125 g de beurre\r\n"+
			"- 70 g de sucre\r\n"+
			"- 2 jaunes d'oeufs\r\n"+
			"- 5 cl d'eau";

		Recette recette = new Recette();
		ArrayList<Ingredient> ingredients=recette.parseIngredients(strRecette);
		
		Assert.assertNotNull(ingredients);
		Assert.assertEquals(ingredients.size(), 26);
		
	}

}
