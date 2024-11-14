package Pane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utils.Config;

public class GamePanel extends VBox {
    static CharacterBox croissantBox;
    static CharacterBox saladBox;

    public GamePanel() {
        setAlignment(Pos.CENTER); // Set alignment to center
        setPrefWidth(Config.SCREEN_SIZE);
        setPrefHeight(150);
        setStyle("-fx-background-image: url(/bg.png);  -fx-background-size: cover;");
        setSpacing(10); // Set spacing between labels


        ItemDescription butterForCroissant = new ItemDescription("+2", "/butter.png");
        ItemDescription vegForCroissant = new ItemDescription("-2", "/vegetable.png");
        ItemDescription butterForSalad = new ItemDescription("-2", "/butter.png");
        ItemDescription vegForSalad = new ItemDescription("+2", "/vegetable.png");

        ItemBox fliesBox = new ItemBox("-1", "flies.png");
        ItemBox strawBerryBox = new ItemBox("x2", "strawberry.png");
        ItemBox bananaBox = new ItemBox("freeze", "banana.png");
        ItemBox cheeseBox = new ItemBox("speed", "cheese.png");

        HBox characterItems = new HBox();
        croissantBox = new CharacterBox("/croissant.png", "Croissant Score: 0", butterForCroissant, vegForCroissant);
        saladBox = new CharacterBox("/salad.png", "Salad Score: 0", butterForSalad, vegForSalad);
        characterItems.getChildren().addAll(saladBox, croissantBox);


        HBox staticItems = new HBox();
        staticItems.getChildren().addAll(fliesBox, strawBerryBox, bananaBox, cheeseBox);
        staticItems.setSpacing(75);
        staticItems.setPadding(new Insets(10)); // padding around the HBox

        getChildren().addAll(characterItems, staticItems);


    }

    public static void updateSaladScoreLabel(int score) {
        saladBox.updateCharacterScoreLabel("Salad Score: " + score);
    }

    // Method to update the score label for Croissant
    public static void updateCroissantScoreLabel(int score) {
        croissantBox.updateCharacterScoreLabel("Croissant Score: " + score);
    }
}
