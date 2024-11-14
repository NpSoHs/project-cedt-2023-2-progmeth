package Pane;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import main.GameController;
import main.Renderer;
import utils.Config;

public class StartGame extends Group {
    private GraphicsContext gc;
    boolean isEnd;
    private static StartGame instance;

    public static StartGame getInstance() {
        if (instance == null) instance = new StartGame(GameController.getInstance());
        return instance;
    }

    public void clear() {
        instance = null;
    }

    public StartGame(GameController gameController) {
        Canvas canvas = new Canvas(Config.SCREEN_SIZE, Config.SCREEN_SIZE);
        gc = canvas.getGraphicsContext2D(); // Get the graphics context of the canvas
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        GamePanel gamePanel = new GamePanel();
        VBox vbox = new VBox();
        vbox.getChildren().addAll(canvas, gamePanel);
        vbox.setAlignment(Pos.CENTER); // Set alignment to center
        vbox.setPadding(new Insets(0, 0, 0, 0)); // Set top padding to 10
        getChildren().add(vbox); // Add the VBox to the root group

        gc = canvas.getGraphicsContext2D(); // Get the graphics context of the canvas


        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (isEnd) return;
                boolean gameEnd = gameController.update(); // Update the game state
                Platform.runLater(() -> {
                    Renderer.render(gc, gameController);
                });
                isEnd = gameEnd;
            }
        }.start(); // Start the AnimationTimer // Start the AnimationTimer
    }
}
