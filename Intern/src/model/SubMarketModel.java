package model;

import java.io.Serializable;
import java.util.Arrays;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.annotations.SerializedName;

public class SubMarketModel implements Serializable{
	@SerializedName("MarketName")
	private String marketName;
	@SerializedName("High")
	private String high;
	@SerializedName("Low")
	private String low;
	@SerializedName("Volume")
	private String volume;
	@SerializedName("Last")
	private String last;
	@SerializedName("BaseVolume")
	private String baseVolume;
	@SerializedName("TimeStamp")
	private String timeStamp;
	@SerializedName("Bid")
	private String bid;
	@SerializedName("Ask")
	private String ask;
	@SerializedName("OpenBuyOrders")
	private int openBuyOrders;
	@SerializedName("OpenSellOrders")
	private int openSellOrders;
	@SerializedName("PrevDay")
	private String prevDay;
	@SerializedName("Created")
	private String created;
	
	
	public String getMarketName() {
		return marketName;
	}
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getBaseVolume() {
		return baseVolume;
	}
	public void setBaseVolume(String baseVolume) {
		this.baseVolume = baseVolume;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getAsk() {
		return ask;
	}
	public void setAsk(String ask) {
		this.ask = ask;
	}
	public int getOpenBuyOrders() {
		return openBuyOrders;
	}
	public void setOpenBuyOrders(int openBuyOrders) {
		this.openBuyOrders = openBuyOrders;
	}
	public int getOpenSellOrders() {
		return openSellOrders;
	}
	public void setOpenSellOrders(int openSellOrders) {
		this.openSellOrders = openSellOrders;
	}
	public String getPrevDay() {
		return prevDay;
	}
	public void setPrevDay(String prevDay) {
		this.prevDay = prevDay;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
	public JSONObject getObject() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("N", getMarketName());
			obj.put("V", getVolume());
			obj.put("L", getLast());
			obj.put("P", getPrevDay());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
