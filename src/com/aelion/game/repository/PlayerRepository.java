package com.aelion.game.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.aelion.database.MySQLConnect;
import com.aelion.game.models.Player;

public class PlayerRepository implements Repository<Player> {

	@Override
	public Player add(Player entity) throws SQLException {
		// INSERT INTO player (nom, prenom, age) VALUES ('', '', 0);
		String query = "INSERT INTO player (nom, prenom, age) VALUES (?, ?, ?);";
		
		PreparedStatement statement = MySQLConnect.getInstance().prepareStatement(query);
		
		statement.setString(1, entity.getNom());
		statement.setString(2, entity.getPrenom());
		statement.setInt(3, entity.getAge());
		
		statement.executeUpdate(); // La donnée doit être enregistrée
		
		int nextId = this.getLastId();
		
		// Mettre à jour l'entité
		entity.setId(nextId);
		
		
		return entity;
	}

	@Override
	public Optional<Player> find(int id) throws SQLException {
		String query = "SELECT id, nom, prenom, age FROM player WHERE id = " + id;
		
		Statement statement = MySQLConnect.getInstance().createStatement();
		
		ResultSet rs = statement.executeQuery(query);
		
		if (rs.next()) {
			Player player = new Player();
			
			// Alimenter l'objet Player avec les données de la base de données
			player.setId(rs.getInt("id"));
			player.setNom(rs.getString("nom"));
			player.setPrenom(rs.getString("prenom"));
			player.setAge(rs.getInt("age"));
			
			return Optional.of(player);
		}
		
		return Optional.empty();
	}

	@Override
	public List<Player> findAll() throws SQLException {
		// SELECT id, nom, prenom, age FROM player;
		String query = "SELECT id, nom, prenom, age FROM player;";
		
		// Statement : phrase SQL qui doit être envoyée vers la base de données
		Statement statement = MySQLConnect.getInstance().createStatement();
		
		// Envoyer la requête vers le serveur de bases de données
		ResultSet resultSet = statement.executeQuery(query);
		
		ArrayList<Player> players = new ArrayList();
		
		// Boucler sur le ResultSet pour créer les objets Player
		while (resultSet.next()) {
			// Instance d'un objet Player
			Player player = new Player();
			
			// Alimenter l'objet Player avec les données de la base de données
			player.setId(resultSet.getInt("id"));
			player.setNom(resultSet.getString("nom"));
			player.setPrenom(resultSet.getString("prenom"));
			player.setAge(resultSet.getInt("age"));
			
			// Ajouter l'objet Player à la liste des Players
			players.add(player);
		}
		return players;
	}
	
	private int getLastId() throws SQLException {
		String query = "SELECT id FROM player ORDER BY id DESC LIMIT 1;";
		
		Statement statement = MySQLConnect.getInstance().createStatement();
		
		ResultSet rs = statement.executeQuery(query);
		
		rs.next();
		
		return rs.getInt("id");
	}

}
