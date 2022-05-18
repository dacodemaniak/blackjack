package com.aelion.game;

import com.aelion.game.models.Carte;
import com.aelion.game.models.Diamond;
import com.aelion.game.models.Heart;
import com.aelion.game.models.Spade;

public class TestCarte {

	public static void main(String[] args) {
		
		// Instancie un sabot
		Sabot sabot = new Sabot();
		
		sabot.feed();
		
		TirageCarte tirage = new TirageCarte(sabot);
		
		int expectedCards = 52;
		
		if (sabot.getSize() != expectedCards) {
			System.out.println("Something went wrong while feeding");
		} else {
			System.out.println("It should have " + expectedCards + " cards : success");
		}

		// Dump cards
		System.out.println(sabot);
		
		// Tirer une carte
		Carte carte = tirage.tirerCarte();
		
		if (carte instanceof Heart) {
			System.out.println("Coeur tiré : " + carte);
		} else if (carte instanceof Spade) {
			System.out.println("Pique tiré " + carte);
		} else if (carte instanceof Diamond) {
			System.out.println("Carreau tiré " + carte);
		} else {
			System.out.println("Trèfle tiré " + carte);
		}
	}

}
