package com.aryan.virtualtrading.api;

import com.aryan.virtualtrading.models.MarketModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MarketAPI {

    @GET("data/todaysprice")
    Call<List<MarketModel>> getMarket();

}
