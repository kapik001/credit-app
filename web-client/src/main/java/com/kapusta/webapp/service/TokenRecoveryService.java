package com.kapusta.webapp.service;

public interface TokenRecoveryService {
    Boolean recoverToken();
    Boolean rememberToken(String sessionId);
    String getToken();
}
