package com.atrinfanavaran.school.Adapter.New;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.atrinfanavaran.school.Domain.New.CustomGroupGetById;
import com.atrinfanavaran.school.Domain.New.ManageDomain;
import com.atrinfanavaran.school.Kernel.Controller.Controller;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackOperation;
import com.atrinfanavaran.school.R;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StudentNameListSelectedAdapter extends RecyclerView.Adapter<StudentNameListSelectedAdapter.ViewHolder> {

    private final ArrayList<CustomGroupGetById.Data.UsersToCustomGroups> array_object;
    private Context context;

    private Handler mHandler = new Handler();
    private int mFileDuration;
    private PostMiniListAdapter.SelectCallBack selectCallBack;
    public StudentNameListSelectedAdapter(ArrayList<CustomGroupGetById.Data.UsersToCustomGroups> result, PostMiniListAdapter.SelectCallBack selectCallBack) {
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
//        holder.title.setText(array_object.get(position).getName());

        holder.row.setText("" + (position + 1));

        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setChecked(false);

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                alertQuestion(context, holder, isChecked);

                selectCallBack.Id(array_object.get(position).getStudentsId(),false);
            }
        });
    }

    private void alertQuestion(Context context, ViewHolder holder, boolean check) {
//        MaterialDialog question_dialog = new MaterialDialog.Builder(context)
//                .customView(R.layout.alert_question, false)
//                .autoDismiss(false)
//                .backgroundColor(Color.parseColor("#01000000"))
//                .show();
//
//        TextView ok_btn = (TextView) question_dialog.findViewById(R.id.ok);
//        TextView cancel_btn = (TextView) question_dialog.findViewById(R.id.cancel);
//        final TextView warningTxt = (TextView) question_dialog.findViewById(R.id.warning_alert);
//
//        warningTxt.setText("آیا مایل به اضافه کردن این ردیف می باشید؟");
//        if (!check) {
//            warningTxt.setText("آیا مایل به حذف این ردیف می باشید؟");
//        }
//        ok_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                question_dialog.dismiss();
                Controller controller = new Controller(context);

                String status = "AddStudentToGroup";
                if (!check) {
                    status = "RemoveStudentFromGroup";
                }


                JSONObject params = new JSONObject();
                try {
                    if (!check) {
                        params.put("StudentId", "[" + 12 + "]");
//                    params.put("GroupId",);
                    } else {
                        params.put("UserId", "[" + 12 + "]");
                        params.put("CustomGrupId", "[" + 12 + "]");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                controller.operationProcess(context, "api/CustomGroup/" + status, params.toString(), new CallbackOperation() {
                    @Override
                    public void onSuccess(String result) {
                        try {
                            Gson gson = new Gson();
                            ManageDomain manageDomain = gson.fromJson(result, ManageDomain.class);
                            Toast.makeText(context, manageDomain.getMessage(), Toast.LENGTH_SHORT).show();
                            if (!manageDomain.isSuccess()) {
//                                if(check){
//                                    holder.checkBox.setChecked(false);
//                                }
                            }

                        } catch (Exception e) {
                            Toast.makeText(context, "" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(String error) {
                        Toast.makeText(context, "" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

//            }
//        });
//        cancel_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                question_dialog.dismiss();
//            }
//        });

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
