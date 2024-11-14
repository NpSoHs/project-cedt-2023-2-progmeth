package Pane;


import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import utils.Goto;

import java.io.IOException;

public class RootPane extends AnchorPane {
    private static RootPane instance;

    private RootPane() {
        // TODO: FILL CODE HERE

        Goto.setRootPane(this); // ให้ใช้ getRootPane() แทน getInstance()
        Goto.startPage();
    }

    public static RootPane getRootPane() {
        if (instance == null)
            instance = new RootPane();
        return instance;
    }

    public static RootPane getInstance() {
        return instance;
    }
}

