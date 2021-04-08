package com.kapusta.credit.app.server.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kapusta.credit.app.server.rest.clients.LoginClient;
import com.kapusta.credit.app.server.utils.WebClientLogger;
import com.kapusta.security.user.dto.LoginDataDTO;

import java.util.function.Supplier;

@Singleton
public class LoginServiceImpl implements LoginService {

    @Inject
    private LoginClient loginClient;

    @Inject
    private MainSceneService mainSceneService;

    @Inject
    private TokenRepositoryService tokenRepositoryService;

    @Override
    public void login(String login, String password, Supplier<Void> atSuccess, Supplier<Void> atError) {
        LoginDataDTO loginDataDTO = new LoginDataDTO();
        loginDataDTO.setLogin(login);
        loginDataDTO.setPassword(password);
        loginClient.login(loginDataDTO, (res) -> {
            if (res.getToken() != null) {
                tokenRepositoryService.rememberToken(res.getToken());
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
