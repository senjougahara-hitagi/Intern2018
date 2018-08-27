package service;

import model.ResponseResult;
import model.MarketModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BittrexService {
	@GET("public/getmarketsummaries")
	Call<ResponseResult> getMarketSummaries();
}
