package com.duclm.fss.internproject.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.duclm.fss.internproject.R;
import com.duclm.fss.internproject.models.MarketItem;
import com.duclm.fss.internproject.models.ResponseResult;
import com.duclm.fss.internproject.models.Tick;
import com.duclm.fss.internproject.service.GetTicksService;
import com.duclm.fss.internproject.service.ServiceGenerator_2;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMarket extends AppCompatActivity {

    private TextView mName, mLast, mChange, mHigh, mLow, mBid, mAsk, mVol;
    private Toolbar mToolbar;
    private CandleStickChart mCandleStick;
    private ArrayList<CandleEntry> mEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_market);

        mToolbar = findViewById(R.id.toolbar_detail_screen);
        mToolbar.setNavigationIcon(R.drawable.back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mName = findViewById(R.id.name);
        mLast = findViewById(R.id.last);
        mChange = findViewById(R.id.change);
        mVol = findViewById(R.id.vol);
        mBid = findViewById(R.id.bid);
        mAsk = findViewById(R.id.ask);
        mHigh = findViewById(R.id.high);
        mLow = findViewById(R.id.low);

        mCandleStick = findViewById(R.id.chart);

        mEntries = new ArrayList<>();

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getBundleExtra("BUNDLE");
            if (bundle != null) {
                MarketItem item = (MarketItem) bundle.getSerializable("item");

                mToolbar.setTitle(item.getmMarketName());
                mName.setText(item.getmMarketName());
                mLast.setText(item.getmLast());
                mVol.setText(item.getmVolume());
                mBid.setText(item.getmBid());
                mAsk.setText(item.getmAsk());
                mHigh.setText(item.getmHigh());
                mLow.setText(item.getmLow());

                Double changeRate = (Double.parseDouble(item.getmLast()) / Double.parseDouble
                    (item.getmPrevDay()))
                    - 1;
                if (changeRate < 0) {
                    mChange.setTextColor(0xFFA30101);
                } else {
                    mChange.setTextColor(0xFF1CA600);
                }
                mChange.setText(new DecimalFormat("0.00")
                    .format(changeRate * 100) + "%");

                GetTicksService service = ServiceGenerator_2.createService(GetTicksService.class);
                service.getTicks(item.getmMarketName(), "thirtyMin").enqueue(
                    new Callback<ResponseResult>() {
                        @Override
                        public void onResponse(Call<ResponseResult> call,
                                               Response<ResponseResult> response) {
                            if(response.isSuccessful()) {
                                List<Tick> ticks = response.body().getResult();
                                for (int i = 0; i < ticks.size(); i++) {
                                    mEntries.add(new CandleEntry(i,
                                                                Float.parseFloat(ticks.get(i).getmHigh()),
                                                                Float.parseFloat(ticks.get(i).getmLow()),
                                                                Float.parseFloat(ticks.get(i).getmOpen()),
                                                                Float.parseFloat(ticks.get(i).getmClose())));
                                }

                                CandleDataSet candleDataSet = new CandleDataSet(mEntries,
                                    "Thirty Minute");
                                candleDataSet.setColor(Color.rgb(80, 80, 80));
                                candleDataSet.setShadowColor(Color.DKGRAY);
                                candleDataSet.setShadowWidth(0.7f);
                                candleDataSet.setDecreasingColor(Color.RED);
                                candleDataSet.setDecreasingPaintStyle(Paint.Style.FILL);
                                candleDataSet.setIncreasingColor(Color.rgb(122, 242, 84));
                                candleDataSet.setIncreasingPaintStyle(Paint.Style.FILL);
                                candleDataSet.setDrawValues(false);


                                CandleData candleData = new CandleData(candleDataSet);
                                mCandleStick.setData(candleData);
                                mCandleStick.zoom(50f, 15f, ticks.size(), 0);
                                mCandleStick.getXAxis().setPosition(XAxisPosition.BOTTOM);
//                                mCandleStick.moveViewToX(ticks.size());
                                mCandleStick.invalidate();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseResult> call, Throwable t) {
                        }
                    });
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
