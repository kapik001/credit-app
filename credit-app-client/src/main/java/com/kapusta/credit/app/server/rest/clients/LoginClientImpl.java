package com.kapusta.credit.app.server.rest.clients;

import com.google.inject.Inject;
import com.kapusta.credit.app.server.rest.ResourceGenerator;
import com.kapusta.credit.app.server.rest.resources.LoginResource;


import com.kapusta.security.user.dto.LoginDataDTO;
import com.kapusta.security.user.dto.LoginResponseDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.function.Consumer;

public class LoginClientImpl implements LoginClient {

    @Inject
    private ResourceGenerator resourceGenerator;

    @Override
    public void login(LoginDataDTO loginDataDTO, Consumer<LoginResponseDTO> atResponse, Consumer<Throwable> atError) {
        LoginResource loginResource = resourceGenerator.getResource(LoginResource.class);
        loginResource.login(loginDataDTO).enqueue(
                new Callback<LoginResponseDTO>() {
                    @Override
                    public void onResponse(Call<LoginResponseDTO> call, Response<LoginResponseDTO> response) {
                        if (response.isSuccessful()) {
                            atResponse.accept(response.body());
                        } else {
                            if (response.errorBody() != null) {
                                atError.accept(new RestClientException(response.errorBody().toString()));
                            } else {
                                atError.accept(new RestClientException("Problem during calling login method"));
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponseDTO> call, Throwable throwable) {
                        atError.accept(throwable);
                    }
                }
        );
    }
}
