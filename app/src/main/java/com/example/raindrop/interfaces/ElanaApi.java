package com.example.raindrop.interfaces;

import com.example.raindrop.models.Leagues;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ElanaApi {
    @GET("Leagues")
    Call<Leagues> getLeagues(@Query("api_key") String apiKey);



}
