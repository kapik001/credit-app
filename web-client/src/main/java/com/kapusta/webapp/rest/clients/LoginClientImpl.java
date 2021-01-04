package com.kapusta.webapp.rest.clients;

import com.google.inject.Inject;
import com.kapusta.webapp.dto.LoginDataDTO;
import com.kapusta.webapp.dto.LoginResponseDTO;
import com.kapusta.webapp.service.PropertiesRepository;
import javafx.application.Platform;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;
import java.util.function.Consumer;

public class LoginClientImpl implements LoginClient {

    @Inject
    private PropertiesRepository propertiesRepository;

    @Override
    public void login(LoginDataDTO loginDataDTO, Consumer<LoginResponseDTO> atResponse, Consumer<Throwable> atError) {
        Client client = ClientBuilder.newClient();
        Future<LoginResponseDTO> res = client.target(propertiesRepository.getRemoteWebServerUrl())
                .path("login-into-application")
                .request(MediaType.APPLICATION_JSON)
                .async()
                .post(Entity.entity(loginDataDTO, MediaType.APPLICATION_JSON), new InvocationCallback<LoginResponseDTO>() {
                    @Override
                    public void completed(LoginResponseDTO loginResponseDTO) {
                        atResponse.accept(loginResponseDTO);
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
