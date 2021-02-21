package com.kapusta.webapp.service;

public interface TokenRepositoryService {
    Boolean recoverToken();
    void rememberToken(String sessionId);
    String getToken();
    void removeToken();
}
