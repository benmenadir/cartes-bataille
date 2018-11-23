package org.cartes.bataille;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Joueur {
	private String nom;
	private Deque<Carte> cartes = new ArrayDeque<>();
	
	public Joueur(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void add(Carte carte) {
		cartes.push(carte);
	}
	
	public List<Carte> getCartes(){
		return new ArrayList<>(cartes);
	}

	public Carte poserUneCarte() {
		return cartes.pop();
	}
		
	public int getNbCartes() {
		return cartes.size();
	}

	public void prend(List<Carte> cartes) {
		for(Carte c : cartes) {
			this.cartes.addLast(c);
		}
	}

}
