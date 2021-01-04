package com.kapusta.webapp.configuration;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.kapusta.webapp.controller.LoginSceneController;
import com.kapusta.webapp.controller.MainSceneController;
import com.kapusta.webapp.fxmlutils.FXMLHolder;
import com.kapusta.webapp.fxmlutils.FXMLHolderFactory;

public class MainSceneControllerProvider implements Provider<FXMLHolder<MainSceneController>> {

    @Inject
    private MainSceneController mainSceneController;

    @Override
    public FXMLHolder<MainSceneController> get() {
        return FXMLHolderFactory.createFXMLHolder(mainSceneController);
    }
}
