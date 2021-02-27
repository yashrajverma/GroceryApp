package com.yashraj.groceryapp.API;

import com.yashraj.groceryapp.Model.RecordsItem;
import com.yashraj.groceryapp.Model.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("/")
    Call<Response> getRecords(@Query("api-key") String api_key, @Query("format")String format, @Query("offset") int offset, @Query("limit")int limit);

//    @GET("/")
//    Call<List<RecordsItem>> getRecord(@Query("api-key") String api_key, @Query("format")String format, @Query("offset") int offset, @Query("limit")int limit);
}
