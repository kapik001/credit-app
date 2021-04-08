package com.kapusta.credit.app.server.configuration;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.kapusta.credit.app.server.controller.LeftNavMenuController;
import com.kapusta.credit.app.server.fxmlutils.FXMLHolderFactory;
import com.kapusta.credit.app.server.fxmlutils.FXMLHolder;

public class LeftNavMenuControllerProvider implements Provider<FXMLHolder<LeftNavMenuController>> {

    @Inject
    private LeftNavMenuController leftNavMenuController;

    @Override
    public FXMLHolder<LeftNavMenuController> get() {
        return FXMLHolderFactory.createFXMLHolder(leftNavMenuController);
    }
} 