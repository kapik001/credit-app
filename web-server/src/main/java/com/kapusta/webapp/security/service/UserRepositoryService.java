package com.kapusta.webapp.security.service;

import com.kapusta.webapp.security.entity.User;

public interface UserRepositoryService {
    User save(User user);
    User findByLogin(String login);
}