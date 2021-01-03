package com.atrinfanavaran.school.Adapter.New;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atrinfanavaran.school.Activity.New.ListPostActivity;
import com.atrinfanavaran.school.Domain.New.CategoryGetAll;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CategorySmallAdapter extends RecyclerView.Adapter<CategorySmallAdapter.ViewHolder> {

    private final ArrayList<CategoryGetAll.Data> array_object;

    public CategorySmallAdapter(ArrayList<CategoryGetAll.Data> array_object) {
        this.array_object = array_object;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category_small, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        RequestOptions requestOptions = new RequestOptions();
                                requestOptions.placeholder(R.mipmap.logo);
                                requestOptions.error(R.mipmap.logo);

        SettingsBll settingsBll = new SettingsBll(holder.itemView.getContext());
        Glide.with(holder.itemView.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(settingsBll.getUrlAddress() + array_object.get(position).getUrl())
                    .apply(RequestOptions.centerCropTransform())
                .into(holder.icon);

        holder.title.setText(array_object.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.itemView.getContext(), ListPostActivity.class);
                intent.putExtra("CategoryId", array_object.get(position).getId());
                holder.itemView.getContext().startActivity(intent);
            }
        });


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
        ImageView icon;

        private ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            icon = itemView.findViewById(R.id.icon);

        }
    }

}
