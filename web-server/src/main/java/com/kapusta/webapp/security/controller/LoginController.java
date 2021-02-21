package com.kapusta.webapp.security.controller;

import com.kapusta.webapp.dto.LoginDataDTO;
import com.kapusta.webapp.dto.LoginResponseDTO;
import com.kapusta.webapp.security.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private UserAuthenticationService authentication;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public LoginResponseDTO login(@RequestBody LoginDataDTO loginData) {
        String token = authentication.login(loginData.getLogin(), loginData.getPassword());
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setToken(token);
        return loginResponseDTO;
    }
}
