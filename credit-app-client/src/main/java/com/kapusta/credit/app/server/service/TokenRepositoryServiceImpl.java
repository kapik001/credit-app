package com.kapusta.credit.app.server.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.jpro.webapi.WebAPI;

@Singleton
public class TokenRepositoryServiceImpl implements TokenRepositoryService {

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
    public void rememberToken(String token) {
        WebAPI webAPI = mainStageHolder.getWebAPI();
        if (webAPI == null) {
            return;
        }
        webAPI.setCookie(propertiesRepository.getSessionCookiePropertyName(), token);
        tokenId = token;
    }

    @Override
    public String getToken() {
        return this.tokenId;
    }

    @Override
    public void removeToken() {
        WebAPI webAPI = mainStageHolder.getWebAPI();
        if (webAPI == null) {
            return;
        }
        webAPI.deleteCookie(propertiesRepository.getSessionCookiePropertyName());
        tokenId = null;
    }
}
