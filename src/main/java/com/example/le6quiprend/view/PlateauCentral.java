package com.example.le6quiprend.view;

import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;


public class PlateauCentral extends GridPane {
    static final int constraintWidth = 150;
    public PlateauCentral() {
        this.setPadding(new Insets(5, 0, 0, 5));
        this.setPrefWidth(constraintWidth * 5);
        this.setPrefHeight(constraintWidth * 4);
        for (int i = 0; i < 5; i++) { // Modifier la condition de la boucle pour itérer 5 fois (nombre de colonnes)
            this.getColumnConstraints().add(new ColumnConstraints(constraintWidth));
        }
        for (int i = 0; i < 4; i++) { // Modifier la condition de la boucle pour itérer 4 fois (nombre de lignes)
            this.getRowConstraints().add(new RowConstraints(constraintWidth));
        }
        for (int i = 0; i < 4; i++) { // Modifier la condition de la boucle pour itérer 4 fois (nombre de lignes)
            for (int j = 0; j < 5; j++) { // Modifier la condition de la boucle pour itérer 5 fois (nombre de colonnes)
                Pane pane = new Pane();
                this.add(pane, j, i); // Inverser les indices j et i pour placer les éléments correctement dans la grille
            }
        }
        this.setMinHeight(this.getPrefHeight());
        this.setMinWidth(this.getPrefWidth());
        this.setGridLinesVisible(true);
    }
}
