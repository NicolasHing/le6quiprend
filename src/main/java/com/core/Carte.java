package com.core;

public class Carte {
    int valeur;
    int tetesDeBoeuf;
    
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


    public int getTetesDeBoeuf() {
        return tetesDeBoeuf;
    }
    public int getValeur() {
        return valeur;
    }
}
