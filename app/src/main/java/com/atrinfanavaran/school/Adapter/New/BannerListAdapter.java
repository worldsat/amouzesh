package com.atrinfanavaran.school.Adapter.New;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.text.Html;
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
import com.atrinfanavaran.school.Activity.New.SendBannerActivity;
import com.atrinfanavaran.school.Domain.New.BannerGetAll;
import com.atrinfanavaran.school.Domain.New.ManageDomain;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Controller;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGetString;
import com.atrinfanavaran.school.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;

import java.util.ArrayList;

import static org.apache.commons.lang3.StringEscapeUtils.unescapeHtml4;

public class BannerListAdapter extends RecyclerView.Adapter<BannerListAdapter.ViewHolder> {

    private final ArrayList<BannerGetAll.Data> array_object;
    private Context context;

    private Handler mHandler = new Handler();
    private int mFileDuration;

    public BannerListAdapter(ArrayList<BannerGetAll.Data> result) {
        this.array_object = result;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_banner_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        context = holder.itemView.getContext();

        String escaped = unescapeHtml4("<html><body > <head></head>" + java.net.URLDecoder.decode(array_object.get(position).getDescription().replace("null", "-")) + "  </body><html>");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.title.setText(Html.fromHtml(escaped, Html.FROM_HTML_MODE_COMPACT));
        } else {
            holder.title.setText(Html.fromHtml(escaped));
        }
        holder.rowNumber.setText("" + (position + 1));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        SettingsBll settingsBll = new SettingsBll(context);
        if (array_object.get(position).getUrl() != null && !array_object.get(position).getUrl().equals("null")) {
            holder.bannerImage.setVisibility(View.VISIBLE);
            RequestOptions requestOptions = new RequestOptions();
//                                requestOptions.placeholder(R.mipmap.logo);
//                                requestOptions.error(R.mipmap.logo);

            Glide.with(context)
                    .setDefaultRequestOptions(requestOptions)
                    .load(settingsBll.getUrlAddress() + array_object.get(position).getUrl())
//                    .apply(RequestOptions.circleCropTransform())
                    .into(holder.bannerImage);
        }else{
            holder.bannerImage.setVisibility(View.GONE);
        }

        holder.deleteBtn.setOnClickListener(v -> alertQuestion(context, holder));
        holder.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SendBannerActivity.class);
                intent.putExtra("object", array_object.get(position));
                context.startActivity(intent);
            }
        });
        if (settingsBll.getUserType() == 2) {
            holder.buttonsLayer.setVisibility(View.GONE);
        }
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
                controller.GetFromApi2("api/Banner/Remove?Id=" + array_object.get(holder.getAdapterPosition()).getId(), new CallbackGetString() {
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
        TextView title, rowNumber, status;
        ConstraintLayout card;
        ImageView bannerImage;
        LinearLayout deleteBtn, editBtn,buttonsLayer;

        private ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            rowNumber = itemView.findViewById(R.id.rowNumber);
            status = itemView.findViewById(R.id.statusTxt);
            card = itemView.findViewById(R.id.item);
            bannerImage = itemView.findViewById(R.id.imageView20);

            deleteBtn = itemView.findViewById(R.id.deleteBtn);
            editBtn = itemView.findViewById(R.id.editBtn);
            buttonsLayer = itemView.findViewById(R.id.buttonsLayer);


        }
    }


}
