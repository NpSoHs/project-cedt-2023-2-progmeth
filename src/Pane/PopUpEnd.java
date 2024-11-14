package Pane;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.util.Duration;
import utils.Goto;

public class PopUpEnd extends SubScene {
    public PopUpEnd(String winImage, int score, boolean isTie,String name) {
        super(new AnchorPane(), 460, 350);
        setLayoutX(70);
        setLayoutY(1024);

        if (isTie) {
            tiePopUp(score);
            return;
        }
        winPopUp(winImage, score, name);

    }

    public void moveSubScene() {
        System.out.println("open");
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.7));
        transition.setNode(this);
        transition.setToY(-954);

        transition.play();
    }

    public void winPopUp(String winImage, int score, String name){
        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setStyle("-fx-background-color:  #a0a0a0; -fx-background-radius: 20;");

        ImageView croissantImageView = new ImageView(new Image(winImage));
        croissantImageView.setFitWidth(131);
        croissantImageView.setFitHeight(120);
        croissantImageView.setLayoutX(165);
        croissantImageView.setLayoutY(14);
        croissantImageView.setPreserveRatio(true);
        croissantImageView.setPickOnBounds(true);

        Label titleLabel = new Label(name+" Win");
        titleLabel.setLayoutX(0);
        titleLabel.setLayoutY(135);
        titleLabel.setPrefWidth(460);
        titleLabel.setAlignment(javafx.geometry.Pos.CENTER);
        titleLabel.setFont(new Font("Arial Black", 38));


        Label scoreLabel = new Label("Score: " + score);
        scoreLabel.setLayoutX(123);
        scoreLabel.setLayoutY(201);
        scoreLabel.setPrefWidth(216);
        scoreLabel.setAlignment(javafx.geometry.Pos.CENTER);
        scoreLabel.setFont(new Font(32));

        Button playAgainButton = new Button("Play Again");
        playAgainButton.setLayoutX(245);
        playAgainButton.setLayoutY(271);
        playAgainButton.setPrefWidth(160);
        playAgainButton.setPrefHeight(47);
        playAgainButton.setStyle("-fx-background-color: #009109;");
        playAgainButton.setTextFill(javafx.scene.paint.Color.WHITE);
        playAgainButton.setOnAction(actionEvent -> Goto.restartGamePage());
        playAgainButton.setFont(new Font("System Bold", 19));

        Button mainMenuButton = new Button("Main Menu");
        mainMenuButton.setLayoutX(56);
        mainMenuButton.setLayoutY(271);
        mainMenuButton.setPrefWidth(160);
        mainMenuButton.setPrefHeight(47);
        mainMenuButton.setStyle("-fx-background-color: #c91414;");
        mainMenuButton.setTextFill(javafx.scene.paint.Color.WHITE);
        mainMenuButton.setOnAction(actionEvent -> Goto.startPage());
        mainMenuButton.setFont(new Font("System Bold", 19));

        root2.getChildren().addAll(croissantImageView, titleLabel, scoreLabel, playAgainButton, mainMenuButton);
    }

    public void tiePopUp(int score) {
        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setStyle("-fx-background-color:  #a0a0a0; -fx-background-radius: 20;");

        ImageView croissantImageView = new ImageView(new Image("/croissant.png"));
        croissantImageView.setFitWidth(131);
        croissantImageView.setFitHeight(120);
        croissantImageView.setLayoutX(85);
        croissantImageView.setLayoutY(28);
        croissantImageView.setPreserveRatio(true);
        croissantImageView.setPickOnBounds(true);


        ImageView saladImageView = new ImageView(new Image("/salad.png"));
        saladImageView.setFitWidth(131);
        saladImageView.setFitHeight(120);
        saladImageView.setLayoutX(245);
        saladImageView.setLayoutY(28);
        saladImageView.setPreserveRatio(true);
        saladImageView.setPickOnBounds(true);

        Label titleLabel = new Label("It's a Tie");
        titleLabel.setLayoutX(0);
        titleLabel.setLayoutY(135);
        titleLabel.setPrefWidth(460);
        titleLabel.setAlignment(javafx.geometry.Pos.CENTER);
        titleLabel.setFont(new Font("Arial Black", 38));


        Label scoreLabel = new Label("Your Score: " + score);
        scoreLabel.setLayoutX(123);
        scoreLabel.setLayoutY(201);
        scoreLabel.setPrefWidth(216);
        scoreLabel.setAlignment(javafx.geometry.Pos.CENTER);
        scoreLabel.setFont(new Font(32));

        Button playAgainButton = new Button("Play Again");
        playAgainButton.setLayoutX(245);
        playAgainButton.setLayoutY(271);
        playAgainButton.setPrefWidth(160);
        playAgainButton.setPrefHeight(47);
        playAgainButton.setStyle("-fx-background-color: #009109;");
        playAgainButton.setTextFill(javafx.scene.paint.Color.WHITE);
        playAgainButton.setOnAction(actionEvent -> Goto.restartGamePage());
        playAgainButton.setFont(new Font("System Bold", 19));

        Button mainMenuButton = new Button("Main Menu");
        mainMenuButton.setLayoutX(56);
        mainMenuButton.setLayoutY(271);
        mainMenuButton.setPrefWidth(160);
        mainMenuButton.setPrefHeight(47);
        mainMenuButton.setStyle("-fx-background-color: #c91414;");
        mainMenuButton.setTextFill(javafx.scene.paint.Color.WHITE);
        mainMenuButton.setOnAction(actionEvent -> Goto.startPage());
        mainMenuButton.setFont(new Font("System Bold", 19));

        root2.getChildren().addAll(croissantImageView, saladImageView, titleLabel, scoreLabel, playAgainButton, mainMenuButton);
    }
}
