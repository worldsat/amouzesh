package com.atrinfanavaran.school.Kernel.Controller.Module.Glide;

import android.content.Context;

import com.atrinfanavaran.school.Kernel.Controller.Module.Glide.Interface.glide_interface;

public class Glide_module {

    public static glide_interface with(Context context) {

        return new glide(context);
    }
}
