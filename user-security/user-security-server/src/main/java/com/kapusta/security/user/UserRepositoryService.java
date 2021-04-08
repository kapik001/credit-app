package com.kapusta.security.user;

import com.kapusta.security.user.entity.User;

interface UserRepositoryService {
    User save(User user);
    User findByLogin(String login);
}