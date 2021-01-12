package com.atrinfanavaran.school.Adapter.New;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.atrinfanavaran.school.Domain.New.CategoryGetAll;
import com.atrinfanavaran.school.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class AsatidListAdapter extends RecyclerView.Adapter<AsatidListAdapter.ViewHolder> {

    private final ArrayList<CategoryGetAll.Data> array_object;
    private Context context;


    public AsatidListAdapter(ArrayList<CategoryGetAll.Data> result) {
        this.array_object = result;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_asatid_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        context = holder.itemView.getContext();
        holder.title.setText(array_object.get(position).getName());

        holder.showItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.mipmap.logo);
        requestOptions.error(R.mipmap.logo);


        Glide.with(holder.itemView.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load("Url")
//                .apply(RequestOptions.circleCropTransform())
                .into(holder.icon);

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
        TextView title;
        ConstraintLayout card;
        ImageView icon;
        Button showItem;

        private ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            card = itemView.findViewById(R.id.item);
            icon = itemView.findViewById(R.id.icon);
            showItem = itemView.findViewById(R.id.button3);

        }
    }


}
