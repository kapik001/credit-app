package com.kapusta.webapp;

import com.google.inject.Inject;
import com.jpro.webapi.WebAPI;
import com.kapusta.webapp.service.LoginSceneFactory;
import com.kapusta.webapp.service.MainStageHolder;
import com.kapusta.webapp.service.SessionRecoveryService;
import com.kapusta.webapp.utils.WebClientLogger;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WebClientInitializer {

    @Inject
    private LoginSceneFactory loginSceneFactory;

    @Inject
    private MainStageHolder mainStageHolder;

    @Inject
    private SessionRecoveryService sessionRecoveryService;

    public void init(Stage stage) {

        mainStageHolder.setStage(stage);
        stage.setTitle("Web client");
        Scene firstScene = null;
        if (!sessionRecoveryService.recoverSession()) {
            firstScene = loginSceneFactory.factorScene();
        }
        stage.setScene(firstScene);
        stage.setMaximized(true);
        stage.show();

    }


}
