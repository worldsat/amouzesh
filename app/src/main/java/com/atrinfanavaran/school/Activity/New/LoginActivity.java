package com.atrinfanavaran.school.Activity.New;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.atrinfanavaran.school.Domain.AndroidVersion;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Controller;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGet;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackOperation;
import com.atrinfanavaran.school.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoginActivity extends BaseActivity {
    private EditText userEdt, passEdt;
    private ProgressBar waitingProgressbar;
    private LinearLayout loginBtn;
    private TextView rulesBtn, rememberPassBtn;
    private SettingsBll settingsBll;
    private static final int Time_Between_Two_Back = 2000;
    private long TimeBackPressed;
    private TextView rememberBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        initView();
        setVariable();
        checkVersion();
//        setToolbar();
    }

    private void setToolbar() {
        TextView titleToolbar = findViewById(R.id.titleToolbar);
        titleToolbar.setText("");
    }

    @Override
    public void onBackPressed() {
        if (TimeBackPressed + Time_Between_Two_Back > System.currentTimeMillis()) {
            finishAffinity();
            return;
        } else {
            Toast.makeText(this, "به منظور خروج دوباره کلیک کنید", Toast.LENGTH_SHORT).show();
        }
        TimeBackPressed = System.currentTimeMillis();
    }

    private void setVariable() {
        settingsBll = new SettingsBll(this);
        SharedPreferences sp = getApplicationContext().getSharedPreferences("Settings", 0);
        if (sp != null) {
            if (settingsBll.getLoging()) {
                startActivity(new Intent(LoginActivity.this, Main3Activity.class));
            }
        }


        loginBtn.setOnClickListener(v -> {

            waitingProgressbar.setVisibility(View.VISIBLE);

            if (userEdt.getText().toString().isEmpty()) {
                SnakBar("لطفا نام کاربری را وارد نمائید");
                waitingProgressbar.setVisibility(View.GONE);
            } else if (passEdt.getText().toString().isEmpty()) {

                SnakBar("لطفا رمز عبور را وارد نمائید");
                waitingProgressbar.setVisibility(View.GONE);
            } else {

                JSONObject loginObject = null;
                try {
                    loginObject = new JSONObject();
                    loginObject.put("UserName", userEdt.getText().toString());
                    loginObject.put("Password", passEdt.getText().toString());


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                controller().LoginApi(this, SendPostActivity.class, "api/User/Login", loginObject.toString(), new CallbackOperation() {
                    @Override
                    public void onSuccess(String result) {
                        settingsBll.setLoging(true);
                        startActivity(new Intent(LoginActivity.this, Main3Activity.class));
                        waitingProgressbar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(String error) {
                        waitingProgressbar.setVisibility(View.GONE);
                        SnakBar(error);
                    }
                });
            }
        });


        rememberPassBtn.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RememberPasswordActivity.class)));
    }

    private void initView() {
        userEdt = findViewById(R.id.UserEdt);
        passEdt = findViewById(R.id.passEdt);
        loginBtn = findViewById(R.id.loginBtn);
        waitingProgressbar = findViewById(R.id.progressBar3);


        rememberPassBtn = findViewById(R.id.remember);

    }


    private void checkVersion() {


        Controller controller = new Controller(this);
        controller.Get(AndroidVersion.class, null, 0, 0, true, new CallbackGet() {
            @Override
            public <T> void onSuccess(ArrayList<T> result, int count) {
                Log.i("moh3n", "version: " + result);
                ArrayList<AndroidVersion> response = (ArrayList<AndroidVersion>) result;

                if (response.size() > 0) {

                    int lastVerisionCode = Integer.valueOf(response.get(response.size() - 1).getcurrVersion());
                    String link = response.get(response.size() - 1).getappAndroidUrl();

                    try {
                        PackageInfo phoneVersion = LoginActivity.this.getPackageManager().getPackageInfo(getPackageName(), 0);

                        if (phoneVersion.versionCode < lastVerisionCode) {
                            alertQuestion(LoginActivity.this, link);
                        }
                        Log.i("moh3n", phoneVersion.versionCode + " " + lastVerisionCode);
                    } catch (Exception e) {
                        Log.i("moh3n", "error versionConde:" + e);
                    }
                }
            }

            @Override
            public void onError(String error) {

            }
        });

    }

    private void alertQuestion(final Context context, String link) {
        final MaterialDialog question_dialog = new MaterialDialog.Builder(context)
                .customView(R.layout.alert_warning_update, false)
                .autoDismiss(false)
                .backgroundColor(Color.parseColor("#01000000"))
                .show();

        TextView ok_btn = (TextView) question_dialog.findViewById(R.id.ok);
        TextView cancel_btn = (TextView) question_dialog.findViewById(R.id.cancel);
        final TextView warningTxt = (TextView) question_dialog.findViewById(R.id.warning_alert);


        warningTxt.setText("نسخه جدید از نرم افزار موجود است،آیا مایل به بروزرسانی میباشید؟");

        ok_btn.setOnClickListener(v -> {

            String Address = link;
            Log.i("moh3n", "onClick: " + Address);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(Address));
            startActivity(i);

        });
        cancel_btn.setOnClickListener(v -> question_dialog.dismiss());

    }


}
