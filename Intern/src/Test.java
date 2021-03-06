import service.BittrexService;
import service.ServiceGenerator;

import model.ResponseResult;
import model.MarketModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Test {
	private static BittrexService mService;
	
	public static void main(String[] args) {

		mService = ServiceGenerator.createService(BittrexService.class);
		mService.getMarketSummaries().enqueue(new Callback<ResponseResult> () {

			@Override
			public void onResponse(Call<ResponseResult> call, Response<ResponseResult> response) {
				if(response.isSuccessful()) {
                    ResponseResult result = response.body();
                    System.out.println(result.getResult().get(0).getMarketName());
                    System.out.println(result.getResult().get(0).getLast());
                    System.out.println(result.getResult().get(0).getPrevDay());
                } else {
                    System.out.println(response.errorBody());
                }
			}

			@Override
			public void onFailure(Call<ResponseResult> call, Throwable t) {
				t.printStackTrace();
			}

		});

	}
}
