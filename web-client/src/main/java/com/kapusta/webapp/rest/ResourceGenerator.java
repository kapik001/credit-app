package com.kapusta.webapp.rest;

public interface ResourceGenerator {
    <RESOURCE> RESOURCE getResource(Class<RESOURCE> resourceClass);
}
