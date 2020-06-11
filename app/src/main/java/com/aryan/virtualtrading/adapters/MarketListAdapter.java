package com.aryan.virtualtrading.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.aryan.virtualtrading.R;
import com.aryan.virtualtrading.models.MarketModel;

import java.util.List;


public class MarketListAdapter extends RecyclerView.Adapter<MarketListAdapter.MatchFixtureViewHolder> {

    private NotificationManagerCompat notificationManagerCompat;

    List<MarketModel> marketList;
    Context mContext;

    public MarketListAdapter(List<MarketModel> marketList, Context mContext) {
        this.marketList = marketList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MatchFixtureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.portfolio_stock, parent, false);
        notificationManagerCompat = NotificationManagerCompat.from(mContext);

        return new MatchFixtureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchFixtureViewHolder holder, int position) {
        final MarketModel fixture = marketList.get(position);

        holder.valueamt.setText(fixture.getSharePrice() + "");
        holder.nameofcompany.setText(fixture.getName());
        holder.markettype.setText(fixture.getSymbol());
    }



    @Override
    public int getItemCount() {
        return marketList.size();
    }

    public class MatchFixtureViewHolder extends RecyclerView.ViewHolder{

        TextView valueamt, nameofcompany, markettype;

        public MatchFixtureViewHolder(@NonNull View itemView) {
            super(itemView);
            valueamt = itemView.findViewById(R.id.valueamt);
            nameofcompany = itemView.findViewById(R.id.nameofcompany);
            markettype = itemView.findViewById(R.id.tv_symbol);
        }
    }
}
