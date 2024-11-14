package utils;

import Pane.RootPane;
import Pane.StartGame;
import Pane.EndSubScene;
import characters.Character;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import main.GameController;

public class Goto {
    private static RootPane rootPane;

    public static void setRootPane(RootPane rootPane) {

        Goto.rootPane = rootPane;
    }

    public static void clear() {
        rootPane.getChildren().clear();
    }

    public static void startPage() {
        clear();
        FxmlUtils.loadFxml("/Pane/StartPane.fxml", rootPane);
    }

    public static void startGamePage() {
        clear();
        GameController gameController = GameController.getInstance();
        Image backgroundImage = GameController.getInstance().getBackground();
        BackgroundSize backgroundSize = new BackgroundSize(600, 600, false, false, false, false);
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(backgroundImg);
        rootPane.setBackground(background);
        rootPane.getChildren().addAll(StartGame.getInstance());
    }

    public static void restartGamePage() {
        clear();
        GameController gameController = GameController.getInstance();
        gameController.initGame();
        Image backgroundImage = GameController.getInstance().getBackground();
        BackgroundSize backgroundSize = new BackgroundSize(600, 600, false, false, false, false);
        BackgroundImage backgroundImg = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(backgroundImg);
        rootPane.setBackground(background);
        StartGame.getInstance().clear();
        rootPane.getChildren().addAll(StartGame.getInstance());
    }


    public static void popUpHelp() {
        clear();
        FxmlUtils.loadFxml("/Pane/StartPane.fxml", rootPane);
        FxmlUtils.loadFxml("/Pane/help.fxml", rootPane);
    }

    public static void popUpEnd(Character character, boolean isTie) {
        EndSubScene endSubScene = new EndSubScene(character.getImageView().getImage().getUrl(), character.getTotalScore(), isTie, character.toString());
        rootPane.getChildren().addAll(endSubScene);
        endSubScene.moveSubScene();
    }
}