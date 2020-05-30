package com.teste.marsweather.dependecyInjection;

import com.teste.marsweather.retrofit.PhotoApi;

import dagger.Module;
import dagger.Provides;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitPhotoModule {

    private static final String photosBaseUrl = "https://mars-photos.herokuapp.com/api/v1/";

    @Provides
    public PhotoApi getRetrofitPhotoConfig() {
        return new Retrofit.Builder()
                .baseUrl(photosBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(PhotoApi.class);
    }
}
