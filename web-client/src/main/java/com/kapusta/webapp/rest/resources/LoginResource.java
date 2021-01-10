package com.kapusta.webapp.rest.resources;

import com.kapusta.webapp.dto.LoginDataDTO;
import com.kapusta.webapp.dto.LoginResponseDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginResource {

    @POST("/login-into-application")
    Call<LoginResponseDTO> login(@Body LoginDataDTO loginDataDTO);
}
