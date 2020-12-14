package com.kapusta.webapp.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WebClientLogger {
    private static final Logger logger = Logger.getLogger(WebClientLogger.class.getName());

    public static void logError(String error) {
        logger.log(Level.INFO, error);
    }

    public static void logError(String error, Throwable t) {

        logger.log(Level.INFO, error, t);
    }
}
