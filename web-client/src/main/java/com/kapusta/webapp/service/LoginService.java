package com.kapusta.webapp.service;

import java.util.Observer;

public interface LoginService {
    void login(String login, String password);
    void addObserver(Observer o);
}
