package helper;

import java.util.List;

import model.MarketModel;

public class MarketList {
	private static List<MarketModel> mMarketList;
	
	public static void setMarketList(List<MarketModel> list) {
		mMarketList = list;
	}
	
	public static List<MarketModel> getMarketList() {
		return mMarketList;
	}
}
