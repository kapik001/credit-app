package com.kapusta.webapp.service;

import com.google.inject.Singleton;
import com.kapusta.webapp.dto.UserDetailsDTO;

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
