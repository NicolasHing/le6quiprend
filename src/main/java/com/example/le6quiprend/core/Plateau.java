package com.example.le6quiprend.core;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private List<List<Carte>> rangees;
    public static final int nombreDeRangee = 4;
    public static final int nombreCarteParRangee = 5;

    public Plateau() {
        rangees = new ArrayList<>();
        for (int i = 0; i < nombreDeRangee; i++) {
            rangees.add(new ArrayList<>());
        }
    }

    public void ajouterCarte(int rangeeIndex, Carte carte) {
        rangees.get(rangeeIndex).add(carte);
    }

    public void viderRangee(int rangeeIndex) {
        rangees.get(rangeeIndex).clear();
    }

    public boolean estRangeeComplete(int rangeeIndex) {
        return rangees.get(rangeeIndex).size() >= 6;
    }

    public boolean estPlateauComplet() {
        for (int i = 0; i < nombreDeRangee; i++) {
            if (!estRangeeComplete(i)) {
                return false;
            }
        }
        return true;
    }

    public List<Carte> getRangee(int rangeeIndex) {
        return rangees.get(rangeeIndex);
    }

    public List<List<Carte>> getRangees() {
        return rangees;
    }

    public int getNombreCartesDansRangee(int rangeeIndex) {
        return rangees.get(rangeeIndex).size();
    }

    public void afficherRangees() {
        System.out.println("Plateau :");
        for (int i = 0; i < nombreDeRangee; i++) {
            System.out.print("Rangee " + (i + 1) + ": ");
            List<Carte> rangee = rangees.get(i);
            for (Carte carte : rangee) {
                System.out.print(carte.getValeur() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public void actualiserRangees() {
        for (int i = 0; i < nombreDeRangee; i++) {
            if (estRangeeComplete(i)) {
                viderRangee(i);
            }
        }
    }

}
