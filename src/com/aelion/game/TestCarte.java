package com.aelion.game;

public class TestCarte {

	public static void main(String[] args) {
		// Instancie un sabot
		Sabot sabot = new Sabot();
		
		sabot.feed();
		
		int expectedCards = 52;
		
		if (sabot.getSize() != expectedCards) {
			System.out.println("Something went wrong while feeding");
		} else {
			System.out.println("It should have " + expectedCards + " cards : success");
		}

		// Dump cards
		System.out.println(sabot);
	}

}
