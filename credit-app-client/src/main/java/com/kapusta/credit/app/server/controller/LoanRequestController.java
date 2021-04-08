package com.kapusta.credit.app.server.controller;

import com.google.inject.Singleton;
import com.kapusta.credit.app.server.fxmlutils.PresentedBy;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

@Singleton
@PresentedBy("scene-templates/loan-request.fxml")
public class LoanRequestController {

    @FXML
    private Pane clientDataPane;

    public void initLoanRequest(){
        this.clientDataPane.setDisable(true);
    }
}
