package com.atrinfanavaran.school.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.atrinfanavaran.school.Activity.New.LoginActivity;
import com.atrinfanavaran.school.Activity.New.SendPostActivity;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.R;
import com.bumptech.glide.Glide;

public class SplashActivity extends BaseActivity {
    private Handler mHandler = new Handler();
    ProgressBar mProgressBar;
    CountDownTimer mCountDownTimer;
    int i = 0;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        initView();
        setVariable();
        setLogo();
//        timer();
    }

    private void setLogo() {

        SettingsBll settingsBll = new SettingsBll(getActivity());
        imageView = findViewById(R.id.logo3);
        Glide.with(getActivity())
                .load(settingsBll.getUrlAddress() + "/" + settingsBll.getLogoAddress())
                .into(imageView);

    }

    private void timer() {

        new Thread(() -> {

            try {

                mHandler.post(() -> {
                    final Handler handler = new Handler();

                    handler.postDelayed(() -> {

//                        SharedPreferences sp = getApplicationContext().getSharedPreferences("Settings", 0);
//                        if (sp != null) {
//                            if (sp.getString("Token", "null").equals("null")) {
//
//                                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
//                                startActivity(intent);
//                            } else {
//                                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                                startActivity(intent);
//                            }
//                        } else {
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(intent);
//                        }
                    }, 2000);
//
                });
                runOnUiThread(() -> {

                });
            } catch (Exception ignored) {

            }
        }).start();

    }

    private void setVariable() {
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
        mProgressBar.setProgress(i);
        mCountDownTimer = new CountDownTimer(2000, 10) {

            @Override
            public void onTick(long millisUntilFinished) {
                Log.v("Log_tag", "Tick of Progress" + i + millisUntilFinished);
                i++;
                mProgressBar.setProgress((int) i * 100 / (3000 / 10));

            }

            @Override
            public void onFinish() {
                //Do what you want
                i++;
                mProgressBar.setProgress(100);

                SettingsBll settingsBll = new SettingsBll(SplashActivity.this);
                SharedPreferences sp = getApplicationContext().getSharedPreferences("Settings", 0);
                if (sp != null) {
                    if (settingsBll.getLoging()) {
                        startActivity(new Intent(SplashActivity.this, SendPostActivity.class));
                    } else {
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                }

            }
        };
        mCountDownTimer.start();
//        ObjectAnimator animation = ObjectAnimator.ofInt(mProgressBar, "progress", 0, 100);
//        animation.setDuration(5000);
//        animation.setInterpolator(new DecelerateInterpolator());
//        animation.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animator) { }
//
//            @Override
//            public void onAnimationEnd(Animator animator) {
//                //do something when the countdown is complete
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animator) { }
//
//            @Override
//            public void onAnimationRepeat(Animator animator) { }
//        });
//        animation.start();
    }

    private void initView() {

    }

}
