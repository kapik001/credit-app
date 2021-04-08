package com.kapusta.security.user.dto;

import java.io.Serializable;

public class LoginResponseDTO implements Serializable {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
