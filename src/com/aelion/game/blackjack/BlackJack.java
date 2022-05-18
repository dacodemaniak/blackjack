package com.aelion.game.blackjack;

import com.aelion.game.Jeu;
import com.aelion.game.Jouer;
import com.aelion.game.Sabot;
import com.aelion.game.helpers.ReadLine;

public final class BlackJack extends Jeu {
	/**
	 * MAX devient une constante de classe.
	 * 	- Le MAX ne pourra pas être modifié, il sera toujours égal à 21
	 */
	public final int MAX = 21;
	
	private ReadLine reader = new ReadLine();
	
	/**
	 * Constructeur de la classe concrète BlackJack
	 * - Initialise le comportement de la classe
	 */
	public BlackJack() {
		this.nbJoueurMax = 2;
		this.reader.init();
	}
	

	@Override
	public void run() {
		// Récupérer un sabot pour jouer
		Sabot sabot = new Sabot();
		
		// Le joueur doit jouer
		Jouer joueurJouer = new Jouer(this.players.get(0), this);
		joueurJouer.setReader(reader);
		joueurJouer.carte();
		
		if (joueurJouer.getPoint() == this.MAX) {
			System.out.println(this.players.get(0).getNom() + " gagne la partie");
		} else {
			Jouer banqueJouer = new Jouer(this);
			banqueJouer.setReader(reader);
			
			banqueJouer.carte();
			
			// On fait les comptes
			if (banqueJouer.getPoint() > this.MAX) {
				System.out.println(this.players.get(0).getNom() + " gagne la partie");
			} else {
				if (joueurJouer.getPoint() > banqueJouer.getPoint()) {
					System.out.println(this.players.get(0).getNom() + " gagne la partie");
				} else {
					System.out.println("La banque gagne la partie");
				}
			}
		}
		this.reader.end();
	}
}
