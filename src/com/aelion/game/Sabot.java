package com.aelion.game;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import com.aelion.game.models.Carte;
import com.aelion.game.models.Club;
import com.aelion.game.models.Diamond;
import com.aelion.game.models.Heart;
import com.aelion.game.models.Spade;

public class Sabot {
	private ArrayList<Carte> sabot = new ArrayList();
	
	public void feed() {
		
		for (int j = 0; j < 4; j++) {
			Class<?> carteClass = null; // Class est une classe qui permet d'accéder aux données d'une classe
			
			if (j == 0) {
				carteClass = Heart.class;
			} else if (j == 1) {
				carteClass = Spade.class;
			} else if (j == 2) {
				carteClass = Club.class;
			} else if (j == 3) {
				carteClass = Diamond.class;
			}
			
			for (int i = 1; i < 14; i++) {
				
				Carte carte = this.getInstance(carteClass);
				
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

	}

	public void feedOldSchool() {
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 14; j++) {
				Carte carte = null;
				
				// Choisir la couleur
				if (j == 0) {
					carte = new Heart();
				} else if (j == 1) {
					carte = new Spade();
				} else if ( j == 2) {
					carte = new Diamond();
				} else {
					carte = new Club();
				}
				
				// Définir le noms et valeurs
				if (j == 1) {
					carte.setNom("As");
				} else if (j == 11) {
					carte.setNom("Valet");
				} else if (j == 12) {
					carte.setNom("Dame");
				} else if (j == 13) {
					carte.setNom("Roi");
				} else {
					carte.setNom(String.valueOf(i));
				}
				carte.setValeur(j);
				
				this.sabot.add(carte);
				
			}
		}
	}
	
	
	public Carte getCarte(int carteIndice) {
		return this.sabot.get(carteIndice);
	}
	
	public int getValeurCarte(int carteIndice) {
		return this.sabot.get(carteIndice).getValeur();
	}
	
	public int getSize() {
		return this.sabot.size();
	}
	
	@Override
	public String toString() {
		String output = "";
		
		for (Carte carte : this.sabot) {
			output += carte + "\n";
 		}
		
		return output;
	}
	
	/**
	 * Permet de créer dynamiquement une instance de classe (créer un objet)
	 * @param className
	 * @return
	 */
	private Carte getInstance(Class<?> className) {
		try {
			return (Carte) className.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			return null;
		}
	}
	
}
