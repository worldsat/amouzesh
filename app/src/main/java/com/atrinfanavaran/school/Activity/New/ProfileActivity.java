package com.atrinfanavaran.school.Activity.New;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import com.atrinfanavaran.school.Domain.New.UserGetStudentById;
import com.atrinfanavaran.school.Domain.New.UserGetTeacherById;
import com.atrinfanavaran.school.Fragment.NavigationDrawerFragment;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGetString;
import com.atrinfanavaran.school.R;

public class ProfileActivity extends BaseActivity {


    private ProgressBar progressBar;

    private Toolbar my_toolbar;
    private TextView titleTxt;
    private String TeacherUserId;
    private SettingsBll settingsBll;
    private TextView reshteTitle, maghtaTitle, fatherTitle,reshteTitle2,reshteTitle1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        settingsBll = new SettingsBll(this);

        initView();
        getBundle();

        setVariable();
        bottomView();
        NavigationDrawer();
        setToolbar();

        if(settingsBll.getUserType()==0 || settingsBll.getUserType()==1){
            getDataPostTeacher();
        }else{
            getDataPostStudent();
        }
    }

    private void getBundle() {
//        TeacherUserId = getIntent().getStringExtra("TeacherUserId");


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

    private void getDataPostStudent() {

//        progressBar.setVisibility(View.VISIBLE);

        String address = "";

        reshteTitle.setTextColor(getResources().getColor(R.color.blue_2));



        address = "api/User/GetStudentById?Id=" + settingsBll().getApplicationUserId();
        fatherTitle.setVisibility(View.GONE);

        controller().GetFromApi2(address, new CallbackGetString() {
            @Override
            public void onSuccess(String resultStr) {
                try {
                    UserGetStudentById object = gson().fromJson(resultStr, UserGetStudentById.class);
                    titleTxt.setText(object.getData().getFullName());
                    reshteTitle.setText(object.getData().getMajor().getName());
                    maghtaTitle.setText(object.getData().getGrade().getName());


                } catch (Exception e) {
                    Log.i(TAG, "onSuccessException: " + e);

                }
//                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError(String error) {
                Toast.makeText(ProfileActivity.this, error, Toast.LENGTH_SHORT).show();
//                progressBar.setVisibility(View.GONE);
            }
        });
    }
    private void getDataPostTeacher() {

//        progressBar.setVisibility(View.VISIBLE);

        String address = "";

        reshteTitle.setTextColor(getResources().getColor(R.color.blue_2));
        reshteTitle1.setText("شماره همراه:");
        reshteTitle2.setVisibility(View.GONE);
        maghtaTitle.setVisibility(View.GONE);


        address = "api/User/GetTeacherById?Id=" + settingsBll().getApplicationUserId();
        fatherTitle.setVisibility(View.GONE);

        controller().GetFromApi2(address, new CallbackGetString() {
            @Override
            public void onSuccess(String resultStr) {
                try {
                    UserGetTeacherById object = gson().fromJson(resultStr, UserGetTeacherById.class);
                    titleTxt.setText(object.getData().getFullName());
                    reshteTitle.setText(""+object.getData().getMobile());



                } catch (Exception e) {
                    Log.i(TAG, "onSuccessException: " + e);

                }
//                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError(String error) {
                Toast.makeText(ProfileActivity.this, error, Toast.LENGTH_SHORT).show();
//                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void setVariable() {


    }

    private void initView() {


        progressBar = findViewById(R.id.progressBarRow);

        my_toolbar = findViewById(R.id.toolbar);
        titleTxt = findViewById(R.id.titleTxt);
        reshteTitle2 = findViewById(R.id.t4);
        reshteTitle1 = findViewById(R.id.t);
        reshteTitle = findViewById(R.id.t1);
        maghtaTitle = findViewById(R.id.t2);
        fatherTitle = findViewById(R.id.fatherTxt);

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

        view1.setVisibility(View.VISIBLE);

        btn1.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, ProfileActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, Main2Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn3.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, Main3Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn4.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, ListPostActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn5.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, BookmarkListActivity.class);
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