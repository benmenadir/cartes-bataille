package org.cartes.bataille;

import java.util.ArrayList;
import java.util.List;

public class CartesFactory {
	private static String[] noms = {"Deux","Trois","Quatre","Cinq","Six","Sept","Huit","Neuf",
									"Dix","Valet","Dame","Roi","As"};
	public static List<Carte> generer(){
		List<Carte> cartes = new ArrayList<>();
		for(Couleur couleur : Couleur.values()) {
			for(int i = 0 ; i<noms.length ; i++) {
				cartes.add(new Carte(couleur, noms[i], i));
			}
		}
		return cartes;
	}
}
