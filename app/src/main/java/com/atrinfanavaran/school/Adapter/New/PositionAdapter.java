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

import com.atrinfanavaran.school.Domain.New.BannerGetAll;
import com.atrinfanavaran.school.Domain.New.DropdownList;
import com.atrinfanavaran.school.R;

import java.util.ArrayList;

public class PositionAdapter extends RecyclerView.Adapter<PositionAdapter.ViewHolder> {

    private final ArrayList<DropdownList> array_object;
    private Context context;
    int delayAnimate = 300; //global variable
    int delayAnimate2 = 0; //global variable
    private boolean exit = false;
    private boolean endStart = false;
    private boolean endExit = false;
    private SelectCallBack selectCallBack;
    private int oldPosition=0;
    private BannerGetAll.Data object;
    private String kind;

    public PositionAdapter(String kind, ArrayList<DropdownList> result, BannerGetAll.Data object, SelectCallBack selectCallBack) {
        this.array_object = result;
        this.selectCallBack = selectCallBack;
        this.object = object;
        this.kind = kind;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_dropdown, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        context = holder.itemView.getContext();
        String[] fileName = array_object.get(position).getListName().split("/");

//        int kindList = 0;
//        if (object != null) {
//            if (kind.equals("Category")) {
//                kindList = object.getCategory();
//            } else if (kind.equals("accessType")) {
//                kindList = object.getAccessType();
//            }
//        }
//
//        if (object != null && kindList == array_object.get(position).getListId()) {
//
//            for (int i = 0; i < array_object.size(); i++) {
//                if (array_object.get(i).getListId() == array_object.get(position).getListId()) {
//                    array_object.get(i).setTick(true);
//                } else {
//                    array_object.get(i).setTick(false);
//                }
//            }
//        } else if (object != null) {
//            array_object.get(position).setTick(false);
//        }
        if (array_object.get(position).isTick()) {
            holder.icon.setImageResource(R.mipmap.tick128);
            holder.icon.setVisibility(View.VISIBLE);
            oldPosition = position;
        } else {
            holder.icon.setVisibility(View.INVISIBLE);
        }

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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                array_object.get(oldPosition).setTick(false);
                array_object.get(position).setTick(true);

                notifyDataSetChanged();
                holder.icon.setImageResource(R.mipmap.tick128);

                selectCallBack.Id(array_object.get(position).getListId());
            }
        });

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

    public interface SelectCallBack {
        void Id(int num);
    }
}
