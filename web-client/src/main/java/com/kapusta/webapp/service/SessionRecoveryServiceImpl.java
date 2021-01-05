package com.kapusta.webapp.service;

import com.google.inject.Inject;
import com.jpro.webapi.WebAPI;
import com.kapusta.webapp.utils.WebClientLogger;
import javafx.stage.Stage;

public class SessionRecoveryServiceImpl implements SessionRecoveryService {

    @Inject
    private PropertiesRepository propertiesRepository;

    @Inject
    private MainStageHolder mainStageHolder;

    @Inject
    private MainSceneService mainSceneService;

    @Override
    public Boolean recoverSession() {
        WebAPI webAPI = mainStageHolder.getWebAPI();
        if (webAPI == null) {
            return false;
        }
        String sessionId = webAPI.getCookies().get(propertiesRepository.getSessionCookiePropertyName());
        if (sessionId == null || sessionId.isEmpty()) {
            return false;
        }
        mainSceneService.init();
        return true;

    }

    @Override
    public Boolean rememberSession(String sessionId) {
        WebAPI webAPI = mainStageHolder.getWebAPI();
        if (webAPI == null) {
            return false;
        }
        webAPI.setCookie(propertiesRepository.getSessionCookiePropertyName(), sessionId);
        return true;
    }
}
