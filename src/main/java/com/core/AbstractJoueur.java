package com.core;

public abstract class AbstractJoueur {
    protected String nom;
    protected Carte[] main;

    public Joueur(String nom){
        this.nom = nom;
        this.main = new Carte[0];
    }

}
