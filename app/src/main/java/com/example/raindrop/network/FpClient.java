package com.example.raindrop.network;

import com.example.raindrop.Constants;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ElenaClient {

    private static Retrofit retrofit = null;

    public static FpApi getClient() throws IOException {


        OkHttpClient client = new OkHttpClient().newBuilder()
                   .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://football.elenasport.io/v2/leagues?expand=***expand***&name=***name***&page=***page***")
                .get()
                .addHeader("Authorization", "Bearer ")
                .build();

        Response response = client.newCall(request).execute();


        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(FpApi.class);
    }


}
