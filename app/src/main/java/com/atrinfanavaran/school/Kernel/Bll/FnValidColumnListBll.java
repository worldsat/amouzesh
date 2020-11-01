package com.atrinfanavaran.school.Kernel.Bll;

import android.content.Context;

import com.atrinfanavaran.school.Kernel.Controller.Controller;
import com.atrinfanavaran.school.Kernel.Controller.Domain.Filter;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGet;
import com.atrinfanavaran.school.Kernel.Domain.FnValidColumnList;

import java.util.ArrayList;

public class FnValidColumnListBll {

    private final Context context;


    public FnValidColumnListBll(Context context) {
        this.context = context;
    }

    public void Get(ArrayList<Filter> filter, int take, int skip, boolean allData, CallbackGet callbackGet) {
        Controller controller = new Controller(context);
        controller.Get(FnValidColumnList.class, filter, take, skip, allData, callbackGet);
    }
}