package com.core;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private List<List<Carte>>rangees;

    public Plateau() {
        //Création des rangées, Qui est une liste de liste
        rangees = new ArrayList<>();
        for (int i=0; i<4; i++){
            rangees.add(new ArrayList<>());
        }
    }

    public void ajouterCarte(int rangeeIndex, Carte carte){
        rangees.get(rangeeIndex).add(carte);
    }



    public void viderRangee(int rangeeIndex){
        rangees.get(rangeeIndex).clear();
    }

    public boolean estRangeeComplete(int rangeeIndex){
        return rangees.get(rangeeIndex).size() >=6;
    }

    public boolean estPlateauComplet(){
        for(int i =0; i<4; i++){
            if(!estRangeeComplete(i)){
                return false;
                //Si la rangée n'est pas complete il se passe rien
            }
        }
        return true;
    }

    public List<Carte> getRangee(int rangeeIndex){
        return rangees.get(rangeeIndex);
        //Return la liste des cartes d'une rangée
    }

    public int getNombreCartesDansRangee(int rangeeIndex){
        return rangees.get(rangeeIndex).size();
        //Retourne le nombre de carte d'une rangée
    }
}
