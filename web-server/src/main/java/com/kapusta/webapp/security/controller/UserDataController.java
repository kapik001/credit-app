package com.kapusta.webapp.security.controller;

import com.kapusta.webapp.dto.UserDetailsDTO;
import com.kapusta.webapp.security.entity.User;
import com.kapusta.webapp.security.service.UserAuthenticationService;
import com.kapusta.webapp.security.service.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserDataController {

    @Autowired
    private UserRepositoryService userRepositoryService;

    @RequestMapping("get")
    public UserDetailsDTO getUserDetails(Authentication authentication){
        User user = userRepositoryService.findByLogin(authentication.getName());
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setLogin(user.getLogin());
        userDetailsDTO.setFirstName(user.getUserPrivateData().getFirstName());
        userDetailsDTO.setLastName(user.getUserPrivateData().getLastName());
        userDetailsDTO.setEmail(user.getUserPrivateData().getEmail());
        return userDetailsDTO;
    }
}
