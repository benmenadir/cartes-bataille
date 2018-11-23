package org.cartes.bataille;

public class Carte implements Comparable<Carte>{
	private Couleur couleur;
	private String nom;
	private int valeur;
	
	public Carte(Couleur couleur, String nom, int valeur) {
		this.couleur = couleur;
		this.nom = nom;
		this.valeur = valeur;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public String getNom() {
		return nom;
	}

	public int getValeur() {
		return valeur;
	}

	@Override
	/**
	 * cf. javadoc
	 * doit retourner un nombre négatif si l'objet (this) est inférieur à l'objet comparé (c)
	 * 				  un nombre positif si l'objet (this) est supérieur à l'objet comparé (c)
	 * 				  zéro si les deux sont égaux
	 */
	public int compareTo(Carte c) {
		return valeur - c.valeur;
	}

	@Override
	public String toString() {
		return "Carte [couleur=" + couleur + ", nom=" + nom + ", valeur=" + valeur + "]";
	}
	

}
