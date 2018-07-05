package model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class MarketModel implements Serializable{
	@SerializedName("success")
	private boolean success;
	@SerializedName("message")
	private String message;
	@SerializedName("result")
	private List<SubModel> result;
	
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
	public List<SubModel> getResult() {
		return result;
	}
	public void setResult(List<SubModel> result) {
		this.result = result;
	}
	
	public void getSubject() {
		result.forEach(e -> System.out.println(e.getMarketName() + " " + e.getVolume() + " " + e.getLast()));
	}
}
