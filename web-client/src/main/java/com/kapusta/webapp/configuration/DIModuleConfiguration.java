package com.kapusta.webapp.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.kapusta.webapp.controller.LoginSceneController;
import com.kapusta.webapp.fxmlutils.FXMLHolder;
import com.kapusta.webapp.service.LoginService;
import com.kapusta.webapp.service.LoginServiceImpl;
import com.kapusta.webapp.service.SceneFactory;
import com.kapusta.webapp.service.SceneFactoryImpl;
import com.kapusta.webapp.utils.WebClientLogger;


public class DIModuleConfiguration extends AbstractModule {
    @Override
    protected void configure() {
        try {
            configureDependencies();
        } catch (Exception e) {
            WebClientLogger.logError("Problem during DI configuration", e);
        }
    }

    private void configureDependencies()  {
        bind(SceneFactory.class).to(SceneFactoryImpl.class);
        bind(LoginService.class).to(LoginServiceImpl.class);
        bind(new TypeLiteral<FXMLHolder<LoginSceneController>>() {
        }).toProvider(LoginSceneControllerProvider.class);
    }
}
