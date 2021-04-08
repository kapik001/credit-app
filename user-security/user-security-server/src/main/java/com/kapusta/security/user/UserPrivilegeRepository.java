package com.kapusta.security.user;

import com.kapusta.security.user.entity.Privilege;

interface UserPrivilegeRepository {
    Privilege findByName(String name);
    void save(Privilege privilege);
}
