package com.kapusta.webapp.rest.resources;

import com.kapusta.webapp.dto.UserDetailsDTO;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UserResource {

    @GET("/user/get")
    Call<UserDetailsDTO> getUserDetails();
}
