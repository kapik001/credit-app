package com.kapusta.webapp.service;

import com.google.inject.Inject;
import com.kapusta.webapp.controller.LoginSceneController;
import com.kapusta.webapp.fxmlutils.FXMLHolder;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.io.IOException;

public class SceneFactoryImpl implements SceneFactory {

    @Inject
    private FXMLHolder<LoginSceneController> loginSceneHolder;

    @Override
    public Scene factorScene() {
        Scene scene = new Scene(loginSceneHolder.getRoot());
        JMetro jMetro = new JMetro(Style.LIGHT);
        jMetro.setScene(scene);
        return scene;
    }
}
