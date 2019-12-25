package com.atrinfanavaran.kheiriyeh.Fragment;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atrinfanavaran.kheiriyeh.Adapter.BoxIncomeListAdapter;
import com.atrinfanavaran.kheiriyeh.Interface.onCallBackBoxIncomeEdit;
import com.atrinfanavaran.kheiriyeh.Interface.onCallBackNewDischarge;
import com.atrinfanavaran.kheiriyeh.R;
import com.atrinfanavaran.kheiriyeh.Room.AppDatabase;
import com.atrinfanavaran.kheiriyeh.Room.Domian.BoxIncomeR;

import java.util.List;
import java.util.Objects;


public class BoxIncomeListFragment extends Fragment {

    private RecyclerView recyclerView;
    private AppDatabase db;
    private RecyclerView.Adapter adapter;
    private onCallBackNewDischarge onCallBackNewDischarge;
    private onCallBackBoxIncomeEdit onCallBackBoxIncomeEdit;
    private FloatingActionButton floatingActionButton1;
    private TextView titleToolbar;
    private TextView emptyText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_boxincome_list, container, false);

        return rootView;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        titleToolbar.setText("تخلیه صندوق");
        db = Room.databaseBuilder(getActivity(),
                AppDatabase.class, "RoomDb")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        List<BoxIncomeR> list = db.BoxIncomeDao().getAll();
        if (list.size() == 0) {
            emptyText.setVisibility(View.VISIBLE);
        }
        adapter = new BoxIncomeListAdapter(list, new onCallBackBoxIncomeEdit() {
            @Override
            public void EditBoxIncome(BoxIncomeR boxIncome) {
                onCallBackBoxIncomeEdit.EditBoxIncome(boxIncome);
            }

        });
        recyclerView.setAdapter(adapter);

        floatingActionButton1.setOnClickListener(v ->

        {
            onCallBackNewDischarge.btnNewDischarge();

        });


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //getActivity() is fully created in onActivityCreated and instanceOf differentiate it between different Activities
        if (getActivity() instanceof onCallBackNewDischarge)
            onCallBackNewDischarge = (onCallBackNewDischarge) getActivity();
        if (getActivity() instanceof onCallBackBoxIncomeEdit)
            onCallBackBoxIncomeEdit = (onCallBackBoxIncomeEdit) getActivity();
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.view);
        floatingActionButton1 = view.findViewById(R.id.floatingActionButton);
        titleToolbar = Objects.requireNonNull(getActivity()).findViewById(R.id.titleToolbar);
        emptyText = view.findViewById(R.id.EmptyWarning);
    }
}
