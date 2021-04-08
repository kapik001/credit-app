package com.kapusta.credit.app.server.rest.clients;



import com.kapusta.security.user.dto.UserDetailsDTO;

import java.util.function.Consumer;

public interface UserClient {
    void getUserData(Consumer<UserDetailsDTO> atSuccess, Consumer<Throwable> atError);
}
