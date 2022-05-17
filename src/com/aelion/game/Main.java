package com.aelion.game;

import java.util.ArrayList;

import com.aelion.game.helpers.Randomize;
import com.aelion.game.helpers.ReadLine;
import com.aelion.game.models.Carte;
import com.aelion.game.models.Player;

public class Main {
	// Tableau des joueurs
	private ArrayList<Player> players = new ArrayList();
	
	public static void main(String[] args) {
		// Définition des variables
		String content = new String("Bonjour Jean-Luc");
		
		int age = 54;
		
		Boolean estMajeur = age >= 18;
		
		double moyenne = 10.5;
		
		String[] names = { "Jean-Luc", "Elyasin", "Sambou", "Lucas" };
		
		content = names[1]; // Récupère la chaîne à l'indice 1 => Elyasin
		
		if (estMajeur) {
			System.out.println(content + " tu es majeur");
		} else {
			System.out.println(content + " Tu n'es pas majeur");
		}
		
		// Boucles standard for()
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		
		// Boucle >= Java 8 for :
		for (String name : names) {
			System.out.println("For : " + name);
		}
		
		// Lister seulement les prénoms dont la longueur du prénom est >= 6
		for (String name : names) {
			if (name.length() >= 6) {
				System.out.println(name + "(" + name.length() + ")");
			}
		}
		
		// While... boucle conditionnelle
		int i = 6;
		while (i < names.length) {
			System.out.println("while : " + names[i]);
			i++;
		}
		
		// Appeler la méthode run à partir de la static "main"
		Main app = new Main(); // Instance de la classe Main
		app.run();

	}
	
	public void run() {
		// Définition des joueurs
		this.setPlayers();
		
		System.out.println("Nombre de joueurs : " + this.players.size());
		
		// Tester la comparaison de chaînes
		if (this.homonymes()) {
			System.out.println("Les deux Dupont sont homonymes");
		} else {
			System.out.println("Les deux Dupont sont différents");
		}
		
		for(Player player : this.players) {
			System.out.println(player);
		}
		
		// Afficher la moyenne des âges des joueurs
		double moyenne = 0.;
		int cumulAge = 0;
		for (Player player : players) {
			cumulAge += player.getAge();
			// cumulAge = cumulAge + player.getAge();
		}
		moyenne = cumulAge / players.size();
		System.out.println("Moyenne des âges : " + moyenne);
		
		// Map / Reduce (>= Java 8) : Approche fonctionnelle
		moyenne = this.players.stream()
			.mapToDouble(player -> player.getAge())
			.reduce(0, (cumul, x) -> cumul + x / players.size());
		System.out.println("Moyenne (map/reduce) : " + moyenne);
		
		cumulAge = 0;
		// Boucle for classique
		for (int i = 0; i < players.size(); i++) {
			cumulAge = cumulAge + players.get(i).getAge();
		}
		System.out.println("Moyenne classique : " + cumulAge / players.size());
		
		// Afficher le joueur le plus âgé
		Player plusAge = players.get(0);
		for (int i = 1; i < players.size(); i++) {
			Player player = players.get(i);
			if (player.getAge() > plusAge.getAge()) {
				plusAge = player;
			}
		}
		System.out.println("Le plus agé : " + plusAge);
		
		// Afficher le joueur le plus jeune
		Player plusJeune = players.get(0);
		for (int i = 1; i < players.size(); i++) {
			Player player = players.get(i);
			if (player.getAge() < plusJeune.getAge()) {
				plusJeune = player;
			}
		}
		System.out.println("Le plus jeune : " + plusJeune);
		
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
		
		// Tester la classe ReadLine
		ReadLine readLine = new ReadLine();
		readLine.init();
		String nom = readLine.readLine("Quel est votre nom ?");
		
		System.out.println("Bonjour " + nom);
		
		Boolean result = readLine.readBool("Etes-vous majeur ?");
		if (result) {
			System.out.println("Okay, tu es majeur");
		} else {
			System.out.println("Tu n'es pas majeur");
		}
		
		
		// Demander à l'utilisateur après avoir tiré une première carte
		// s'il veut en tirer une autre
		// s'il répond oui, on tire une autre carte et on redemande
		// sauf si le total après tirage dépasse les 21
		
		// Lire une première carte
		cumulPoint = 0; // Réinitialise le cumul des points
		int random = Randomize.generer();
		Carte carte = sabot.getCarte(random - 1);
		cumulPoint += carte.getValeur();
		System.out.println("Carte " + carte.getNom() + " Total : " + cumulPoint);
		
		// On boucle sur la demande utilisateur
		while (readLine.readBool("Voulez-vous une autre carte ?")) {
			Carte newCarte = sabot.getCarte(Randomize.generer() - 1);
			cumulPoint += newCarte.getValeur();
			System.out.println("Carte " + newCarte.getNom() + " Total : " + cumulPoint);
			if (cumulPoint > max) {
				break;
			}
		}
		System.out.println("Joueur : " + cumulPoint);
		
		if (cumulPoint < max) {
			// Le joueur a fini, le casino peut jouer...
			int cumulPointBank = 0;
			Carte carteInitiale = sabot.getCarte(Randomize.generer() - 1);
			cumulPointBank += carteInitiale.getValeur();
			System.out.println("Carte " + carteInitiale.getNom() + " Total : " + cumulPointBank);
			
			// On boucle sur la demande utilisateur
			while (readLine.readBool("Banque, voulez-vous une autre carte ?")) {
				Carte newCarte = sabot.getCarte(Randomize.generer() - 1);
				cumulPointBank += newCarte.getValeur();
				System.out.println("Carte " + newCarte.getNom() + " Total : " + cumulPointBank);
				if (cumulPointBank > max) {
					break;
				}
			}
			// Résultat...
			if (cumulPointBank > max) {
				System.out.println("La banque perd !");
			} else {
				if (cumulPoint > cumulPointBank) {
					System.out.println("Le joueur remporte la mise !");
				} else if (cumulPoint < cumulPointBank) {
					System.out.println("La banque remporte la mise !");
				} else {
					System.out.println("La mise est annulée");
				}
			}
		} else {
			if (cumulPoint == max) {
				System.out.println("Le joueur remporte la mise !");
			} else {
				System.out.println("Le joueur perd !");
			}
		}

		

		readLine.end();
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
