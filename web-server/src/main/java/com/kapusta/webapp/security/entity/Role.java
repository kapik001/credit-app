package com.kapusta.webapp.security.entity;

import java.io.Serializable;
import java.util.Collection;

public class Role implements Serializable {
    private String name;
    private Collection<Privilege> privileges;

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }
}
