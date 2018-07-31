import service.BittrexService;
import service.ServiceGenerator;

import model.MarketModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Test {
	private static BittrexService mService;
	
	public static void main(String[] args) {

		mService = ServiceGenerator.createService(BittrexService.class);
		mService.getMarketSummaries().enqueue(new Callback<MarketModel> () {

			@Override
			public void onResponse(Call<MarketModel> call, Response<MarketModel> response) {
				if(response.isSuccessful()) {
                    MarketModel marketList = response.body();
                    System.out.println(marketList.getResult().get(0).getMarketName());
                    System.out.println(marketList.getResult().get(0).getLast());
                    System.out.println(marketList.getResult().get(0).getPrevDay());
                } else {
                    System.out.println(response.errorBody());
                }
			}

			@Override
			public void onFailure(Call<MarketModel> call, Throwable t) {
				t.printStackTrace();
			}

		});

	}
}
