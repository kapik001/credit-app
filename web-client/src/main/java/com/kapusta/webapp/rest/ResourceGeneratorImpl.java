package com.kapusta.webapp.rest;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kapusta.webapp.configuration.AbleToInit;
import com.kapusta.webapp.service.PropertiesRepository;
import com.kapusta.webapp.service.TokenRecoveryService;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Singleton
public class ResourceGeneratorImpl implements ResourceGenerator, AbleToInit {

    private Retrofit retrofit;

    @Inject
    private TokenRecoveryService tokenRecoveryService;

    @Inject
    private PropertiesRepository propertiesRepository;

    @Override
    public void onInit() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(chain -> {
            Request original = chain.request();

            Request request = original.newBuilder()
                    .header("Authorization", "Bearer " + tokenRecoveryService.getToken())
                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(request);
        });
        retrofit = new Retrofit.Builder().baseUrl(propertiesRepository.getRemoteWebServerUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();

    }

    @Override
    public <RESOURCE> RESOURCE getResource(Class<RESOURCE> resourceClass) {
        return retrofit.create(resourceClass);
    }


}
