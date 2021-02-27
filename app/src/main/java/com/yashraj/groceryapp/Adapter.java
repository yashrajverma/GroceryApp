package com.yashraj.groceryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yashraj.groceryapp.Model.RecordsItem;

import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {
    Context context;
    List<RecordsItem> list;

    public Adapter(Context context, List<RecordsItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.record_data,parent,false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        RecordsItem records=list.get(position);
        holder.state.setText(records.getState());
        holder.max_price.setText(String.valueOf(records.getMaxPrice()));
        holder.min_price.setText(String.valueOf(records.getMinPrice()));
        holder.date.setText(String.valueOf(records.getArrivalDate()));
        holder.district.setText(records.getDistrict());
        holder.market.setText(records.getMarket());
        holder.commodity.setText(records.getCommodity());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class AdapterViewHolder  extends RecyclerView.ViewHolder{
        private final TextView district;
        private final TextView state;
        private final TextView date;
        private final TextView min_price;
        private final TextView max_price;
        private final TextView commodity;
        private final TextView market;
        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            district=itemView.findViewById(R.id.district);
            min_price=itemView.findViewById(R.id.min_price);
            max_price=itemView.findViewById(R.id.max_price);
            date=itemView.findViewById(R.id.date);
            state=itemView.findViewById(R.id.state);
            commodity=itemView.findViewById(R.id.commodity);
            market=itemView.findViewById(R.id.market);

        }
    }
}
