package com.kapusta.webapp.service;

import com.google.inject.Inject;
import com.kapusta.webapp.dto.LoginDataDTO;
import com.kapusta.webapp.dto.LoginResponseDTO;
import com.kapusta.webapp.utils.WebClientLogger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.MediaType;

import java.util.concurrent.Future;
import java.util.function.Consumer;


public class LoginServiceImpl implements LoginService {

    @Inject
    private PropertiesRepository propertiesRepository;

    @Override
    public void login(LoginDataDTO loginDataDTO, Consumer<Boolean> atResponse, Consumer<Throwable> atError) {
        Client client = ClientBuilder.newClient();
        Future<LoginResponseDTO> res = client.target(propertiesRepository.getRemoteWebServerUrl())
                .path("login-into-application")
                .request(MediaType.APPLICATION_JSON)
                .async()
                .post(Entity.entity(loginDataDTO, MediaType.APPLICATION_JSON), new InvocationCallback<LoginResponseDTO>() {
                    @Override
                    public void completed(LoginResponseDTO loginResponseDTO) {
                        atResponse.accept(loginResponseDTO.getResult());
                        client.close();
                    }

                    @Override
                    public void failed(Throwable throwable) {
                        atError.accept(throwable);
                        client.close();
                    }
                });

    }
}
