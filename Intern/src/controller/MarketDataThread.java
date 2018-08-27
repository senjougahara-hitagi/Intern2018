package controller;

import java.text.DecimalFormat;

import helper.MarketList;
import model.ResponseResult;
import model.MarketModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.BittrexService;
import service.ServiceGenerator;

public class MarketDataThread implements Runnable {
	
	private BittrexService mService;

	@Override
	public void run() {
		mService = ServiceGenerator.createService(BittrexService.class);
		mService.getMarketSummaries().enqueue(new Callback<ResponseResult> () {

			@Override
			public void onResponse(Call<ResponseResult> call, Response<ResponseResult> response) {
				if(response.isSuccessful()) {
                    MarketList.setMarketList(response.body().getResult());   
					for (MarketModel el : MarketList.getMarketList()) {
						el.setVolume(new DecimalFormat("0.000")
			                    .format(Double.parseDouble(el.getVolume())));
					}
                }
			}

			@Override
			public void onFailure(Call<ResponseResult> call, Throwable t) {
				t.printStackTrace();
			}

		});
	}

}
