package com.atrinfanavaran.school.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.util.Log;
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
import com.atrinfanavaran.school.Activity.New.BookmarkListActivity;
import com.atrinfanavaran.school.Activity.New.ShowPostActivity;
import com.atrinfanavaran.school.Domain.New.FavoritGetAll;
import com.atrinfanavaran.school.Domain.New.ManageDomain;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Controller;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackOperation;
import com.atrinfanavaran.school.Kernel.Helper.Waiting;
import com.atrinfanavaran.school.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BookmarkListAdapter extends RecyclerView.Adapter<BookmarkListAdapter.ViewHolder> {

    private final ArrayList<FavoritGetAll.Data> array_object;
    private Context context;

    private Handler mHandler = new Handler();
    private int mFileDuration;

    public BookmarkListAdapter(ArrayList<FavoritGetAll.Data> result) {
        this.array_object = result;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_post_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        context = holder.itemView.getContext();
        holder.title.setText(array_object.get(position).getEducationPost().getTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, ShowPostActivity.class);
                intent.putExtra("Id", array_object.get(position).getEducationPostId());
                context.startActivity(intent);


            }
        });
        SettingsBll settingsBll = new SettingsBll(context);
        String Url = settingsBll.getUrlAddress() + array_object.get(position).getEducationPost().getIconUrl();

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.mipmap.logo);
        requestOptions.error(R.mipmap.logo);


        Glide.with(holder.itemView.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(Url)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.icon);

//        if (settingsBll.getUserType() == 2) {
//            holder.editBtn.setVisibility(View.GONE);
//            holder.deleteBtn.setVisibility(View.GONE);
//        }

        holder.deleteBtn.setOnClickListener(v -> alertQuestion(context,  array_object.get(position)));
        holder.editBtn.setVisibility(View.GONE);

    }

    private void alertQuestion(Context context, FavoritGetAll.Data object) {
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
                    controller.operationProcess(context, "Api/Favorit/Remove", params.toString(), new CallbackOperation() {
                        @Override
                        public void onSuccess(String result) {
                            try {
                                Gson gson = new Gson();
                                ManageDomain manageDomain = gson.fromJson(result, ManageDomain.class);
                                Toast.makeText(context, manageDomain.getMessage(), Toast.LENGTH_SHORT).show();
                                if (manageDomain.isSuccess()) {
                                    ((Activity) context).finish();
                                    Intent intent = new Intent(context, BookmarkListActivity.class);
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
        TextView title, time, size;
        ConstraintLayout card, deleteIcon;
        ImageView icon;
        LinearLayout deleteBtn, editBtn;

        private ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            time = itemView.findViewById(R.id.timeTxt);
            size = itemView.findViewById(R.id.sizeTxt);
            card = itemView.findViewById(R.id.item);
            deleteIcon = itemView.findViewById(R.id.icon_background);
            icon = itemView.findViewById(R.id.icon);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
            editBtn = itemView.findViewById(R.id.editBtn);


        }
    }


}
