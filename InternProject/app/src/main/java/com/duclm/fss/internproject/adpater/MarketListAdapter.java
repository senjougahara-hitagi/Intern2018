package com.duclm.fss.internproject.adpater;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duclm.fss.internproject.R;
import com.duclm.fss.internproject.models.MarketItem;

import java.text.DecimalFormat;
import java.util.List;

public class MarketListAdapter extends RecyclerView.Adapter<MarketListAdapter.DataViewHolder> {

    private List<MarketItem> mMarketList;
    private Context mContext;

    public MarketListAdapter(List<MarketItem> mMarketList, Context mContext) {
        this.mMarketList = mMarketList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MarketListAdapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int
        viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.market_item,
            parent, false);
        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MarketListAdapter.DataViewHolder holder, int position) {
        String marketName = mMarketList.get(position).getmMarketName();
        String volume = mMarketList.get(position).getmVolume();
        String lastPrice = mMarketList.get(position).getmLast();
        String prevDay = mMarketList.get(position).getmPrevDay();

        holder.mMarketName.setText(marketName);
        holder.mLast.setText(lastPrice);
        Double vol = Double.parseDouble(volume);
        if(vol > 10000000) {
            holder.mVolume.setText("Vol: " + new DecimalFormat("0.0")
                .format(vol));
        } else if(vol > 1000000) {
            holder.mVolume.setText("Vol: " + new DecimalFormat("0.00")
                .format(vol));
        } else {
            holder.mVolume.setText("Vol: " + vol);
        }
        Double changeRate = (Double.parseDouble(lastPrice) / Double.parseDouble(prevDay)) - 1;
        if (changeRate < 0) {
            holder.m24HChange.setBackgroundColor(0xFFA30101);
        } else {
            holder.m24HChange.setBackgroundColor(0xFF1CA600);
        }
        holder.m24HChange.setText(new DecimalFormat("0.00")
                                    .format(changeRate * 100) + "%");
    }

    @Override
    public int getItemCount() {
        return mMarketList == null ? 0 : mMarketList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {

        private TextView mMarketName;
        private TextView mVolume;
        private TextView mLast;
        private TextView m24HChange;

        public DataViewHolder(View itemView) {
            super(itemView);

            mMarketName = itemView.findViewById(R.id.marketName);
            mVolume = itemView.findViewById(R.id.volume);
            mLast = itemView.findViewById(R.id.lastPrice);
            m24HChange = itemView.findViewById(R.id.dayChange);
        }
    }
}
