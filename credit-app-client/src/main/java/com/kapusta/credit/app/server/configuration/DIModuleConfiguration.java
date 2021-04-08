package com.kapusta.credit.app.server.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.internal.SingletonScope;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import com.kapusta.credit.app.server.controller.LeftNavMenuController;
import com.kapusta.credit.app.server.controller.LoginSceneController;
import com.kapusta.credit.app.server.controller.MainSceneController;
import com.kapusta.credit.app.server.rest.ResourceGenerator;
import com.kapusta.credit.app.server.rest.ResourceGeneratorImpl;
import com.kapusta.credit.app.server.rest.clients.LoginClient;
import com.kapusta.credit.app.server.rest.clients.LoginClientImpl;
import com.kapusta.credit.app.server.rest.clients.UserClient;
import com.kapusta.credit.app.server.rest.clients.UserClientImpl;
import com.kapusta.credit.app.server.service.*;
import com.kapusta.credit.app.server.controller.LoanRequestController;
import com.kapusta.credit.app.server.fxmlutils.FXMLHolder;
import com.kapusta.credit.app.server.utils.WebClientLogger;


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
        bind(LeftNavMenuService.class).to(LeftNavMenuServiceImpl.class);
    }

    private void bindControllerDependencies() {
        bind(new TypeLiteral<FXMLHolder<LoginSceneController>>() {
        }).toProvider(LoginSceneControllerProvider.class).in(new SingletonScope());
        bind(new TypeLiteral<FXMLHolder<MainSceneController>>() {
        }).toProvider(MainSceneControllerProvider.class).in(new SingletonScope());
        bind(new TypeLiteral<FXMLHolder<LeftNavMenuController>>() {
        }).toProvider(LeftNavMenuControllerProvider.class).in(new SingletonScope());
        bind(new TypeLiteral<FXMLHolder<LoanRequestController>>(){
        }).toProvider(LoanRequestControllerProvider.class).in(new SingletonScope());
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
