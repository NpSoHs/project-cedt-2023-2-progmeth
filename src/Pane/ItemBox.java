package Pane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ItemBox extends HBox {
    public ItemBox(String scoreLabel, String itemImage) {
        setAlignment(Pos.CENTER_LEFT);
        setSpacing(8);
        setPadding(new Insets(0, 0, 0, 15));

        Label strawBerryLabel = new Label(scoreLabel);
        strawBerryLabel.setStyle("-fx-text-fill: white; -fx-font-family: 'Pixeloid Sans'; -fx-font-size: 14;");
        ImageView strawberryImage = new ImageView(new Image(itemImage));
        strawberryImage.setFitWidth(30); // Set image width
        strawberryImage.setFitHeight(30); // Set image height
        getChildren().addAll(strawberryImage, strawBerryLabel);
    }


}