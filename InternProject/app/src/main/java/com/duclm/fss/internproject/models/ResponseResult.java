package com.duclm.fss.internproject.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ResponseResult implements Serializable {
    @SerializedName("success")
    private boolean success;
    @SerializedName("message")
    private String message;
    @SerializedName("result")
    private List<Tick> result;

    public ResponseResult(boolean success, String message, List<Tick> result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }

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

    public List<Tick> getResult() {
        return result;
    }

    public void setResult(List<Tick> result) {
        this.result = result;
    }
}
