package utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class FxmlUtils {

    public static void loadFxml(String fxmlPath, Pane rootPane) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(FxmlUtils.class.getResource(fxmlPath));
            Parent parent = fxmlLoader.load();
            rootPane.getChildren().setAll(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
