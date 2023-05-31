package com.example.le6quiprend.view;

import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

public class MainCarte extends GridPane {
    static final int constraintWidth = 150;

    public MainCarte() {
        this.setPadding(new Insets(5, 0, 0, 5));
        this.setPrefWidth(constraintWidth * 10);
        this.setPrefHeight(constraintWidth);
        for (int i = 0; i < 10; i++) { //10 colonnes pour afficher la main
            this.getColumnConstraints().add(new ColumnConstraints(constraintWidth));
        }
        this.getRowConstraints().add(new RowConstraints(constraintWidth));
        for (int i = 0; i < 5; i++) {
            Pane pane = new Pane();
            this.add(pane,0, i);
        }
        this.setMinHeight(this.getPrefHeight());
        this.setMinWidth(this.getPrefWidth());
        this.setGridLinesVisible(true);
    }
}
