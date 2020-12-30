package com.kapusta.webapp.dto;

import java.io.Serializable;

public class LoginResponseDTO implements Serializable {
    private Boolean result;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
