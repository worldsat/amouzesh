package com.atrinfanavaran.school.Activity.New;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atrinfanavaran.school.Adapter.New.EducationPostListAdapter;
import com.atrinfanavaran.school.Domain.New.EducationPostGetAll;
import com.atrinfanavaran.school.Fragment.NavigationDrawerFragment;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGetString;
import com.atrinfanavaran.school.R;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class ListPostActivity extends BaseActivity {
    private RecyclerView recyclerViewlistPost;
    private RecyclerView.Adapter adapter;
    private FloatingActionButton floatingActionButton1;
    private FloatingActionMenu floatingActionMenu;
    private ProgressBar progressBar;
    private TextView warningTxt;
    private Toolbar my_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_post2);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        initView();
        setVariable();
        getData();
        bottomView();
        NavigationDrawer();
    }

    private void NavigationDrawer() {

        NavigationDrawerFragment my_nav = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        my_nav.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), my_toolbar);

    }

    private void getData() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerViewlistPost.setVisibility(View.GONE);
        warningTxt.setVisibility(View.GONE);

        controller().GetFromApi2("api/EducationPost/GetAll?Id=1", new CallbackGetString() {
            @Override
            public void onSuccess(String resultStr) {
                try {
                    EducationPostGetAll educationPostGetAll = gson().fromJson(resultStr, EducationPostGetAll.class);

                    if (educationPostGetAll.getData().size() > 0) {
                        warningTxt.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        recyclerViewlistPost.setVisibility(View.VISIBLE);

                        adapter = new EducationPostListAdapter(educationPostGetAll.getData());
                        recyclerViewlistPost.setAdapter(adapter);
                    } else {
                        warningTxt.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                        recyclerViewlistPost.setVisibility(View.GONE);
                    }
                } catch (Exception e) {
                    Log.i(TAG, "onSuccessException: " + e);
                }
            }

            @Override
            public void onError(String error) {
                Toast.makeText(ListPostActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setVariable() {
        recyclerViewlistPost.setLayoutManager(new LinearLayoutManager(this));

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListPostActivity.this, SendPostActivity.class));
            }
        });
    }

    private void initView() {
        recyclerViewlistPost = findViewById(R.id.View);
        floatingActionButton1 = findViewById(R.id.material_design_floating_action_menu_item1);
        progressBar = findViewById(R.id.progressBarRow);
        warningTxt = findViewById(R.id.warninTxt1);
        my_toolbar = findViewById(R.id.toolbar);
    }

    private void bottomView() {
        LinearLayout btn1 = findViewById(R.id.btn1);
        LinearLayout btn2 = findViewById(R.id.btn2);
        LinearLayout btn3 = findViewById(R.id.btn3);
        LinearLayout btn4 = findViewById(R.id.btn4);
        LinearLayout btn5 = findViewById(R.id.btn5);
        View view1 = findViewById(R.id.view1);
        View view2 = findViewById(R.id.view2);
        View view3 = findViewById(R.id.view3);
        View view4 = findViewById(R.id.view4);
        View view5 = findViewById(R.id.view5);

        view4.setVisibility(View.VISIBLE);

        btn1.setOnClickListener(v -> {
            Intent intent = new Intent(ListPostActivity.this, Main1Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(ListPostActivity.this, Main2Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn3.setOnClickListener(v -> {
            Intent intent = new Intent(ListPostActivity.this, Main3Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn4.setOnClickListener(v -> {
            Intent intent = new Intent(ListPostActivity.this, ListPostActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn5.setOnClickListener(v -> {
            Intent intent = new Intent(ListPostActivity.this, Main5Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
    }
}