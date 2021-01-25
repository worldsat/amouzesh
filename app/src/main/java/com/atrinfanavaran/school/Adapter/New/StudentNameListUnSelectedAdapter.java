package com.atrinfanavaran.school.Adapter.New;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.atrinfanavaran.school.Domain.New.GetRelatedStudentsFromCustomGroup;
import com.atrinfanavaran.school.R;

import java.util.ArrayList;

public class StudentNameListUnSelectedAdapter extends RecyclerView.Adapter<StudentNameListUnSelectedAdapter.ViewHolder> {

    private final ArrayList<GetRelatedStudentsFromCustomGroup.Data> array_object;
    private Context context;

    private Handler mHandler = new Handler();
    private int mFileDuration;
    private PostMiniListAdapter.SelectCallBack selectCallBack;
    public StudentNameListUnSelectedAdapter(ArrayList<GetRelatedStudentsFromCustomGroup.Data> result, PostMiniListAdapter.SelectCallBack selectCallBack) {
        this.array_object = result;
        this.selectCallBack = selectCallBack;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_student_name_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        context = holder.itemView.getContext();
        holder.title.setText(array_object.get(position).getFullName());

        holder.row.setText("" + (position + 1));

        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setChecked(false);

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                alertQuestion(context, holder, isChecked);

                selectCallBack.Id(array_object.get(position).getId(),false);
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
        TextView title, row;
        ConstraintLayout card;
        CheckBox checkBox;

        private ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            row = itemView.findViewById(R.id.rowNumber);
            card = itemView.findViewById(R.id.item);
            checkBox = itemView.findViewById(R.id.checkBox2);
        }
    }


}
