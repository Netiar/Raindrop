package com.example.raindrop.network;

import com.example.raindrop.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FpClient {

    private static Retrofit retrofit = null;

    public static FpApi getClient()  {




        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request().newBuilder()
                           .addHeader("X-RapidAPI-Key", Constants.X_RAPIDAPI_KEY)
                           .addHeader("X-RapidAPI-Host", "football-prediction-api.p.rapidapi.com")
                           .addHeader("Content-Type", "application/json")
                           .addHeader("Accept", "application/json")
                                    .build();
                            return chain.proceed(request);}
                    }).build();



            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(FpApi.class);
    }


}
