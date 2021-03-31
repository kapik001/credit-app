package com.kapusta.webapp.service;

import com.kapusta.webapp.dto.UserDetailsDTO;

public interface UserContextHolder {
    void putUser(UserDetailsDTO userDetailsDTO);
    UserDetailsDTO getUser();
}
