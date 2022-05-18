package com.aelion.game;

import java.util.ArrayList;

import com.aelion.game.models.Player;

public abstract class Jeu {
	protected ArrayList<Player> players = new ArrayList();
	
	protected int nbJoueurMin = 1;
	protected int nbJoueurMax = 1;
	
	/**
	 * Ajoute un joueur à un jeu donné :
	 * 	- On ne peut pas avoir deux fois le même joueur,
	 *  - La liste ne peut pas contenir plus de nbJoueurMax joueurs
	 * @param player
	 */
	public void addPlayer(Player player) {
		if (players.size() < nbJoueurMax) {
			if (!this.playerAlreadyInList(player)) {
				players.add(player);
			} else {
				// Problème, le joueur est déjà dans la liste
			}
			
		} else {
			// Problème, on dépasse la capacité de joueurs pour le jeu
		}
	}
	
	@Override
	public String toString() {
		return this.players.size() + " joueurs dans la liste";
	}
	
	private Boolean playerAlreadyInList(Player player) {
		Boolean alreadyInList = false;
		
		for (Player playerInList : players) {
			if (playerInList == player) {
				alreadyInList = true;
			}
		}
		
		return alreadyInList;
	}
}
