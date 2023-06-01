package com.example.le6quiprend.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pioche {
    private List<Carte> cartes;

    public Pioche() {
        this.cartes = new ArrayList<>();

        // Ajouter les cartes à la pioche (valeurs de 1 à 104)
        for (int valeur = 1; valeur <= 104; valeur++) {
            this.cartes.add(new Carte(valeur));
        }

        // Mélanger les cartes
        Collections.shuffle(cartes);
    }

    /**
     * Prend la 1ere carte de la pioche et la renvoie
     * Affiche dans la console si la pioche est vide
     * @return 1ere carte de la pioche
     */
    public Carte tirerCarte() {
        if (!cartes.isEmpty()) {
            return cartes.remove(0);
        } else {
            throw new IllegalStateException("La pioche est vide !");
        }
    }
}
