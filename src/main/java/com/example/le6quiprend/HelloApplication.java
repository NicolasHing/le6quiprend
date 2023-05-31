package com.example.le6quiprend;

import com.example.le6quiprend.view.GamePresenter;
import com.example.le6quiprend.view.MainCarte;
import com.example.le6quiprend.view.PlateauCentral;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        VBox root = new VBox();
        PlateauCentral plateauCentral = new PlateauCentral();
        MainCarte mainCarte = new MainCarte();
        //Game game = new Game();
        GamePresenter gamePresenter = new GamePresenter(plateauCentral,
                mainCarte,
                //game,
                this);
        System.out.println("A new game has been started");
        root.getChildren().add(plateauCentral);
        root.getChildren().add(mainCarte);
        Scene scene = new Scene(root, 1600, 800);
        this.stage.setTitle("Le 6 qui prend");
        this.stage.setScene(scene);
        this.stage.show();
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