package com.atrinfanavaran.school.Activity.New;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.atrinfanavaran.school.Domain.New.RememberPassword;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGetString;
import com.atrinfanavaran.school.R;

public class RememberPasswordActivity extends BaseActivity {
    private EditText mobileEdt;
    private ProgressBar waitingProgressbar;
    private LinearLayout loginBtn;
    private TextView rulesBtn;
    private SettingsBll settingsBll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember_password);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        initView();
        setVariable();
//        setToolbar();
    }

    private void setToolbar() {
        TextView titleToolbar = findViewById(R.id.titleToolbar);
        titleToolbar.setText("");
    }

    private void setVariable() {
        settingsBll = new SettingsBll(this);

        loginBtn.setOnClickListener(v -> {

            waitingProgressbar.setVisibility(View.VISIBLE);

//            JSONObject loginObject = null;
//            try {
//                loginObject = new JSONObject();
//                loginObject.put("userName", mobileEdt.getText().toString());
//
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
            if (mobileEdt.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "لطفا شماره همراه را وارد نمائید", Toast.LENGTH_SHORT).show();
                return;
            }

            controller().GetFromApi2("api/User/ForgetPassword?Mobile=" + mobileEdt.getText().toString().trim(), new CallbackGetString() {
                @Override
                public void onSuccess(String resultStr) {
                    RememberPassword response = gson().fromJson(resultStr, RememberPassword.class);
                    Toast.makeText(RememberPasswordActivity.this, response.getMessage(), Toast.LENGTH_LONG).show();
                    if (response.isSuccess()) {
                        startActivity(new Intent(RememberPasswordActivity.this, LoginActivity.class));
                    }
                    waitingProgressbar.setVisibility(View.GONE);
                }

                @Override
                public void onError(String error) {
                    waitingProgressbar.setVisibility(View.GONE);
                    SnakBar(error);
                }
            });

        });


    }

    private void initView() {
        mobileEdt = findViewById(R.id.mobileEdt);
        loginBtn = findViewById(R.id.loginBtn);
        waitingProgressbar = findViewById(R.id.progressBar3);


    }

}
