package com.example.le6quiprend.view;


import com.example.le6quiprend.HelloApplication;
import com.example.le6quiprend.core.Carte;
import com.example.le6quiprend.core.Partie;
import com.example.le6quiprend.core.Plateau;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GamePresenter {

    HelloApplication application;
    PlateauCentral plateauCentral;
    MainCarte mainCarte;
    Partie partie;

    public GamePresenter(PlateauCentral plateauCentral,
                         MainCarte mainCarte,
                         Partie partie,
                         HelloApplication application) {
        this.plateauCentral = plateauCentral;
        this.mainCarte = mainCarte;
        this.partie = partie;
        this.application = application;
        for (int i = 0; i < Plateau.nombreDeRangee; i++) {
            for (int j = 0; j < Plateau.nombreCarteParRangee; j++) {
                Pane pane = new Pane();
                try {
                    String stringCarte = this.partie.getPlateau().getRangees().get(i).get(j).toString();
                    Label carteLabel = new Label(stringCarte);
                    pane.getChildren().add(carteLabel);
                } catch (IndexOutOfBoundsException e) {

                }
                pane.setOnMouseClicked(this::handleClickPlateauCentral);
                plateauCentral.add(pane, j, i);
            }
        }
        for (int i = 0; i < 10; i++) {
            Pane pane = new Pane();
            pane.setOnMouseClicked(this::handleClickMainCarte);
            mainCarte.add(pane, i,0);
        }

    }

    public void handleClickPlateauCentral(MouseEvent e) {
        System.out.println("Plateau");
        System.out.printf("%f x and %f y %n", e.getX(), e.getY());
        System.out.printf("Pane: %s%n", e.getTarget());
        Pane pane = (Pane) e.getTarget();
        int row = GridPane.getRowIndex(pane);
        System.out.println("r:" + row);

        if (this.partie.partieTerminee()) {
            return;
        }

    }

    public void handleClickMainCarte(MouseEvent e) {
        System.out.println("main");
        System.out.printf("%f x and %f y %n", e.getX(), e.getY());
        System.out.printf("Pane: %s%n", e.getTarget());
        Pane pane = (Pane) e.getTarget();
        int col = GridPane.getColumnIndex(pane);
        System.out.println("c: " + col);

        if (this.partie.partieTerminee()) {
            return;
        }
    }
}
