package com.atrinfanavaran.school.Activity.New;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.atrinfanavaran.school.Adapter.New.PostMiniListAdapter;
import com.atrinfanavaran.school.Adapter.New.TeacherNameListSelectedAdapter;
import com.atrinfanavaran.school.Adapter.New.TeacherNameListUnSelectedAdapter;
import com.atrinfanavaran.school.Domain.New.CustomGroup;
import com.atrinfanavaran.school.Domain.New.CustomGroupGetById;
import com.atrinfanavaran.school.Domain.New.GetRelatedTeachersFromCustomGroup;
import com.atrinfanavaran.school.Domain.New.ManageDomain;
import com.atrinfanavaran.school.Fragment.NavigationDrawerFragment;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGetString;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackOperation;
import com.atrinfanavaran.school.Kernel.Helper.Waiting;
import com.atrinfanavaran.school.R;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ListTeacherNameActivity extends BaseActivity {
    private RecyclerView recyclerViewlistPost;
    private RecyclerView.Adapter adapter;

    private ProgressBar progressBar;
    private TextView warningTxt;
    private Toolbar my_toolbar;
    private TextView titleTxt;
    private EditText edtSearch;
    private ImageView searchIcon;

    private String Action;
    private CustomGroup.Data object;
    private LinearLayout SendBtn;
    private TextView titleBtn;
    private ArrayList<Integer> SelectedTeacherId = new ArrayList<>();
    private HashMap<String, Object> param = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        initView();
        getBundle();
        setVariable();

        bottomView();
        NavigationDrawer();
        setToolbar();
        action();
    }

    private void action() {
        if (Action.equals("Select")) {
            titleTxt.setText("اضافه کردن به لیست");
            titleBtn.setText("اضافه کردن");
            getDataUnSelect(false);
        } else if (Action.equals("UnSelect")) {
            titleTxt.setText("حذف کردن از لیست");
            titleBtn.setText("حذف کردن");
            getDataSelect(false);
        }
    }

    private void getBundle() {
        Action = getIntent().getStringExtra("Action");
        object = (CustomGroup.Data) getIntent().getSerializableExtra("object");
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

    private void getDataSelect(boolean search) {
        progressBar.setVisibility(View.VISIBLE);
        recyclerViewlistPost.setVisibility(View.GONE);
        warningTxt.setVisibility(View.GONE);
        String address = "api/CustomGroup/getById?Id=" + object.getId();
        if (search) {
            address = "api/CustomGroup/Search?txtSearch=" + edtSearch.getText().toString().trim() + "&UserId=" + settingsBll().getApplicationUserId();
        }
        controller().GetFromApi2(address, new CallbackGetString() {
            @Override
            public void onSuccess(String resultStr) {
                try {
                    CustomGroupGetById list = gson().fromJson(resultStr, CustomGroupGetById.class);

                    if (list.getData().getUsersToCustomGroups().size() > 0) {
                        warningTxt.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        recyclerViewlistPost.setVisibility(View.VISIBLE);

                        adapter = new TeacherNameListSelectedAdapter(list.getData().getUsersToCustomGroups(), new PostMiniListAdapter.SelectCallBack() {
                            @Override
                            public void Id(int num, boolean allSelect) {

                                if (SelectedTeacherId.contains(num)) {
                                    for (int i = 0; i < SelectedTeacherId.size(); i++) {
                                        if (SelectedTeacherId.get(i) == num) {
                                            SelectedTeacherId.remove(i);
                                            break;
                                        }
                                    }
                                } else {
                                    SelectedTeacherId.add(num);
                                }

                                Log.i(TAG, "TeacherSelectedId: " + SelectedTeacherId.toString().replace(" ", ""));
                                if (SelectedTeacherId.size() > 0) {
                                    param.put("TeacherId", SelectedTeacherId.toString().replace(" ", ""));
                                } else {
                                    if (param.get("TeacherId") != null) {
                                        param.remove("TeacherId");
                                    }
                                }
                                Log.i(TAG, "StudentSelectedId: " + param.get("TeacherId"));
                            }
                        });
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
                Toast.makeText(ListTeacherNameActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getDataUnSelect(boolean search) {
        progressBar.setVisibility(View.VISIBLE);
        recyclerViewlistPost.setVisibility(View.GONE);
        warningTxt.setVisibility(View.GONE);
        String address = "api/CustomGroup/GetRelatedTeachersFromCustomGroup?groupId=" + object.getId() + "&UserId=" + settingsBll().getApplicationUserId();
        if (search) {
            address = "api/CustomGroup/Search?txtSearch=" + edtSearch.getText().toString().trim() + "&UserId=" + settingsBll().getApplicationUserId();
        }
        controller().GetFromApi2(address, new CallbackGetString() {
            @Override
            public void onSuccess(String resultStr) {
                try {
                    GetRelatedTeachersFromCustomGroup list = gson().fromJson(resultStr, GetRelatedTeachersFromCustomGroup.class);

                    if (list.getData().size() > 0) {
                        warningTxt.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        recyclerViewlistPost.setVisibility(View.VISIBLE);

                        adapter = new TeacherNameListUnSelectedAdapter(list.getData(), new PostMiniListAdapter.SelectCallBack() {
                            @Override
                            public void Id(int num, boolean allSelect) {

                                if (SelectedTeacherId.contains(num)) {
                                    for (int i = 0; i < SelectedTeacherId.size(); i++) {
                                        if (SelectedTeacherId.get(i) == num) {
                                            SelectedTeacherId.remove(i);
                                            break;
                                        }
                                    }
                                } else {
                                    SelectedTeacherId.add(num);
                                }

                                Log.i(TAG, "StudentSelectedId: " + SelectedTeacherId.toString().replace(" ", ""));
                                if (SelectedTeacherId.size() > 0) {
                                    param.put("TeacherId", SelectedTeacherId.toString().replace(" ", ""));
                                } else {
                                    if (param.get("TeacherId") != null) {
                                        param.remove("TeacherId");
                                    }
                                }
                                Log.i(TAG, "StudentSelectedId: " + param.get("TeacherId"));
                            }
                        });
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
                Toast.makeText(ListTeacherNameActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setVariable() {

        recyclerViewlistPost.setLayoutManager(new LinearLayoutManager(this));

        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtSearch.getText().toString().trim().isEmpty()) {
//                    Toast.makeText(ListCategoryActivity.this, "لطفا متن جستجو را وارد نمائید", Toast.LENGTH_SHORT).show();
                    getDataSelect(false);
                } else {
                    getDataSelect(true);
                }
            }
        });
        SendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (param.get("TeacherId") == null) {
                    Toast.makeText(ListTeacherNameActivity.this, "هیچ مورد انتخاب نشده است", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Action.equals("Select")) {
                    SendToSelected();
                } else if (Action.equals("UnSelect")) {
                    SendToUnSelected();

                }
            }
        });
    }

    private void SendToSelected() {
        JSONObject params = new JSONObject();
        try {
            params.put("TeacherId", param.get("TeacherId").toString().replace("\"", ""));
            params.put("GroupId", object.getId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MaterialDialog wait = new Waiting(ListTeacherNameActivity.this).alertWaiting();
        wait.show();
        controller().operationProcess(ListTeacherNameActivity.this, "api/CustomGroup/AddTeacherToGroup", params.toString().replace("\"[", "[").replace("]\"", "]"), new CallbackOperation() {
            @Override
            public void onSuccess(String result) {
                try {
                    Gson gson = new Gson();
                    ManageDomain manageDomain = gson.fromJson(result, ManageDomain.class);
                    Toast.makeText(ListTeacherNameActivity.this, manageDomain.getMessage(), Toast.LENGTH_SHORT).show();
                    if (manageDomain.isSuccess()) {
                        finish();
                        Intent intent = new Intent(ListTeacherNameActivity.this, ListTeacher2Activity.class);
                        startActivity(intent);
                    }

                } catch (Exception e) {
                    Toast.makeText(ListTeacherNameActivity.this, "" + e.toString(), Toast.LENGTH_SHORT).show();
                }
                wait.dismiss();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(ListTeacherNameActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void SendToUnSelected() {
        JSONObject params = new JSONObject();
        try {
            params.put("UsersId", param.get("TeacherId").toString().replace("\"", ""));
            params.put("CustomGrupId", object.getId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MaterialDialog wait = new Waiting(ListTeacherNameActivity.this).alertWaiting();
        wait.show();
        controller().operationProcess(ListTeacherNameActivity.this, "api/CustomGroup/RemoveTeacherFromGroup", params.toString().replace("\"[", "[").replace("]\"", "]"), new CallbackOperation() {
            @Override
            public void onSuccess(String result) {
                try {
                    Gson gson = new Gson();
                    ManageDomain manageDomain = gson.fromJson(result, ManageDomain.class);
                    Toast.makeText(ListTeacherNameActivity.this, manageDomain.getMessage(), Toast.LENGTH_SHORT).show();
                    if (manageDomain.isSuccess()) {
                        finish();
                        Intent intent = new Intent(ListTeacherNameActivity.this, ListTeacher2Activity.class);
                        startActivity(intent);
                    }

                } catch (Exception e) {
                    Toast.makeText(ListTeacherNameActivity.this, "" + e.toString(), Toast.LENGTH_SHORT).show();
                }
                wait.dismiss();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(ListTeacherNameActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initView() {
        recyclerViewlistPost = findViewById(R.id.viewAttach);
        progressBar = findViewById(R.id.progressBarRow4);
        warningTxt = findViewById(R.id.warninTxt);
        my_toolbar = findViewById(R.id.toolbar);
        titleTxt = findViewById(R.id.titleTxt);
        searchIcon = findViewById(R.id.sub_toggle_button_category);
        edtSearch = findViewById(R.id.edtSearch);
        titleTxt = findViewById(R.id.title);
        SendBtn = findViewById(R.id.sendBtn);
        titleBtn = findViewById(R.id.titleBtn);
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

        view3.setVisibility(View.VISIBLE);

        btn1.setOnClickListener(v -> {
            Intent intent = new Intent(ListTeacherNameActivity.this, ProfileActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(ListTeacherNameActivity.this, Main2Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn3.setOnClickListener(v -> {
            Intent intent = new Intent(ListTeacherNameActivity.this, Main3Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn4.setOnClickListener(v -> {
            Intent intent = new Intent(ListTeacherNameActivity.this, ListPostActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn5.setOnClickListener(v -> {
            Intent intent = new Intent(ListTeacherNameActivity.this,BookmarkListActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        ConstraintLayout postLayout=findViewById(R.id.postlayout);
        if (settingsBll.getUserType() != 0 && settingsBll.getUserType() != 1) {
            postLayout.setVisibility(View.GONE);
        }
    }
}