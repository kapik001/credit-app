package com.kapusta.security.user;

import com.kapusta.security.user.dto.UserDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
