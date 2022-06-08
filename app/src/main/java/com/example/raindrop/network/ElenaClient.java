package com.example.raindrop.network;

import com.example.raindrop.Constants;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ElenaClient {

    private static Retrofit retrofit = null;

    public static ElenaApi getClient() throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://football.elenasport.io/v2/leagues?expand=***expand***&name=***name***&page=***page***")
                .get()
                .addHeader("Authorization", "***Authorization***")
                .build();

        Response response = client.newCall(request).execute();





//                .addInterceptor(new Interceptor(){
//                    @Override
//                    public okhttp3.Response intercept(Chain chain) throws IOException {
//                        okhttp3.Request request = chain.request();
//                        okhttp3.Request.Builder builder = request.newBuilder().addHeader("Authorization", Constants.API_KEY);
//                        return chain.proceed(builder.build());
//                    }
//                }).build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ElenaApi.class);
    }


}
