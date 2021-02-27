package com.yashraj.groceryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adapter;
    Root root;
    RetrofitInterface retrofitInterface=new RetrofitApi().getRetrofit().create(RetrofitInterface.class);
    List<Records> recordsList;
    public static final String api_key="579b464db66ec23bdd0000019c31c18a3d734b335e6113d48c74e33f";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recordsList=new ArrayList<>();
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        LoadData();
        LoadRecord();
    }
//    private void LoadData(){
//        Call<Root> listCall=retrofitInterface.getRecords(api_key,"json",0,10);
//        listCall.enqueue(new Callback<Root>() {
//            @Override
//            public void onResponse(Call<Root> call, Response<Root> response) {
//                if(response.body()!=null){
//                    root=new Root(response.body());
//                    recordsList=root.getRecordsList();
//                    adapter=new Adapter(getApplicationContext(),recordsList);
//                    recyclerView.setAdapter(adapter);
//                    recyclerView.setHasFixedSize(true);
//                    Toast.makeText(getApplicationContext(),"Data: "+response.body(),Toast.LENGTH_LONG).show();
//                    Log.i("TAG", "onResponse: "+recordsList);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Root> call, Throwable t) {
//                Toast.makeText(getApplicationContext(),"Some error occured: "+t.getMessage(),Toast.LENGTH_LONG).show();
//                Log.i("TAG", "onFailure: "+t.getMessage());
//            }
//        });
//    }
    private void LoadRecord(){
        Call<List<Records>> listCall=retrofitInterface.getRecord(api_key,"json",0,10);
        listCall.enqueue(new Callback<List<Records>>() {
            @Override
            public void onResponse(Call<List<Records>> call, Response<List<Records>> response) {
                root=new Root(response.body());
                recordsList=root.getRecordsList();
                adapter=new Adapter(getApplicationContext(),recordsList);
                recyclerView.setAdapter(adapter);
                Log.i("TAG", "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<List<Records>> call, Throwable t) {
                Log.i("TAG", "onFailure: "+t.getMessage());
            }
        });
    }
}