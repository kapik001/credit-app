package com.kapusta.credit.app.server;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.kapusta.credit.app.server.configuration.DIModuleConfiguration;
import javafx.application.Application;
import javafx.stage.Stage;



public class Run extends Application {

    @Override
    public void start(Stage stage) {
        Injector injector = Guice.createInjector(new DIModuleConfiguration());
        WebClientInitializer webClientInitializer = injector.getInstance(WebClientInitializer.class);
        webClientInitializer.init(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}