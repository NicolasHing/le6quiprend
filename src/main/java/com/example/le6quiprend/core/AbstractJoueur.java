package com.example.le6quiprend.core;

import java.util.ArrayList;
import java.util.List;

//TODO @amine : COMMENTER

public abstract class AbstractJoueur {
    protected String nom;
    protected List<Carte> main;
    protected List<Carte> cartesEncaissees;
    protected Carte carteChoisie;

    public AbstractJoueur(String nom){
        this.nom = nom;
        this.main = new ArrayList<>();
        this.cartesEncaissees = new ArrayList<>();
        this.carteChoisie = null;
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

    public Carte getCarteChoisie() {
        return carteChoisie;
    }

    public void trierMain(){
        int posMin;
        for (int i = 0; i < this.main.size() - 1; i++){
            posMin = i;
            for (int j = i +1; j < this.main.size(); j++){
                if (this.main.get(j).getValeur() < this.main.get(posMin).getValeur()){
                    posMin = j;
                }
            }
            Carte temp = this.main.get(posMin);
            this.main.set(posMin, this.main.get(i));
            this.main.set(i,temp);
        }

    }

    public abstract Carte choisirCarteAJouer();
}
