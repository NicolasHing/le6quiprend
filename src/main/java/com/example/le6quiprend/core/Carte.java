package com.example.le6quiprend.core;

import java.util.List;

public class Carte {
    private int valeur;
    private int tetesDeBoeuf;
    
    Carte(int valeur) {
        this.valeur = valeur;

        if (valeur % 10 == 5) {
            this.tetesDeBoeuf = 3;
        } else if (valeur % 10 == 0) {
            this.tetesDeBoeuf = 3;
        } else {
            this.tetesDeBoeuf = 1;
        }

        if(valeur % 11 == 0){
            this.tetesDeBoeuf += 5;
        }
    }


    /**
     * Règle n°1 : La carte est posable si supérieur à la valeur de la dernière carte
     * @param rangees Toutes les lignes du plateau
     * @return true si carte posable dans une des lignes
     */
    public boolean ComparerCarte(List<List<Carte>> rangees){
        boolean posable = false;
        int i = 0;
        while (!posable && i < rangees.size()) {// on parcourt toutes les lignes.
            int valeurCarteAPoser = this.valeur;

            List<Carte> rangee = rangees.get(i);

            Carte deniereCarteDeRangee = rangee.get(rangee.size() - 1);
            int valeurDeniereCarteDeRangee = deniereCarteDeRangee.getValeur();

            if (valeurCarteAPoser > valeurDeniereCarteDeRangee){
                posable = true;
            }
            i++;
        }
        return(posable);
    }


    /**
     * Règle n°2 : sur la ligne avec la plus petite différence
     * @param rangees Toutes les lignes du plateau
     * @return Ligne avec la plus petite différence
     */
    public int PlusPetiteDiff(List<List<Carte>> rangees){
        int valeurDeLaCarteAPoser = this.valeur;

        int indiceRangeeAvecPlusPetiteDiff = 5;
        int plusPetiteDiff = 200; //valeur volontairement élevée car on a vérif avant qu'il y aura un diff strictement inférieur à 104-1 = 103
        for (int i = 0; i < rangees.size(); i++) {
            List<Carte> rangee = rangees.get(i);
            int valeurDerniereCarteDeLaRangee = rangee.get(rangee.size()-1).getValeur();

            if (valeurDeLaCarteAPoser > valeurDerniereCarteDeLaRangee) {
                int diff = valeurDeLaCarteAPoser - valeurDerniereCarteDeLaRangee;
                if (diff < plusPetiteDiff) {
                    plusPetiteDiff = diff;
                    indiceRangeeAvecPlusPetiteDiff = i;
                }
            }
        }
        return indiceRangeeAvecPlusPetiteDiff;
    }


    public int getTetesDeBoeuf() {
        return tetesDeBoeuf;
    }
    public int getValeur() {
        return valeur;
    }

    /**
     *
     * @return "valeur (TdB)"
     */
    public String afficherCarte() {
        String string = this.valeur + "(" + tetesDeBoeuf + ")" ;
        return string;
    }
}
