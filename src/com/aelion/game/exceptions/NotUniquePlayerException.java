package com.aelion.game.exceptions;

public class NotUniquePlayerException extends Exception {

	public NotUniquePlayerException(String string) {
		super(string); // Appelle explicitement le constructeur de la classe parente
	}
}
