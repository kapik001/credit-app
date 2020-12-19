package com.kapusta.webapp.service;

import com.kapusta.webapp.utils.WebClientLogger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Observable;
import java.util.function.Consumer;


public class LoginServiceImpl extends Observable implements LoginService {

    @Override
    public void login(String login, String password) {
        Client client = ClientBuilder.newClient();
        client.target("http://127.0.0.1:8081/loginintoapplication/" + login + "/" + password)
                .request(MediaType.APPLICATION_JSON)
                .async()
                .get(new InvocationCallback<Boolean>() {
                    @Override
                    public void completed(Boolean aBoolean) {
                        setChanged();
                        notifyObservers(aBoolean);
                    }

                    @Override
                    public void failed(Throwable throwable) {
                        WebClientLogger.logError("Problem during login into application", throwable);
                    }
                });
    }
}
