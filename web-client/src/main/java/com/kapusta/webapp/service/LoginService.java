package com.kapusta.webapp.service;

import com.kapusta.webapp.dto.LoginDataDTO;

import java.util.Observer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public interface LoginService {
    void login(String login, String password, Supplier<Void> atSuccess, Supplier<Void> atError);
}
