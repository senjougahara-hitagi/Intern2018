package service;

import model.MarketModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BittrexService {
	@GET("public/getmarketsummaries")
	Call<MarketModel> getMarketSummaries();
}
