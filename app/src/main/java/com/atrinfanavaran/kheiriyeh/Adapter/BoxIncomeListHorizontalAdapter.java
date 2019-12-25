package com.atrinfanavaran.kheiriyeh.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.atrinfanavaran.kheiriyeh.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.kheiriyeh.R;
import com.atrinfanavaran.kheiriyeh.Room.Domian.BoxIncomeR;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class BoxIncomeListHorizontalAdapter extends RecyclerView.Adapter<BoxIncomeListHorizontalAdapter.ViewHolder> {

    private final List<BoxIncomeR> array_object;


    public BoxIncomeListHorizontalAdapter(List<BoxIncomeR> result) {

        this.array_object = result;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_last_discharge, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        SettingsBll settingsBll = new SettingsBll(holder.itemView.getContext());
        String Url = settingsBll.getUrlAddress();



    }

    @Override
    public int getItemCount() {
        return array_object == null ? 0 : array_object.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView date, code, name, price, address;
        ImageView pic;
        Button editBtn;

        private ViewHolder(View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date);
            code = itemView.findViewById(R.id.code);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            address = itemView.findViewById(R.id.address);
            pic = itemView.findViewById(R.id.pic);

        }
    }
}