package com.example.le6quiprend.core;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private List<List<Carte>> rangees;
    public static final int nombreDeRangee = 4;
    public static final int nombreCarteParRangee = 5;

    /**
     * Initialise le plateau
     */
    public Plateau() {
        this.rangees = new ArrayList<>();
        for (int i = 0; i < nombreDeRangee; i++) {
            this.rangees.add(new ArrayList<>());
        }
    }
    /**
     * Ajoute carte à l'index rangeeIndex
     * @param rangeeIndex L'index où ajouter la carte
     * @param carte La carte à ajouter
     */
    public void ajouterCarte(int rangeeIndex, Carte carte) {
        rangees.get(rangeeIndex).add(carte);
    }

    public List<List<Carte>> getRangees() {
        return rangees;
    }

    public void afficherRangees() {
        System.out.println("Plateau :");
        for (int i = 0; i < nombreDeRangee; i++) {
            System.out.print("Rangée " + (i + 1) + " : ");
            List<Carte> rangee = rangees.get(i);
            for (Carte carte : rangee) {
                System.out.print(carte.afficherCarte() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void setRangees(List<List<Carte>> rangees) {
        this.rangees = rangees;
    }
}
