package com.kapusta.credit.app.server.service;


import java.util.function.Supplier;

public interface LoginService {
    void login(String login, String password, Supplier<Void> atSuccess, Supplier<Void> atError);
}
