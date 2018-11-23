package org.cartes.bataille;

public class MainBataille {

	public static void main(String[] args) {
		JeuDeBataille jeu = new JeuDeBataille();
		
		Joueur j1 = new Joueur("Gaston");
		Joueur j2 = new Joueur("Adèle");
		
		jeu.setJoueurs(j1, j2);
		jeu.distribuer();

		jeu.jouer();
		
		System.out.println("VAINQUEUR : "+jeu.getVainqueur().getNom());
		System.out.println(j1.getNbCartes());
		System.out.println(j2.getNbCartes());

	}

}
