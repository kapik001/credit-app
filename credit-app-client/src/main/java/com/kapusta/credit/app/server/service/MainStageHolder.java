package com.kapusta.credit.app.server.service;

import com.jpro.webapi.WebAPI;
import javafx.scene.Parent;
import javafx.stage.Stage;

public interface MainStageHolder {
    void changeRoot(Parent root);
    void setStage(Stage stage);
    WebAPI getWebAPI();
}
