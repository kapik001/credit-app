package com.kapusta.webapp.security;

import com.kapusta.webapp.security.entity.User;

interface UserRepositoryService {
    User save(User user);
    User findByLogin(String login);
}