package com.example.le6quiprend.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IA extends AbstractJoueur {
    public IA() {
        super("IA");
    }

    @Override
    public List<Carte> choisirCartesAJouer(Plateau plateau) {
        List<Carte> cartesAJouer = new ArrayList<>();

        // Choix d'une carte au hasard dans la main de l'IA
        Random random = new Random();
        int indexCarte = random.nextInt(getMain().size());
        Carte carte = getMain().get(indexCarte);

        // Règle 4 : Si la carte ne peut être placée dans aucune rangée, ramasser toutes les cartes d'une rangée de son choix
        if (!peutPlacerCarteDansRangee(carte.getValeur(), plateau)) {
            System.out.println("La carte ne peut pas être placée dans une rangée. Ramassez toutes les cartes d'une rangée de votre choix.");
            ramasserCartesRangee(plateau);
        } else {
            // Règle 2 : Trouver la rangée où la différence entre la dernière carte déposée et la nouvelle est la plus faible
            int indexRangee = trouverRangeeOptimale(carte.getValeur(), plateau);
            if (indexRangee == -1) {
                System.out.println("Aucune rangée n'est disponible pour placer la carte. Ramassez toutes les cartes d'une rangée de votre choix.");
                ramasserCartesRangee(plateau);
            } else {
                // Ajouter la carte à la rangée
                cartesAJouer.add(carte);
                plateau.ajouterCarte(indexRangee, carte);
                getMain().remove(indexCarte);
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
