package Pane;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utils.Config;

public class CharacterBox extends HBox {
    public Label CharacterScoreLabel;

    public CharacterBox(String CharacterImage, String message, ItemDescription butterForCharacter, ItemDescription vegForCharacter) {
        setSpacing(10);
        setPadding(new Insets(25, 9, 0, 65));

        ImageView characterImage = new ImageView(new Image(CharacterImage));
        characterImage.setFitWidth(60); // Set image width
        characterImage.setFitHeight(60); // Set image height

        VBox characterPanel = new VBox();
        HBox characterScoreHbox = new HBox();
        CharacterScoreLabel = new Label(message);
        CharacterScoreLabel.setStyle("-fx-text-fill: white; -fx-font-family: 'Pixeloid Sans'; -fx-font-size: 12;");
        CharacterScoreLabel.setPadding(new Insets(0, 5, 0, 0));
        ImageView star = new ImageView(new Image(Config.STAR_IMAGE_PATH));
        star.setFitWidth(15); // Set image width
        star.setFitHeight(15); // Set image height
        characterScoreHbox.setSpacing(5);
        characterScoreHbox.getChildren().addAll(star, CharacterScoreLabel);
        characterPanel.setSpacing(10);
        characterPanel.getChildren().addAll(characterScoreHbox, butterForCharacter, vegForCharacter);
        getChildren().addAll(characterImage, characterPanel);
    }

    public void updateCharacterScoreLabel(String score) {
        CharacterScoreLabel.setText(score);
    }
}

