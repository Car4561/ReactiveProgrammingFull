package com.carlosllerenatest.reactiveprogrammingfull;


import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.Call;

public interface MoviesExtraInfoApisService {

    @GET("/")
    Call<OmdbApi> getExtraInfoMovie(@Query("t") String tittle,@Query("apikey") String apikey);

    @GET("/")
    Observable<OmdbApi> getExtraInfoMovieObservable(@Query("t") String tittle,@Query("apikey") String apikey);

}
