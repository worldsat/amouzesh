package com.atrinfanavaran.school.Kernel.GenericFilter;



import com.atrinfanavaran.school.Kernel.Controller.Domain.FilteredDomain;

import java.util.HashMap;

public interface OnApplyFilterListener {
    void onApply(HashMap<Integer, FilteredDomain> domainInfos);
}
