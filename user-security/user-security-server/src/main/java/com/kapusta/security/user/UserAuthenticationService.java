package com.kapusta.security.user;

import com.kapusta.security.user.entity.User;

interface UserAuthenticationService {

    String login(String username, String password);

    User findByToken(String token);

    void logout(User user);
}
