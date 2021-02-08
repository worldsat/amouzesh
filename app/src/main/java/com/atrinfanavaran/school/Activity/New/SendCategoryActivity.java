package com.atrinfanavaran.school.Activity.New;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.atrinfanavaran.school.Domain.New.CategoryGetAll;
import com.atrinfanavaran.school.Domain.New.ManageDomain;
import com.atrinfanavaran.school.Fragment.NavigationDrawerFragment;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Controller;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGetString;
import com.atrinfanavaran.school.Kernel.Controller.Interface.IOnResponseListener;
import com.atrinfanavaran.school.Kernel.Helper.FilePath;
import com.atrinfanavaran.school.R;
import com.google.gson.Gson;

import java.io.File;
import java.util.HashMap;

public class SendCategoryActivity extends BaseActivity {


    private Toolbar my_toolbar;
    private TextView titleTxt;
    private EditText edt1;
    private LinearLayout saveBtn,teacherswitchlayout;
    private HashMap<String, Object> params = new HashMap<>();
    private String selectedFilePath;
    private ImageView toggle_icon;
    private LinearLayout iconBtn;
    private CategoryGetAll.Data object;
    private Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_category);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        initView();
        setVariable();

        bottomView();
        NavigationDrawer();
        setToolbar();
        getBundle();
    }

    private void getBundle() {
        object = (CategoryGetAll.Data) getIntent().getSerializableExtra("object");

        if (object != null) {
            edt1.setText(object.getName());

            if (object.isIsOnlyForTeacher()) {
                aSwitch.setChecked(true);
            }
            params.put("id", object.getId());

            if (object.getUrl() != null && !object.getUrl().equals("null")) {
                toggle_icon.setVisibility(View.VISIBLE);
                toggle_icon.setImageResource(R.mipmap.unmark);
                toggle_icon.setOnClickListener(v -> alertQuestionDeleteFile(SendCategoryActivity.this));
                params.put("file", "null");
            }
        }
    }

    private void alertQuestionDeleteFile(Context context) {
        MaterialDialog question_dialog = new MaterialDialog.Builder(context)
                .customView(R.layout.alert_question, false)
                .autoDismiss(false)
                .backgroundColor(Color.parseColor("#01000000"))
                .show();

        TextView ok_btn = (TextView) question_dialog.findViewById(R.id.ok);
        TextView cancel_btn = (TextView) question_dialog.findViewById(R.id.cancel);
        final TextView warningTxt = (TextView) question_dialog.findViewById(R.id.warning_alert);

        warningTxt.setText("آیا مایل به حذف می باشید؟");

        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (object.getUrl() != null && !object.getUrl().equals("null")) {
                    question_dialog.dismiss();
                    Controller controller = new Controller(context);
                    controller.GetFromApi2("api/Category/RemoveFile?Id=" + object.getId(), new CallbackGetString() {
                        @Override
                        public void onSuccess(String resultStr) {
                            try {
                                Gson gson = new Gson();
                                ManageDomain manageDomain = gson.fromJson(resultStr, ManageDomain.class);
                                Toast.makeText(context, manageDomain.getMessage(), Toast.LENGTH_SHORT).show();
                                if (manageDomain.isSuccess()) {
                                    params.put("file", "");
                                    toggle_icon.setVisibility(View.GONE);
                                    Toast.makeText(context, manageDomain.getMessage(), Toast.LENGTH_SHORT).show();

                                }

                            } catch (Exception e) {
                                Toast.makeText(context, "" + e.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onError(String error) {

                        }
                    });
                } else {
                    params.put("file", "");
                    toggle_icon.setVisibility(View.GONE);
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

    private void setToolbar() {
        TextView titleToolbar = findViewById(R.id.titleToolbar);
        titleToolbar.setText(settingsBll().getSchoolName());
    }

    private void NavigationDrawer() {

        NavigationDrawerFragment my_nav = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        my_nav.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), my_toolbar);

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {

            if (data == null) {
                return;
            }
            Uri selectedImage = data.getData();
            selectedFilePath = FilePath.getPath(this, selectedImage);
            params.put("file", new File(selectedFilePath));

            toggle_icon.setVisibility(View.VISIBLE);
            toggle_icon.setImageResource(R.mipmap.unmark);
            Log.i(TAG, "onActivityResult: " + params.toString());
        }


    }

    private void setVariable() {
//        titleTxt.setText("کلیه پست ها");

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().toString().trim().isEmpty()) {
                    Toast.makeText(SendCategoryActivity.this, "لطفا عنوان دسته بندی را وارد نمائید", Toast.LENGTH_SHORT).show();
                } else {
                    Controller controller = new Controller(SendCategoryActivity.this);
                    SettingsBll settingsBll = new SettingsBll(SendCategoryActivity.this);

                    params.put("Name", edt1.getText().toString().trim());
                    params.put("ApplicationUserId", settingsBll.getApplicationUserId());
                    params.put("IsOnlyForTeacher", aSwitch.isChecked());
                    Log.i(TAG, "onClick: " + params.toString());
                    controller.uploadFileNew(SendCategoryActivity.this, "api/Category/Add", null, params, new IOnResponseListener() {
                        @Override
                        public void onResponse(String response) {

                            finish();
                            Intent intent = new Intent(SendCategoryActivity.this, ListCategoryActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onError() {


                        }
                    });
                }
            }
        });
        iconBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                Intent sIntent;
                if (Build.BRAND.equals("samsung")) {
                    intent = new Intent("com.sec.android.app.myfiles.PICK_DATA");
                    sIntent = new Intent("com.sec.android.app.myfiles.PICK_DATA");
                } else {

                    intent = new Intent();
                    sIntent = new Intent();
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                }
//            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);

                // special intent for Samsung file manager

                // if you want any file type, you can skip next line
                sIntent.putExtra("CONTENT_TYPE", "*/*");
                sIntent.addCategory(Intent.CATEGORY_DEFAULT);

                Intent chooserIntent;
                if (getPackageManager().resolveActivity(sIntent, 0) != null) {
                    // it is device with Samsung file manager
                    chooserIntent = Intent.createChooser(sIntent, "فایل مورد نظر را انتخاب کنید");
                    chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{intent});
                } else {
                    chooserIntent = Intent.createChooser(intent, "فایل مورد نظر را انتخاب کنید");
                }

                try {
                    startActivityForResult(chooserIntent, 1);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "No suitable File Manager was found.", Toast.LENGTH_SHORT).show();
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
        aSwitch = findViewById(R.id.switch10);
        teacherswitchlayout = findViewById(R.id.teacherswitchlayout);


        if(settingsBll.getUserType()==0){
            teacherswitchlayout.setVisibility(View.VISIBLE);
        }else{
            teacherswitchlayout.setVisibility(View.GONE);
        }
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
            Intent intent = new Intent(SendCategoryActivity.this, ProfileActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(SendCategoryActivity.this, Main2Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn3.setOnClickListener(v -> {
            Intent intent = new Intent(SendCategoryActivity.this, Main3Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn4.setOnClickListener(v -> {
            Intent intent = new Intent(SendCategoryActivity.this, ListPostActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn5.setOnClickListener(v -> {
            Intent intent = new Intent(SendCategoryActivity.this, BookmarkListActivity.class);
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