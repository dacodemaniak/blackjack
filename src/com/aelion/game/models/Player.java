package com.aelion.game.models;

public class Player {
	private String nom;
	private String prenom;
	private int age;
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Nom : " + this.nom + "\n" + 
				"Prénom : " + this.prenom + "\n" +
				"Age : " + this.age;
	}
	
	
	
}
