package com.kapusta.webapp.service;

public interface SessionRecoveryService {
    Boolean recoverSession();
    Boolean rememberSession(String sessionId);
}
