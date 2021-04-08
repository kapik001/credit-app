package com.kapusta.credit.app.server.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kapusta.credit.app.server.controller.LoginSceneController;
import com.kapusta.credit.app.server.fxmlutils.FXMLHolder;
import javafx.scene.Parent;

@Singleton
public class LoginSceneFactoryImpl implements LoginSceneFactory {

    @Inject
    private FXMLHolder<LoginSceneController> loginSceneHolder;

    @Override
    public Parent factorLoginRoot(){
        return loginSceneHolder.getRoot();
    }
}
