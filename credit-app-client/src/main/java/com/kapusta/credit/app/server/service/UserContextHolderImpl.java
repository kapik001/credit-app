package com.kapusta.credit.app.server.service;

import com.google.inject.Singleton;
import com.kapusta.security.user.dto.UserDetailsDTO;

@Singleton
public class UserContextHolderImpl implements UserContextHolder {
    private UserDetailsDTO userDetailsDTO;

    public void putUser(UserDetailsDTO userDetailsDTO) {
        this.userDetailsDTO = userDetailsDTO;
    }

    public UserDetailsDTO getUser() {
        return this.userDetailsDTO;
    }
}
