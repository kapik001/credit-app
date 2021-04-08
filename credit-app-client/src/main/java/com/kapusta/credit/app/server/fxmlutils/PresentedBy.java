package com.kapusta.credit.app.server.fxmlutils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PresentedBy {
    String value();

}
