package com.kapusta.security.user;


import com.kapusta.security.user.dto.LoginDataDTO;
import com.kapusta.security.user.dto.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
class LoginController {

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
