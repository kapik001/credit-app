package com.kapusta.webapp.configuration;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.kapusta.webapp.controller.LeftNavMenuController;
import com.kapusta.webapp.controller.LoginSceneController;
import com.kapusta.webapp.fxmlutils.FXMLHolder;
import com.kapusta.webapp.fxmlutils.FXMLHolderFactory;

public class LeftNavMenuControllerProvider implements Provider<FXMLHolder<LeftNavMenuController>> {

    @Inject
    private LeftNavMenuController leftNavMenuController;

    @Override
    public FXMLHolder<LeftNavMenuController> get() {
        return FXMLHolderFactory.createFXMLHolder(leftNavMenuController);
    }
} 