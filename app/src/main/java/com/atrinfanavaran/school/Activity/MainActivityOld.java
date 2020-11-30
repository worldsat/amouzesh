package com.atrinfanavaran.school.Activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.atrinfanavaran.school.Domain.Setting;
import com.atrinfanavaran.school.Fragment.BoxIncomeListFragment;
import com.atrinfanavaran.school.Fragment.BoxListFragment;
import com.atrinfanavaran.school.Fragment.FirstFragment;
import com.atrinfanavaran.school.Fragment.MapFragment;
import com.atrinfanavaran.school.Fragment.NavigationDrawerFragment;
import com.atrinfanavaran.school.Fragment.RouteListFragment;

import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGetString;
import com.atrinfanavaran.school.R;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivityOld extends BaseActivity  {

    private static final int Time_Between_Two_Back = 2000;
    private long TimeBackPressed;
    private BottomNavigationView bottomNavigation;
    private FragmentManager fragmentManager;
    private Fragment fragment;
    private Toolbar my_toolbar;

    private ImageView imageView;
    private LinearLayout  filterIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_post);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);


//        getApplicationContext().deleteDatabase("RoomDb");
        RunPermissionDownload();
        initView();
        BottomNavigation();
        NavigationDrawer();
        getSetting();
//        setFilter();


    }

    private void setFilter() {
        filterIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    private void BottomNavigation() {

        bottomNavigation.setSelected(true);
        fragmentManager = getSupportFragmentManager();

        bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            switch (id) {
                case R.id.action_main:

                    fragment = new FirstFragment();
                    //off or on selected button color
                    bottomNavigation.getMenu().getItem(0).setCheckable(true);
                    bottomNavigation.getMenu().getItem(1).setCheckable(true);

                    break;
                case R.id.action_export:
//                    fragment = new AddBoxIncomeFragment1();
                    fragment = new BoxIncomeListFragment();
                    bottomNavigation.getMenu().getItem(0).setCheckable(true);
                    bottomNavigation.getMenu().getItem(1).setCheckable(true);

                    break;
                case R.id.action_add:
                    fragment = new BoxListFragment();

                    bottomNavigation.getMenu().getItem(0).setCheckable(true);
                    bottomNavigation.getMenu().getItem(1).setCheckable(true);
                    break;
                case R.id.action_address:
                    fragment = new MapFragment();

                    bottomNavigation.getMenu().getItem(0).setCheckable(true);
                    bottomNavigation.getMenu().getItem(1).setCheckable(true);
                    break;
                case R.id.action_addAdress:
                    fragment = new RouteListFragment();

                    bottomNavigation.getMenu().getItem(0).setCheckable(true);
                    bottomNavigation.getMenu().getItem(1).setCheckable(true);
                    break;
            }
            bottomNavigation.getMenu().getItem(0).setCheckable(true);
            bottomNavigation.getMenu().getItem(1).setCheckable(true);

            FragmentTransaction transaction = fragmentManager.beginTransaction();
//            transaction.replace(R.id.main_container, fragment, "mainPage").addToBackStack(null).commit();
            return true;
        });


        fragment = new FirstFragment();

        bottomNavigation.getMenu().getItem(0).setCheckable(false);
        bottomNavigation.getMenu().getItem(1).setCheckable(false);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.main_container, fragment, "mainPage").addToBackStack(null).commit();

        //end set default


        //set Icon size
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNavigation.getChildAt(0);
        for (int i = 0; i < menuView.getChildCount(); i++) {
            final View iconView = menuView.getChildAt(i).findViewById(R.id.icon);
            final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
            final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            // set your height here
            layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 23, displayMetrics);
            // set your width here
            layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 23, displayMetrics);
            iconView.setLayoutParams(layoutParams);

        }
    }


    private void initView() {
//        bottomNavigation = findViewById(R.id.bottomnav);
        my_toolbar = findViewById(R.id.toolbar);
        filterIcon = findViewById(R.id.filterButton);
    }

    private void NavigationDrawer() {

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
                    Toast.makeText(MainActivityOld.this, "به منظور خروج دوباره کلیک کنید", Toast.LENGTH_SHORT).show();
                }
                TimeBackPressed = System.currentTimeMillis();
            }
        } else {
            if (TimeBackPressed + Time_Between_Two_Back > System.currentTimeMillis()) {
                finishAffinity();
                return;
            } else {
                Toast.makeText(MainActivityOld.this, "به منظور خروج دوباره کلیک کنید", Toast.LENGTH_SHORT).show();
            }
            TimeBackPressed = System.currentTimeMillis();
        }
    }





    private void setFragment() {
        bottomNavigation.getMenu().getItem(0).setCheckable(true);
        bottomNavigation.getMenu().getItem(1).setCheckable(true);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.main_container, fragment, "subPage").addToBackStack(null).commit();

    }



    private void RunPermissionDownload() {

        Dexter.withActivity(getActivity())
                .withPermissions(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_NETWORK_STATE
                        , Manifest.permission.ACCESS_FINE_LOCATION
                        , Manifest.permission.ACCESS_COARSE_LOCATION

                )
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {

                        }

                        if (report.isAnyPermissionPermanentlyDenied()) {
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                })
                .onSameThread().check();

    }

    private void checkRunTimePermission() {
        String[] permissionArrays = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE
                , Manifest.permission.ACCESS_NETWORK_STATE
                , Manifest.permission.ACCESS_FINE_LOCATION
                , Manifest.permission.ACCESS_COARSE_LOCATION
        };

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissionArrays, 1);
        } else {

        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    checkRunTimePermission();
                }
                return;
            }
        }
    }

    private void getSetting() {

        controller().GetFromApi2("api/Setting", new CallbackGetString() {
            @Override
            public void onSuccess(String resultStr) {
                Gson gson = new Gson();

                try {
                    String str = new JSONObject(resultStr).getString("data");
                    Setting response = gson.fromJson(str, Setting.class);
                    if (response.getid() == null) return;

                    SettingsBll settingsBll = new SettingsBll(getActivity());
                    settingsBll.setLogoAddress(response.getlogoName());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String error) {

            }
        });

    }

}