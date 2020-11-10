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

import com.atrinfanavaran.school.Domain.New.AttachFile;
import com.atrinfanavaran.school.R;

import java.util.ArrayList;

public class AttachAdapter extends RecyclerView.Adapter<AttachAdapter.ViewHolder> {

    private final ArrayList<AttachFile> array_object;
    private Context context;
    int delayAnimate = 300; //global variable
    int delayAnimate2 = 0; //global variable
    private boolean exit = false;
    private boolean endStart = false;
    private boolean endExit = false;
    private deleteAttachCallBack deleteAttachCallBack;

    public AttachAdapter(ArrayList<AttachFile> result, deleteAttachCallBack deleteAttachCallBack) {
        this.array_object = result;
        this.deleteAttachCallBack = deleteAttachCallBack;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_attach, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        context = holder.itemView.getContext();
        String[] fileName = array_object.get(position).getAttachName().split("/");

        int nSplite = fileName.length;
        String name = "---";
        try {
            if (nSplite > 0) {
                name = fileName[(nSplite - 1)];
            }
        } catch (Exception e) {
            name = "---";
        }

        holder.title.setText(name);
        holder.deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array_object.remove(position);
                notifyDataSetChanged();
                deleteAttachCallBack.position(position);
            }
        });

//        setbackground(position, holder.card, holder.icon_background, holder.title);
//        holder.card.setVisibility(View.INVISIBLE);

//
//        if (exit) {
//            holder.itemView.setVisibility(View.VISIBLE);
//
//        } else {
//            if (!endStart) {
//
//            } else {
//                holder.itemView.setVisibility(View.VISIBLE);
//            }
//        }

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!endExit) {
//                    holder.itemView.setVisibility(View.VISIBLE);
//                    exit = true;
//                    notifyDataSetChanged();
//                }
//
//            }
//        });
        if (array_object.size() == (position + 1)) {
            endStart = true;
        }
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

    public interface deleteAttachCallBack {
        void position(int num);
    }
}
