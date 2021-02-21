package com.kapusta.webapp.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kapusta.webapp.fxmlutils.PresentedBy;
import com.kapusta.webapp.service.LogoutService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

@Singleton
@PresentedBy("scene-templates/main-scene.fxml")
public class MainSceneController {

    @Inject
    private LogoutService logoutService;

    @FXML
    private Label userName;

    public void setUserName(String uName) {
        Platform.runLater(() -> this.userName.setText(uName));
    }

    @FXML
    private void logoutClicked() {
        logoutService.logout();
    }
}
