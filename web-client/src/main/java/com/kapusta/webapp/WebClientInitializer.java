package com.kapusta.webapp;

import com.google.inject.Inject;
import com.kapusta.webapp.service.LoginSceneFactory;
import com.kapusta.webapp.service.MainStageHolder;
import com.kapusta.webapp.service.TokenRecoveryService;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WebClientInitializer {

    @Inject
    private LoginSceneFactory loginSceneFactory;

    @Inject
    private MainStageHolder mainStageHolder;

    @Inject
    private TokenRecoveryService tokenRecoveryService;

    public void init(Stage stage) {

        mainStageHolder.setStage(stage);
        stage.setTitle("Web client");
        Scene firstScene = null;
        if (!tokenRecoveryService.recoverToken()) {
            firstScene = loginSceneFactory.factorScene();
        }
        stage.setScene(firstScene);
        stage.setMaximized(true);
        stage.show();

    }


}
