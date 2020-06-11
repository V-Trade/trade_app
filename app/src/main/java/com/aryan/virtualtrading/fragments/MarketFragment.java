package com.aryan.virtualtrading.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aryan.virtualtrading.R;
import com.aryan.virtualtrading.RetrofitUrl;
import com.aryan.virtualtrading.adapters.MarketListAdapter;
import com.aryan.virtualtrading.api.MarketAPI;
import com.aryan.virtualtrading.models.MarketModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarketFragment extends Fragment {

    private RecyclerView rvMarket;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_market, container, false);
        rvMarket = root.findViewById(R.id.stockListView);
        getMarket();
        return root;
    }

    private void getMarket() {

        MarketAPI marketAPI = RetrofitUrl.getInstance().create(MarketAPI.class);
        Call<List<MarketModel>> marketCall = marketAPI.getMarket();

        marketCall.enqueue(new Callback<List<MarketModel>>() {
            @Override
            public void onResponse(Call<List<MarketModel>> call, Response<List<MarketModel>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(), "Error loading fixtures" , Toast.LENGTH_SHORT).show();
                    return;
                }
                List<MarketModel> list = response.body();
                MarketListAdapter adapter = new MarketListAdapter(list, getContext());
                rvMarket.setAdapter(adapter);
                rvMarket.setLayoutManager(new LinearLayoutManager(getContext()));
            }

            @Override
            public void onFailure(Call<List<MarketModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Error loading fixtures" , Toast.LENGTH_SHORT).show();
            }
        });

    }
}