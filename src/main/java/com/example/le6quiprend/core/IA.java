package com.example.le6quiprend.core;

import java.util.List;
import java.util.Random;

public class IA extends AbstractJoueur {
    public IA(String nom) {
        super(nom);
    }



    /** Choix d'une carte au hasard dans la main de l'IA et la place dans attribu
     */
    @Override
    public void choisirCarteAJouer() {
        Random random = new Random();
        int indexCarte = random.nextInt(getMain().size());
        this.carteChoisie = getMain().get(indexCarte);
    }

    @Override
    public int choisirLigne(List<List<Carte>> rangees) {
        int valeurMin = 200;
        int indiceDeRangeeAvecLeMoinsTdB = 0;
        for (int i = 0; i < rangees.size(); i++) {
            List<Carte> rangee = rangees.get(i);
            Carte carte = rangee.get(rangee.size() - 1);
            if (carte.getValeur() < valeurMin) {
                valeurMin = carte.getValeur();
                indiceDeRangeeAvecLeMoinsTdB = i;
            }
        }
        return indiceDeRangeeAvecLeMoinsTdB;
    }


    @Override
    public void afficherMain() {}

}
