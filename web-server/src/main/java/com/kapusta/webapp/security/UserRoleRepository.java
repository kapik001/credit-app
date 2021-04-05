package com.kapusta.webapp.security;

import com.kapusta.webapp.security.entity.Role;

interface UserRoleRepository {
    Role findByName(String name);
    void save(Role privilege);
}
