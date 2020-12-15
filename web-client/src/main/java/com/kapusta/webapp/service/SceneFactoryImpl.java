package com.kapusta.webapp.service;

import com.google.inject.Inject;
import com.kapusta.webapp.controller.LoginSceneController;
import com.kapusta.webapp.fxmlutils.FXMLHolder;
import javafx.scene.Scene;


public class SceneFactoryImpl implements SceneFactory {

    @Inject
    private FXMLHolder<LoginSceneController> loginSceneHolder;

    @Override
    public Scene factorScene() {
        Scene scene = new Scene(loginSceneHolder.getRoot());
        return scene;
    }
}
