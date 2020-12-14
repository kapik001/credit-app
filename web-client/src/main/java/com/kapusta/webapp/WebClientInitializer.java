package com.kapusta.webapp;

import com.google.inject.Inject;
import com.kapusta.webapp.service.SceneFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WebClientInitializer {

    @Inject
    private SceneFactory sceneFactory;

    public void init(Stage stage){
        stage.setTitle("Web client");
        Scene mainScene = sceneFactory.factorScene();
        stage.setScene(mainScene);
        stage.setMaximized(true);
        stage.show();
    }
}
