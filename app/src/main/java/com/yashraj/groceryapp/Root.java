package com.yashraj.groceryapp;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Root {
    @Expose
    @SerializedName("records")
    List<Records> records;

    public Root(Root body) {
        records=body.records;
    }

    public Root(List<Records> body) {
        this.records=body;
    }


    public List<Records> getRecordsList() {
        return this.records;
    }

    public void setRecordsList(List<Records> recordsList) {
        this.records = recordsList;
    }


}
