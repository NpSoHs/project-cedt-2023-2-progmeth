package main;

import Pane.*;
import javafx.scene.Scene;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import utils.Config;

public class GameWindow extends Stage {

    private GameController gameController;
    Sound sound = new Sound();

    public GameWindow() {
        // Set the title and make the window not resizable
        setTitle("Game");
        setResizable(false);
        // Initialize the game
        initGame();
        // Create a scene with a black background
        Scene scene = new Scene(RootPane.getRootPane(), Config.SCREEN_SIZE, Config.SCREEN_SIZE + 150);
        scene.setFill(new ImagePattern(GameController.getInstance().getBackground()));
        playMusic(0);


        // panelfont
        Font.loadFont(getClass().getResourceAsStream("/font/PixeloidSans.ttf"), 12);

        scene.setOnKeyPressed(e -> gameController.handleInput(e.getCode()));
        scene.setOnKeyReleased(e -> gameController.getPressedKeys().remove(e.getCode()));

        setScene(scene);
    }

    // Initialize the game
    private void initGame() {
        gameController = GameController.getInstance(); // Get the game controller instance
        gameController.start(this); // Start the game controller by passing the stage
    }

    public void playMusic(int i) {
        sound.setFile(i);
        sound.setVolume(0.5f);
        sound.play();
        sound.loop();
    }

    public void stopMusic() {
        sound.stop();
    }

    public void playSE(int i) {
        sound.setFile(i);
        sound.play();
    }


}

