package com.duclm.fss.internproject.service;

import com.duclm.fss.internproject.models.ResponseResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetTicksService {
    @GET("pub/market/GetTicks")
    Call<ResponseResult> getTicks(@Query("marketName") String marketName, @Query("tickInterval") String
        tickInterval);
}
