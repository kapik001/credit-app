package com.kapusta.webapp.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kapusta.webapp.controller.LoanRequestController;
import com.kapusta.webapp.controller.MainSceneController;
import com.kapusta.webapp.fxmlutils.FXMLHolder;

@Singleton
public class LeftNavMenuServiceImpl implements LeftNavMenuService{

    @Inject
    private MainSceneService mainSceneService;

    @Inject
    private FXMLHolder<LoanRequestController> loanRequestController;

    public void newLoanRequest(){
        this.mainSceneService.setCenterRoot(loanRequestController.getRoot());
    }
}
