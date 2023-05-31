package com.example.le6quiprend.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Création du plateau de jeu
        Plateau plateau = new Plateau();

        // Création des joueurs
        Joueur joueur1 = new Joueur("Joueur 1");
        Joueur joueur2 = new Joueur("Joueur 2");

        // Distribuer les cartes aux joueurs
        List<Carte> cartes = creerCartes();
        distribuerCartes(cartes, joueur1, joueur2);

        // Début du jeu
        while (!plateau.estPlateauComplet()) {
            // Tour du joueur 1
            System.out.println("Tour du joueur : " + joueur1.getNom());
            List<Carte> cartesAJouer = joueur1.choisirCartesAJouer(plateau);
            System.out.println("Le joueur a joué les cartes : " + cartesAJouer);

            // Tour du joueur 2
            System.out.println("Tour du joueur : " + joueur2.getNom());
            cartesAJouer = joueur2.choisirCartesAJouer(plateau);
            System.out.println("Le joueur a joué les cartes : " + cartesAJouer);
        }

        // Fin du jeu
        int totalTetesDeBoeufJoueur1 = joueur1.totalTetesDeBoeuf();
        int totalTetesDeBoeufJoueur2 = joueur2.totalTetesDeBoeuf();

        System.out.println("Jeu terminé !");
        System.out.println("Total de têtes de bœuf du Joueur 1 : " + totalTetesDeBoeufJoueur1);
        System.out.println("Total de têtes de bœuf du Joueur 2 : " + totalTetesDeBoeufJoueur2);
        System.out.println("Le gagnant est : " + (totalTetesDeBoeufJoueur1 < totalTetesDeBoeufJoueur2 ? joueur1.getNom() : joueur2.getNom()));
    }

    // Crée les cartes du jeu
    private static List<Carte> creerCartes() {
        List<Carte> cartes = new ArrayList<>();
        for (int valeur = 1; valeur <= 104; valeur++) {
            cartes.add(new Carte(valeur));
        }
        return cartes;
    }

    // Distribue les cartes aux joueurs
    private static void distribuerCartes(List<Carte> cartes, Joueur joueur1, Joueur joueur2) {
        for (int i = 0; i < Plateau.nombreCarteParRangee; i++) {
            joueur1.ajouterCarteMain(cartes.remove(0));
            joueur2.ajouterCarteMain(cartes.remove(0));
        }
    }
}
