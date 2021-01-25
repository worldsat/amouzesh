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
import com.atrinfanavaran.school.Activity.New.ListCommentActivity;
import com.atrinfanavaran.school.Domain.New.CategoryGetAll;
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

    private final ArrayList<CategoryGetAll.Data> array_object;
    private Context context;

    private Handler mHandler = new Handler();
    private int mFileDuration;

    public CommentTeacherListAdapter(ArrayList<CategoryGetAll.Data> result) {
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
        holder.title.setText(array_object.get(position).getName());

        holder.approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                approve(0,array_object.get(position));
            }
        });

        holder.unapprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                approve(1,array_object.get(position));
            }
        });
        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteComment(array_object.get(position));
            }
        });

    }
    private void approve(int status,CategoryGetAll.Data object) {
        SettingsBll settingsBll = new SettingsBll(context);
        JSONObject params = new JSONObject();
        try {
            params.put("CommentStatus", status);
//            params.put("Id", EducationPostId);
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
                        Intent intent = new Intent(context, ListCommentActivity.class);
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
    private void deleteComment(CategoryGetAll.Data object) {
        SettingsBll settingsBll = new SettingsBll(context);
        JSONObject params = new JSONObject();
        try {

//            params.put("Id", EducationPostId);
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
                        Intent intent = new Intent(context, ListCommentActivity.class);
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
        TextView title, rowNumber, size;
        ConstraintLayout card;
        ImageView icon;
        CheckBox checkBox;
        LinearLayout approve, unapprove,deleteBtn;
        private ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            rowNumber = itemView.findViewById(R.id.rowNumber);
            card = itemView.findViewById(R.id.item);
            icon = itemView.findViewById(R.id.icon);
            checkBox = itemView.findViewById(R.id.checkBox);
            approve = itemView.findViewById(R.id.sendBtn);
            unapprove = itemView.findViewById(R.id.backBtn);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
        }
    }


}
