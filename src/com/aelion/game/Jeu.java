package com.aelion.game;

import java.util.ArrayList;

import com.aelion.game.exceptions.NotUniquePlayerException;
import com.aelion.game.exceptions.PlayerExceedsMaxException;
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
	 * @throws NotUniquePlayerException 
	 * @throws PlayerExceedsMaxException 
	 */
	public void addPlayer(Player player) throws NotUniquePlayerException, PlayerExceedsMaxException {
		if (players.size() < nbJoueurMax) {
			if (!this.playerAlreadyInList(player)) {
				players.add(player);
			} else {
				throw new NotUniquePlayerException(player.getNom() + " déjà dans la liste");
			}
			
		} else {
			throw new PlayerExceedsMaxException("La capacité max est de " + nbJoueurMax);
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
