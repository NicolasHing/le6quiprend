package com.example.le6quiprend.view;


import com.example.le6quiprend.HelloApplication;
import com.example.le6quiprend.core.Plateau;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GamePresenter {

    HelloApplication application;
    PlateauCentral plateauCentral;
    MainCarte mainCarte;
    //Game game;

    public GamePresenter(PlateauCentral plateauCentral,
                         MainCarte mainCarte,
                         //Game game,
                         HelloApplication application) {
        this.plateauCentral = plateauCentral;
        this.mainCarte = mainCarte;
        //this.game = game;
        this.application = application;
        for (int i = 0; i < Plateau.nombreDeRangee; i++) {
            for (int j = 0; j < Plateau.nombreCarteParRangee; j++) {
                Pane pane = new Pane();
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
        System.out.printf("Coordinates of the click: %f x and %f y %n", e.getX(), e.getY());
        System.out.printf("I have been clicked by this pane: %s%n", e.getTarget());
        Pane pane = (Pane) e.getTarget();
        int row = GridPane.getRowIndex(pane);
        System.out.println("r:" + row);

        /*
        if (game.isGameOver()) {
            System.out.println("The game is already finished!");
            return;
        }
        if (!game.fillSquare(row, col)) {
            System.out.println("Already taken. Move along");
            return;
        }
        Shape shape;
        if (game.getCurrentPlayer() % 2 == 0) {
            shape = new Circle(75, 75, 75);
            shape.setStroke(Color.ORANGERED);
            shape.setFill(null);
        } else {
            Line line1 = new Line(0, 0, 150, 150);
            Line line2 = new Line(150, 0, 0, 150);
            shape = Shape.union(line1, line2);
            shape.setStroke(Color.AQUA);
        }
        pane.getChildren().add(shape);
        game.getBoard().printBoard();

        if (game.isGameOver()) {
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(3000),
                    (f) -> {
                        int winner = ((game.getCurrentPlayer() + 1) % 2);
                        System.out.printf("Player %d has won!", winner);
                        application.declareWinner(winner);
                    }
            ));
            timeline.play();
        }

         */
    }

    public void handleClickMainCarte(MouseEvent e) {
        System.out.println("main");
        System.out.printf("Coordinates of the click: %f x and %f y %n", e.getX(), e.getY());
        System.out.printf("I have been clicked by this pane: %s%n", e.getTarget());
        Pane pane = (Pane) e.getTarget();
        int col = GridPane.getColumnIndex(pane);
        System.out.println("c: " + col);
    }
}
