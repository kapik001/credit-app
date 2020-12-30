package com.kapusta.webapp.controller;

import com.kapusta.webapp.dto.LoginDataDTO;
import com.kapusta.webapp.dto.LoginResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @RequestMapping(value = "login-into-application", method = RequestMethod.POST)
    public LoginResponseDTO login(@RequestBody LoginDataDTO loginData) {
        Boolean result = ("admin".equals(loginData.getLogin()) && "admin".equals(loginData.getPassword()));
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setResult(result);
        return loginResponseDTO;
    }
}
