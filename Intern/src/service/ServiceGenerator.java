package service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import helper.Config;
import okhttp3.OkHttpClient;

public class ServiceGenerator {
	
	private static Retrofit retrofit = null;
    private static Retrofit.Builder builder = new Retrofit.Builder()
		    								.baseUrl(Config.BASE_URL)
		    								.addConverterFactory(GsonConverterFactory.create());
    private final static OkHttpClient.Builder sOkHttpClientBuilder = new OkHttpClient.Builder();
    private final static OkHttpClient sOkHttpClient = sOkHttpClientBuilder.build();
    
    public static <T> T createService(Class<T> serviceClass) {
        if (retrofit == null) {
            retrofit = builder.client(sOkHttpClient).build();
        }
        return retrofit.create(serviceClass);
    }
}
