package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import helper.MarketList;
import model.MarketModel;

@WebServlet(urlPatterns = {"/getmarketdata"})
public class GetMarketData extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/plain");
		
		JSONArray json  = new JSONArray();
		
		if(MarketList.getMarketList() == null) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
        
		switch(req.getParameter("type")) {
			case "BTC": 
				for (MarketModel el : MarketList.getMarketList()) {
					if(el.getMarketName().contains("BTC-"))
						json.put(el.getObject());
		        }
				break;
			case "ETH": 
				for (MarketModel el : MarketList.getMarketList()) {
					if(el.getMarketName().contains("ETH-"))
						json.put(el.getObject());
		        }
				break;
			case "USDT": 
				for (MarketModel el : MarketList.getMarketList()) {
					if(el.getMarketName().contains("USDT-"))
						json.put(el.getObject());
		        }
				break;
		}

        try {
			PrintWriter pw = resp.getWriter();
        	pw.println(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
