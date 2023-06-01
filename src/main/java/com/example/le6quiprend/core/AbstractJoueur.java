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

    /**
     * Pose la carte à la rangée numeroRangeeAModifier, récupère les cartes si la rangée est pleine
     * @param ancienneRangees Plateau
     * @param numeroRangeeAModifier Là où poser la carte
     * @return Les rangées modifiées
     */
    public List<List<Carte>> poserCarte(List<List<Carte>> ancienneRangees, int numeroRangeeAModifier){
        List<List<Carte>> newRangees = new ArrayList<>(ancienneRangees);

        for (int i = 0; i < ancienneRangees.size(); i++){ // passe par chaque ligne du tableau.
            List<Carte> rangee = ancienneRangees.get(i);

            if (i == numeroRangeeAModifier) { // On est sur la ligne à modifier
                // soit on pose la carte facilement car il y a la place et c'est plus grand
                if (rangee.size() + 1 < 6 && this.carteChoisie.getValeur() > rangee.get(rangee.size() - 1).getValeur()){
                    rangee.add(this.carteChoisie);
                    newRangees.set(i, rangee);
                } else { // Soit, il n'y a pas la place,
                    // On récupère les cartes
                    this.cartesEncaissees.addAll(rangee);
                    // On pose
                    List<Carte> nouvelleRangee = new ArrayList<>();
                    nouvelleRangee.add(this.carteChoisie);
                    newRangees.set(i, nouvelleRangee);
                }
            } else { // On est sur une ligne à NE PAS modifier.
                newRangees.set(i, rangee);
            }
        }
        this.carteChoisie = null;
        return newRangees;
    }

    public List<Carte> getMain() {
        return this.main;
    }

    public String getNom(){
        return nom;
    }

    public Carte getCarteChoisie() {
        return carteChoisie;
    }

    /**
     * Méthode qui trie la main du joueur
     */
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

    /**
     * Renvoie le score, c'est à dire de nombre de TdB dans cartesEncaissées
     * @return sum(cartesEncaissées.TdB)
     */
    public int getScore() {
        int sum = 0;
        for (Carte carte : this.cartesEncaissees) {
            sum += carte.getTetesDeBoeuf();
        }
        return sum;
    }

    public abstract void afficherMain();
    /**
     * Affiche :
     * nomJoueur - Score : getScore
     */
    public void afficherScore() {
        System.out.println(getNom() + " - Score : " + getScore());
    }

    public abstract void choisirCarteAJouer();
    public abstract int choisirLigne(List<List<Carte>> rangees);
}
