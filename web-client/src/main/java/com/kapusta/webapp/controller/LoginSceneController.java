package com.kapusta.webapp.controller;

import com.google.inject.Inject;
import com.kapusta.webapp.configuration.AbleToInit;
import com.kapusta.webapp.dto.LoginDataDTO;
import com.kapusta.webapp.fxmlutils.PresentedBy;
import com.kapusta.webapp.service.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.Observable;
import java.util.Observer;

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
        LoginDataDTO loginDataDTO = new LoginDataDTO();
        loginDataDTO.setLogin(login.getText());
        loginDataDTO.setPassword(password.getText());
        loginService.login(loginDataDTO, System.out::println, Throwable::printStackTrace);
    }

}
