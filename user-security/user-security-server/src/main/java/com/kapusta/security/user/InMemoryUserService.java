package com.kapusta.security.user;

import com.kapusta.security.user.entity.Role;
import com.kapusta.security.user.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
class InMemoryUserService implements UserRepositoryService {

    private final List<User> users = new LinkedList<>();

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User findByLogin(String login) {
        User user = users.stream().filter(u -> login.equals(u.getLogin())).findAny().orElse(null);
        if (user == null) {
            return null;
        }
        if (user.getRoles() != null) {
            for (Role role : user.getRoles()) {
                role.getPrivileges().forEach(p -> {
                    SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(p.getName());
                    user.getAuthorities().add(grantedAuthority);
                });
            }
        }
        return user;
    }
}
