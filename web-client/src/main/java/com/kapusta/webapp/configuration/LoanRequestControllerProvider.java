package com.kapusta.webapp.configuration;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.kapusta.webapp.controller.LeftNavMenuController;
import com.kapusta.webapp.controller.LoanRequestController;
import com.kapusta.webapp.fxmlutils.FXMLHolder;
import com.kapusta.webapp.fxmlutils.FXMLHolderFactory;

public class LoanRequestControllerProvider implements Provider<FXMLHolder<LoanRequestController>> {

    @Inject
    private LoanRequestController loanRequestController;

    @Override
    public FXMLHolder<LoanRequestController> get() {
        return FXMLHolderFactory.createFXMLHolder(loanRequestController);
    }
}
