package com.aelion.game.models;

/**
 * Classe abstraite pour définir toutes les caractéristiques communes de toutes les cartes
 * 
 * @author Aelion
 *
 */
public abstract class Carte {
	protected String nom;
	protected int valeur;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
}
