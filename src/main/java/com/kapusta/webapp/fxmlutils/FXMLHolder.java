package com.kapusta.webapp.fxmlutils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class FXMLHolder<FXML_CONTROLLER> {
    private FXML_CONTROLLER controller;
    private FXMLLoader loader;
    private Parent parent;

    FXMLHolder(FXML_CONTROLLER controller, FXMLLoader loader, Parent parent){
        this.controller = controller;
        this.loader = loader;
        this.parent = parent;
    };

    public Parent getRoot(){
        return parent;
    }
}
