package com.aelion.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton de connexion à la base de données
 * -	Constructeur privé
 * -	Méthode statique pour récupérer une instance
 * 
 * @author Aelion
 *
 */
public class MySQLConnect {
	/**
	 * Stocke de manière statique l'instance de connexion au serveur
	 */
	private static Connection instance = null;
	
	private MySQLConnect() {
		System.out.println("Constructeur de MySQLConnect");
		try {
			MySQLConnect.instance = DriverManager.getConnection(  
					"jdbc:mysql://127.0.0.1:3306/players", 
					"root", 
					"root"
			);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Access denied for : root on 127.0.0.1 " + e.getMessage());
		}  
	}
	
	public static Connection getInstance() {
		if (MySQLConnect.instance == null) {
			new MySQLConnect();
		}
		
		return MySQLConnect.instance;
	}
	
	public static void close() {
		try {
			MySQLConnect.instance.close();
			MySQLConnect.instance = null;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
