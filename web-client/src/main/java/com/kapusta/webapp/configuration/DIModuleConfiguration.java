package com.kapusta.webapp.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import com.kapusta.webapp.controller.LoginSceneController;
import com.kapusta.webapp.controller.MainSceneController;
import com.kapusta.webapp.fxmlutils.FXMLHolder;
import com.kapusta.webapp.rest.ResourceGenerator;
import com.kapusta.webapp.rest.ResourceGeneratorImpl;
import com.kapusta.webapp.rest.clients.*;
import com.kapusta.webapp.service.*;
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

    private void configureDependencies() {
        bindBasicDependencies();
        bindControllerDependencies();
        bindListeners();
    }

    private void bindBasicDependencies() {
        bind(LoginSceneFactory.class).to(LoginSceneFactoryImpl.class);
        bind(LoginService.class).to(LoginServiceImpl.class);
        bind(PropertiesRepository.class).to(PropertiesRepositoryImpl.class);
        bind(MainStageHolder.class).to(MainStageHolderImpl.class);
        bind(LoginClient.class).to(LoginClientImpl.class);
        bind(TokenRecoveryService.class).to(TokenRecoveryServiceImpl.class);
        bind(MainSceneService.class).to(MainSceneServiceImpl.class);
        bind(UserClient.class).to(UserClientImpl.class);
        bind(ResourceGenerator.class).to(ResourceGeneratorImpl.class);
    }

    private void bindControllerDependencies() {
        bind(new TypeLiteral<FXMLHolder<LoginSceneController>>() {
        }).toProvider(LoginSceneControllerProvider.class);
        bind(new TypeLiteral<FXMLHolder<MainSceneController>>() {
        }).toProvider(MainSceneControllerProvider.class);
    }

    private void bindListeners() {
        bindListener(Matchers.any(), new TypeListener() {
            @Override
            public <I> void hear(final TypeLiteral<I> typeLiteral, TypeEncounter<I> typeEncounter) {
                typeEncounter.register((InjectionListener<I>) i -> {
                    if (i instanceof AbleToInit) {
                        ((AbleToInit) i).onInit();
                    }
                });
            }
        });
    }
}
