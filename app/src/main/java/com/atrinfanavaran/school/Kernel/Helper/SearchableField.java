package com.atrinfanavaran.school.Kernel.Helper;


import android.widget.ArrayAdapter;

import com.atrinfanavaran.school.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.Collection;
import java.util.List;

public class SearchableField {
    public static <T> void setSpinner(SearchableSpinner spinner,  List<String> data) {
        spinner.setTitle("لطفا آیتم مورد نظر را انتخاب کنید");
        spinner.setPositiveButton("لغو");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(spinner.getContext(), R.layout.spinner_item_blue, data);
        spinner.setAdapter(adapter);
    }
    public static <T> void setSpinnerRed(SearchableSpinner spinner, Collection<T> data) {
        spinner.setTitle("لطفا آیتم مورد نظر را انتخاب کنید");
        spinner.setPositiveButton("لغو");
        ArrayAdapter<T> adapter = new ArrayAdapter<>(spinner.getContext(),
                R.layout.spinner_item_red,
                (List<T>) data);
        spinner.setAdapter(adapter);
    }
}
