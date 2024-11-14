package Pane;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ItemDescription extends HBox {
    public ItemDescription(String scoreForItem, String itemImage) {
        setSpacing(5);
        Label itemScoreLabel = new Label(scoreForItem);
        itemScoreLabel.setStyle("-fx-text-fill: white; -fx-font-family: 'Pixeloid Sans'; -fx-font-size: 12;");
        itemScoreLabel.setPadding(new Insets(0, 5, 0, 0));
        ImageView vegetableImage = new ImageView(new Image(itemImage));
        vegetableImage.setFitWidth(15); // Set image width
        vegetableImage.setFitHeight(15); // Set image height
        getChildren().addAll(vegetableImage, itemScoreLabel);
    }
}

