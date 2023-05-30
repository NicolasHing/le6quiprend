package com.core;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractJoueur implements OperationSurListeDeCarte{
    protected String nom;
    protected List<Carte> main;
    protected List<Carte> cartesEncaissees;

    public AbstractJoueur(String nom){
        this.nom = nom;
        this.main = new ArrayList<>();
        this.cartesEncaissees = new ArrayList<>();
    }

    @Override
    public int totalTetesDeBoeuf() {
        int total = 0;
        for (Carte carte : cartesEncaissees) {
            total += carte.getTetesDeBoeuf();
        }
        return total;
    }
}
