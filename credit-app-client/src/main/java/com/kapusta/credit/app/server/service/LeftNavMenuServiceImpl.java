package com.kapusta.credit.app.server.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kapusta.credit.app.server.controller.LoanRequestController;
import com.kapusta.credit.app.server.fxmlutils.FXMLHolder;

@Singleton
public class LeftNavMenuServiceImpl implements LeftNavMenuService{

    @Inject
    private MainSceneService mainSceneService;

    @Inject
    private FXMLHolder<LoanRequestController> loanRequestController;

    public void newLoanRequest(){
        this.loanRequestController.getController().initLoanRequest();
        this.mainSceneService.setCenterRoot(this.loanRequestController.getRoot());
    }
}
