package com.kapusta.credit.app.server.configuration;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.kapusta.credit.app.server.fxmlutils.FXMLHolderFactory;
import com.kapusta.credit.app.server.controller.LoanRequestController;
import com.kapusta.credit.app.server.fxmlutils.FXMLHolder;

public class LoanRequestControllerProvider implements Provider<FXMLHolder<LoanRequestController>> {

    @Inject
    private LoanRequestController loanRequestController;

    @Override
    public FXMLHolder<LoanRequestController> get() {
        return FXMLHolderFactory.createFXMLHolder(loanRequestController);
    }
}
