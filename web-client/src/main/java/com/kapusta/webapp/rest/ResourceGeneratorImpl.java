package com.kapusta.webapp.rest;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kapusta.webapp.configuration.AbleToInit;
import com.kapusta.webapp.service.PropertiesRepository;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class ResourceGeneratorImpl implements ResourceGenerator, AbleToInit {

    private Retrofit retrofit;

    @Inject
    private PropertiesRepository propertiesRepository;

    @Override
    public void onInit() {
        retrofit = new Retrofit.Builder().baseUrl(propertiesRepository.getRemoteWebServerUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();

    }

    @Override
    public <RESOURCE> RESOURCE getResource(Class<RESOURCE> resourceClass) {
        return retrofit.create(resourceClass);
    }


}
