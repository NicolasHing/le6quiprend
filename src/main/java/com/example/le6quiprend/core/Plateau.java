package com.example.le6quiprend.core;

import java.util.ArrayList;
import java.util.Collections;
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
     * @param rangeeIndex
     * @param carte
     */
    public void ajouterCarte(int rangeeIndex, Carte carte) {
        rangees.get(rangeeIndex).add(carte);
    }

    /**
     * Permet de vider la rangée
     * @param rangeeIndex
     */
    public void viderRangee(int rangeeIndex) {
        rangees.get(rangeeIndex).clear();
    }

    /**
     *
     * @param rangeeIndex
     * @return true si la rangée est pleine
     */
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

    /**
     *
     * @param rangeeIndex
     * @return rangees[rangeeIndex]
     */
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
            System.out.print("Rangée " + (i + 1) + ": ");
            List<Carte> rangee = rangees.get(i);
            for (Carte carte : rangee) {
                System.out.printf("%d (%d) , ", carte.getValeur(), carte.getTetesDeBoeuf());
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

    public void placerCartes(List<Carte> cartesPourLeTour) {
        List<Integer> classeesParOrdreCroissant = new ArrayList<>();
        for (Carte carte : cartesPourLeTour) {
            classeesParOrdreCroissant.add(carte.getValeur());
        }
        Collections.sort(classeesParOrdreCroissant);
        //on place chaque carte
        for (int valeurTraite : classeesParOrdreCroissant) {
            //vérifier règle 4
        }
    }
    /*
    public boolean regle4(Carte carte) {
        boolean status = false;
        for (List<Carte> cartesDeLaRangee : this.rangees) {
            Carte deniereCarteDeLaRangee = cartesDeLaRangee.get(cartesDeLaRangee.size());
            if (carte.getValeur()<) {
            }
        }
        return status;
    }

     */

}
