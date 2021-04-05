package com.kapusta.webapp.security;

import com.kapusta.webapp.security.entity.User;

interface UserAuthenticationService {

    String login(String username, String password);

    User findByToken(String token);

    void logout(User user);
}
