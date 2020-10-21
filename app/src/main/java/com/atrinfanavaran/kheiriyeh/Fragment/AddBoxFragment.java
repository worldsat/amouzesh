package com.atrinfanavaran.kheiriyeh.Fragment;

import android.annotation.SuppressLint;
import androidx.room.Room;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.alirezaafkar.sundatepicker.DatePicker;
import com.alirezaafkar.sundatepicker.components.DateItem;
import com.atrinfanavaran.kheiriyeh.Domain.Box;
import com.atrinfanavaran.kheiriyeh.Interface.onCallBackAddBox;
import com.atrinfanavaran.kheiriyeh.Kernel.Helper.SearchableField;
import com.atrinfanavaran.kheiriyeh.R;
import com.atrinfanavaran.kheiriyeh.Room.AppDatabase;
import com.atrinfanavaran.kheiriyeh.Room.Domian.BoxR;
import com.atrinfanavaran.kheiriyeh.Room.Domian.RouteR;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class AddBoxFragment extends Fragment {

    private Button btn1Save;
    private onCallBackAddBox onCallBack;
    private EditText edt1_1, edt1_2, edt1_3, edt1_5, edt1_6;
    private Box box;
    private boolean editable = false;
    private SearchableSpinner spinner;
    private ImageView calendarBtn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            box = (Box) bundle.get("Box");
            editable = (boolean) bundle.get("editable");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_add_box, container, false);

        return rootView;


    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);

        AppDatabase db = Room.databaseBuilder(getActivity(),
                AppDatabase.class, "RoomDb")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
        List<RouteR> Routes = db.RouteDao().getAll();
        List<String> Routes2 = new ArrayList<>();
        List<Integer> RoutesId = new ArrayList<>();
        Routes2.add("انتخاب کنید");
        for (int i = 0; i < Routes.size(); i++) {
            Routes2.add(Routes.get(i).code + ":" + Routes.get(i).address);
            RoutesId.add(Routes.get(i).id);
        }


        SearchableField.setSpinner(spinner, Routes2);

        if (box != null) {
            edt1_1.setText(box.getFullName());
            edt1_2.setText(box.getNumber());
            edt1_3.setText(box.getMobile());
            edt1_6.setText(box.getAddress());
            edt1_5.setText(box.getassignmentDate());

        }
        if (box != null && box.getDischargeRouteId() != null) {
            try {
                for (int i = 0; i < RoutesId.size(); i++) {
                    if (RoutesId.get(i).equals(Integer.valueOf(box.getDischargeRouteId()))) {
                        spinner.setSelection(i + 1);
                        break;
                    }
                }
            } catch (Exception e) {
                Toast.makeText(getActivity(), "خطا در بازخانی کد مسیر", Toast.LENGTH_SHORT).show();
            }
        }

        btn1Save.setOnClickListener(v -> {
            BoxR box = new BoxR();
            box.fullName = edt1_1.getText().toString().trim();
            box.number = edt1_2.getText().toString().trim();
            box.mobile = edt1_3.getText().toString().trim();
            String[] code = spinner.getSelectedItem().toString().split(":");
            box.code = code[0];
            String str = "";
            for (int i = 0; i < Routes.size(); i++) {
                if (Routes.get(i).code.equals(code[0])) {
                    str = String.valueOf(RoutesId.get(i ));
                }
            }

            box.dischargeRouteId = str;

            box.assignmentDate = edt1_5.getText().toString().trim();
            box.address = edt1_6.getText().toString().trim();
            if (editable) {
                box.id = this.box.getBoxId();
                box.boxId = this.box.getBoxId();
            } else {
                box.isNew = "true";
            }
            onCallBack.SaveBox(box, editable);
        });


        calendarBtn.setOnClickListener(v -> {
            DatePicker.Builder builder = new DatePicker
                    .Builder()
                    .theme(R.style.DialogTheme)
                    .future(true);
            Date mDate = new Date();
            builder.date(mDate.getDay(), mDate.getMonth(), mDate.getYear());
            builder.build((id, calendar, day, month, year) -> {
                DateFormat df = new SimpleDateFormat("hh:mm:ss a", Locale.US);
                java.util.Date d = new java.util.Date();
                String dt = df.format(d);

                mDate.setDate(day, month, year);
                edt1_5.setText(year + "-" + month + "-" + day+" "+dt);

            }).show(getActivity().getSupportFragmentManager(), "");

        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //getActivity() is fully created in onActivityCreated and instanceOf differentiate it between different Activities
        if (getActivity() instanceof onCallBackAddBox)
            onCallBack = (onCallBackAddBox) getActivity();
    }

    private void initView(View view) {

        btn1Save = view.findViewById(R.id.btn_1);
        edt1_1 = view.findViewById(R.id.edt1_1);
        edt1_2 = view.findViewById(R.id.edt1_2);
        edt1_3 = view.findViewById(R.id.edt1_3);
        edt1_5 = view.findViewById(R.id.edt1_5);
        edt1_6 = view.findViewById(R.id.edt1_6);
        spinner = view.findViewById(R.id.spinner);
        calendarBtn = view.findViewById(R.id.calendar);
    }

    class Date extends DateItem {
        String getDate() {
            Calendar calendar = getCalendar();
            return String.format(Locale.US,
                    "%d/%d/%d",
                    getYear(), getMonth(), getDay(),
                    calendar.get(Calendar.YEAR),
                    +calendar.get(Calendar.MONTH) + 1,
                    +calendar.get(Calendar.DAY_OF_MONTH));
        }
    }
}
