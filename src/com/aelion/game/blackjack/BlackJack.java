package com.aelion.game.blackjack;

import com.aelion.game.Jeu;

public final class BlackJack extends Jeu {
	
	public BlackJack() {
		this.nbJoueurMax = 2;
	}
	
	@Override
	public void run() {
		System.out.println("Le jeu de blackjack peut démarrer");
	}
}
