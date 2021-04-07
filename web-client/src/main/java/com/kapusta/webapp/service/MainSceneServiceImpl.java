package com.kapusta.webapp.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kapusta.webapp.controller.MainSceneController;
import com.kapusta.webapp.fxmlutils.FXMLHolder;
import com.kapusta.webapp.rest.clients.UserClient;
import com.kapusta.webapp.utils.WebClientLogger;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;

@Singleton
public class MainSceneServiceImpl implements MainSceneService {

    @Inject
    private FXMLHolder<MainSceneController> mainSceneController;

    @Inject
    private MainStageHolder mainStageHolder;

    @Inject
    private LogoutService logoutService;

    @Inject
    private UserClient userClient;

    @Inject
    private UserContextHolder userContextHolder;

    public void init() {
        userClient.getUserData((userData) -> {
            Platform.runLater(() -> mainStageHolder.changeRoot(mainSceneController.getRoot()));
            userContextHolder.putUser(userData);
            mainSceneController.getController().initMenuAfterSuccessfulLogin();
        }, (t) -> {
            WebClientLogger.logError("Error during retrieving user data", t);
            logoutService.logout();
        });
    }

    public void setCenterRoot(Parent root){
        this.mainSceneController.getController().setCenterRoot(root);
    }
}
