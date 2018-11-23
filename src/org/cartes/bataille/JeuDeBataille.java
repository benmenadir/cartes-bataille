package org.cartes.bataille;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JeuDeBataille {
	private List<Carte> cartes;
	private Joueur[] joueurs = new Joueur[2];

	public JeuDeBataille() {
		cartes = CartesFactory.generer();
	}

	public void setJoueurs(Joueur j1, Joueur j2) {
		joueurs[0] = j1;
		joueurs[1] = j2;
	}

	public void distribuer() {
		Collections.shuffle(cartes);
		for (int i = 0; i < cartes.size(); i += 2) {
			joueurs[0].add(cartes.get(i));
			joueurs[1].add(cartes.get(i + 1));
		}
	}

	public void jouer() {
		List<Carte> donne = new ArrayList<>();
		while (true) {
			if (joueurs[0].getNbCartes()==0 || joueurs[1].getNbCartes()==0)
				return;

			Carte c0 = joueurs[0].poserUneCarte();
			Carte c1 = joueurs[1].poserUneCarte();
			donne.add(c0);
			donne.add(c1);

			System.out.format("%s pose %s et %s pose %s\n", joueurs[0].getNom(), c0.getNom(), joueurs[1].getNom(),c1.getNom());
			
			if (c0.compareTo(c1) == 0) {
				System.out.println("\n>>> BATAILLE\n");
				if (joueurs[0].getNbCartes()==0 || joueurs[1].getNbCartes()==0)
					return;
				donne.add(joueurs[0].poserUneCarte());
				donne.add(joueurs[1].poserUneCarte());
			} else if (c0.compareTo(c1) > 0) {
				joueurs[0].prend(donne);
				System.out.format("%s ramasse les cartes (nb de cartes : %d)\n", joueurs[0].getNom(),joueurs[0].getNbCartes());
				donne.clear();
			} else {
				joueurs[1].prend(donne);
				System.out.format("%s ramasse les cartes (nb de cartes : %d)\n", joueurs[1].getNom(),joueurs[1].getNbCartes());
				donne.clear();
			}
		}
	}
	
	public Joueur getVainqueur() {
		if(joueurs[0].getNbCartes()==0)
			return joueurs[1];
		if(joueurs[1].getNbCartes()==0)
			return joueurs[0];
		return null;
	}

	public List<Carte> getCartes() {
		return cartes;
	}

}
