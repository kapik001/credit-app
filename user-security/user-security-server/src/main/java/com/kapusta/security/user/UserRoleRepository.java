package com.kapusta.security.user;

import com.kapusta.security.user.entity.Role;

interface UserRoleRepository {
    Role findByName(String name);
    void save(Role privilege);
}
