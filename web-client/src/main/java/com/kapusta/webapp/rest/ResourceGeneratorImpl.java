package com.kapusta.webapp.rest;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kapusta.webapp.configuration.AbleToInit;
import com.kapusta.webapp.service.PropertiesRepository;
import com.kapusta.webapp.service.TokenRepositoryService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class ResourceGeneratorImpl implements ResourceGenerator, AbleToInit {

    private Retrofit retrofit;

    @Inject
    private TokenRepositoryService tokenRepositoryService;

    @Inject
    private PropertiesRepository propertiesRepository;

    @Override
    public void onInit() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(chain -> {
            Request original = chain.request();

            Request request = original.newBuilder()
                    .header("Authorization", "Bearer " + tokenRepositoryService.getToken())
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
