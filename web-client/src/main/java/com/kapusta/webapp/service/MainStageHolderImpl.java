package com.kapusta.webapp.service;

import com.google.inject.Singleton;
import com.jpro.webapi.WebAPI;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@Singleton
public class MainStageHolderImpl implements MainStageHolder {

    private Stage stage;

    @Override
    public void changeRoot(Parent root) {
        if (this.stage.getScene() == null) {
            this.stage.setScene(new Scene(root));
        }
        this.stage.getScene().setRoot(root);
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
