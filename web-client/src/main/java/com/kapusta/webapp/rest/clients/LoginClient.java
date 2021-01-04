package com.kapusta.webapp.rest.clients;

import com.kapusta.webapp.dto.LoginDataDTO;
import com.kapusta.webapp.dto.LoginResponseDTO;

import java.util.function.Consumer;

public interface LoginClient {
    void login(LoginDataDTO loginDataDTO, Consumer<LoginResponseDTO> atResponse, Consumer<Throwable> atError);
}
