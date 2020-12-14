package com.kapusta.webapp;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.kapusta.webapp.controller.LoginSceneController;
import com.kapusta.webapp.fxmlutils.FXMLHolder;
import com.kapusta.webapp.fxmlutils.FXMLHolderFactory;

public class LoginSceneControllerProvider implements Provider<FXMLHolder<LoginSceneController>> {

    @Inject
    private LoginSceneController loginSceneController;

    @Override
    public FXMLHolder<LoginSceneController> get() {
        return FXMLHolderFactory.createFXMLHolder(loginSceneController);
    }
}
