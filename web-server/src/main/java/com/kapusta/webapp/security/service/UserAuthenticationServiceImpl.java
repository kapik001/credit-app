package com.kapusta.webapp.security.service;

import com.kapusta.webapp.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

    @Autowired
    private UserRepositoryService usersRepo;

    @Autowired
    private TokenService tokenService;

    @Override
    public String login(String username, String password) {
        User user = usersRepo.findByLogin(username);
        if (user.getPassword().equals(password)) {
            return tokenService.expiring(Map.of("username", username));
        } else {
            return null;
        }
    }

    @Override
    public User findByToken(String token) {
        Map<String, String> loadedFromToken = tokenService.verify(token);
        if (loadedFromToken != null && !loadedFromToken.isEmpty()) {
            String userName = loadedFromToken.get("username");
            return usersRepo.findByLogin(userName);
        } else {
            return null;
        }
    }

    @Override
    public void logout(User user) {

    }
}
