package com.kapusta.webapp.security;

import com.kapusta.webapp.security.entity.Role;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;

@Service
class InMemoryUserRoleRepositoryImpl implements UserRoleRepository {

    private final Collection<Role> roles;

    public InMemoryUserRoleRepositoryImpl() {
        roles = new LinkedList<>();
    }

    @Override
    public Role findByName(String name) {
        return roles.stream().filter( r -> name.equals(r.getName())).findAny().orElse(null);
    }

    @Override
    public void save(Role role) {
        if(findByName(role.getName()) == null){
            roles.add(role);
        }
    }
}
