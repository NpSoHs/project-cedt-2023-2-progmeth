package Pane;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class EndSubScene extends SubScene {
    PopUpEnd popUpEnd;

    public EndSubScene(String winImage, int score, boolean isTie, String name) {
        super(new AnchorPane(), 600, 750);
        prefHeight(600);
        prefWidth(750);
        popUpEnd = new PopUpEnd(winImage, score, isTie, name);
        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setStyle("-fx-background-color: rgba(0, 0, 0, 0.8); ");
        root2.getChildren().add(popUpEnd);
    }

    public void moveSubScene() {
        popUpEnd.moveSubScene();
    }
}
