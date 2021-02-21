package com.kapusta.webapp.security.service;

import com.kapusta.webapp.security.entity.User;

public interface UserAuthenticationService {

    String login(String username, String password);

    User findByToken(String token);

    void logout(User user);
}
