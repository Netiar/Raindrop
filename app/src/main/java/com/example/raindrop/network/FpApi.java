package com.example.raindrop.network;







import com.example.raindrop.models.Datum;
import com.example.raindrop.models.Odds;
import com.example.raindrop.models.Response;

import okhttp3.ResponseBody;
import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

import retrofit2.http.Path;
import retrofit2.http.Query;


public interface FpApi {
    @GET("predictions?market=classic&iso_date=2018-12-01&federation=UEFA")
    Call<Response> getPrediction();



















}
