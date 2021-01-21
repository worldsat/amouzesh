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
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atrinfanavaran.school.Adapter.New.BannerListAdapter;
import com.atrinfanavaran.school.Adapter.New.PostListAsatidAdapter;
import com.atrinfanavaran.school.Domain.New.BannerGetAll;
import com.atrinfanavaran.school.Domain.New.GetRelatedEducationPost;
import com.atrinfanavaran.school.Fragment.NavigationDrawerFragment;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGetString;
import com.atrinfanavaran.school.R;

public class ListPostAsatidActivity extends BaseActivity {
    private RecyclerView recyclerViewlistPost;
    private RecyclerView.Adapter adapter;

    private ProgressBar progressBar;
    private TextView warningTxt;
    private Toolbar my_toolbar;
    private TextView titleTxt;
    private String TeacherUserId;
    private String TeacherUserName;
    private SettingsBll settingsBll;
    private TextView postTitle, bannerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asatid_list_category2);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        settingsBll = new SettingsBll(this);

        initView();
        getBundle();
        getDataPost();
        setVariable();
        bottomView();
        NavigationDrawer();
        setToolbar();
    }

    private void getBundle() {
        TeacherUserId = getIntent().getStringExtra("TeacherUserId");
        TeacherUserName = getIntent().getStringExtra("TeacherUserName");
        titleTxt.setText(TeacherUserName);
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

    private void getDataPost() {

        progressBar.setVisibility(View.VISIBLE);
        recyclerViewlistPost.setVisibility(View.GONE);
        warningTxt.setVisibility(View.GONE);
        warningTxt.setText(R.string.noData);
        String address = "";

        postTitle.setTextColor(getResources().getColor(R.color.blue_2));
        bannerTitle.setTextColor(getResources().getColor(R.color.grey_500));


        address = "api/User/GetRelatedEducationPost?UserId=" + TeacherUserId + "&StudentId=" + settingsBll().getApplicationUserId();


        controller().GetFromApi2(address, new CallbackGetString() {
            @Override
            public void onSuccess(String resultStr) {
                try {
                    GetRelatedEducationPost getRelatedEducationPost = gson().fromJson(resultStr, GetRelatedEducationPost.class);

                    if (getRelatedEducationPost.getData().size() > 0) {
                        warningTxt.setVisibility(View.GONE);
                        recyclerViewlistPost.setVisibility(View.VISIBLE);
                        adapter = new PostListAsatidAdapter(getRelatedEducationPost.getData());
                        recyclerViewlistPost.setAdapter(adapter);
                    } else {
                        warningTxt.setVisibility(View.VISIBLE);
                        recyclerViewlistPost.setVisibility(View.GONE);
                    }
                } catch (Exception e) {
                    Log.i(TAG, "onSuccessException: " + e);

                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError(String error) {
                Toast.makeText(ListPostAsatidActivity.this, error, Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void getDataBanner() {

        progressBar.setVisibility(View.VISIBLE);
        recyclerViewlistPost.setVisibility(View.GONE);
        warningTxt.setVisibility(View.GONE);
        warningTxt.setText(R.string.noData);
        String address = "";

        postTitle.setTextColor(getResources().getColor(R.color.grey_500));
        bannerTitle.setTextColor(getResources().getColor(R.color.blue_2));
        address = "api/Banner/GetAll?Id=" + settingsBll().getApplicationUserId();


        controller().GetFromApi2(address, new CallbackGetString() {
            @Override
            public void onSuccess(String resultStr) {
                try {
                    BannerGetAll bannerGetAll = gson().fromJson(resultStr, BannerGetAll.class);

                    if (bannerGetAll.getData().size() > 0) {
                        warningTxt.setVisibility(View.GONE);
                        recyclerViewlistPost.setVisibility(View.VISIBLE);
                        adapter = new BannerListAdapter(bannerGetAll.getData());
                        recyclerViewlistPost.setAdapter(adapter);
                    } else {
                        warningTxt.setVisibility(View.VISIBLE);
                        recyclerViewlistPost.setVisibility(View.GONE);
                    }
                } catch (Exception e) {
                    Log.i(TAG, "onSuccessException: " + e);

                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError(String error) {
                Toast.makeText(ListPostAsatidActivity.this, error, Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void setVariable() {
        recyclerViewlistPost.setLayoutManager(new LinearLayoutManager(this));

        bannerTitle.setOnClickListener(v -> getDataBanner());
        postTitle.setOnClickListener(v -> getDataPost());
    }

    private void initView() {
        recyclerViewlistPost = findViewById(R.id.View);

        progressBar = findViewById(R.id.progressBarRow);
        warningTxt = findViewById(R.id.warninTxt1);
        my_toolbar = findViewById(R.id.toolbar);
        titleTxt = findViewById(R.id.titleTxt);
        postTitle = findViewById(R.id.t1);
        bannerTitle = findViewById(R.id.t2);

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
            Intent intent = new Intent(ListPostAsatidActivity.this, Main1Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(ListPostAsatidActivity.this, Main2Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn3.setOnClickListener(v -> {
            Intent intent = new Intent(ListPostAsatidActivity.this, Main3Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn4.setOnClickListener(v -> {
            Intent intent = new Intent(ListPostAsatidActivity.this, ListPostAsatidActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn5.setOnClickListener(v -> {
            Intent intent = new Intent(ListPostAsatidActivity.this, Main5Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
    }
}