package com.kapusta.credit.app.server;

import com.google.inject.Inject;
import com.kapusta.credit.app.server.service.LoginSceneFactory;
import com.kapusta.credit.app.server.service.MainStageHolder;
import com.kapusta.credit.app.server.service.TokenRepositoryService;
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
