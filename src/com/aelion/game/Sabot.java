package com.aelion.game;

import java.util.ArrayList;

import com.aelion.game.models.Carte;

public class Sabot {
	private ArrayList<Carte> sabot = new ArrayList();
	
	public void feed() {
		
		for (int i = 1; i < 14; i++) {
			
			Carte carte = new Carte();
			
			if (i == 1) {
				carte.setNom("As");
			} else if (i == 11) {
				carte.setNom("Valet");
			} else if (i == 12) {
				carte.setNom("Dame");
			} else if (i == 13) {
				carte.setNom("Roi");
			} else {
				carte.setNom(String.valueOf(i));
			}
			carte.setValeur(i);
			
			this.sabot.add(carte);
		}
	}

	@Override
	public String toString() {
		String output = "";
		
		for (Carte carte : this.sabot) {
			output += carte.getNom() + " (" + carte.getValeur() + ")\n";
 		}
		
		return output;
	}
	
	
}
