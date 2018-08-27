package com.duclm.fss.internproject.service;

import com.duclm.fss.internproject.models.MarketItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarketService {
    @GET("getmarketdata")
    Call<List<MarketItem>> getMarketList(@Query("type") String type);
}
