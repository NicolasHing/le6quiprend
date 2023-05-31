package com.example.le6quiprend.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Joueur extends AbstractJoueur {
    public Joueur(String nom) {
        super(nom);
    }

    @Override
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
                cartesAJouer.add(main.get(numeroCarte - 1));
                plateau.ajouterCarte(indexRangee, main.get(numeroCarte - 1));
                main.remove(numeroCarte - 1);
            }
        }

        return cartesAJouer;
    }

    // Vérifie si la carte peut être placée dans une rangée en respectant la règle 1
    private boolean peutPlacerCarteDansRangee(int numeroCarte, Plateau plateau) {
        for (List<Carte> rangee : plateau.getRangees()) {
            if (rangee.isEmpty() || rangee.get(rangee.size() - 1).getValeur() < numeroCarte) {
                return true;
            }
        }
        return false;
    }

    // Trouve la rangée où la différence entre la dernière carte déposée et la nouvelle est la plus faible, en respectant la règle 2
    private int trouverRangeeOptimale(int numeroCarte, Plateau plateau) {
        int indexRangeeOptimale = -1;
        int differenceMin = Integer.MAX_VALUE;

        for (int i = 0; i < Plateau.nombreDeRangee; i++) {
            List<Carte> rangee = plateau.getRangee(i);

            if (rangee.isEmpty() || rangee.get(rangee.size() - 1).getValeur() < numeroCarte) {
                int difference = Math.abs(numeroCarte - rangee.get(rangee.size() - 1).getValeur());
                if (difference < differenceMin) {
                    differenceMin = difference;
                    indexRangeeOptimale = i;
                }
            }
        }
        return indexRangeeOptimale;
    }

    // Ramasse toutes les cartes d'une rangée de son choix, en respectant la règle 3
    private void ramasserCartesRangee(Plateau plateau) {
        System.out.println("Choisissez le numéro de la rangée à ramasser :");
        Scanner scanner = new Scanner(System.in);
        int numeroRangee = scanner.nextInt();

        List<Carte> rangee = plateau.getRangee(numeroRangee - 1);
        cartesEncaissees.addAll(rangee);
        rangee.clear();
    }
}
