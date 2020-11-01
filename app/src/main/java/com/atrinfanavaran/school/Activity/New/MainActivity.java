package com.atrinfanavaran.school.Activity.New;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atrinfanavaran.school.Adapter.New.AttachAdapter;
import com.atrinfanavaran.school.Adapter.New.QuestionAdapter;
import com.atrinfanavaran.school.Domain.New.AttachFile;
import com.atrinfanavaran.school.Domain.New.DropdownList;
import com.atrinfanavaran.school.Domain.Setting;
import com.atrinfanavaran.school.Fragment.NavigationDrawerFragment;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGetString;
import com.atrinfanavaran.school.Kernel.Helper.FilePath;
import com.atrinfanavaran.school.R;
import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private static final int Time_Between_Two_Back = 2000;
    private long TimeBackPressed;

    private Toolbar my_toolbar;
    private LinearLayoutManager linearLayoutManager;

    private String selectedFilePath;

    private String mCameraFilePath;
    private File f;
    private Uri image;
    private RecyclerView recyclerViewlistAttach;
    private RecyclerView.Adapter adapter;
    ArrayList<AttachFile> attachFiles = new ArrayList<>();
    private LinearLayout addAttachFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);


        RunPermissionDownload();
        initView();

        NavigationDrawer();
        getSetting();
        setVariable();
        attachFiles = attach1();

        getDataApi2(attachFiles, false);
    }

    private void setVariable() {
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewlistAttach.setLayoutManager(linearLayoutManager);

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

    }

    private ArrayList<AttachFile> attach1() {

        ArrayList<AttachFile> array_object = new ArrayList<>();
        array_object.add(new AttachFile("test1", "1", "1"));
        array_object.add(new AttachFile("test2", "2", "2"));
        array_object.add(new AttachFile("test3", "3", "3"));

        return array_object;
    }


    private ArrayList<DropdownList> list1() {

        ArrayList<DropdownList> array_object = new ArrayList<>();
        array_object.add(new DropdownList("تست1", "1"));
        array_object.add(new DropdownList("تست2", "2"));
        array_object.add(new DropdownList("تست3", "3"));
        array_object.add(new DropdownList("تست4", "4"));


        return array_object;
    }

    private void initView() {

        my_toolbar = findViewById(R.id.toolbar);
        addAttachFile = findViewById(R.id.addAttachFile);

        recyclerViewlistAttach = findViewById(R.id.viewAttach);
    }

    private void NavigationDrawer() {

        NavigationDrawerFragment my_nav = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        my_nav.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), my_toolbar);

    }

    @Override
    public void onBackPressed() {

        FragmentManager fm = getSupportFragmentManager();
        Fragment hm = getSupportFragmentManager().findFragmentByTag("subPage");

        if (hm != null) {
            if (hm.isVisible()) {
                if (fm.getBackStackEntryCount() > 1) {
                    fm.popBackStack();
                }
            } else {
                if (TimeBackPressed + Time_Between_Two_Back > System.currentTimeMillis()) {
                    finishAffinity();
                    return;
                } else {
                    Toast.makeText(MainActivity.this, "به منظور خروج دوباره کلیک کنید", Toast.LENGTH_SHORT).show();
                }
                TimeBackPressed = System.currentTimeMillis();
            }
        } else {
            if (TimeBackPressed + Time_Between_Two_Back > System.currentTimeMillis()) {
                finishAffinity();
                return;
            } else {
                Toast.makeText(MainActivity.this, "به منظور خروج دوباره کلیک کنید", Toast.LENGTH_SHORT).show();
            }
            TimeBackPressed = System.currentTimeMillis();
        }
    }

    private void RunPermissionDownload() {

        Dexter.withActivity(getActivity())
                .withPermissions(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_NETWORK_STATE
                        , Manifest.permission.ACCESS_FINE_LOCATION
                        , Manifest.permission.ACCESS_COARSE_LOCATION

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

    private void getSetting() {

        controller().GetFromApi2("api/Setting", new CallbackGetString() {
            @Override
            public void onSuccess(String resultStr) {
                Gson gson = new Gson();

                try {
                    String str = new JSONObject(resultStr).getString("data");
                    Setting response = gson.fromJson(str, Setting.class);
                    if (response.getid() == null) return;

                    SettingsBll settingsBll = new SettingsBll(getActivity());
                    settingsBll.setLogoAddress(response.getlogoName());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String error) {

            }
        });

    }

    private void getDataApi(ArrayList<DropdownList> array_object, boolean notify) {
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
//        ArrayList<String> array_object = new ArrayList<>();
//        array_object.add("مایل به خرید کدام یک از موارد زیر می باشید؟");
//        array_object.add("پوشاک");
//        array_object.add("لوازم دیجیتال");
//        array_object.add("خودرو");
//        array_object.add("مواد غذایی");


        adapter = new QuestionAdapter(array_object);


        recyclerViewlistAttach.setAdapter(adapter);
    }

    private void getDataApi2(ArrayList<AttachFile> array_object, boolean notify) {
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

        adapter = new AttachAdapter(array_object);
        recyclerViewlistAttach.setAdapter(adapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (data == null) {
                return;
            }
            Uri selectedImage = data.getData();

            selectedFilePath = FilePath.getPath(this, selectedImage);
            attachFiles.add(new AttachFile(selectedFilePath, "1", "1"));
            adapter.notifyDataSetChanged();
        }



}


}