package com.atrinfanavaran.school.Adapter.New;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.atrinfanavaran.school.Domain.New.DropdownList;
import com.atrinfanavaran.school.Domain.New.EducationPostGetAll;
import com.atrinfanavaran.school.Domain.New.ManageDomain;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Controller;
import com.atrinfanavaran.school.Kernel.Controller.Interface.IOnResponseListener;
import com.atrinfanavaran.school.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

public class DastresiAdapter extends RecyclerView.Adapter<DastresiAdapter.ViewHolder> {

    private final ArrayList<DropdownList> array_object;
    private Context context;
    int delayAnimate = 300; //global variable
    int delayAnimate2 = 0; //global variable
    private boolean exit = false;
    private boolean endStart = false;
    private boolean endExit = false;
    private SelectCallBack selectCallBack;
    private int oldPosition = 0;
    private EducationPostGetAll.Data object;
    private String kind;

    public DastresiAdapter(String kind, ArrayList<DropdownList> result, EducationPostGetAll.Data object, SelectCallBack selectCallBack) {
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
                if (kind.equals("Category")) {
                    if (array_object.get(position).getListId() == 0) {
                        alertNewCategory(holder.itemView.getContext());
                    } else {
                        array_object.get(oldPosition).setTick(false);
                        array_object.get(position).setTick(true);

                        notifyDataSetChanged();
                        holder.icon.setImageResource(R.mipmap.tick128);

                        selectCallBack.Id(array_object.get(position).getListId());
                    }
                } else {
                    array_object.get(oldPosition).setTick(false);
                    array_object.get(position).setTick(true);

                    notifyDataSetChanged();
                    holder.icon.setImageResource(R.mipmap.tick128);

                    selectCallBack.Id(array_object.get(position).getListId());
                }

            }
        });

        if (array_object.size() == (position + 1)) {
            endStart = true;
        }
    }

    private void alertNewCategory(Context context) {
        MaterialDialog question_dialog = new MaterialDialog.Builder(context)
                .customView(R.layout.alert_category_new, false)
                .autoDismiss(false)
                .backgroundColor(Color.parseColor("#01000000"))
                .show();

        TextView ok_btn = (TextView) question_dialog.findViewById(R.id.ok);
        TextView cancel_btn = (TextView) question_dialog.findViewById(R.id.cancel);
        EditText warningTxt = (EditText) question_dialog.findViewById(R.id.warning_alert);


        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String categoryStr = warningTxt.getText().toString().trim();
                if (warningTxt.getText().toString().trim().isEmpty()) {
                    Toast.makeText(context, "نام دسته بندی را وارد نمایید", Toast.LENGTH_SHORT).show();
                    return;
                } else {

                    SettingsBll settingsBll = new SettingsBll(context);
                    HashMap<String, Object> params = new HashMap<>();
                    params.put("ApplicationUserId", settingsBll.getApplicationUserId());
                    params.put("Name", categoryStr);
                    params.put("file", "");
                    question_dialog.dismiss();
                    Controller controller = new Controller(context);

                    controller.uploadFileNew(context, "api/Category/Add", null, params, new IOnResponseListener() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                Gson gson = new Gson();
                                ManageDomain manageDomain = gson.fromJson(response, ManageDomain.class);
                                Toast.makeText(context, manageDomain.getMessage(), Toast.LENGTH_SHORT).show();

                                if (manageDomain.isSuccess()) {
                                    selectCallBack.refresh();
                                }

                            } catch (Exception e) {
                                Toast.makeText(context, "" + e.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onError() {

                        }
                    });

                }
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

        void refresh();
    }
}
