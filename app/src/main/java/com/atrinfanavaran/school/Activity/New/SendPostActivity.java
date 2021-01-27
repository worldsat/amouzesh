package com.atrinfanavaran.school.Activity.New;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atrinfanavaran.school.Adapter.New.AttachPostAdapter;
import com.atrinfanavaran.school.Adapter.New.DastresiAdapter;
import com.atrinfanavaran.school.Adapter.New.PostMiniListAdapter;
import com.atrinfanavaran.school.Domain.New.AttachFile;
import com.atrinfanavaran.school.Domain.New.CategoryGetAll;
import com.atrinfanavaran.school.Domain.New.CustomGroup;
import com.atrinfanavaran.school.Domain.New.DropdownList;
import com.atrinfanavaran.school.Domain.New.EducationPostGetAll;
import com.atrinfanavaran.school.Domain.New.GetRelatedUsers;
import com.atrinfanavaran.school.Fragment.NavigationDrawerFragment;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Controller;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGetString;
import com.atrinfanavaran.school.Kernel.Controller.Interface.IOnResponseListener;
import com.atrinfanavaran.school.Kernel.Helper.FilePath;
import com.atrinfanavaran.school.R;
import com.github.irshulx.Editor;
import com.github.irshulx.models.EditorTextStyle;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import org.apache.commons.text.StringEscapeUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import top.defaults.colorpicker.ColorPickerPopup;

import static org.apache.commons.lang3.StringEscapeUtils.unescapeHtml4;

public class SendPostActivity extends BaseActivity {

    private static final int Time_Between_Two_Back = 2000;
    private long TimeBackPressed;

    private Toolbar my_toolbar;
    private LinearLayoutManager linearLayoutManager;

    private String selectedFilePath;

    private String mCameraFilePath;
    private File f;
    private Uri image;
    private RecyclerView recyclerViewlistAttach;
    private RecyclerView recyclerViewlistDastresi;
    private RecyclerView recyclerViewlistCategory;
    private RecyclerView recyclerViewlisttakhsis;
    private RecyclerView recyclerViewlisttakhsisGroup;
    private RecyclerView.Adapter adapterAttach;
    private RecyclerView.Adapter adapterDastresi;
    private RecyclerView.Adapter adapterCategory;
    private RecyclerView.Adapter adaptertakhsis;
    private RecyclerView.Adapter adaptertakhsisGroup;
    private ArrayList<AttachFile> attachFiles = new ArrayList<>();
    private ArrayList<DropdownList> DastresiList = new ArrayList<>();
    private ArrayList<DropdownList> CategoryList = new ArrayList<>();
    private ArrayList<DropdownList> takhsisList = new ArrayList<>();
    private ArrayList<DropdownList> takhsisGroupList = new ArrayList<>();
    private LinearLayout addAttachFile;
    private HashMap<String, Object> params = new HashMap<>();
    private LinearLayout sendBtn;
    private Switch pinnedSwitch;
    private EditText titlePostEdt;
    private Editor editor;
    private LinearLayout categoryBtn, dastresiBtn, iconBtn, takhsisBtn, takhsisGroupBtn;
    private ImageView toggle_category, toggle_dastresi, toggle_icon, toggle_takhsis, toggle_takhsis_group;
    private EducationPostGetAll.Data object;
    private ProgressBar progressBarRowCategory;
    private ProgressBar progressBarRowtakhsis;
    private ProgressBar progressBarRowtakhsisGroup;
    private ArrayList<Integer> takhisisSelectIds = new ArrayList<>();
    private ArrayList<Integer> takhisisGroupSelectIds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_post);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);


        RunPermissionDownload();
        initView();
        EditorWYSIWYG();
        getBundle();
        NavigationDrawer();
        setVariable();

        attachFiles.addAll(attach1());
        DastresiList = DastresiList();
        CategoryList = CategoryList(false);
        takhsisList = takhsisList(false);
        takhsisGroupList = TakhsisGroupList(false);

        getDataApi2(attachFiles, DastresiList, CategoryList, false);

        sendData();
        defaultValue();
        bottomView();
        NavigationDrawer();
        setToolbar();
    }

    private void setToolbar() {
        TextView titleToolbar = findViewById(R.id.titleToolbar);
        titleToolbar.setText(settingsBll().getSchoolName());
    }

    private void getBundle() {
        object = (EducationPostGetAll.Data) getIntent().getSerializableExtra("object");
        if (object != null) {
            titlePostEdt.setText(object.getTitle());
            String escaped = unescapeHtml4("<html><body > <head></head>" + java.net.URLDecoder.decode(object.getDescription().replace("null", "-")) + "  </body><html>");

            editor.render(escaped);
            pinnedSwitch.setChecked(object.isPin());
            if (object.getMedias() != null) {

                ArrayList<EducationPostGetAll.Data.Medias> res = object.getMedias();
                for (int i = 0; i < res.size(); i++) {

                    attachFiles.add(new AttachFile(res.get(i).getTitle(), String.valueOf(res.get(i).getId()), ""));
                }
            }
        }
    }

    private void defaultValue() {
        params.put("accessType", 0);
        params.put("CategoryId", 0);

        if (object != null) {
            params.put("id", object.getId());
        }
    }

    private void sendData() {


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (titlePostEdt.getText().toString().isEmpty()) {
                    SnakBar("لطفا عنوان را وارد نمائید");
                } else {
                    params.put("Title", titlePostEdt.getText().toString());
                }

                if (pinnedSwitch.isChecked()) {
                    params.put("Pin", true);
                } else {
                    params.put("Pin", false);
                }
                SettingsBll settingsBll = new SettingsBll(SendPostActivity.this);
                params.put("Description", StringEscapeUtils.escapeHtml4(editor.getContentAsHTML()));
                params.put("ApplicationUserId", settingsBll.getApplicationUserId());

                Controller controller = new Controller(SendPostActivity.this);

//                settingsBll.setTicket("rewrwerewrrsggeetsdgffdgfdgfdgf");

                Log.i(TAG, "onActivityResult22: " + params.toString().replaceAll("<<.*>>", ""));

                controller.uploadFileNew(SendPostActivity.this, "api/EducationPost/Add", null, params, new IOnResponseListener() {
                    @Override
                    public void onResponse(String response) {
//                        Toast.makeText(SendPostActivity.this, "ok", Toast.LENGTH_SHORT).show();
//                waiting.dismiss();

                        finish();
                        Intent intent = new Intent(SendPostActivity.this, ListPostActivity.class);
//                intent.putExtra("PersonelTaskId", PersonelTaskId);
                        startActivity(intent);
                    }

                    @Override
                    public void onError() {

//                waiting.dismiss();
                    }
                });
            }
        });

    }

    private void setVariable() {
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewlistAttach.setLayoutManager(linearLayoutManager);
        recyclerViewlistAttach.setNestedScrollingEnabled(false);

        recyclerViewlistDastresi.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewlistDastresi.setNestedScrollingEnabled(false);

        recyclerViewlistCategory.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewlistCategory.setNestedScrollingEnabled(false);

        recyclerViewlisttakhsis.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewlisttakhsis.setNestedScrollingEnabled(false);
        addAttachFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                Intent sIntent;
                if (Build.BRAND.equals("samsung")) {
                    intent = new Intent("com.sec.android.app.myfiles.PICK_DATA");
                    sIntent = new Intent("com.sec.android.app.myfiles.PICK_DATA");
                } else {

                    intent = new Intent();
                    sIntent = new Intent();
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                }
//            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);

                // special intent for Samsung file manager

                // if you want any file type, you can skip next line
                sIntent.putExtra("CONTENT_TYPE", "*/*");
                sIntent.addCategory(Intent.CATEGORY_DEFAULT);

                Intent chooserIntent;
                if (getPackageManager().resolveActivity(sIntent, 0) != null) {
                    // it is device with Samsung file manager
                    chooserIntent = Intent.createChooser(sIntent, "فایل مورد نظر را انتخاب کنید");
                    chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{intent});
                } else {
                    chooserIntent = Intent.createChooser(intent, "فایل مورد نظر را انتخاب کنید");
                }

                try {
                    startActivityForResult(chooserIntent, 0);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "No suitable File Manager was found.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        iconBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                Intent sIntent;
                if (Build.BRAND.equals("samsung")) {
                    intent = new Intent("com.sec.android.app.myfiles.PICK_DATA");
                    sIntent = new Intent("com.sec.android.app.myfiles.PICK_DATA");
                } else {

                    intent = new Intent();
                    sIntent = new Intent();
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                }
//            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);

                // special intent for Samsung file manager

                // if you want any file type, you can skip next line
                sIntent.putExtra("CONTENT_TYPE", "*/*");
                sIntent.addCategory(Intent.CATEGORY_DEFAULT);

                Intent chooserIntent;
                if (getPackageManager().resolveActivity(sIntent, 0) != null) {
                    // it is device with Samsung file manager
                    chooserIntent = Intent.createChooser(sIntent, "فایل مورد نظر را انتخاب کنید");
                    chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{intent});
                } else {
                    chooserIntent = Intent.createChooser(intent, "فایل مورد نظر را انتخاب کنید");
                }

                try {
                    startActivityForResult(chooserIntent, 1);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "No suitable File Manager was found.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        categoryBtn.setOnClickListener(v -> {
            if (recyclerViewlistCategory.getVisibility() == (View.VISIBLE)) {
                recyclerViewlistCategory.setVisibility(View.GONE);
                toggle_category.setImageResource(R.drawable.ic_expand_less);
            } else {
                recyclerViewlistCategory.setVisibility(View.VISIBLE);
                toggle_category.setImageResource(R.drawable.ic_expand_more);
            }
        });
        dastresiBtn.setOnClickListener(v -> {
            if (recyclerViewlistDastresi.getVisibility() == (View.VISIBLE)) {
                recyclerViewlistDastresi.setVisibility(View.GONE);
                toggle_dastresi.setImageResource(R.drawable.ic_expand_less);
            } else {
                recyclerViewlistDastresi.setVisibility(View.VISIBLE);
                toggle_dastresi.setImageResource(R.drawable.ic_expand_more);
            }
        });
        takhsisBtn.setOnClickListener(v -> {
            if (recyclerViewlisttakhsis.getVisibility() == (View.VISIBLE)) {
                recyclerViewlisttakhsis.setVisibility(View.GONE);
                toggle_takhsis.setImageResource(R.drawable.ic_expand_less);
            } else {
                recyclerViewlisttakhsis.setVisibility(View.VISIBLE);
                toggle_takhsis.setImageResource(R.drawable.ic_expand_more);
            }
        });
        takhsisGroupBtn.setOnClickListener(v -> {
            if (recyclerViewlisttakhsisGroup.getVisibility() == (View.VISIBLE)) {
                recyclerViewlisttakhsisGroup.setVisibility(View.GONE);
                toggle_takhsis_group.setImageResource(R.drawable.ic_expand_less);
            } else {
                recyclerViewlisttakhsisGroup.setVisibility(View.VISIBLE);
                toggle_takhsis_group.setImageResource(R.drawable.ic_expand_more);
            }
        });
    }

    private ArrayList<AttachFile> attach1() {

        ArrayList<AttachFile> array_object = new ArrayList<>();
//        array_object.add(new AttachFile("test1", "1", "1"));
//        array_object.add(new AttachFile("test2", "2", "2"));
//        array_object.add(new AttachFile("test3", "3", "3"));

        return array_object;
    }


    private ArrayList<DropdownList> DastresiList() {

        ArrayList<DropdownList> array_object = new ArrayList<>();
        array_object.add(new DropdownList("رایگان", 0, true));
        array_object.add(new DropdownList("شامل هزینه", 1, false));

        return array_object;
    }

    private ArrayList<DropdownList> CategoryList(boolean notify) {

        ArrayList<DropdownList> array_object = new ArrayList<>();
//        array_object.add(new DropdownList("ریاضی", 0, true));
//        array_object.add(new DropdownList("علوم پایه", 1, false));
//        array_object.add(new DropdownList("جغرافیا", 2, false));
//        array_object.add(new DropdownList("زیست", 3, false));

        String address = "api/Category/GetAll?UserId=" + settingsBll().getApplicationUserId();

        progressBarRowCategory.setVisibility(View.VISIBLE);
        controller().GetFromApi2(address, new CallbackGetString() {
            @Override
            public void onSuccess(String resultStr) {
                Log.i(TAG, "category: " + resultStr);
                CategoryGetAll categoryGetAll = gson().fromJson(resultStr, CategoryGetAll.class);
                if (CategoryList.size() > 0) {
                    CategoryList.clear();
                }
                if (categoryGetAll.getData().size() > 0) {
                    boolean tick = false;
                    for (int i = 0; i < categoryGetAll.getData().size(); i++) {
                        if (i == 0) {
                            params.put("CategoryId", categoryGetAll.getData().get(0).getId());
                        }
                        if (object != null) {
                            if (object.getCategoryId() == categoryGetAll.getData().get(i).getId()) {
                                tick = true;
                                params.put("CategoryId", categoryGetAll.getData().get(i).getId());
                            } else {
                                tick = false;

                            }
                        } else {
                            if (i == 0) {
                                tick = true;
                            } else {
                                tick = false;
                            }
                        }
                        array_object.add(new DropdownList(categoryGetAll.getData().get(i).getName(), categoryGetAll.getData().get(i).getId(), tick));
                    }
                }
                array_object.add(new DropdownList("دسته بندی جدید", 0, false));
//                if (notify) {
//                    CategoryList = array_object;
//                    adapterCategory.notifyDataSetChanged();
//
//                }

                adapterCategory = new DastresiAdapter("Category", array_object, object, new DastresiAdapter.SelectCallBack() {
                    @Override
                    public void Id(int num) {
                        params.put("CategoryId", num);
                    }

                    @Override
                    public void refresh() {
                        CategoryList(true);
                    }
                });
                recyclerViewlistCategory.setAdapter(adapterCategory);
                progressBarRowCategory.setVisibility(View.GONE);
            }

            @Override
            public void onError(String error) {

            }
        });
        return array_object;
    }

    private ArrayList<DropdownList> takhsisList(boolean notify) {

        ArrayList<DropdownList> array_object = new ArrayList<>();
//        array_object.add(new DropdownList("ریاضی", 0, true));
//        array_object.add(new DropdownList("علوم پایه", 1, false));
//        array_object.add(new DropdownList("جغرافیا", 2, false));
//        array_object.add(new DropdownList("زیست", 3, false));

        String address = "api/User/GetRelatedUsers?Id=" + settingsBll().getApplicationUserId();

        progressBarRowtakhsis.setVisibility(View.VISIBLE);
        controller().GetFromApi2(address, new CallbackGetString() {
            @Override
            public void onSuccess(String resultStr) {
                Log.i(TAG, "StudentListToPost: " + resultStr);
                GetRelatedUsers getRelatedUsers = gson().fromJson(resultStr, GetRelatedUsers.class);
                if (takhsisList.size() > 0) {
                    takhsisList.clear();
                }
                if (getRelatedUsers.getData().getStudents().size() > 0) {
                    array_object.add(new DropdownList("انتخاب همه", -1, false));
                    boolean tick = false;
                    for (int i = 0; i < getRelatedUsers.getData().getStudents().size(); i++) {
                        if (object != null) {
                            for (int j = 0; j < object.getStudents().size(); j++) {
                                if (object.getStudents().get(j) == getRelatedUsers.getData().getStudents().get(i).getId()) {
                                    tick = true;
                                    takhisisSelectIds.add(object.getStudents().get(j));
                                    params.put("StudentListToPost", takhisisSelectIds.toString().replace(" ", "").replace("[", "").replace("]", ""));

                                    break;

                                } else {
                                    tick = false;

                                }
                            }

                        } else {
                            if (i == 0) {
                                tick = false;
                            } else {
                                tick = false;
                            }
                        }
                        array_object.add(new DropdownList(getRelatedUsers.getData().getStudents().get(i).getFullName(), getRelatedUsers.getData().getStudents().get(i).getId(), tick));
                    }
                }

//                if (notify) {
//                    CategoryList = array_object;
//                    adapterCategory.notifyDataSetChanged();
//
//                }

                adaptertakhsis = new PostMiniListAdapter(array_object, null, new PostMiniListAdapter.SelectCallBack() {
                    @Override
                    public void Id(int num, boolean allSelect) {
                        if (allSelect) {
                            ArrayList<Integer> allId = new ArrayList<>();
                            for (int i = 0; i < array_object.size(); i++) {
                                allId.add(array_object.get(i).getListId());
                                array_object.get(i).setTick(true);

                            }
                            adaptertakhsis.notifyDataSetChanged();
                            params.put("StudentListToPost", allId.toString().replace(" ", "").replace("[", "").replace("]", ""));
                            Log.i(TAG, "Id: " + params.toString());
                            return;
                        }
                        params.put("StudentListToPost", num);

                        if (takhisisSelectIds.contains(num)) {
                            for (int i = 0; i < takhisisSelectIds.size(); i++) {
                                if (takhisisSelectIds.get(i) == num) {
                                    takhisisSelectIds.remove(i);
                                    break;
                                }
                            }
                        } else {
                            takhisisSelectIds.add(num);
                        }

                        Log.i(TAG, "bannerToPostsId: " + takhisisSelectIds.toString().replace(" ", "").replace("[", "").replace("]", ""));
                        if (takhisisSelectIds.size() > 0) {
                            params.put("StudentListToPost", takhisisSelectIds.toString().replace(" ", "").replace("[", "").replace("]", ""));
                        } else {
                            if (params.get("StudentListToPost") != null) {
                                params.remove("StudentListToPost");
                            }
                        }
                    }


                });
                recyclerViewlisttakhsis.setAdapter(adaptertakhsis);
                progressBarRowtakhsis.setVisibility(View.GONE);
            }

            @Override
            public void onError(String error) {

            }
        });
        return array_object;
    }

    private ArrayList<DropdownList> TakhsisGroupList(boolean notify) {

        ArrayList<DropdownList> array_object = new ArrayList<>();
//        array_object.add(new DropdownList("ریاضی", 0, true));
//        array_object.add(new DropdownList("علوم پایه", 1, false));
//        array_object.add(new DropdownList("جغرافیا", 2, false));
//        array_object.add(new DropdownList("زیست", 3, false));

        String address = "api/CustomGroup/GetAll?UserId=" + settingsBll().getApplicationUserId();

        progressBarRowtakhsisGroup.setVisibility(View.VISIBLE);
        controller().GetFromApi2(address, new CallbackGetString() {
            @Override
            public void onSuccess(String resultStr) {
                Log.i(TAG, "takhsisGroup: " + resultStr);
                CustomGroup list = gson().fromJson(resultStr, CustomGroup.class);
                if (takhsisGroupList.size() > 0) {
                    takhsisGroupList.clear();
                }
                if (list.getData().size() > 0) {
                    array_object.add(new DropdownList("انتخاب همه", -1, false));
                    boolean tick = false;
                    for (int i = 0; i < list.getData().size(); i++) {
                        if (object != null) {
                            if (object.getCategoryId() == list.getData().get(i).getId()) {
                                tick = true;
                            } else {
                                tick = false;
                            }
                        } else {
                            if (i == 0) {
                                tick = true;
                            } else {
                                tick = false;
                            }
                        }
                        array_object.add(new DropdownList(list.getData().get(i).getName(), list.getData().get(i).getId(), tick));
                    }
                }

//                if (notify) {
//                    CategoryList = array_object;
//                    adapterCategory.notifyDataSetChanged();
//
//                }

                adaptertakhsisGroup = new PostMiniListAdapter(array_object, null, new PostMiniListAdapter.SelectCallBack() {
                    @Override
                    public void Id(int num, boolean allSelect) {
                        if (allSelect) {
                            ArrayList<Integer> allId = new ArrayList<>();
                            for (int i = 0; i < array_object.size(); i++) {
                                allId.add(array_object.get(i).getListId());
                                array_object.get(i).setTick(true);

                            }
                            adaptertakhsisGroup.notifyDataSetChanged();
                            params.put("StudentListToPost", allId.toString().replace(" ", ""));
                            Log.i(TAG, "Id: " + params.toString());
                            return;
                        }
                        params.put("StudentListToPost", num);

                        if (takhisisGroupSelectIds.contains(num)) {
                            for (int i = 0; i < takhisisGroupSelectIds.size(); i++) {
                                if (takhisisGroupSelectIds.get(i) == num) {
                                    takhisisGroupSelectIds.remove(i);
                                    break;
                                }
                            }
                        } else {
                            takhisisGroupSelectIds.add(num);
                        }

                        Log.i(TAG, "takhsisGroup: " + takhisisGroupSelectIds.toString().replace(" ", ""));
                        if (takhisisGroupSelectIds.size() > 0) {
                            params.put("StudentListToPost", takhisisGroupSelectIds.toString().replace(" ", ""));
                        } else {
                            if (params.get("StudentListToPost") != null) {
                                params.remove("StudentListToPost");
                            }
                        }
                    }


                });
                recyclerViewlisttakhsisGroup.setAdapter(adaptertakhsisGroup);
                progressBarRowtakhsisGroup.setVisibility(View.GONE);
            }

            @Override
            public void onError(String error) {

            }
        });
        return array_object;
    }

    private void initView() {

        my_toolbar = findViewById(R.id.toolbar);
        addAttachFile = findViewById(R.id.addAttachFile);

        recyclerViewlistAttach = findViewById(R.id.viewAttach);
        recyclerViewlistDastresi = findViewById(R.id.viewDastresi);
        recyclerViewlistCategory = findViewById(R.id.viewPostion);
        recyclerViewlisttakhsis = findViewById(R.id.viewtakhsis);
        recyclerViewlisttakhsisGroup = findViewById(R.id.viewtakhsisgroup);
        sendBtn = findViewById(R.id.sendBtn);
        pinnedSwitch = findViewById(R.id.switch10);
        titlePostEdt = findViewById(R.id.titlePostEdt);
        categoryBtn = findViewById(R.id.categoryBtn);
        dastresiBtn = findViewById(R.id.dastresiBtn);
        takhsisBtn = findViewById(R.id.takhsisBtn);
        takhsisGroupBtn = findViewById(R.id.takhsisGroupBtn);
        toggle_category = findViewById(R.id.sub_toggle_button_category);
        toggle_dastresi = findViewById(R.id.sub_toggle_button_dastresi);
        toggle_takhsis = findViewById(R.id.sub_toggle_button_takhsis);
        toggle_icon = findViewById(R.id.sub_toggle_button_icon);
        toggle_takhsis_group = findViewById(R.id.sub_toggle_button_takhsis_groups);
        iconBtn = findViewById(R.id.iconBtn);
        progressBarRowCategory = findViewById(R.id.progressBarRow1);
        progressBarRowtakhsis = findViewById(R.id.progressBarRow2);
        progressBarRowtakhsisGroup = findViewById(R.id.progressBarRow3);
    }

    private void NavigationDrawer() {

        NavigationDrawerFragment my_nav = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        my_nav.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), my_toolbar);

    }


    private void RunPermissionDownload() {

        Dexter.withActivity(getActivity())
                .withPermissions(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                        , Manifest.permission.READ_EXTERNAL_STORAGE


                )
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {

                        }

                        if (report.isAnyPermissionPermanentlyDenied()) {
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                })
                .onSameThread().check();

    }

    private void checkRunTimePermission() {
        String[] permissionArrays = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE
                , Manifest.permission.READ_EXTERNAL_STORAGE
                , Manifest.permission.ACCESS_NETWORK_STATE
                , Manifest.permission.ACCESS_FINE_LOCATION
                , Manifest.permission.ACCESS_COARSE_LOCATION
        };

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissionArrays, 1);
        } else {

        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    checkRunTimePermission();
                }
                return;
            }
        }
    }


    private void getDataApi2(ArrayList<AttachFile> array_object, ArrayList<DropdownList> array_objectDastresi, ArrayList<DropdownList> array_objectCategory, boolean notify) {
//
//        PersonelTaskListBll personelTaskListBll = new PersonelTaskListBll(this);
//
//        ArrayList<Filter> filter = new ArrayList<>();
//
//
//
//
//
//        filter.add(new Filter("PersonelTaskId", getIntent().getStringExtra("PersonelTaskId")));
//
//
//        warningTxt.setVisibility(View.GONE);
//        progressBar.setVisibility(View.VISIBLE);
//        personelTaskListBll.Get(filter, TAKE, SKIP, false, new CallbackGet() {
//            @Override
//            public <T> void onSuccess(ArrayList<T> result, int count) {
//
//
//                int previousResponseSize = SKIP;
//                if (notify) {
//                    response.clear();
//                }
//                response.addAll((Collection<? extends PersonelTask>) result);
//
//                SKIP = response.size();
//
////                row.setVisibility(View.VISIBLE);
////                String Str = count + " ردیف ";
////                row.setText(Str);
//
//                // check if the server response if not error if so show a text
//                if (response.size() == 0) {
//                    warningTxt.setVisibility(View.VISIBLE);
//                } else {
//                    warningTxt.setVisibility(View.GONE);
//                    if (notify) {
//                        progressBar.setVisibility(View.GONE);
//                        adapter.notifyDataSetChanged();
//                        return;
//                    }
//                    // check if the response count is less or equal to the total available data
//                    // remove the scroll listener
//                    if (count != -1 && SKIP == count) {
//                        recyclerViewlist.clearOnScrollListeners();
//                        isScrollListenerAdded = false;
//                    }
//                    if (adapter == null) {
//                        recyclerViewlist.setVisibility(View.VISIBLE);
//

        adapterAttach = new AttachPostAdapter(array_object, new AttachPostAdapter.deleteAttachCallBack() {
            @Override
            public void position(int num) {
                params.remove("file<<" + (num + 1) + ">>");

                Log.i(TAG, "params: " + params.toString());
            }
        });
        recyclerViewlistAttach.setAdapter(adapterAttach);


        //for dastresi
        if (object != null) {
            for (int i = 0; i < array_objectDastresi.size(); i++) {
                if (array_objectDastresi.get(i).getListId() == object.getAccessType()) {
                    array_objectDastresi.get(i).setTick(true);
                } else {
                    array_objectDastresi.get(i).setTick(false);
                }
            }
        }
        adapterDastresi = new DastresiAdapter("accessType", array_objectDastresi, object, new DastresiAdapter.SelectCallBack() {
            @Override
            public void Id(int num) {
                params.put("accessType", num);
            }

            @Override
            public void refresh() {

            }
        });
        recyclerViewlistDastresi.setAdapter(adapterDastresi);


        //for category
        if (object != null) {
            for (int i = 0; i < array_objectCategory.size(); i++) {
                if (array_objectCategory.get(i).getListId() == object.getCategoryId()) {
                    array_objectCategory.get(i).setTick(true);
                } else {
                    array_objectCategory.get(i).setTick(false);
                }
            }
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (data == null) {
                return;
            }
            Uri selectedImage = data.getData();

            selectedFilePath = FilePath.getPath(this, selectedImage);
            attachFiles.add(new AttachFile(selectedFilePath, "null", "1"));
            adapterAttach.notifyDataSetChanged();
            params.put("file<<" + attachFiles.size() + ">>", new File(selectedFilePath));

            Log.i(TAG, "onActivityResult: " + params.toString());
        } else if (requestCode == 1) {
            if (data == null) {
                return;
            }
            Uri selectedImage = data.getData();

            selectedFilePath = FilePath.getPath(this, selectedImage);
            attachFiles.add(new AttachFile(selectedFilePath, "null", "1"));
            adapterAttach.notifyDataSetChanged();
            params.put("Icon", new File(selectedFilePath));
            toggle_icon.setImageResource(R.mipmap.tick128);
            Log.i(TAG, "onActivityResult: " + params.toString());
        }


    }

    private void EditorWYSIWYG() {
        editor = (Editor) findViewById(R.id.editor);
        findViewById(R.id.action_h1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.updateTextStyle(EditorTextStyle.H1);
            }
        });

        findViewById(R.id.action_h2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.updateTextStyle(EditorTextStyle.H2);
            }
        });

        findViewById(R.id.action_h3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.updateTextStyle(EditorTextStyle.H3);
            }
        });

        findViewById(R.id.action_bold).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.updateTextStyle(EditorTextStyle.BOLD);
            }
        });

        findViewById(R.id.action_Italic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.updateTextStyle(EditorTextStyle.ITALIC);
            }
        });

        findViewById(R.id.action_indent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.updateTextStyle(EditorTextStyle.INDENT);
            }
        });

        findViewById(R.id.action_outdent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.updateTextStyle(EditorTextStyle.OUTDENT);
            }
        });

        findViewById(R.id.action_bulleted).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.insertList(false);
            }
        });


        findViewById(R.id.action_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ColorPickerPopup.Builder(SendPostActivity.this)
                        .initialColor(Color.RED) // Set initial color
                        .enableAlpha(true) // Enable alpha slider or not
                        .okTitle("تائید")
                        .cancelTitle("لغو")
                        .showIndicator(true)
                        .showValue(true)
                        .build()
                        .show(findViewById(android.R.id.content), new ColorPickerPopup.ColorPickerObserver() {
                            @Override
                            public void onColorPicked(int color) {
                                //Toast.makeText(DisApproveActivity.this, "picked" + colorHex(color), Toast.LENGTH_LONG).show();
                                editor.updateTextColor(colorHex(color));
                            }

                            @Override
                            public void onColor(int color, boolean fromUser) {

                            }
                        });


            }
        });
        findViewById(R.id.action_unordered_numbered).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.insertList(true);
            }
        });

        findViewById(R.id.action_hr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.insertDivider();
            }
        });


        editor.render();
    }

    private String colorHex(int color) {
        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);
        return String.format(Locale.getDefault(), "#%02X%02X%02X", r, g, b);
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
            Intent intent = new Intent(SendPostActivity.this, Main1Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(SendPostActivity.this, Main2Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn3.setOnClickListener(v -> {
            Intent intent = new Intent(SendPostActivity.this, Main3Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn4.setOnClickListener(v -> {
            Intent intent = new Intent(SendPostActivity.this, ListPostActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn5.setOnClickListener(v -> {
            Intent intent = new Intent(SendPostActivity.this, Main5Activity.class);
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