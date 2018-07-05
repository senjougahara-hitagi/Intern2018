import service.BittrexService;
import service.ServiceGenerator;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.binance.api.client.BinanceApiCallback;
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.BinanceApiWebSocketClient;
import com.binance.api.client.domain.market.AggTrade;
import com.binance.api.client.domain.market.BookTicker;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.domain.market.TickerPrice;
import com.binance.api.client.domain.market.TickerStatistics;
import com.binance.api.client.exception.BinanceApiException;

import model.MarketModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Test {
	private static BittrexService mService;
	
	public static void main(String[] args) {
		System.out.println("Start");
		mService = ServiceGenerator.createService(BittrexService.class);
		mService.getMarketSummaries().enqueue(new Callback<MarketModel> () {

			@Override
			public void onResponse(Call<MarketModel> call, Response<MarketModel> response) {
				if(response.isSuccessful()) {
                    MarketModel marketList = response.body();
                    marketList.getSubject();
                } else {
                    System.out.println(response.errorBody());
                }
			}

			@Override
			public void onFailure(Call<MarketModel> call, Throwable t) {
				t.printStackTrace();
			}

		});;
	}
}
