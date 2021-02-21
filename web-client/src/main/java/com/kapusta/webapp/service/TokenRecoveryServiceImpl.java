package com.kapusta.webapp.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.jpro.webapi.WebAPI;

@Singleton
public class TokenRecoveryServiceImpl implements TokenRecoveryService {

    private String tokenId = null;

    @Inject
    private PropertiesRepository propertiesRepository;

    @Inject
    private MainStageHolder mainStageHolder;

    @Inject
    private MainSceneService mainSceneService;

    @Override
    public Boolean recoverToken() {
        WebAPI webAPI = mainStageHolder.getWebAPI();
        if (webAPI == null) {
            return false;
        }
        String sessionId = webAPI.getCookies().get(propertiesRepository.getSessionCookiePropertyName());
        if (sessionId == null || sessionId.isEmpty()) {
            return false;
        }
        tokenId = sessionId;
        mainSceneService.init();
        return true;

    }

    @Override
    public Boolean rememberToken(String token) {
        System.out.println(token);
        WebAPI webAPI = mainStageHolder.getWebAPI();
        if (webAPI == null) {
            return false;
        }
        System.out.println(token);

        webAPI.setCookie(propertiesRepository.getSessionCookiePropertyName(), token);
        tokenId = token;
        return true;
    }

    @Override
    public String getToken() {
        return this.tokenId;
    }
}
