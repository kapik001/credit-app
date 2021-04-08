package com.kapusta.credit.app.server.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kapusta.credit.app.server.service.UserContextHolder;
import com.kapusta.credit.app.server.fxmlutils.FXMLHolder;
import com.kapusta.credit.app.server.fxmlutils.PresentedBy;
import com.kapusta.credit.app.server.service.LogoutService;
import com.kapusta.security.user.dto.UserDetailsDTO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

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
            this.leftNavMenuControllerHolder.getController().initLeftNavMenuController();
            this.borderPane.setLeft(leftNavMenuControllerHolder.getRoot());
        });

    }

    public void setCenterRoot(Parent root) {
        Platform.runLater(() -> {
            this.borderPane.setCenter(root);
        });
    }

    @FXML
    private void logoutClicked() {
        logoutService.logout();
    }
}
