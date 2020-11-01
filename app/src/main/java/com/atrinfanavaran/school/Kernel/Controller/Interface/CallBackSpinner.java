package com.atrinfanavaran.school.Kernel.Controller.Interface;


import com.atrinfanavaran.school.Kernel.Controller.Domain.SpinnerDomain;

import java.util.ArrayList;

public interface CallBackSpinner {
    void onSuccess(ArrayList<SpinnerDomain> result);

    void onError(String error);
}
