package com.example.le6quiprend.core;

import java.util.ArrayList;
import java.util.List;

public class Partie {
    private List<Joueur> joueurs;
    private Plateau plateau;
    private Pioche pioche;

    public Partie(List<String> nomsJoueurs) {
        // Initialisation des joueurs
        joueurs = new ArrayList<>();
        for (String nom : nomsJoueurs) {
            joueurs.add(new Joueur(nom));
        }

        // Initialisation du plateau
        plateau = new Plateau();

        // Initialisation de la pioche
        pioche = new Pioche();

        // Initialisation Rangée
        for (int i = 0; i < Plateau.nombreDeRangee; i++) {
            Carte carte = pioche.tirerCarte();
            plateau.ajouterCarte(i, carte);
        }

    }

    public void jouer() {
        // Distribution des cartes initiales aux joueurs
        distribuerCartesInitiales();

        // Tour de jeu
        int tour = 1;
        while (!partieTerminee()) {
            System.out.println("----- Tour " + tour + " -----");

            // Affichage de l'état du jeu
            afficherEtatJeu();

            // Chaque joueur joue une carte
            List<Carte> cartesPourLeTour = new ArrayList<Carte>();
            for (Joueur joueur : joueurs) {
                Carte carteAJouer = joueur.choisirCarteAJouer();
                cartesPourLeTour.add(carteAJouer);
            }

            // Placer les cartes sur le plateau
            plateau.placerCartes(cartesPourLeTour);

            // Actualisation du plateau et des scores
            plateau.actualiserRangees();
            actualiserScores();

            // Passage au tour suivant
            tour++;
        }

        // Affichage du score final
        afficherScoreFinal();
    }

    private void distribuerCartesInitiales() {
        for (Joueur joueur : joueurs) {
            for (int i = 0; i < Plateau.nombreCarteParRangee; i++) {
                Carte carte = pioche.tirerCarte();
                joueur.ajouterCarteInitial(carte);
            }
        }
    }

    private boolean partieTerminee() {
        for (Joueur joueur : joueurs) {
            if (joueur.getMain().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private void actualiserScores() {
        for (Joueur joueur : joueurs) {
            joueur.calculerScore();
        }
    }

    private void afficherEtatJeu() {
        for (Joueur joueur : joueurs) {
            joueur.afficherMain();
        }
        plateau.afficherRangees();
    }

    private void afficherScoreFinal() {
        System.out.println("----- Score final -----");
        for (Joueur joueur : joueurs) {
            joueur.afficherScore();
        }
        System.out.println("-----------------------");
    }
}
