package com.kapusta.webapp.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kapusta.webapp.controller.LoginSceneController;
import com.kapusta.webapp.fxmlutils.FXMLHolder;
import javafx.scene.Parent;
import javafx.scene.Scene;

@Singleton
public class LoginSceneFactoryImpl implements LoginSceneFactory {

    @Inject
    private FXMLHolder<LoginSceneController> loginSceneHolder;

    @Override
    public Parent factorLoginRoot(){
        return loginSceneHolder.getRoot();
    }
}
