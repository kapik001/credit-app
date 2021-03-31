package com.kapusta.webapp.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.internal.SingletonScope;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import com.kapusta.webapp.controller.LeftNavMenuController;
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
        bind(TokenRepositoryService.class).to(TokenRepositoryServiceImpl.class);
        bind(MainSceneService.class).to(MainSceneServiceImpl.class);
        bind(UserClient.class).to(UserClientImpl.class);
        bind(ResourceGenerator.class).to(ResourceGeneratorImpl.class);
        bind(LogoutService.class).to(LogoutServiceImpl.class);
        bind(UserContextHolder.class).to(UserContextHolderImpl.class);
    }

    private void bindControllerDependencies() {
        bind(new TypeLiteral<FXMLHolder<LoginSceneController>>() {
        }).toProvider(LoginSceneControllerProvider.class).in(new SingletonScope());
        bind(new TypeLiteral<FXMLHolder<MainSceneController>>() {
        }).toProvider(MainSceneControllerProvider.class).in(new SingletonScope());
        bind(new TypeLiteral<FXMLHolder<LeftNavMenuController>>() {
        }).toProvider(LeftNavMenuControllerProvider.class).in(new SingletonScope());
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
