package com.kapusta.webapp.security;

import com.kapusta.webapp.security.entity.Privilege;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;

@Service
class InMemoryUserPrivilegeRepositoryImpl implements UserPrivilegeRepository {

    private final Collection<Privilege> privileges;

    public InMemoryUserPrivilegeRepositoryImpl() {
        privileges = new LinkedList<>();
    }

    @Override
    public Privilege findByName(String name){
        return privileges.stream().filter( p -> name.equals(p.getName())).findAny().orElse(null);
    }

    @Override
    public void save(Privilege privilege) {
        if (findByName(privilege.getName()) == null){
            privileges.add(privilege);
        }
    }
}
