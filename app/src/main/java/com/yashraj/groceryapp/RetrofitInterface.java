package com.yashraj.groceryapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("/")
    Call<Root> getRecords(@Query("api-key") String api_key,@Query("format")String format,@Query("offset") int offset,@Query("limit")int limit);

    @GET("/")
    Call<List<Records>> getRecord(@Query("api-key") String api_key,@Query("format")String format,@Query("offset") int offset,@Query("limit")int limit);
}
