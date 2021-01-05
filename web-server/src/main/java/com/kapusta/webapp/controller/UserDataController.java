package com.kapusta.webapp.controller;

import com.kapusta.webapp.dto.UserDetailsDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserDataController {

    @RequestMapping("get")
    public UserDetailsDTO getUserDetails(){
        UserDetailsDTO userDetails = new UserDetailsDTO();
        userDetails.setEmail("test@gmail.com");
        userDetails.setFirstName("John");
        userDetails.setLastName("Goldenberg");
        userDetails.setLogin("GOLDI");
        return userDetails;
    }
}
