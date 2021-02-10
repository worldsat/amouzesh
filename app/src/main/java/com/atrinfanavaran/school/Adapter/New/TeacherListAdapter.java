package com.atrinfanavaran.school.Adapter.New;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.atrinfanavaran.school.Activity.New.ListStudentNameActivity;
import com.atrinfanavaran.school.Activity.New.ListTeacherNameActivity;
import com.atrinfanavaran.school.Activity.New.SendStudentGroupNameActivity;
import com.atrinfanavaran.school.Activity.New.SendTeacherGroupNameActivity;
import com.atrinfanavaran.school.Domain.New.CustomGroup;
import com.atrinfanavaran.school.Domain.New.ManageDomain;
import com.atrinfanavaran.school.Kernel.Controller.Controller;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGetString;
import com.atrinfanavaran.school.R;
import com.google.gson.Gson;

import java.util.ArrayList;

public class TeacherListAdapter extends RecyclerView.Adapter<TeacherListAdapter.ViewHolder> {

    private final ArrayList<CustomGroup.Data> array_object;
    private Context context;

    private Handler mHandler = new Handler();
    private int mFileDuration;

    public TeacherListAdapter(ArrayList<CustomGroup.Data> result) {
        this.array_object = result;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_teacher_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        context = holder.itemView.getContext();
        holder.title.setText(array_object.get(position).getName());

        holder.row.setText("" + (position + 1));


        holder.deleteBtn.setOnClickListener(v -> alertQuestion(context, holder));
        holder.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SendTeacherGroupNameActivity.class);
                intent.putExtra("object", array_object.get(position));
                context.startActivity(intent);
            }
        });
        holder.UnSelectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (array_object.get(position).isIsForTeacher()) {
                    Intent intent = new Intent(context, ListTeacherNameActivity.class);
                    intent.putExtra("object", array_object.get(position));
                    intent.putExtra("Action", "UnSelect");
                    context.startActivity(intent);
                } else {
                    Intent intent = new Intent(context, ListStudentNameActivity.class);
                    intent.putExtra("object", array_object.get(position));
                    intent.putExtra("Action", "UnSelect");
                    context.startActivity(intent);
                }

            }
        });
        holder.SelectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (array_object.get(position).isIsForTeacher()) {
                    Intent intent = new Intent(context, ListTeacherNameActivity.class);
                    intent.putExtra("object", array_object.get(position));
                    intent.putExtra("Action", "Select");
                    context.startActivity(intent);
                } else {
                    Intent intent = new Intent(context, ListStudentNameActivity.class);
                    intent.putExtra("object", array_object.get(position));
                    intent.putExtra("Action", "Select");
                    context.startActivity(intent);
                }
            }
        });
    }

    private void alertQuestion(Context context, ViewHolder holder) {
        MaterialDialog question_dialog = new MaterialDialog.Builder(context)
                .customView(R.layout.alert_question, false)
                .autoDismiss(false)
                .backgroundColor(Color.parseColor("#01000000"))
                .show();

        TextView ok_btn = (TextView) question_dialog.findViewById(R.id.ok);
        TextView cancel_btn = (TextView) question_dialog.findViewById(R.id.cancel);
        final TextView warningTxt = (TextView) question_dialog.findViewById(R.id.warning_alert);

        warningTxt.setText("آیا مایل به حذف این ردیف می باشید؟");

        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question_dialog.dismiss();
                Controller controller = new Controller(context);
                controller.GetFromApi2("api/CustomGroup/Remove?Id=" + array_object.get(holder.getAdapterPosition()).getId(), new CallbackGetString() {
                    @Override
                    public void onSuccess(String resultStr) {
                        try {
                            Gson gson = new Gson();
                            ManageDomain manageDomain = gson.fromJson(resultStr, ManageDomain.class);
                            Toast.makeText(context, manageDomain.getMessage(), Toast.LENGTH_SHORT).show();
                            if (manageDomain.isSuccess()) {

                                array_object.remove(holder.getAdapterPosition());
                                notifyItemRemoved(holder.getAdapterPosition());
                                notifyItemRangeChanged(holder.getAdapterPosition(), array_object.size());

                            }

                        } catch (Exception e) {
                            Toast.makeText(context, "" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(String error) {

                    }
                });

            }
        });
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question_dialog.dismiss();
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
        ConstraintLayout card, deleteIcon;
        ImageView icon;
        LinearLayout deleteBtn, editBtn, SelectBtn, UnSelectBtn;

        private ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            row = itemView.findViewById(R.id.rowNumber);
            card = itemView.findViewById(R.id.item);
            deleteIcon = itemView.findViewById(R.id.icon_background);
            icon = itemView.findViewById(R.id.icon);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
            editBtn = itemView.findViewById(R.id.editBtn);
            SelectBtn = itemView.findViewById(R.id.SelectBtn);
            UnSelectBtn = itemView.findViewById(R.id.UnSelectBtn);


        }
    }


}
