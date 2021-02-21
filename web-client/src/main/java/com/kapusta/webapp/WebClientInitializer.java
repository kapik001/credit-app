package com.kapusta.webapp;

import com.google.inject.Inject;
import com.kapusta.webapp.service.LoginSceneFactory;
import com.kapusta.webapp.service.MainStageHolder;
import com.kapusta.webapp.service.TokenRepositoryService;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WebClientInitializer {

    @Inject
    private LoginSceneFactory loginSceneFactory;

    @Inject
    private MainStageHolder mainStageHolder;

    @Inject
    private TokenRepositoryService tokenRepositoryService;

    public void init(Stage stage) {

        mainStageHolder.setStage(stage);
        stage.setTitle("Web client");
        Scene firstScene = null;
        if (!tokenRepositoryService.recoverToken()) {
            firstScene = new Scene(loginSceneFactory.factorLoginRoot());
        }
        stage.setScene(firstScene);
        stage.setMaximized(true);
        stage.show();

    }


}
