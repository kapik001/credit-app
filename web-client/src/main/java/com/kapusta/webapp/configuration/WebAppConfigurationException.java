package com.kapusta.webapp.configuration;

public class WebAppConfigurationException extends RuntimeException {
    public WebAppConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public WebAppConfigurationException(String message) {
        super(message);
    }
}
