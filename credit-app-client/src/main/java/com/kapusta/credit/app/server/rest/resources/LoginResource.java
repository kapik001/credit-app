package com.kapusta.credit.app.server.rest.resources;

import com.kapusta.security.user.dto.LoginDataDTO;
import com.kapusta.security.user.dto.LoginResponseDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginResource {

    @POST("/login")
    Call<LoginResponseDTO> login(@Body LoginDataDTO loginDataDTO);
}
