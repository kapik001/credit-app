package com.kapusta.webapp.service;

import com.google.inject.Singleton;
import com.jpro.webapi.WebAPI;
import javafx.scene.Scene;
import javafx.stage.Stage;

@Singleton
public class MainStageHolderImpl implements MainStageHolder {

    private Stage stage;

    @Override
    public void changeScene(Scene scene) {
        this.stage.setScene(scene);
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public WebAPI getWebAPI() {
        if (stage == null) {
            return null;
        } else {
            return WebAPI.getWebAPI(stage);
        }
    }


}
