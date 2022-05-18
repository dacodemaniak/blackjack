package com.aelion.game;

import com.aelion.game.helpers.ReadLine;
import com.aelion.game.models.Carte;
import com.aelion.game.models.Player;
import com.aelion.game.blackjack.*;

public class Jouer {
	private Player player;
	private Jeu game;
	
	private int cumulPoint = 0;
	private TirageCarte tirage = new TirageCarte();
	
	private int tours = 0;
	
	private ReadLine reader;
	
	public Jouer(Jeu game) {
		this.game = game;
	}
	
	public Jouer(Player player, Jeu game) {
		this.player = player;
		this.game = game;
	}

	public void setReader(ReadLine reader) {
		this.reader = reader;
		
		this.firstCarte();
	}
	

	
	public void carte() {
		String message = (this.player != null) ? this.player.getNom() : "Banque";
		
		/*
		if (this.player != null) {
			message = this.player.getNom();
		} else {
			message = "Banque";
		}
		*/
		
		message += " Tirez une autre carte";
		
		// On boucle sur la demande utilisateur
		while (reader.readBool(message)) {
			Carte newCarte = tirage.tirerCarte();
			cumulPoint += newCarte.getValeur();
			System.out.println("Carte " + newCarte.getNom() + " Total : " + cumulPoint);
			// Il est nécessaire de "caster" l'attribut "game" en "BlackJack"
			// pour pouvoir accéder à l'attribut MAX spécifique
			if (cumulPoint > ((BlackJack) game).MAX) {
				break;
			}
		}
	}
	
	public int getPoint() {
		return this.cumulPoint;
	}
	
	private void firstCarte() {
		Carte carte = tirage.tirerCarte();
		cumulPoint += carte.getValeur();
		System.out.println("Carte " + carte.getNom() + " Total : " + cumulPoint);
	}
	
}
