package com.yashraj.groceryapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi
{
    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    Retrofit retrofit=null;
    public static final String
            BASE_URL="https://api.data.gov.in/resource/9ef84268-d588-465a-a308-a864a43d0070/";

    public Retrofit getRetrofit() {
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
