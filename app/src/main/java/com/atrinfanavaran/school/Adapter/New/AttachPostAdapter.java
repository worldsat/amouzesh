package com.atrinfanavaran.school.Adapter.New;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.atrinfanavaran.school.Domain.New.AttachFile;
import com.atrinfanavaran.school.Domain.New.ManageDomain;
import com.atrinfanavaran.school.Kernel.Controller.Controller;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGetString;
import com.atrinfanavaran.school.R;
import com.google.gson.Gson;

import java.util.ArrayList;

public class AttachPostAdapter extends RecyclerView.Adapter<AttachPostAdapter.ViewHolder> {

    private final ArrayList<AttachFile> array_object;
    private Context context;
    int delayAnimate = 300; //global variable
    int delayAnimate2 = 0; //global variable
    private boolean exit = false;
    private boolean endStart = false;
    private boolean endExit = false;
    private deleteAttachCallBack deleteAttachCallBack;

    public AttachPostAdapter(ArrayList<AttachFile> result, deleteAttachCallBack deleteAttachCallBack) {
        this.array_object = result;
        this.deleteAttachCallBack = deleteAttachCallBack;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_attach, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        context = holder.itemView.getContext();
        String[] fileName = array_object.get(position).getAttachName().split("/");

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
        holder.deleteIcon.setOnClickListener(v -> {
            if (array_object.get(position).getAttachId().equals("null")) {
                array_object.remove(position);
                notifyDataSetChanged();
                deleteAttachCallBack.position(position);
            } else {
                alertQuestionDeleteFile(context, holder);
            }
        });

//        setbackground(position, holder.card, holder.icon_background, holder.title);
//        holder.card.setVisibility(View.INVISIBLE);

//
//        if (exit) {
//            holder.itemView.setVisibility(View.VISIBLE);
//
//        } else {
//            if (!endStart) {
//
//            } else {
//                holder.itemView.setVisibility(View.VISIBLE);
//            }
//        }

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

    }

    private void alertQuestionDeleteFile(Context context, AttachPostAdapter.ViewHolder holder) {
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
                controller.GetFromApi2("api/EducationPost/RemoveFile?Id=" + array_object.get(holder.getAdapterPosition()).getAttachId(), new CallbackGetString() {
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

    public interface deleteAttachCallBack {
        void position(int num);
    }
}
