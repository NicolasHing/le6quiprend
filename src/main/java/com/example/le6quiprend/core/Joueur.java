package com.example.le6quiprend.core;

import com.example.le6quiprend.core.Carte;
import com.example.le6quiprend.core.Plateau;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Joueur extends AbstractJoueur {

    public Joueur(String nom) {
        super(nom);
    }

    public void afficherMain() {
        System.out.println("Main de " + getNom() + ":");
        for (int i = 0; i < getMain().size(); i++) {
            Carte carte = getMain().get(i);
            System.out.println((i + 1) + ". " + carte.getValeur() + " (" + carte.getTetesDeBoeuf() + ")");
        }
    }

    public void ajouterCarteInitial(Carte carte) {
        getMain().add(carte);
    }
    /*
    public void jouerCarte(Plateau plateau) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez le numéro de la carte à jouer :");
        int numeroCarte = scanner.nextInt();

        List<Carte> cartesAJouer = choisirCartesAJouer(plateau);

        if (!cartesAJouer.isEmpty()) {
            System.out.println(getNom() + " joue la carte " + cartesAJouer.get(0).getValeur());
        }
    }


    public List<Carte> choisirCartesAJouer(Plateau plateau) {
        Scanner scanner = new Scanner(System.in);
        List<Carte> cartesAJouer = new ArrayList<>();

        System.out.println("Choisissez le numéro de la carte à jouer :");
        int numeroCarte = scanner.nextInt();

        // Règle 4 : Si la carte ne peut être placée dans aucune rangée, ramasser toutes les cartes d'une rangée de son choix
        if (!peutPlacerCarteDansRangee(numeroCarte, plateau)) {
            System.out.println("La carte ne peut pas être placée dans une rangée. Ramassez toutes les cartes d'une rangée de votre choix.");
            ramasserCartesRangee(plateau);
        } else {
            // Règle 2 : Trouver la rangée où la différence entre la dernière carte déposée et la nouvelle est la plus faible
            int indexRangee = trouverRangeeOptimale(numeroCarte, plateau);
            if (indexRangee == -1) {
                System.out.println("Aucune rangée n'est disponible pour placer la carte. Ramassez toutes les cartes d'une rangée de votre choix.");
                ramasserCartesRangee(plateau);
            } else {
                // Ajouter la carte à la rangée
                cartesAJouer.add(getMain().get(numeroCarte - 1));
                plateau.ajouterCarte(indexRangee, getMain().get(numeroCarte - 1));
                getMain().remove(numeroCarte - 1);
            }
        }

        return cartesAJouer;
    }

     */

    /**
     * Demande à l'utilisateur l'indice de la carte qu'il souhaite jouer
     * @return Carte choisie
     */
    @Override
    public Carte choisirCarteAJouer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez le numéro de la carte à jouer :");
        int numeroCarte = scanner.nextInt()-1;
        Carte carte = this.main.remove(numeroCarte);
        this.carteChoisie = carte;
        return carte;
    }

    /**
     * Pose la carte à la rangée numeroLigneAModifier, récupère les cartes si la rangée est pleine
     * @param ancienneRangees
     * @param numeroLigneAModifier
     * @return
     */
    public List<List<Carte>> poserCarte(List<List<Carte>> ancienneRangees, int numeroLigneAModifier){
        List<List<Carte>> newRangees = new ArrayList<>(ancienneRangees);

        for (int i = 0; i < ancienneRangees.size(); i++){ // passe par chaque ligne du tableau.
            List<Carte> rangee = ancienneRangees.get(i);

            if (i == numeroLigneAModifier) { // On est sur la ligne à modifier
                // soit on pose la carte facilement car il y a la place et c'est plus grand
                if (rangee.size() + 1 < 6 && this.carteChoisie.getValeur() > rangee.get(rangee.size() - 1).getValeur()){
                    rangee.add(this.carteChoisie);
                    newRangees.set(i, rangee);
                } else { // Soit, il n'y a pas la place,
                    // On récupère les cartes
                    for (Carte carte : rangee) {
                        this.cartesEncaissees.add(carte);
                    }
                    // On pose
                    List<Carte> nouvelleRangee = new ArrayList<>();
                    nouvelleRangee.add(this.carteChoisie);
                    newRangees.set(i, nouvelleRangee);
                }
            } else { // On est sur une ligne à NE PAS modifier.
                newRangees.set(i, rangee);
            }
        }
        this.carteChoisie = null;
        return newRangees;
    }

    /**
     * Le joueur choisi la ligne
     */
    public int choisirLigne(){
        Scanner joueur = new Scanner(System.in);
        int numLigne = joueur.nextInt();
        numLigne = numLigne - 1;

        return numLigne;
    }


}
