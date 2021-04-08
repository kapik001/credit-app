package com.kapusta.credit.app.server.configuration;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.kapusta.credit.app.server.controller.LoginSceneController;
import com.kapusta.credit.app.server.fxmlutils.FXMLHolderFactory;
import com.kapusta.credit.app.server.fxmlutils.FXMLHolder;

public class LoginSceneControllerProvider implements Provider<FXMLHolder<LoginSceneController>> {

    @Inject
    private LoginSceneController loginSceneController;

    @Override
    public FXMLHolder<LoginSceneController> get() {
        return FXMLHolderFactory.createFXMLHolder(loginSceneController);
    }
}
