package com.atrinfanavaran.school.Activity;


import androidx.multidex.MultiDexApplication;

public class App extends MultiDexApplication {


    @Override
    public void onCreate() {
        super.onCreate();

        String font = "fonts/iransans_m.ttf";
//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                .setDefaultFontPath(font)
//                .setFontAttrId(R.attr.fontPath)
//                .build()
//        );
//        Stetho.initializeWithDefaults(this);


    }

}
