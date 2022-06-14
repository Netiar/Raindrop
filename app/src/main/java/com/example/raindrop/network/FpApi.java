package com.example.raindrop.network;



import com.example.raindrop.models.Leagues;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ElenaApi {
    @POST("token")
    Call<Response> getToken(@Header("Authorization") String auth);


    @GET("leagues")
    Call<List<Leagues>> getLeagues(@Header("Authorization") String authToken);







}
