package com.kapusta.credit.app.server.service;

public interface TokenRepositoryService {
    Boolean recoverToken();
    void rememberToken(String sessionId);
    String getToken();
    void removeToken();
}
