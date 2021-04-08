package com.kapusta.credit.app.server.rest.clients;

import com.google.inject.Inject;
import com.kapusta.credit.app.server.rest.ResourceGenerator;
import com.kapusta.credit.app.server.rest.resources.UserResource;
import com.kapusta.security.user.dto.UserDetailsDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.function.Consumer;

public class UserClientImpl implements UserClient {

    @Inject
    private ResourceGenerator resourceGenerator;

    @Override
    public void getUserData(Consumer<UserDetailsDTO> atSuccess, Consumer<Throwable> atError) {
        UserResource userResource = resourceGenerator.getResource(UserResource.class);
        userResource.getUserDetails().enqueue(
                new Callback<UserDetailsDTO>() {
                    @Override
                    public void onResponse(Call<UserDetailsDTO> call, Response<UserDetailsDTO> response) {
                        if (response.isSuccessful()) {
                            atSuccess.accept(response.body());
                        } else {
                            if (response.errorBody() != null) {
                                try {
                                    atError.accept(new RestClientException("Problem: " + response.errorBody().string()));
                                } catch (IOException e) {
                                    atError.accept(new RestClientException("Error code: " + response.code()));
                                }
                            } else {
                                atError.accept(new RestClientException("Problem during calling user method"));
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<UserDetailsDTO> call, Throwable throwable) {
                        atError.accept(throwable);
                    }
                }
        );
    }
}
