package com.yashraj.groceryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.yashraj.groceryapp.API.RetrofitApi;
import com.yashraj.groceryapp.API.RetrofitInterface;
import com.yashraj.groceryapp.Model.RecordsItem;
import com.yashraj.groceryapp.Model.Response;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adapter;
    Response root;
    RetrofitInterface retrofitInterface=new RetrofitApi().getRetrofit().create(RetrofitInterface.class);
    List<RecordsItem> recordsList;
    public static final String api_key="579b464db66ec23bdd0000019c31c18a3d734b335e6113d48c74e33f";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recordsList=new ArrayList<>();
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LoadData();
//        LoadRecord();
    }
    private void LoadData(){
        Call<Response> listCall=retrofitInterface.getRecords(api_key,"json",0,10);
       listCall.enqueue(new Callback<Response>() {
           @Override
           public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                   root=new Response(response.body());
                   recordsList=root.getRecords();
                   adapter=new Adapter(getApplicationContext(),recordsList);
                   recyclerView.setAdapter(adapter);
                   recyclerView.setHasFixedSize(true);
                   Toast.makeText(getApplicationContext(),"Data: "+response.body(),Toast.LENGTH_LONG).show();
                   Log.i("TAG", "onResponse: "+recordsList);

           }

           @Override
           public void onFailure(Call<Response> call, Throwable t) {
               Toast.makeText(getApplicationContext(),"Data: "+t.getMessage(),Toast.LENGTH_LONG).show();
               Log.i("TAG", "onResponse: "+t.getMessage());
           }
       });
    }
//    private void LoadRecord(){
//        Call<List<RecordsItem>> listCall=retrofitInterface.getRecord(api_key,"json",0,10);
//        listCall.enqueue(new Callback<List<RecordsItem>>() {
//            @Override
//            public void onResponse(Call<List<RecordsItem>> call, Response<List<RecordsItem>> response) {
//                root=new com.yashraj.groceryapp.Model.Response(response.body());
//                recordsList=root.getRecords();
//                adapter=new Adapter(getApplicationContext(),recordsList);
//                recyclerView.setAdapter(adapter);
//                Log.i("TAG", "onResponse: "+recordsList);
//            }
//
//            @Override
//            public void onFailure(Call<List<RecordsItem>> call, Throwable t) {
//                Log.i("TAG", "onFailure: "+t.getMessage());
//            }
//        });
//    }
}