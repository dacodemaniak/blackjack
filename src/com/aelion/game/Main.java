package com.aelion.game;

import java.util.ArrayList;

import com.aelion.game.blackjack.BlackJack;
import com.aelion.game.exceptions.NotUniquePlayerException;
import com.aelion.game.exceptions.PlayerExceedsMaxException;
import com.aelion.game.helpers.Randomize;
import com.aelion.game.helpers.ReadLine;
import com.aelion.game.models.Carte;
import com.aelion.game.models.Player;


/**
 * Exécute votre application...
 * 
 * @author Aelion
 *
 */
public class Main {
	// Tableau des joueurs
	private ArrayList<Player> players = new ArrayList();
	
	public static void main(String[] args) {
		// Appeler la méthode run à partir de la static "main"
		Main app = new Main(); // Instance de la classe Main
		app.run();

	}
	
	public void run() {
		// Définition des joueurs
		this.setPlayers();
		
		// Alimenter le sabot avec les cartes
		Sabot sabot = new Sabot();
		sabot.feed();
		System.out.println(sabot);
		
		// Tester les nombres aléatoires (entre 1 et 10)
		Randomize.setMax(13);
		for (int i = 0; i < 9; i++) {
			System.out.println("Nombre aléatoire : "  + Randomize.generer());
		}
		
		// Tirer aléatoirement des cartes dans le sabot jusqu'à ce que le total
		// atteigne au minimum 21 !
		int max = 21;
		int cumulPoint = 0;
		
		while (cumulPoint <= max) {
			int random = Randomize.generer();
			Carte carte = sabot.getCarte(random - 1);
			// Cumuler les points
			cumulPoint += carte.getValeur();
		}
		System.out.println("Cumul des points : " + cumulPoint);
		
		
		// Impossible d'instancier la classe Jeu => new Jeu() n'est pas autorisé
		// La classe BlackJack peut être instanciée
		BlackJack game = new BlackJack();
		try {
			game.addPlayer(this.players.get(0));
		} catch (NotUniquePlayerException e) {
			System.out.println("Le joueur est déjà dans la liste");
		} catch (PlayerExceedsMaxException e) {
			System.out.println("La capacité totale du jeu a été atteinte");
		}
		
		try {
			game.addPlayer(this.players.get(0));
		} catch (NotUniquePlayerException e) {
			System.out.println(e.getMessage());
		} catch (PlayerExceedsMaxException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			game.addPlayer(this.players.get(1));
		} catch (NotUniquePlayerException e) {
			System.out.println(e.getMessage());
		} catch (PlayerExceedsMaxException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			game.addPlayer(this.players.get(2));
		} catch (NotUniquePlayerException e) {
			System.out.println(e.getMessage());
		} catch (PlayerExceedsMaxException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(game);
		game.run();
		
	}
	
	private void setPlayers() {
		Player player = new Player(); // Nouveau joueur
		player.setNom("Aubert");
		player.setPrenom("Jean-Luc");
		player.setAge(54);
		
		Player player2 = new Player();
		player2.setNom("Dupont");
		player2.setPrenom("Antoine");
		player2.setAge(29);
		
		Player player3 = new Player();
		player3.setNom("Dupont");
		player3.setPrenom("Jean");
		player3.setAge(40);
		
		this.players.add(player);
		this.players.add(player2);
		this.players.add(player3);
	}
	
	// Déterminer le nombre de personnes ayant le même nom dans la liste des joueurs
	private Boolean homonymes() {
		Boolean homonymes = false;
		
		Player dupont1 = this.players.get(1);
		Player dupont2 = this.players.get(2);
		
		
		if (dupont1.getNom().equals(dupont2.getNom())) {
			homonymes = true;
		}
		
		return homonymes;
	}

}
