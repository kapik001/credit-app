package com.kapusta.webapp.service;

import com.google.inject.Inject;
import com.kapusta.webapp.dto.LoginDataDTO;
import com.kapusta.webapp.rest.clients.LoginClient;
import com.kapusta.webapp.utils.WebClientLogger;

import java.util.function.Supplier;


public class LoginServiceImpl implements LoginService {

    @Inject
    private LoginClient loginClient;

    @Inject
    private MainSceneService mainSceneService;

    @Inject
    private TokenRecoveryService tokenRecoveryService;

    @Override
    public void login(String login, String password, Supplier<Void> atSuccess, Supplier<Void> atError) {
        LoginDataDTO loginDataDTO = new LoginDataDTO();
        loginDataDTO.setLogin(login);
        loginDataDTO.setPassword(password);
        loginClient.login(loginDataDTO, (res) -> {
            if (res.getToken() != null) {
                tokenRecoveryService.rememberToken(res.getToken());
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
