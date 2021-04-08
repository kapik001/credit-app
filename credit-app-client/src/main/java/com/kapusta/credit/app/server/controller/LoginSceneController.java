package com.kapusta.credit.app.server.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kapusta.credit.app.server.fxmlutils.PresentedBy;
import com.kapusta.credit.app.server.service.LoginService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

@Singleton
@PresentedBy("scene-templates/login-scene.fxml")
public class LoginSceneController {

    @Inject
    private LoginService loginService;

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    private Label wrongPasswordLabel;

    @FXML
    private ProgressBar loadingBar;

    @FXML
    private void login() {
        wrongPasswordLabel.setVisible(false);
        loadingBar.setVisible(true);
        loginService.login(login.getText(), password.getText(), () -> {
            Platform.runLater(() -> {
                loadingBar.setVisible(false);
                login.setText("");
                password.setText("");
            });

            return null;
        }, () -> {
            Platform.runLater(() -> {
                loadingBar.setVisible(false);
                wrongPasswordLabel.setVisible(true);
            });
            return null;
        });
    }

    @FXML
    private void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode().getCode() == 10){
            this.login();
        }
    }
}
