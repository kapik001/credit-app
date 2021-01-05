package com.kapusta.webapp.service;

import com.jpro.webapi.WebAPI;
import javafx.scene.Scene;
import javafx.stage.Stage;

public interface MainStageHolder {
    void changeScene(Scene scene);
    void setStage(Stage stage);
    WebAPI getWebAPI();
}
