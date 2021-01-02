package com.atrinfanavaran.school.Kernel.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.afollestad.materialdialogs.MaterialDialog;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Controller;
import com.atrinfanavaran.school.Kernel.Controller.Module.SnakBar.SnakBar;
import com.atrinfanavaran.school.Kernel.Helper.ExceptionHandler;
import com.atrinfanavaran.school.Kernel.Helper.ListBuilder;
import com.atrinfanavaran.school.R;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class BaseActivity extends AppCompatActivity {

    public static final String TAG = "moh3n";

    {
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));

    }

    @SuppressLint("SimpleDateFormat")
    public static String getCurrentTimeStamp(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(date);
    }


    public static MaterialDialog alertWaiting(Context context) {

        MaterialDialog waiting_dialog = new MaterialDialog.Builder(context)
                .customView(R.layout.alert_waiting, false)
                .autoDismiss(false)
                .backgroundColor(Color.parseColor("#01000000"))
                .build();

        ImageView loading_circle = (ImageView) waiting_dialog.findViewById(R.id.loading_circle_alert);

        Glide.with(context)
                .load(R.mipmap.loading)
                .into(loading_circle);
        return waiting_dialog;
    }

    public static MaterialDialog alertWaiting2(Context context, String str) {

        MaterialDialog waiting_dialog = new MaterialDialog.Builder(context)
                .customView(R.layout.alert_waiting, false)
                .autoDismiss(false)
                .backgroundColor(Color.parseColor("#01000000"))
                .build();
        TextView warning = (TextView) waiting_dialog.findViewById(R.id.ok);
        warning.setText(str);
        ImageView loading_circle = (ImageView) waiting_dialog.findViewById(R.id.loading_circle_alert);

        Glide.with(context)
                .load(R.mipmap.loading)
                .into(loading_circle);
        return waiting_dialog;
    }

    protected <T extends BaseActivity> T getActivity() {
        return (T) this;
    }

    public void SnakBar(String str) {
        SnakBar snakBar = new SnakBar();
        snakBar.snakShow(BaseActivity.this, str);
    }

    public Controller controller() {

        return new Controller(BaseActivity.this);
    }

    public SettingsBll settingsBll() {
        return new SettingsBll(BaseActivity.this);
    }

    public Gson gson() {
        return new Gson();
    }

    public ListBuilder listBuilder() {
        return new ListBuilder(BaseActivity.this);
    }


    public Boolean isONLINE(Context context) {
        SettingsBll settingsBll = new SettingsBll(context);
        return settingsBll.isOnline();
    }


    public String changeNumber(String num) {
        num = num.replaceAll("۰", "0");
        num = num.replaceAll("۱", "1");
        num = num.replaceAll("۲", "2");
        num = num.replaceAll("۳", "3");
        num = num.replaceAll("۴", "4");
        num = num.replaceAll("۵", "5");
        num = num.replaceAll("۶", "6");
        num = num.replaceAll("۷", "7");
        num = num.replaceAll("۸", "8");
        num = num.replaceAll("۹", "9");
        num = num.replaceAll("٫", ".");
        return num;
    }
}
