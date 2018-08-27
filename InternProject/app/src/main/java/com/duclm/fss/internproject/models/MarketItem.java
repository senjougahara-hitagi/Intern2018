package com.duclm.fss.internproject.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MarketItem implements Serializable {
    @SerializedName("N")
    private String mMarketName;
    @SerializedName("V")
    private String mVolume;
    @SerializedName("L")
    private String mLast;
    @SerializedName("P")
    private String mPrevDay;
    @SerializedName("H")
    private String mHigh;
    @SerializedName("LO")
    private String mLow;
    @SerializedName("B")
    private String mBid;
    @SerializedName("A")
    private String mAsk;

    public MarketItem(String mMarketName, String mVolume, String mLast, String mPrevDay,
                      String mHigh, String mLow, String mBid, String mAsk) {
        this.mMarketName = mMarketName;
        this.mVolume = mVolume;
        this.mLast = mLast;
        this.mPrevDay = mPrevDay;
        this.mHigh = mHigh;
        this.mLow = mLow;
        this.mBid = mBid;
        this.mAsk = mAsk;
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

    public String getmBid() {
        return mBid;
    }

    public void setmBid(String mBid) {
        this.mBid = mBid;
    }

    public String getmAsk() {
        return mAsk;
    }

    public void setmAsk(String mAsk) {
        this.mAsk = mAsk;
    }

    public String getmVolume() {
        return mVolume;
    }

    public void setmVolume(String mVolume) {
        this.mVolume = mVolume;
    }

    public String getmLast() {
        return mLast;
    }

    public void setmLast(String mLast) {
        this.mLast = mLast;
    }

    public String getmPrevDay() {
        return mPrevDay;
    }

    public void setmPrevDay(String mPrevDay) {
        this.mPrevDay = mPrevDay;
    }

    public String getmMarketName() {
        return mMarketName;
    }

    public void setmMarketName(String mMarketName) {
        this.mMarketName = mMarketName;
    }
}
