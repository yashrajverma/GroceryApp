package com.yashraj.groceryapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Records {
    @Expose
    @SerializedName("district")
    private String district;
    @Expose
    @SerializedName("state")
    private String state;
    @Expose
    @SerializedName("commodity")
    private String commodity;
    @Expose
    @SerializedName("arrival_date")
    private Date arrival_date;
    @Expose
    @SerializedName("min_price")
    private int min_price;
    @Expose
    @SerializedName("max_price")
    private int max_price;
    @Expose
    @SerializedName("market")
    private String market;

    public Records(){}

    public Records(String district, String state, String commodity, Date arrival_date, int min_price, int max_price, String market) {
        this.district = district;
        this.state = state;
        this.commodity = commodity;
        this.arrival_date = arrival_date;
        this.min_price = min_price;
        this.max_price = max_price;
        this.market = market;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public int getMin_price() {
        return min_price;
    }

    public void setMin_price(int min_price) {
        this.min_price = min_price;
    }

    public int getMax_price() {
        return max_price;
    }

    public void setMax_price(int max_price) {
        this.max_price = max_price;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }
}
