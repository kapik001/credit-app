package com.kapusta.webapp.rest.clients;

import com.kapusta.webapp.dto.UserDetailsDTO;

import java.util.function.Consumer;

public interface UserClient {
    void getUserData(Consumer<UserDetailsDTO> atSuccess, Consumer<Throwable> atError);
}
