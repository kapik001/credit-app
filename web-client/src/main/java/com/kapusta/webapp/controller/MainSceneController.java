package com.kapusta.webapp.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kapusta.webapp.dto.UserDetailsDTO;
import com.kapusta.webapp.fxmlutils.FXMLHolder;
import com.kapusta.webapp.fxmlutils.PresentedBy;
import com.kapusta.webapp.service.LogoutService;
import com.kapusta.webapp.service.UserContextHolder;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

@Singleton
@PresentedBy("scene-templates/main-scene.fxml")
public class MainSceneController {

    @Inject
    private LogoutService logoutService;

    @FXML
    private Label userName;

    @FXML
    private BorderPane borderPane;

    @Inject
    private FXMLHolder<LeftNavMenuController> leftNavMenuControllerHolder;

    @Inject
    private UserContextHolder userContextHolder;

    public void initMenuAfterSuccessfulLogin() {
        UserDetailsDTO userData = userContextHolder.getUser();
        String uName = userData.getLogin() + " "
                + userData.getFirstName() + " " + userData.getLastName();
        Platform.runLater(() -> {
            this.userName.setText(uName);
            leftNavMenuControllerHolder.getController().initLeftNavMenuController();
            borderPane.setLeft(leftNavMenuControllerHolder.getRoot());
        });

    }

    @FXML
    private void logoutClicked() {
        logoutService.logout();
    }
}
