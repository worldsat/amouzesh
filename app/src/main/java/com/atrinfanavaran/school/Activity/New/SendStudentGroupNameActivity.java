package com.atrinfanavaran.school.Activity.New;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.atrinfanavaran.school.Domain.New.CustomGroup;
import com.atrinfanavaran.school.Domain.New.ManageDomain;
import com.atrinfanavaran.school.Fragment.NavigationDrawerFragment;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Controller;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackOperation;
import com.atrinfanavaran.school.Kernel.Helper.Waiting;
import com.atrinfanavaran.school.R;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class SendStudentGroupNameActivity extends BaseActivity {


    private Toolbar my_toolbar;
    private TextView titleTxt;
    private EditText edt1;
    private LinearLayout saveBtn;
    private JSONObject  params = new JSONObject();
    private String selectedFilePath;
    private ImageView toggle_icon;
    private LinearLayout iconBtn;
    private CustomGroup.data object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_student_group);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        initView();
        setVariable();

        bottomView();
        NavigationDrawer();
        setToolbar();
        getBundle();
    }

    private void getBundle() {
        object = (CustomGroup.data) getIntent().getSerializableExtra("object");

        if (object != null) {
            edt1.setText(object.getName());
            try {
                params.put("id", object.getId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
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
        titleTxt.setText("گروه دانش آموزان");

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().toString().trim().isEmpty()) {
                    Toast.makeText(SendStudentGroupNameActivity.this, "لطفا عنوان را وارد نمائید", Toast.LENGTH_SHORT).show();
                } else {
                    Controller controller = new Controller(SendStudentGroupNameActivity.this);
                    SettingsBll settingsBll = new SettingsBll(SendStudentGroupNameActivity.this);

                    try {
                        params.put("Name", edt1.getText().toString().trim());
                        params.put("ApplicationUserId", settingsBll.getApplicationUserId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Log.i(TAG, "onClick: " + params.toString());
                    MaterialDialog wait=new Waiting(SendStudentGroupNameActivity.this).alertWaiting();
                    wait.show();
                    controller().operationProcess(SendStudentGroupNameActivity.this, "api/CustomGroup/Add", params.toString(), new CallbackOperation() {
                        @Override
                        public void onSuccess(String result) {
                            try {
                                Gson gson = new Gson();
                                ManageDomain manageDomain = gson.fromJson(result, ManageDomain.class);
                                Toast.makeText(SendStudentGroupNameActivity.this, manageDomain.getMessage(), Toast.LENGTH_SHORT).show();
                                if (manageDomain.isSuccess()) {
                                    finish();
                                    Intent intent = new Intent(SendStudentGroupNameActivity.this, ListStudentActivity.class);
                                    startActivity(intent);
                                }

                            } catch (Exception e) {
                                Toast.makeText(SendStudentGroupNameActivity.this, "" + e.toString(), Toast.LENGTH_SHORT).show();
                            }
                            wait.dismiss();
                        }

                        @Override
                        public void onError(String error) {
                            wait.dismiss();
                            Toast.makeText(SendStudentGroupNameActivity.this, "" + error.toString(), Toast.LENGTH_SHORT).show();
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
        toggle_icon = findViewById(R.id.sub_toggle_button_icon);
        iconBtn = findViewById(R.id.iconBtn);


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
            Intent intent = new Intent(SendStudentGroupNameActivity.this, Main1Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(SendStudentGroupNameActivity.this, Main2Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn3.setOnClickListener(v -> {
            Intent intent = new Intent(SendStudentGroupNameActivity.this, Main3Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn4.setOnClickListener(v -> {
            Intent intent = new Intent(SendStudentGroupNameActivity.this, ListPostActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn5.setOnClickListener(v -> {
            Intent intent = new Intent(SendStudentGroupNameActivity.this, Main5Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
    }
}