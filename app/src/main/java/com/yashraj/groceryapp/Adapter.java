package com.yashraj.groceryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {
    Context context;
    List<Records> list;

    public Adapter(Context context, List<Records> list) {
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
        Records records=list.get(position);
        holder.state.setText(records.getState());
        holder.max_price.setText(String.valueOf(records.getMax_price()));
        holder.min_price.setText(String.valueOf(records.getMin_price()));
        holder.date.setText(String.valueOf(records.getArrival_date()));
        holder.district.setText(records.getDistrict());
        holder.market.setText(records.getMarket());
        holder.commodity.setText(records.getCommodity());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AdapterViewHolder  extends RecyclerView.ViewHolder{
        private TextView district,state,date,min_price,max_price,commodity,market;
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
