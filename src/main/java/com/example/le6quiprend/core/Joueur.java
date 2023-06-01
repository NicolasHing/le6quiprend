package com.example.le6quiprend.core;

import java.util.List;
import java.util.Scanner;

public class Joueur extends AbstractJoueur {

    public Joueur(String nom) {
        super(nom);
    }

    /**
     * Affiche la main dans la console : "Main de nomJoueur : 1. valeur(TdB)\n ..."
     */
    @Override
    public void afficherMain() {
        System.out.println("Main de " + getNom() + ":");
        for (int i = 0; i < getMain().size(); i++) {
            Carte carte = getMain().get(i);
            System.out.println((i + 1) + ". " + carte.afficherCarte());
        }
    }

    /**
     * Demande à l'utilisateur l'indice de la carte qu'il souhaite jouer, et place la carte dans l'attribut
     */
    @Override
    public void choisirCarteAJouer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez le numéro de la carte à jouer :");
        int numeroCarte = scanner.nextInt()-1;
        this.carteChoisie = this.main.remove(numeroCarte);
    }




    /**
     * Le joueur choisi la ligne
     */
    @Override
    public int choisirLigne(List<List<Carte>> rangees){
        Scanner joueur = new Scanner(System.in);
        int numLigne = joueur.nextInt();
        numLigne = numLigne - 1;

        return numLigne;
    }


}
