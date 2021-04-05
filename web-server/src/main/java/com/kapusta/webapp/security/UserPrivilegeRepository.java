package com.kapusta.webapp.security;

import com.kapusta.webapp.security.entity.Privilege;

interface UserPrivilegeRepository {
    Privilege findByName(String name);
    void save(Privilege privilege);
}
