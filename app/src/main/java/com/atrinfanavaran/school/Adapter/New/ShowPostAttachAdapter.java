package com.atrinfanavaran.school.Adapter.New;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.atrinfanavaran.school.Domain.New.ShowPost;
import com.atrinfanavaran.school.Kernel.Controller.Module.SnakBar.SnakBar;
import com.atrinfanavaran.school.Kernel.Helper.DownloadFileUrl;
import com.atrinfanavaran.school.Kernel.Interface.OnFinishedDownloadCallback;
import com.atrinfanavaran.school.R;

import java.util.ArrayList;

public class ShowPostAttachAdapter extends RecyclerView.Adapter<ShowPostAttachAdapter.ViewHolder> {

    private final ArrayList<ShowPost> array_object;
    private Context context;


    public ShowPostAttachAdapter(ArrayList<ShowPost> result) {
        this.array_object = result;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_attach_download, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        context = holder.itemView.getContext();

        holder.title.setText(array_object.get(position).getTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DownloadFileUrl(context, array_object.get(position).getLink(), array_object.get(position).getFileName(), null, new OnFinishedDownloadCallback() {
                    @Override
                    public void onFinish() {

                    }

                    @Override
                    public void onCancel() {
                        SnakBar snakBar = new SnakBar();
                        snakBar.snakShow(context, "دریافت فایل لغو شد");

                    }
                });
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
        ConstraintLayout card, deleteIcon;
        ImageView icon;

        private ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            card = itemView.findViewById(R.id.item);
            deleteIcon = itemView.findViewById(R.id.icon_background);
            icon = itemView.findViewById(R.id.icon);

        }
    }
}
