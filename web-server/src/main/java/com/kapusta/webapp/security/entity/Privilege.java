package com.kapusta.webapp.security.entity;

import java.io.Serializable;
import java.util.Collection;

public class Privilege implements Serializable {
    private String name;

    public Privilege(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
