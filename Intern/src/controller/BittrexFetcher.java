package controller;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;

import io.gsonfire.builders.JsonArrayBuilder;
import io.swagger.client.JSON;
import model.MarketModel;
import model.SubMarketModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.BittrexService;
import service.ServiceGenerator;

@WebServlet(urlPatterns = {"/bittrexData"})
public class BittrexFetcher extends HttpServlet{
	private BittrexService mService;
	private MarketModel marketList;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/plain");

		mService = ServiceGenerator.createService(BittrexService.class);
		mService.getMarketSummaries().enqueue(new Callback<MarketModel> () {

			@Override
			public void onResponse(Call<MarketModel> call, Response<MarketModel> response) {
				if(response.isSuccessful()) {
					
                    marketList = response.body();

                    JSONArray json  = new JSONArray();
                                                            
                    for (SubMarketModel el : marketList.getResult()) {
                    	if(el.getMarketName().contains("BTC-"))
                    		json.put(el.getObject());
                    }

                    try {
						PrintWriter pw = resp.getWriter();
	                	pw.println(json.toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
                                        
                } else {
                    JSONObject json = new JSONObject();
        			try {
        				json.put("BITTREX", "FAIL");

        				PrintWriter pw = resp.getWriter();
        				pw.println(json.toString());
        			} catch (JSONException | IOException e) {
        				e.printStackTrace();
        			}
                }
			}

			@Override
			public void onFailure(Call<MarketModel> call, Throwable t) {
				t.printStackTrace();
			}

		});
		
	}
}
