package com.kapusta.credit.app.server.rest.clients;


import com.kapusta.security.user.dto.LoginDataDTO;
import com.kapusta.security.user.dto.LoginResponseDTO;

import java.util.function.Consumer;

public interface LoginClient {
    void login(LoginDataDTO loginDataDTO, Consumer<LoginResponseDTO> atResponse, Consumer<Throwable> atError);
}
