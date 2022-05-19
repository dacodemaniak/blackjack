package com.aelion.database;

import java.sql.Connection;

public class TestDatabase {

	public static void main(String[] args) {
		Connection connection = MySQLConnect.getInstance();
		
		if (connection != null) {
			System.out.println("Connection was successfully");
			MySQLConnect.close();
		}

	}

}
