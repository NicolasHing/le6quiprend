package com.example.le6quiprend.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pioche {
    private List<Carte> cartes;

    public Pioche() {
        cartes = new ArrayList<>();

        // Ajouter les cartes à la pioche (valeurs de 1 à 104)
        for (int valeur = 1; valeur <= 104; valeur++) {
            cartes.add(new Carte(valeur));
        }

        // Mélanger les cartes
        Collections.shuffle(cartes);
    }

    public Carte tirerCarte() {
        if (!cartes.isEmpty()) {
            return cartes.remove(0);
        } else {
            throw new IllegalStateException("La pioche est vide !");
        }
    }
}
