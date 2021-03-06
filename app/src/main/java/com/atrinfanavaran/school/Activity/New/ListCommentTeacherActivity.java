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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atrinfanavaran.school.Adapter.New.CommentTeacherListAdapter;
import com.atrinfanavaran.school.Domain.New.CommentsGetAll;
import com.atrinfanavaran.school.Fragment.NavigationDrawerFragment;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGetString;
import com.atrinfanavaran.school.R;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class ListCommentTeacherActivity extends BaseActivity {
    private RecyclerView recyclerViewlistPost;
    private RecyclerView.Adapter adapter;
    private FloatingActionButton floatingActionButton1;
    private FloatingActionMenu floatingActionMenu;
    private ProgressBar progressBar;
    private TextView warningTxt;
    private Toolbar my_toolbar;
    private TextView titleTxt;
    private LinearLayout backBtn, newCommentBtn;
    private String EducationPostId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_comment);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        initView();
        getBundle();
        setVariable();
        getData();
        bottomView();
        NavigationDrawer();
        setToolbar();
    }

    private void getBundle() {
        EducationPostId = String.valueOf(getIntent().getIntExtra("EducationPostId",0));
//        EducationPostId ="1032";
    }

    private void setToolbar() {
        TextView titleToolbar = findViewById(R.id.titleToolbar);
        titleToolbar.setText(settingsBll().getSchoolName());
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
        String address = "Api/Comments/GetAll?UserId="+settingsBll.getApplicationUserId()+"&Id=" + EducationPostId;

        controller().GetFromApi2(address, new CallbackGetString() {
            @Override
            public void onSuccess(String resultStr) {
                try {
                    CommentsGetAll commentsGetAll = gson().fromJson(resultStr, CommentsGetAll.class);

                    if (commentsGetAll.getData().size() > 0) {
                        warningTxt.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        recyclerViewlistPost.setVisibility(View.VISIBLE);

                        adapter = new CommentTeacherListAdapter(commentsGetAll.getData());
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
                Toast.makeText(ListCommentTeacherActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setVariable() {
//        titleTxt.setText("کلیه پست ها");
        recyclerViewlistPost.setLayoutManager(new LinearLayoutManager(this));
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        newCommentBtn.setVisibility(View.GONE);
        newCommentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (settingsBll.getUserType() == 2) {
                    Intent i = new Intent(getActivity(), SendCommentActivity.class);
                    i.putExtra("EducationPostId", EducationPostId);
//                getActivity().startActivityForResult(i, 0);
                    startActivity(i);
                }else{
                    Toast.makeText(ListCommentTeacherActivity.this, "شما دسترسی لازم را ندارید", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void initView() {
        recyclerViewlistPost = findViewById(R.id.viewAttach);
//        floatingActionButton1 = findViewById(R.id.material_design_floating_action_menu_item1);
        progressBar = findViewById(R.id.progressBarRow4);
        warningTxt = findViewById(R.id.warninTxt);
        my_toolbar = findViewById(R.id.toolbar);
        titleTxt = findViewById(R.id.titleTxt);
        backBtn = findViewById(R.id.backBtn);
        newCommentBtn = findViewById(R.id.sendBtn);
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
            Intent intent = new Intent(ListCommentTeacherActivity.this, ProfileActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(ListCommentTeacherActivity.this, Main2Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn3.setOnClickListener(v -> {
            Intent intent = new Intent(ListCommentTeacherActivity.this, Main3Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn4.setOnClickListener(v -> {
            Intent intent = new Intent(ListCommentTeacherActivity.this, ListPostActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn5.setOnClickListener(v -> {
            Intent intent = new Intent(ListCommentTeacherActivity.this,BookmarkListActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        ConstraintLayout postLayout = findViewById(R.id.postlayout);
        if (settingsBll.getUserType() != 0 && settingsBll.getUserType() != 1) {
            postLayout.setVisibility(View.GONE);
        }
    }
}