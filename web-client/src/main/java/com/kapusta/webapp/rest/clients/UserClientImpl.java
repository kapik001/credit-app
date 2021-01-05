package com.kapusta.webapp.rest.clients;

import com.google.inject.Inject;
import com.kapusta.webapp.dto.LoginResponseDTO;
import com.kapusta.webapp.dto.UserDetailsDTO;
import com.kapusta.webapp.service.PropertiesRepository;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.MediaType;
import java.util.function.Consumer;

public class UserClientImpl implements UserClient {

    @Inject
    private PropertiesRepository propertiesRepository;

    @Override
    public void getUserData(Consumer<UserDetailsDTO> atSuccess, Consumer<Throwable> atError) {
        Client client = ClientBuilder.newClient();
        client.target(propertiesRepository.getRemoteWebServerUrl())
                .path("user/get")
                .request(MediaType.APPLICATION_JSON)
                .async()
                .get(new InvocationCallback<UserDetailsDTO>() {
                    @Override
                    public void completed(UserDetailsDTO userDetailsDTO) {
                        atSuccess.accept(userDetailsDTO);
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
