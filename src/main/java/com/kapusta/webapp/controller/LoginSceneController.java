package com.kapusta.webapp.controller;

import com.google.inject.Inject;
import com.kapusta.webapp.fxmlutils.PresentedBy;
import com.kapusta.webapp.service.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

@PresentedBy("scene-templates/login-scene.fxml")
public class LoginSceneController {

    @Inject
    private LoginService loginService;

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    private void login() {
        loginService.login(login.getText(), password.getText());
    }
}
