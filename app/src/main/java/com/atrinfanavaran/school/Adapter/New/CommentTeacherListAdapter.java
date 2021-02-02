package com.atrinfanavaran.school.Adapter.New;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.atrinfanavaran.school.Activity.New.ListCommentTeacherActivity;
import com.atrinfanavaran.school.Domain.New.CommentsGetAll;
import com.atrinfanavaran.school.Domain.New.ManageDomain;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Controller;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackOperation;
import com.atrinfanavaran.school.Kernel.Helper.Waiting;
import com.atrinfanavaran.school.R;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CommentTeacherListAdapter extends RecyclerView.Adapter<CommentTeacherListAdapter.ViewHolder> {

    private final ArrayList<CommentsGetAll.Data> array_object;
    private Context context;

    private Handler mHandler = new Handler();
    private int mFileDuration;

    public CommentTeacherListAdapter(ArrayList<CommentsGetAll.Data> result) {
        this.array_object = result;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_comment2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        context = holder.itemView.getContext();
        holder.title.setText(array_object.get(position).getText());
        holder.t1.setText(array_object.get(position).getStudents());
        holder.t2.setText(array_object.get(position).getDate());
        if (array_object.get(position).getCommentStatus() == 0) {
            holder.statusTxt.setText("تاییده شده");
            holder.statusTxt.setTextColor(context.getResources().getColor(R.color.green_A700));
        } else if (array_object.get(position).getCommentStatus() == 1) {
            holder.statusTxt.setText("در حال انتظار");
            holder.statusTxt.setTextColor(context.getResources().getColor(R.color.brown_700));
        }
        else if (array_object.get(position).getCommentStatus() == 2) {
            holder.statusTxt.setText("عدم تایید");
            holder.statusTxt.setTextColor(context.getResources().getColor(R.color.red_700));
        }
        holder.approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                approve(0, array_object.get(position));
            }
        });

        holder.unapprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                approve(1, array_object.get(position));
            }
        });
        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteComment(array_object.get(position));
            }
        });

    }

    private void approve(int status, CommentsGetAll.Data object) {
        SettingsBll settingsBll = new SettingsBll(context);
        JSONObject params = new JSONObject();
        try {
            params.put("CommentStatus", status);
            params.put("Id", object.getId());
            params.put("ApplicationUserId", settingsBll.getApplicationUserId());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.i("moh3n", "onClick: " + params.toString());
        MaterialDialog wait = new Waiting(context).alertWaiting();
        wait.show();
        Controller controller = new Controller(context);
        controller.operationProcess(context, "Api/Comments/ChangeStatus", params.toString(), new CallbackOperation() {
            @Override
            public void onSuccess(String result) {
                try {
                    Gson gson = new Gson();
                    ManageDomain manageDomain = gson.fromJson(result, ManageDomain.class);
                    Toast.makeText(context, manageDomain.getMessage(), Toast.LENGTH_SHORT).show();
                    if (manageDomain.isSuccess()) {
                        ((Activity) context).finish();
                        Intent intent = new Intent(context, ListCommentTeacherActivity.class);
                        context.startActivity(intent);
                    }

                } catch (Exception e) {
                    Toast.makeText(context, "" + e.toString(), Toast.LENGTH_SHORT).show();
                }
                wait.dismiss();
            }

            @Override
            public void onError(String error) {
                wait.dismiss();
                Toast.makeText(context, "" + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void deleteComment(CommentsGetAll.Data object) {
        SettingsBll settingsBll = new SettingsBll(context);
        JSONObject params = new JSONObject();
        try {

            params.put("Id", object.getId());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.i("moh3n", "onClick: " + params.toString());
        MaterialDialog wait = new Waiting(context).alertWaiting();
        wait.show();
        Controller controller = new Controller(context);
        controller.operationProcess(context, "Api/Comments/Remove", params.toString(), new CallbackOperation() {
            @Override
            public void onSuccess(String result) {
                try {
                    Gson gson = new Gson();
                    ManageDomain manageDomain = gson.fromJson(result, ManageDomain.class);
                    Toast.makeText(context, manageDomain.getMessage(), Toast.LENGTH_SHORT).show();
                    if (manageDomain.isSuccess()) {
                        ((Activity) context).finish();
                        Intent intent = new Intent(context, ListCommentTeacherActivity.class);
                        context.startActivity(intent);
                    }

                } catch (Exception e) {
                    Toast.makeText(context, "" + e.toString(), Toast.LENGTH_SHORT).show();
                }
                wait.dismiss();
            }

            @Override
            public void onError(String error) {
                wait.dismiss();
                Toast.makeText(context, "" + error, Toast.LENGTH_SHORT).show();
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
        TextView title, rowNumber, statusTxt;
        ConstraintLayout card;
        ImageView icon;
        CheckBox checkBox;
        LinearLayout approve, unapprove, deleteBtn;
TextView t1,t2;
        private ViewHolder(View itemView) {
            super(itemView);

            statusTxt = itemView.findViewById(R.id.statusTxt);
            title = itemView.findViewById(R.id.title);
            rowNumber = itemView.findViewById(R.id.rowNumber);
            card = itemView.findViewById(R.id.item);
            icon = itemView.findViewById(R.id.icon);
            checkBox = itemView.findViewById(R.id.checkBox);
            approve = itemView.findViewById(R.id.sendBtn);
            unapprove = itemView.findViewById(R.id.backBtn);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
        }
    }


}
