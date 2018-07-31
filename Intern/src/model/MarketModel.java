package model;

import java.io.Serializable;
import java.util.List;

import org.json.JSONObject;

import com.google.gson.annotations.SerializedName;

public class MarketModel implements Serializable{
	@SerializedName("success")
	private boolean success;
	@SerializedName("message")
	private String message;
	@SerializedName("result")
	private List<SubMarketModel> result;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<SubMarketModel> getResult() {
		return result;
	}
	public void setResult(List<SubMarketModel> result) {
		this.result = result;
	}
}
