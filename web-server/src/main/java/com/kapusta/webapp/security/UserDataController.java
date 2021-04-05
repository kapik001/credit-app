package com.kapusta.webapp.security;

import com.kapusta.webapp.dto.UserDetailsDTO;
import com.kapusta.webapp.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("user")
class UserDataController {

    @Autowired
    private UserRepositoryService userRepositoryService;

    @RequestMapping("get")
    public UserDetailsDTO getUserDetails(Authentication authentication) {
        return UserDetailsConverter.convertUser(userRepositoryService.findByLogin(authentication.getName()));
    }
}
