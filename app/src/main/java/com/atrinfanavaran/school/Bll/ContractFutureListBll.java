package com.atrinfanavaran.school.Bll;

import android.content.Context;


import com.atrinfanavaran.school.Kernel.Controller.Controller;
import com.atrinfanavaran.school.Kernel.Controller.Domain.Filter;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGet;

import java.util.ArrayList;

public class ContractFutureListBll {

    private final Context context;


    public ContractFutureListBll(Context context) {
        this.context = context;
    }

    public void Get(ArrayList<Filter> filter, int take, int skip, boolean allData, CallbackGet callbackGet) {
        Controller controller = new Controller(context);
        controller.Get(String.class, filter, take, skip, allData, callbackGet);
    }
}