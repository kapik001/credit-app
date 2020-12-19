package com.kapusta.webapp.controller;

import com.google.inject.Inject;
import com.kapusta.webapp.configuration.AbleToInit;
import com.kapusta.webapp.fxmlutils.PresentedBy;
import com.kapusta.webapp.service.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.Observable;
import java.util.Observer;

@PresentedBy("scene-templates/login-scene.fxml")
public class LoginSceneController implements Observer, AbleToInit {

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

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("The result of login is: " + arg);
    }

    @Override
    public void onInit() {
        loginService.addObserver(this);
    }
}
