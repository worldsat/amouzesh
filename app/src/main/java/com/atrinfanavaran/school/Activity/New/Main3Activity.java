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

import com.atrinfanavaran.school.Domain.New.BannerGetAll;
import com.atrinfanavaran.school.Fragment.NavigationDrawerFragment;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGetString;
import com.atrinfanavaran.school.R;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

public class Main3Activity extends BaseActivity {
    private static final int Time_Between_Two_Back = 2000;
    private long TimeBackPressed;
    private Toolbar my_toolbar;
    private SliderLayout banner1, banner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        bottomView();
        NavigationDrawer();
        initView();
        setToolbar();
        setBanner();
    }

    private void setBanner() {
        banner1.stopAutoCycle();
        banner2.stopAutoCycle();
        controller().GetFromApi2("api/Banner/GetAll?Id=" + settingsBll().getApplicationUserId(), new CallbackGetString() {
            @Override
            public void onSuccess(String resultStr) {
                BannerGetAll result = gson().fromJson(resultStr, BannerGetAll.class);

                if (result.getData().size() > 0) {
                    int n = 0;
                    int z = 0;
                    for (int i = 0; i < result.getData().size(); i++) {
                        if (result.getData().get(i).isShowOnMainPage()) {

                            if (result.getData().get(i).getBannerPlace() == 0) {
                                n++;
                                banner1.setVisibility(View.VISIBLE);

                                DefaultSliderView DefaultSliderView = new DefaultSliderView(getActivity());
                                DefaultSliderView
                                        .setOnSliderClickListener(slider -> {
                                            Intent i1 = new Intent(Intent.ACTION_VIEW);
//                                                i1.setData(Uri.parse(Url));
                                            startActivity(i1);
                                        })
                                        .image(settingsBll().getUrlAddress() + "/" + result.getData().get(i).getUrl())
                                        .setScaleType(BaseSliderView.ScaleType.Fit);

                                banner1.addSlider(DefaultSliderView);

                                if (n < 2) {
                                    banner1.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);
                                    banner1.stopAutoCycle();
                                } else {
                                    banner1.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Visible);
                                    banner1.startAutoCycle();

                                }
                                banner1.setDuration(6000);
                            } else if (result.getData().get(i).getBannerPlace() == 1) {
                                z++;
                                banner2.setVisibility(View.VISIBLE);

                                DefaultSliderView DefaultSliderView = new DefaultSliderView(getActivity());
                                DefaultSliderView
                                        .setOnSliderClickListener(slider -> {
                                            Intent i1 = new Intent(Intent.ACTION_VIEW);
//                                                i1.setData(Uri.parse(Url));
                                            startActivity(i1);
                                        })
                                        .image(settingsBll().getUrlAddress() + "/" + result.getData().get(i).getUrl())
                                        .setScaleType(BaseSliderView.ScaleType.Fit);

                                banner2.addSlider(DefaultSliderView);

                                if (z < 2) {
                                    banner2.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);
                                    banner2.stopAutoCycle();
                                } else {
                                    banner2.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Visible);
                                    banner2.startAutoCycle();
                                }
                                banner2.setDuration(5000);

                            }
                        }

                    }
                }

            }

            @Override
            public void onError(String error) {

            }
        });
    }

    private void setToolbar() {
        TextView titleToolbar = findViewById(R.id.titleToolbar);
        titleToolbar.setText(settingsBll().getSchoolName());
    }

    private void NavigationDrawer() {
        my_toolbar = findViewById(R.id.toolbar);
        NavigationDrawerFragment my_nav = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        my_nav.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), my_toolbar);

    }

    private void initView() {
        banner1 = findViewById(R.id.banner1);
        banner2 = findViewById(R.id.banner2);
        LinearLayout btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, ListPostActivity.class);
                intent.putExtra("", "");
                startActivity(intent);
            }
        });
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
                    Toast.makeText(Main3Activity.this, "به منظور خروج دوباره کلیک کنید", Toast.LENGTH_SHORT).show();
                }
                TimeBackPressed = System.currentTimeMillis();
            }
        } else {
            if (TimeBackPressed + Time_Between_Two_Back > System.currentTimeMillis()) {
                finishAffinity();
                return;
            } else {
                Toast.makeText(Main3Activity.this, "به منظور خروج دوباره کلیک کنید", Toast.LENGTH_SHORT).show();
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

        view3.setVisibility(View.VISIBLE);

        btn1.setOnClickListener(v -> {
            Intent intent = new Intent(Main3Activity.this, Main1Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn3.setOnClickListener(v -> {
            Intent intent = new Intent(Main3Activity.this, Main3Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn4.setOnClickListener(v -> {
            Intent intent = new Intent(Main3Activity.this, ListPostActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn5.setOnClickListener(v -> {
            Intent intent = new Intent(Main3Activity.this, Main5Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
    }
}