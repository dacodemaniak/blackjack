package com.aelion.game.helpers;

import java.util.Scanner;

public class ReadLine {
	private Scanner scanner;
	
	// Tableau avec les réponses possibles pour un booléen
	private static String[] boolResponses = {"o", "n", "oui", "non"};
	
	public void init() {
		try {
			this.scanner = new Scanner(System.in);
		} catch (Exception e) {
			System.out.println("Impossible d'instancier le scanner " + e.getMessage());
		}
	}
	
	public void end() {
		if (this.scanner != null) {
			this.scanner.close();
		}
	}
	
	public String readLine(String promptMessage) {
		System.out.print(promptMessage);
		
		return this.scanner.nextLine();
	}
	
	public Boolean readBool(String promptMessage) {
		Boolean correctResponse = false;
		String prompt = promptMessage + " (Oui / Non) : ";
		String userResponse = "";
		while (!correctResponse) {
			userResponse = this.readLine(prompt);
			correctResponse = this.inBoolResponses(userResponse);
		}
		
		return this.isPositive(userResponse);
	}
	
	private Boolean inBoolResponses(String userResponse) {
		Boolean inBoolResponse = false;
		
		for (int i = 0; i < ReadLine.boolResponses.length; i++) {
			if (userResponse.toLowerCase().equals(ReadLine.boolResponses[i])) {
				inBoolResponse = true;
			}
		}
		return inBoolResponse;
	}
	
	private Boolean isPositive(String userResponse) {
		if (userResponse.toLowerCase().equals("o") || userResponse.toLowerCase().equals("oui")) {
			return true;
		}
		
		return false;
	}
}
