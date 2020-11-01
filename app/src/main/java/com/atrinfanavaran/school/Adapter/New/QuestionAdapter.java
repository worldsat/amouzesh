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

import com.atrinfanavaran.school.Domain.New.DropdownList;
import com.atrinfanavaran.school.R;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    private final ArrayList<DropdownList> array_object;
    private Context context;
    int delayAnimate = 300; //global variable
    int delayAnimate2 = 0; //global variable
    private boolean exit = false;
    private boolean endStart = false;
    private boolean endExit = false;

    public QuestionAdapter(ArrayList<DropdownList> result) {
        this.array_object = result;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_question, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        context = holder.itemView.getContext();
        holder.title.setText(array_object.get(position).getListName());
        setbackground(position, holder.card, holder.icon_background, holder.title);
        holder.card.setVisibility(View.INVISIBLE);


        if (exit) {
            holder.itemView.setVisibility(View.VISIBLE);



        } else {
            if (!endStart) {

            } else {
                holder.itemView.setVisibility(View.VISIBLE);
            }
        }

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


    private void setbackground(int position, ConstraintLayout item, ConstraintLayout icon_background, TextView title) {
        switch (position) {

//            case 0: {
//                item.setBackgroundResource(R.drawable.background_circle_purple2);
//                icon_background.setBackgroundResource(R.drawable.background_circle_green2);
//                icon_background.setVisibility(View.GONE);
//
////                title.setTextColor(context.getResources().getColor(R.color.grey_800));
//                break;
//            }
//            case 1: {
//
//                item.setBackgroundResource(R.drawable.background_circle);
//                icon_background.setBackgroundResource(R.drawable.background_circle_red2);
//                title.setTextColor(context.getResources().getColor(R.color.grey_800));
//                break;
//            }
//            case 2: {
//                item.setBackgroundResource(R.drawable.background_circle);
//                icon_background.setBackgroundResource(R.drawable.background_circle_blue2);
//                title.setTextColor(context.getResources().getColor(R.color.grey_800));
//                break;
//            }
//            case 3: {
//                item.setBackgroundResource(R.drawable.background_circle);
//                icon_background.setBackgroundResource(R.drawable.background_circle_orange2);
//                title.setTextColor(context.getResources().getColor(R.color.grey_800));
//                break;
//            }
//            case 4: {
//
//                item.setBackgroundResource(R.drawable.background_circle);
//                icon_background.setBackgroundResource(R.drawable.background_circle_green2);
//                title.setTextColor(context.getResources().getColor(R.color.grey_800));
//                break;
//            }
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ConstraintLayout card, icon_background;
        ImageView icon;

        private ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            card = itemView.findViewById(R.id.item);
            icon_background = itemView.findViewById(R.id.icon_background);
            icon = itemView.findViewById(R.id.icon);

        }
    }
}
