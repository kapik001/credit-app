package com.kapusta.webapp;

import com.google.inject.Inject;
import com.kapusta.webapp.service.InitSceneFactory;
import com.kapusta.webapp.service.MainStageHolder;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WebClientInitializer {

    @Inject
    private InitSceneFactory initSceneFactory;

    @Inject
    private MainStageHolder mainStageHolder;

    public void init(Stage stage){
        stage.setTitle("Web client");
        Scene mainScene = initSceneFactory.factorScene();
        stage.setScene(mainScene);
        stage.setMaximized(true);
        stage.show();
        mainStageHolder.setStage(stage);
    }
}
