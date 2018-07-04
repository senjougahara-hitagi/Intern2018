package service;

import model.Market;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BinanceService {
	@GET("planetary/apod")
	Call<Market> getNasa(@Query("date") String date, @Query("api_key") String key);
}
