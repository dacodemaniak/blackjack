package com.aelion.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.aelion.game.models.Player;
import com.aelion.game.repository.PlayerRepository;

public class TestDb {

	public static void main(String[] args) throws SQLException {
		Connection connection = MySQLConnect.getInstance();
		
		if (connection != null) {
			System.out.println("MySQL connection was successfull");
		}
		
		
		
		// Tester la méthode findAll du Repository de l'entité Player
		PlayerRepository playerRepository = new PlayerRepository();
		ArrayList<Player> players = (ArrayList<Player>) playerRepository.findAll();
		
		
		
		// Boucler sur le ArrayList pour afficher les players
		for (Player player : players) {
			System.out.println(player.getId() + " " + player.getNom() + " " + player.getPrenom() + " " + player.getAge());
		}
		
		
		// Test find avec un id valide
		Optional<Player> oPlayer = playerRepository.find(1);
		if (oPlayer.isPresent()) {
			Player player = oPlayer.get();
			System.out.println(player.getId() + " " + player.getNom() + " " + player.getPrenom() + " " + player.getAge());
		}
		
		oPlayer = playerRepository.find(23);
		if (oPlayer.isEmpty()) {
			System.out.println("No player with id 23");
		}
		
		
		// Tester l'insertion
		Player player = new Player();
		player.setNom("Rolland");
		player.setPrenom("Xavier");
		player.setAge(45);
		
		player = playerRepository.add(player);
		
		System.out.println(player.getId() + " " + player.getNom() + " " + player.getPrenom() + " " + player.getAge());
		
		MySQLConnect.close();
	}

}
