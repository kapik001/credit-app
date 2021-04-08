package com.kapusta.credit.app.server.configuration;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.kapusta.credit.app.server.controller.MainSceneController;
import com.kapusta.credit.app.server.fxmlutils.FXMLHolderFactory;
import com.kapusta.credit.app.server.fxmlutils.FXMLHolder;

public class MainSceneControllerProvider implements Provider<FXMLHolder<MainSceneController>> {

    @Inject
    private MainSceneController mainSceneController;

    @Override
    public FXMLHolder<MainSceneController> get() {
        return FXMLHolderFactory.createFXMLHolder(mainSceneController);
    }
}
