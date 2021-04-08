package com.kapusta.credit.app.server.service;


import com.kapusta.security.user.dto.UserDetailsDTO;

public interface UserContextHolder {
    void putUser(UserDetailsDTO userDetailsDTO);
    UserDetailsDTO getUser();
}
