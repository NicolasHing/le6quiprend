package com.example.le6quiprend.core;

import java.util.ArrayList;
import java.util.List;

//TODO @amine : COMMENTER

public abstract class AbstractJoueur {
    protected String nom;
    protected List<Carte> main;
    protected List<Carte> cartesEncaissees;

    public AbstractJoueur(String nom){
        this.nom = nom;
        this.main = new ArrayList<>();
        this.cartesEncaissees = new ArrayList<>();
    }

    public void ajouterCarteMain(Carte carte){
        main.add(carte);
    }

    public void encaisserCartes(List<Carte> cartes){
        cartesEncaissees.addAll(cartes);
    }

    public void viderMain(){
        this.main.clear();
    }

    public List<Carte> getMain() {
        return this.main;
    }

    public List<Carte> getCartesEncaissees(){
        return cartesEncaissees;
    }

    public String getNom(){
        return nom;
    }

    public abstract Carte choisirCarteAJouer();
}
