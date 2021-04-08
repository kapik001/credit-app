package com.kapusta.credit.app.server.rest;

public interface ResourceGenerator {
    <RESOURCE> RESOURCE getResource(Class<RESOURCE> resourceClass);
}
