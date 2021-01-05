package com.kapusta.webapp.controller;

import com.kapusta.webapp.fxmlutils.PresentedBy;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

@PresentedBy("scene-templates/main-scene.fxml")
public class MainSceneController {

    @FXML
    private Label userName;

    public void setUserName(String uName) {
        Platform.runLater(() -> this.userName.setText(uName));
    }
}
