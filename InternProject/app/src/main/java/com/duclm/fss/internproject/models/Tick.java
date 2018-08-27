package com.duclm.fss.internproject.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Tick implements Serializable{
    @SerializedName("O")
    private String mOpen;
    @SerializedName("H")
    private String mHigh;
    @SerializedName("L")
    private String mLow;
    @SerializedName("C")
    private String mClose;
    @SerializedName("V")
    private String mVol;
    @SerializedName("T")
    private String mTime;
    @SerializedName("BV")
    private String mBaseVol;

    public String getmOpen() {
        return mOpen;
    }

    public void setmOpen(String mOpen) {
        this.mOpen = mOpen;
    }

    public String getmHigh() {
        return mHigh;
    }

    public void setmHigh(String mHigh) {
        this.mHigh = mHigh;
    }

    public String getmLow() {
        return mLow;
    }

    public void setmLow(String mLow) {
        this.mLow = mLow;
    }

    public String getmClose() {
        return mClose;
    }

    public void setmClose(String mClose) {
        this.mClose = mClose;
    }

    public String getmVol() {
        return mVol;
    }

    public void setmVol(String mVol) {
        this.mVol = mVol;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public String getmBaseVol() {
        return mBaseVol;
    }

    public void setmBaseVol(String mBaseVol) {
        this.mBaseVol = mBaseVol;
    }
}
