package com.atrinfanavaran.school.Adapter.New;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.atrinfanavaran.school.Activity.New.ShowPostActivity;
import com.atrinfanavaran.school.Domain.New.EducationPostGetAll;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class EducationPostListAdapter extends RecyclerView.Adapter<EducationPostListAdapter.ViewHolder> {

    private final ArrayList<EducationPostGetAll.Data> array_object;
    private Context context;

    private Handler mHandler = new Handler();
    private int mFileDuration;

    public EducationPostListAdapter(ArrayList<EducationPostGetAll.Data> result) {
        this.array_object = result;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_post_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        context = holder.itemView.getContext();
        holder.title.setText(array_object.get(position).getTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, ShowPostActivity.class);
                intent.putExtra("Id", array_object.get(position).getId());
                context.startActivity(intent);


            }
        });
        SettingsBll settingsBll = new SettingsBll(context);
        String Url = settingsBll.getUrlAddress()+array_object.get(position).getIconUrl();

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.mipmap.logo);
        requestOptions.error(R.mipmap.logo);


        Glide.with(holder.itemView.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(Url)
                .apply(RequestOptions.circleCropTransform())
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
        TextView title, time, size;
        ConstraintLayout card, deleteIcon;
        ImageView icon;


        private ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            time = itemView.findViewById(R.id.timeTxt);
            size = itemView.findViewById(R.id.sizeTxt);
            card = itemView.findViewById(R.id.item);
            deleteIcon = itemView.findViewById(R.id.icon_background);
            icon = itemView.findViewById(R.id.icon);


        }
    }


}
