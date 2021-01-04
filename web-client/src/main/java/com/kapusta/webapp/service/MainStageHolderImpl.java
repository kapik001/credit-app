package com.kapusta.webapp.service;

import com.google.inject.Singleton;
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


}
