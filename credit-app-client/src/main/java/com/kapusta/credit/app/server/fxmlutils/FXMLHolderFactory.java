package com.kapusta.credit.app.server.fxmlutils;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class FXMLHolderFactory {
    public static <FXML_CONTROLLER> FXMLHolder<FXML_CONTROLLER> createFXMLHolder(FXML_CONTROLLER controller) throws FXMLHolderConfigurationException {
        try {
            PresentedBy annotation = controller.getClass().getAnnotation(PresentedBy.class);
            if (annotation == null) {
                throw new FXMLHolderConfigurationException("No PresentedBy annotation provided");
            }
            String fxmlPath = annotation.value();
            if (fxmlPath.isEmpty()) {
                throw new FXMLHolderConfigurationException("Empty resource path");
            }
            FXMLLoader loader = new FXMLLoader(controller.getClass().getClassLoader().getResource(fxmlPath));
            loader.setController(controller);
            Parent root = loader.load();
            if (root == null) {
                throw new FXMLHolderConfigurationException("Empty root for {" + controller.getClass().getName() + "}, recheck configuration");
            }
            return new FXMLHolder<>(controller, loader, root);
        } catch (Throwable t) {
            t.printStackTrace();
            throw new FXMLHolderConfigurationException("Impossible to create FXMLHolder for {" + controller.getClass().getName() + "}," +
                    " recheck configuration");
        }
    }
}
