package com.example.le6quiprend;

import com.example.le6quiprend.core.Partie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Demande les noms des joueurs
        List<String> nomsJoueurs = demanderNomsJoueurs();

        // Création de la partie
        Partie partie = new Partie(nomsJoueurs);

        // Lancement de la partie
        partie.jouer();
    }

    private static List<String> demanderNomsJoueurs() {
        List<String> nomsJoueurs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nombre de joueurs :");
        int nombreJoueurs = scanner.nextInt();

        for (int i = 1; i <= nombreJoueurs; i++) {
            System.out.println("Nom du joueur " + i + " :");
            String nomJoueur = scanner.next();
            nomsJoueurs.add(nomJoueur);
        }

        return nomsJoueurs;
    }
}
