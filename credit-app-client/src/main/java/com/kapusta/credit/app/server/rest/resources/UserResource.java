package com.kapusta.credit.app.server.rest.resources;

import com.kapusta.security.user.dto.UserDetailsDTO;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UserResource {

    @GET("/user/get")
    Call<UserDetailsDTO> getUserDetails();
}
