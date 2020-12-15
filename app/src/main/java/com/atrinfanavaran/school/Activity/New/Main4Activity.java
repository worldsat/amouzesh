package com.atrinfanavaran.school.Activity.New;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.atrinfanavaran.school.Fragment.NavigationDrawerFragment;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.R;

public class Main4Activity extends BaseActivity {
    private static final int Time_Between_Two_Back = 2000;
    private long TimeBackPressed;
    private Toolbar my_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        bottomView();
        NavigationDrawer();
        setToolbar();
    }
    private void setToolbar() {
        TextView titleToolbar=findViewById(R.id.titleToolbar);
        titleToolbar.setText(settingsBll().getSchoolName());
    }
    private void NavigationDrawer() {
        my_toolbar = findViewById(R.id.toolbar);
        NavigationDrawerFragment my_nav = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        my_nav.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), my_toolbar);

    }
    @Override
    public void onBackPressed() {

        FragmentManager fm = getSupportFragmentManager();
        Fragment hm = getSupportFragmentManager().findFragmentByTag("subPage");

        if (hm != null) {
            if (hm.isVisible()) {
                if (fm.getBackStackEntryCount() > 1) {
                    fm.popBackStack();
                }
            } else {
                if (TimeBackPressed + Time_Between_Two_Back > System.currentTimeMillis()) {
                    finishAffinity();
                    return;
                } else {
                    Toast.makeText(Main4Activity.this, "به منظور خروج دوباره کلیک کنید", Toast.LENGTH_SHORT).show();
                }
                TimeBackPressed = System.currentTimeMillis();
            }
        } else {
            if (TimeBackPressed + Time_Between_Two_Back > System.currentTimeMillis()) {
                finishAffinity();
                return;
            } else {
                Toast.makeText(Main4Activity.this, "به منظور خروج دوباره کلیک کنید", Toast.LENGTH_SHORT).show();
            }
            TimeBackPressed = System.currentTimeMillis();
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

        view4.setVisibility(View.VISIBLE);

        btn1.setOnClickListener(v -> {
            Intent intent = new Intent(Main4Activity.this, Main1Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0,0); //0 for no animation
        });
        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(Main4Activity.this,Main2Activity.class );
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0,0); //0 for no animation
        });
        btn3.setOnClickListener(v -> {
            Intent intent = new Intent(Main4Activity.this, Main3Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0,0); //0 for no animation
        });
        btn4.setOnClickListener(v -> {
            Intent intent = new Intent(Main4Activity.this, ListPostActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0,0); //0 for no animation
        });
        btn5.setOnClickListener(v -> {
            Intent intent = new Intent(Main4Activity.this, Main5Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0,0); //0 for no animation
        });
    }
}