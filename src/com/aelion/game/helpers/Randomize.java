package com.aelion.game.helpers;

public class Randomize {
	private static int min = 1;
	private static int max = 10;
	
	public static void setMin(int min) {
		Randomize.min = min;
	}
	
	public static void setMax(int max) {
		Randomize.max = max;
	}
	
	public static int generer() {
		int range = Randomize.max - Randomize.min + 1;
		
		return (int)(Math.random() * range) + Randomize.min;
	}
}
