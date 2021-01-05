package com.kapusta.webapp.service;

import com.google.inject.Singleton;
import com.kapusta.webapp.configuration.AbleToInit;
import com.kapusta.webapp.configuration.WebAppConfigurationException;
import com.kapusta.webapp.utils.WebClientLogger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Singleton
public class PropertiesRepositoryImpl implements PropertiesRepository, AbleToInit {

    private Properties properties;
    private final static String REMOTE_WEB_SERVER_ADDRESS_PROPERTY_NAME = "remote-server-url";
    private final static String SESSION_COOKIE_PROPERTY_NAME = "session-cookie-name";

    @Override
    public void onInit() {
        properties = new Properties();
        String propertiesFileName = "application.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);

        if (inputStream != null) {
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                WebClientLogger.logError("Problem during loading of property file", e);
                throw new WebAppConfigurationException("Problem during loading of property file", e);
            }
        } else {
            WebClientLogger.logError("Problem during loading of property file");
            throw new WebAppConfigurationException("Problem during loading of property file");

        }
    }

    @Override
    public String getRemoteWebServerUrl() {
        return properties.getProperty(REMOTE_WEB_SERVER_ADDRESS_PROPERTY_NAME);
    }

    @Override
    public String getSessionCookiePropertyName(){
        return properties.getProperty(SESSION_COOKIE_PROPERTY_NAME);
    }
}
