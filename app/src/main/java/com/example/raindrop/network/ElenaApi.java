package com.example.raindrop.network;

import com.example.raindrop.models.Leagues;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ElenaApi {
    @GET("Leagues")
    Call<Leagues> getLeagues(@Query("expand") String expand);

}
