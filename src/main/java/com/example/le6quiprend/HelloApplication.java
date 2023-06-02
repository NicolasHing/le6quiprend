
package com.example.le6quiprend;

import com.example.le6quiprend.core.AbstractJoueur;
import com.example.le6quiprend.core.Partie;
import com.example.le6quiprend.view.GamePresenter;
import com.example.le6quiprend.view.MainCarte;
import com.example.le6quiprend.view.PlateauCentral;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    Stage stage;
    Scene sceneBienvenu, sceneChoixNom, sceneDebutPartie;
    int nombreDeJoueur;
    Partie partie;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        welcomeScene();

        this.stage.setTitle("Le 6 qui prend");
        this.stage.setScene(sceneBienvenu);
        this.stage.show();
    }

    public void welcomeScene() {
        Label welcomeLabel = new Label("Bonjour, combien de joueur ?");
        TextField nameField = new TextField();
        Label bienvenuErr = new Label("Entrez un nombre entier de joueur");
        bienvenuErr.setTextFill(Color.RED);
        bienvenuErr.setVisible(false);
        HBox nameFieldZone = new HBox(nameField, bienvenuErr);
        Button startButton = new Button("Valider");
        VBox welcomeBox = new VBox(welcomeLabel, nameFieldZone, startButton);
        Scene sceneBienvenu = new Scene(welcomeBox, 400, 200);
        startButton.setOnAction(event -> {
            try {
                this.nombreDeJoueur = Integer.parseInt(nameField.getText());
                choixNomScene();
                this.stage.setScene(sceneChoixNom);
            }
            catch (NumberFormatException e) {
                bienvenuErr.setVisible(true);
            }

        });
        this.sceneBienvenu = sceneBienvenu;
    }

    public void choixNomScene() {
        Label welcomeLabel = new Label("Tapez le nom des joueur.\nAjoutez IA pour que celui-ci soit une IA");

        VBox nameFieldsZone = new VBox();
        for (int i = 0; i < this.nombreDeJoueur; i++) {
            TextField nameField = new TextField();
            nameFieldsZone.getChildren().add(nameField);
        }
        Button nameButton = new Button("Valider");
        VBox welcomeBox = new VBox(welcomeLabel, nameFieldsZone, nameButton);
        Scene sceneChoixNom = new Scene(welcomeBox, 400, 200);
        nameButton.setOnAction(event -> {
            try {
                List<String> joueurs = new ArrayList<>();
                for (int i = 0; i < nameFieldsZone.getChildren().size(); i++) {
                    if (nameFieldsZone.getChildren().get(i) instanceof TextField) {
                        TextField textField = (TextField) nameFieldsZone.getChildren().get(i);
                        joueurs.add(textField.getText());
                    }
                }
                this.partie = new Partie(joueurs);
                debutPartieScene();
                this.stage.setScene(sceneDebutPartie);
            }
            catch (NumberFormatException e) {
            }

        });
        this.sceneChoixNom = sceneChoixNom;
    }


    public void debutPartieScene() {
        VBox root = new VBox();
        PlateauCentral plateauCentral = new PlateauCentral();
        MainCarte mainCarte = new MainCarte();
        GamePresenter gamePresenter = new GamePresenter(plateauCentral, mainCarte, this.partie,this);
        System.out.println("A new game has been started");
        root.getChildren().add(plateauCentral);
        root.getChildren().add(mainCarte);
        Scene sceneDebutPartie = new Scene(root, 1600, 800);
        this.sceneDebutPartie = sceneDebutPartie;
    }


    public void declareWinner(int player) {
        VBox root = new VBox();
        Label label = new Label(String.format("Player %d has won the game! Congratulations!", player));
        label.getStyleClass().add("label");
        root.getStyleClass().add("vbox");
        //root.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        root.getChildren().add(label);
        Scene scene = new Scene(root, 800, 800);
        this.stage.setTitle("End!");
        this.stage.setScene(scene);
        this.stage.show();
    }



        public static void main(String[] args) {
        launch(args);
    }

}