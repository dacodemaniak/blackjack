package com.aelion.game;

import com.aelion.game.helpers.Randomize;
import com.aelion.game.models.Carte;

public class TirageCarte {
	private Sabot sabot;
	
	/**
	 * Couplage fort : le sabot sera détruit après utilisation de la classe TirageCarte
	 */
	public TirageCarte() {
		this.sabot = new Sabot();
		sabot.feed();
	}
	
	/**
	 * Injection de dépendances : Sabot devient une dépendance de TirageCarte
	 * Couplage faible : le Sabot continuera à exister même si le TirageCarte disparaît
	 * 
	 * @param sabot
	 */
	public TirageCarte(Sabot sabot) { // Constructeur de classe Java
		this.sabot = sabot;
	}
	
	public Carte tirerCarte() {
		Randomize.setMax(this.sabot.getSize());
		int indice = Randomize.generer();
		
		return this.sabot.getCarte(indice - 1);
	}
}
