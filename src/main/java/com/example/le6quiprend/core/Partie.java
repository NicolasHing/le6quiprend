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

            // Affichage du plateau
            plateau.afficherRangees();

            // Pour chaque joueur, affichage de la main et choix
            for (Joueur joueur : this.joueurs) {
                joueur.afficherMain();
                joueur.choisirCarteAJouer();
            }

            // Classer les joueurs par le numéro de carte
            trierJoueur();

            // Placer carte sur le plateau
            for (int i = 0; i < this.joueurs.size(); i++){
                Joueur joueur = this.joueurs.get(i);
                Carte carteChoisie = joueur.getCarteChoisie();
                if (carteChoisie.ComparerCarte(this.plateau.getRangees())){ // La carte posable sur l'une des rangées avec la règle 1
                    this.plateau.setRangees(joueur.poserCarte(this.plateau.getRangees(),carteChoisie.PlusPetiteDiff(this.plateau.getRangees())));
                }
                else { // La carte est trop petite
                    System.out.println(joueur.getNom() + ", la carte " + carteChoisie.afficherCarte() + " ne peut pas être posée.");
                    System.out.println("Récupère une des lignes suivantes :");
                    plateau.afficherRangees();
                    this.plateau.setRangees(joueur.poserCarte(this.plateau.getRangees(),joueur.choisirLigne()));
                }
            }




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
        int nombreDeCartesDepart = 10;
        for (Joueur joueur : joueurs) {
            for (int i = 0; i < nombreDeCartesDepart; i++) {
                Carte carte = pioche.tirerCarte();
                joueur.ajouterCarteInitial(carte);
            }
        }
    }

    public void trierJoueur(){
        int posMin;
        for (int i = 0; i < this.joueurs.size() - 1; i++){
            posMin = i;
            for (int j = i +1; j < this.joueurs.size(); j++){
                if (this.joueurs.get(j).getCarteChoisie().getValeur() < this.joueurs.get(posMin).getCarteChoisie().getValeur()){
                    posMin = j;
                }
            }
            Joueur temp = this.joueurs.get(posMin);
            this.joueurs.set(posMin, this.joueurs.get(i));
            this.joueurs.set(i,temp);
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

    private void afficherScoreFinal() {
        System.out.println("----- Score final -----");
        for (Joueur joueur : joueurs) {
            joueur.afficherScore();
        }
        System.out.println("-----------------------");
    }



}
