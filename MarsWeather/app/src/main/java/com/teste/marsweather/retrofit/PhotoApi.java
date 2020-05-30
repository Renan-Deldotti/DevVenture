package com.teste.marsweather.retrofit;

import com.teste.marsweather.model.MarsPhoto;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PhotoApi {

    @GET("rovers/curiosity/photos")
    Observable<MarsPhoto> getLatestPhotos(@Query("earth_date") String date, @Query("camera") String camera);


    @GET("rovers/curiosity/photos")
    Observable<MarsPhoto> getLatestPhotosWithoutCamera(@Query("earth_date") String date);
}
