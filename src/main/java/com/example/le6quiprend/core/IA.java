package com.example.le6quiprend.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IA extends AbstractJoueur {
    public IA() {
        super("IA");
    }

    /** Choix d'une carte au hasard dans la main de l'IA et la place dans attribu
     * @return la carte choisie
     */
    @Override
    public Carte choisirCarteAJouer() {
        Random random = new Random();
        int indexCarte = random.nextInt(getMain().size());
        Carte carte = getMain().get(indexCarte);
        this.carteChoisie = carte;
        return carte;
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
        // Sélection d'une rangée au hasard
        Random random = new Random();
        int indexRangee = random.nextInt(Plateau.nombreDeRangee);

        // Récupération des cartes de la rangée sélectionnée
        List<Carte> cartesARamasser = plateau.getRangee(indexRangee);

        // Ajout des cartes à la main de l'IA
        getMain().addAll(cartesARamasser);

        // Suppression des cartes de la rangée
        cartesARamasser.clear();

        System.out.println("L'IA a ramassé toutes les cartes de la rangée " + (indexRangee + 1));
    }
}
