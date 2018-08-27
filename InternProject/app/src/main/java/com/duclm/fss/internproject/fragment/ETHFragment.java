package com.duclm.fss.internproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.duclm.fss.internproject.R;
import com.duclm.fss.internproject.activities.DetailMarket;
import com.duclm.fss.internproject.adpater.MarketListAdapter;
import com.duclm.fss.internproject.listener.ClickListener;
import com.duclm.fss.internproject.listener.RecyclerTouchListener;
import com.duclm.fss.internproject.models.MarketItem;
import com.duclm.fss.internproject.service.MarketService;
import com.duclm.fss.internproject.service.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_LONG;

public class ETHFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView mRecycler;
    private MarketService mService;
    private List<MarketItem> mMarketList;
    private MarketListAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public ETHFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.market_layout, container, false);
        mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        mRecycler = view.findViewById(R.id.list_market);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),
            LinearLayoutManager.VERTICAL,
            false);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setHasFixedSize(true);
        mMarketList = new ArrayList<>();
        mAdapter = new MarketListAdapter(mMarketList, getActivity());
        mRecycler.setAdapter(mAdapter);
        mRecycler.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), mRecycler,
            new ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("item", mMarketList.get(position));
                    Intent intent = new Intent(getActivity(), DetailMarket.class);
                    intent.putExtra("BUNDLE", bundle);
                    startActivity(intent);
                }

                @Override
                public void onLongClick(View view, int position) {
                }
            }));
        mService = ServiceGenerator.createService(MarketService.class);
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                loadData();
            }
        });
        return view;
    }

    @Override
    public void onRefresh() {
        loadData();
    }

    private void loadData() {
        mSwipeRefreshLayout.setRefreshing(true);
        mService.getMarketList("ETH").enqueue(new Callback<List<MarketItem>>() {
            @Override
            public void onResponse(Call<List<MarketItem>> call,
                                   Response<List<MarketItem>> response) {
                mMarketList.removeAll(mMarketList);
                for (MarketItem e : response.body()) {
                    mMarketList.add(e);
                }
                mAdapter.notifyDataSetChanged();
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<MarketItem>> call, Throwable t) {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
