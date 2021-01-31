package com.atrinfanavaran.school.Activity.New;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.atrinfanavaran.school.Domain.New.CustomGroup;
import com.atrinfanavaran.school.Domain.New.ManageDomain;
import com.atrinfanavaran.school.Fragment.NavigationDrawerFragment;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackOperation;
import com.atrinfanavaran.school.Kernel.Helper.Waiting;
import com.atrinfanavaran.school.R;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class SendCommentActivity extends BaseActivity {


    private Toolbar my_toolbar;
    private TextView titleTxt;
    private EditText edt1;
    private LinearLayout saveBtn;
    private JSONObject params = new JSONObject();

    private CustomGroup.data object;
    private String EducationPostId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_comment);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        initView();
        setVariable();

        bottomView();
        NavigationDrawer();
        setToolbar();
        getBundle();
    }

    private void getBundle() {
        EducationPostId = getIntent().getStringExtra("EducationPostId");
//        EducationPostId = "1028";
//        object = (CustomGroup.data) getIntent().getSerializableExtra("object");
//
//        if (object != null) {
//            edt1.setText(object.getName());
//            try {
//                params.put("id", object.getId());
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
    }


    private void setToolbar() {
        TextView titleToolbar = findViewById(R.id.titleToolbar);
        titleToolbar.setText(settingsBll().getSchoolName());
    }

    private void NavigationDrawer() {

        NavigationDrawerFragment my_nav = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        my_nav.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), my_toolbar);

    }


    private void setVariable() {
//        titleTxt.setText("گروه دانش آموزان");

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().toString().trim().isEmpty()) {
                    Toast.makeText(SendCommentActivity.this, "لطفا نظر خود را وارد نمائید", Toast.LENGTH_SHORT).show();
                } else {

                    SettingsBll settingsBll = new SettingsBll(SendCommentActivity.this);

                    try {
                        params.put("Text", edt1.getText().toString().trim());
                        params.put("EducationPostId", EducationPostId);
                        params.put("StudentsId", settingsBll.getApplicationUserId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Log.i(TAG, "onClick: " + params.toString());
                    MaterialDialog wait = new Waiting(SendCommentActivity.this).alertWaiting();
                    wait.show();
                    controller().operationProcess(SendCommentActivity.this, "Api/Comments/Add", params.toString(), new CallbackOperation() {
                        @Override
                        public void onSuccess(String result) {
                            try {
                                Gson gson = new Gson();
                                ManageDomain manageDomain = gson.fromJson(result, ManageDomain.class);
                                Toast.makeText(SendCommentActivity.this, manageDomain.getMessage(), Toast.LENGTH_SHORT).show();
                                if (manageDomain.isSuccess()) {
                                    finish();
                                    Intent intent = new Intent(SendCommentActivity.this, ListCommentActivity.class);
                                   intent.putExtra("EducationPostId",Integer.valueOf(EducationPostId));
                                    startActivity(intent);
                                }

                            } catch (Exception e) {
                                Toast.makeText(SendCommentActivity.this, "" + e.toString(), Toast.LENGTH_SHORT).show();
                            }
                            wait.dismiss();
                        }

                        @Override
                        public void onError(String error) {
                            wait.dismiss();
                            Toast.makeText(SendCommentActivity.this, "" + error, Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });


    }

    private void initView() {

        my_toolbar = findViewById(R.id.toolbar);
        titleTxt = findViewById(R.id.titleTxt);
        edt1 = findViewById(R.id.edt1);
        saveBtn = findViewById(R.id.sendBtn);

    }

    private void bottomView() {
        LinearLayout btn1 = findViewById(R.id.btn1);
        LinearLayout btn2 = findViewById(R.id.btn2);
        LinearLayout btn3 = findViewById(R.id.btn3);
        LinearLayout btn4 = findViewById(R.id.btn4);
        LinearLayout btn5 = findViewById(R.id.btn5);
        View view1 = findViewById(R.id.view1);
        View view2 = findViewById(R.id.view2);
        View view3 = findViewById(R.id.view3);
        View view4 = findViewById(R.id.view4);
        View view5 = findViewById(R.id.view5);

        view3.setVisibility(View.VISIBLE);

        btn1.setOnClickListener(v -> {
            Intent intent = new Intent(SendCommentActivity.this, Main1Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(SendCommentActivity.this, Main2Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn3.setOnClickListener(v -> {
            Intent intent = new Intent(SendCommentActivity.this, Main3Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn4.setOnClickListener(v -> {
            Intent intent = new Intent(SendCommentActivity.this, ListPostActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn5.setOnClickListener(v -> {
            Intent intent = new Intent(SendCommentActivity.this, Main5Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        ConstraintLayout postLayout = findViewById(R.id.postlayout);
        if (settingsBll.getUserType() != 0 && settingsBll.getUserType() != 1) {
            postLayout.setVisibility(View.GONE);
        }
    }
}