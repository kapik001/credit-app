package com.kapusta.credit.app.server.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kapusta.credit.app.server.service.LeftNavMenuService;
import com.kapusta.credit.app.server.service.UserContextHolder;
import com.kapusta.credit.app.server.fxmlutils.PresentedBy;
import com.kapusta.security.user.dto.UserDetailsDTO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.VBox;

@Singleton
@PresentedBy("scene-templates/left-nav-menu.fxml")
public class LeftNavMenuController {

    @Inject
    private UserContextHolder userContextHolder;

    @Inject
    private LeftNavMenuService leftNavMenuService;

    @FXML
    private MenuButton adminPanelMenu;

    @FXML
    private MenuButton loanRequestMenu;

    @FXML
    private VBox vBoxMenu;

    public void initLeftNavMenuController() {
        this.reset();
        UserDetailsDTO userDetails = userContextHolder.getUser();

        if (userDetails != null) {
            if (userDetails.getPrivileges().stream().noneMatch("LOAN_REQUEST"::equals)) {
                hideEntry(loanRequestMenu);
            }
            if (userDetails.getPrivileges().stream().noneMatch("ADMIN_TAB"::equals)) {
                hideEntry(adminPanelMenu);
            }
        }
    }

    @FXML
    public void newLoanRequest(){
        this.leftNavMenuService.newLoanRequest();
    }

    private void hideEntry(MenuButton menuButton) {
        Platform.runLater(() -> {
            menuButton.setVisible(false);
            vBoxMenu.getChildren().remove(menuButton);
        });
    }

    private void showEntry(MenuButton menuButton) {
        Platform.runLater(() -> {
            menuButton.setVisible(true);
            vBoxMenu.getChildren().add(menuButton);
        });
    }

    private void reset() {
        hideEntry(loanRequestMenu);
        hideEntry(adminPanelMenu);
        showEntry(loanRequestMenu);
        showEntry(adminPanelMenu);

    }

}
