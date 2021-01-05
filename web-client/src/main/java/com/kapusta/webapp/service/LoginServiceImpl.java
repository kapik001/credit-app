package com.kapusta.webapp.service;

import com.google.inject.Inject;
import com.kapusta.webapp.controller.MainSceneController;
import com.kapusta.webapp.dto.LoginDataDTO;
import com.kapusta.webapp.dto.LoginResponseDTO;
import com.kapusta.webapp.fxmlutils.FXMLHolder;
import com.kapusta.webapp.rest.clients.LoginClient;
import com.kapusta.webapp.utils.WebClientLogger;
import javafx.application.Platform;
import javafx.scene.Scene;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.MediaType;

import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Supplier;


public class LoginServiceImpl implements LoginService {

    @Inject
    private LoginClient loginClient;

    @Inject
    private MainSceneService mainSceneService;

    @Inject
    private SessionRecoveryService sessionRecoveryService;

    @Override
    public void login(String login, String password, Supplier<Void> atSuccess, Supplier<Void> atError) {
        LoginDataDTO loginDataDTO = new LoginDataDTO();
        loginDataDTO.setLogin(login);
        loginDataDTO.setPassword(password);
        loginClient.login(loginDataDTO, (res) -> {
            if (Boolean.TRUE.equals(res.getResult())) {
                sessionRecoveryService.rememberSession("XXx");
                mainSceneService.init();
                atSuccess.get();
            } else {
                atError.get();
            }

        }, (throwable) -> {
            WebClientLogger.logError("Error during login", throwable);
            atError.get();
        });
    }
}
