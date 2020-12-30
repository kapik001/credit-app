package com.kapusta.webapp.service;

import com.kapusta.webapp.dto.LoginDataDTO;

import java.util.Observer;
import java.util.function.Consumer;

public interface LoginService {
    void login(LoginDataDTO loginDataDTO, Consumer<Boolean> atResponse, Consumer<Throwable> atError);
}
