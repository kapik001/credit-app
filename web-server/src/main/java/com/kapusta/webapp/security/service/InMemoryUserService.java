package com.kapusta.webapp.security.service;

import com.kapusta.webapp.security.entity.User;
import com.kapusta.webapp.security.entity.UserPrivateData;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class InMemoryUserService implements UserRepositoryService {

    private List<User> users = new LinkedList<>();

    public InMemoryUserService() {
        UserPrivateData userPrivateData1 = new UserPrivateData();
        userPrivateData1.setEmail("admin@webapp");
        userPrivateData1.setFirstName("ADMINEK");
        userPrivateData1.setLastName("GOLDENSTEIN");
        User user1 = new User("admin", "admin", userPrivateData1);
        UserPrivateData userPrivateData2 = new UserPrivateData();
        userPrivateData2.setEmail("test@webapp");
        userPrivateData2.setFirstName("TEST");
        userPrivateData2.setLastName("TESTOWY");
        User user2 = new User("test", "test", userPrivateData2);
        users.add(user1);
        users.add(user2);
    }

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User findByLogin(String login) {
        return users.stream().filter(u -> login.equals(u.getLogin())).findAny().orElse(null);
    }
}
