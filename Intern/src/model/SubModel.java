package model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class SubModel implements Serializable{
	@SerializedName("MarketName")
	private String marketName;
	@SerializedName("High")
	private double high;
	@SerializedName("Low")
	private double low;
	@SerializedName("Volume")
	private double volume;
	@SerializedName("Last")
	private double last;
	@SerializedName("BaseVolume")
	private double baseVolume;
	@SerializedName("TimeStamp")
	private String timeStamp;
	@SerializedName("Bid")
	private double bid;
	@SerializedName("Ask")
	private double ask;
	@SerializedName("OpenBuyOrders")
	private int openBuyOrders;
	@SerializedName("OpenSellOrders")
	private int openSellOrders;
	@SerializedName("PrevDay")
	private double prevDay;
	@SerializedName("Created")
	private String created;
	public String getMarketName() {
		return marketName;
	}
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(float high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(float low) {
		this.low = low;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(float volume) {
		this.volume = volume;
	}
	public double getLast() {
		return last;
	}
	public void setLast(float last) {
		this.last = last;
	}
	public double getBaseVolume() {
		return baseVolume;
	}
	public void setBaseVolume(float baseVolume) {
		this.baseVolume = baseVolume;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public double getBid() {
		return bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	public double getAsk() {
		return ask;
	}
	public void setAsk(float ask) {
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
	public double getPrevDay() {
		return prevDay;
	}
	public void setPrevDay(float prevDay) {
		this.prevDay = prevDay;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
}
