package utils;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import utils.Config;
import utils.Goto;

import java.io.IOException;

public class StartPaneController {
    @FXML
    private Button PlayButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button helpButton;
    @FXML
    private AnchorPane popupHelp;


    boolean isOpen = true;

    public void StartGame(ActionEvent event) {
        System.out.println("button is click");
        if (Config.isFirstTime) {
            Goto.startGamePage();
            Config.isFirstTime = false;
            return;
        }
        Goto.restartGamePage();
        System.out.println("goto restart");

    }

    public void exitProgram(ActionEvent event) throws IOException {
        Platform.exit();
    }

    @FXML
    private void HelpPage(ActionEvent event) {
        if (isOpen) {
            System.out.println("open");
            TranslateTransition transition = new TranslateTransition();
            transition.setDuration(Duration.seconds(0.7));
            transition.setNode(popupHelp);

            transition.setToY(377);

            transition.play();
            isOpen = false;
        } else {
            System.out.println("close");
            TranslateTransition transition = new TranslateTransition();
            transition.setDuration(Duration.seconds(0.7));
            transition.setNode(popupHelp);

            transition.setToY(1024);

            transition.play();
            isOpen = true;
        }
    }
}
