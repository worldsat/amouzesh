package com.atrinfanavaran.school.Adapter.New;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.atrinfanavaran.school.Domain.New.GetRelatedComment;
import com.atrinfanavaran.school.R;

import java.util.ArrayList;

public class CommentListAdapter extends RecyclerView.Adapter<CommentListAdapter.ViewHolder> {

    private final ArrayList<GetRelatedComment.Data> array_object;
    private Context context;

    private Handler mHandler = new Handler();
    private int mFileDuration;

    public CommentListAdapter(ArrayList<GetRelatedComment.Data> result) {
        this.array_object = result;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_comment1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        context = holder.itemView.getContext();
        holder.title.setText(array_object.get(position).getText());
        holder.t1.setText(array_object.get(position).getStudents());
        holder.t2.setText(array_object.get(position).getDate());


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
        TextView title, rowNumber, size;
        TextView t1,t2;
        ConstraintLayout card;
        ImageView icon;
        CheckBox checkBox;


        private ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            rowNumber = itemView.findViewById(R.id.rowNumber);
            card = itemView.findViewById(R.id.item);
            icon = itemView.findViewById(R.id.icon);
            checkBox = itemView.findViewById(R.id.checkBox);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);


        }
    }


}
