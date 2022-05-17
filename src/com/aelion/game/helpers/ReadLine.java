package com.aelion.game.helpers;

import java.util.Scanner;

public class ReadLine {
	private Scanner scanner;
	
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
}
