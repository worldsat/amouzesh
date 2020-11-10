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
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atrinfanavaran.school.Adapter.New.AttachAdapter;
import com.atrinfanavaran.school.Adapter.New.DastresiAdapter;
import com.atrinfanavaran.school.Domain.New.AttachFile;
import com.atrinfanavaran.school.Domain.New.DropdownList;
import com.atrinfanavaran.school.Fragment.NavigationDrawerFragment;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Controller;
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
    private RecyclerView.Adapter adapterAttach;
    private RecyclerView.Adapter adapterDastresi;
    private RecyclerView.Adapter adapterCategory;
    private ArrayList<AttachFile> attachFiles = new ArrayList<>();
    private ArrayList<DropdownList> DastresiList = new ArrayList<>();
    private ArrayList<DropdownList> CategoryList = new ArrayList<>();
    private LinearLayout addAttachFile;
    private HashMap<String, Object> params = new HashMap<>();
    private LinearLayout sendBtn;
    private Switch pinnedSwitch;
    private EditText titlePostEdt;
    private Editor editor;
    private LinearLayout categoryBtn, dastresiBtn, iconBtn;
    private ImageView toggle_category, toggle_dastresi, toggle_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);


        RunPermissionDownload();
        initView();

        NavigationDrawer();
        setVariable();

        attachFiles = attach1();
        DastresiList = DastresiList();
        CategoryList = CategoryList();

        getDataApi2(attachFiles, DastresiList, CategoryList, false);
        EditorWYSIWYG();
        sendData();
        defaultValue();
        bottomView();
    }

    private void defaultValue() {
        params.put("accessType", 0);
        params.put("Category", 0);
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

                params.put("Description", StringEscapeUtils.escapeHtml4(editor.getContentAsHTML()));
                params.put("TeacherId", 1);

                Controller controller = new Controller(SendPostActivity.this);
                SettingsBll settingsBll = new SettingsBll(SendPostActivity.this);
                settingsBll.setTicket("rewrwerewrrsggeetsdgffdgfdgfdgf");

                Log.i(TAG, "onActivityResult22: " + params.toString().replaceAll("<<.*>>", ""));

                controller.uploadFileNew(SendPostActivity.this, "api/EducationPost/Add", null, params, new IOnResponseListener() {
                    @Override
                    public void onResponse() {
                        Toast.makeText(SendPostActivity.this, "ok", Toast.LENGTH_SHORT).show();
//                waiting.dismiss();

//                finish();
//                Intent intent = new Intent(PersonelTaskAttach_ManageActivity.this, PersonelTaskAttachListActivity.class);
//                intent.putExtra("PersonelTaskId", PersonelTaskId);
//                startActivity(intent);
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

    private ArrayList<DropdownList> CategoryList() {

        ArrayList<DropdownList> array_object = new ArrayList<>();
        array_object.add(new DropdownList("ریاضی", 0, true));
        array_object.add(new DropdownList("علوم پایه", 1, false));
        array_object.add(new DropdownList("جغرافیا", 2, false));
        array_object.add(new DropdownList("زیست", 3, false));

        return array_object;
    }

    private void initView() {

        my_toolbar = findViewById(R.id.toolbar);
        addAttachFile = findViewById(R.id.addAttachFile);

        recyclerViewlistAttach = findViewById(R.id.viewAttach);
        recyclerViewlistDastresi = findViewById(R.id.viewDastresi);
        recyclerViewlistCategory = findViewById(R.id.viewCategory);
        sendBtn = findViewById(R.id.sendBtn);
        pinnedSwitch = findViewById(R.id.switch10);
        titlePostEdt = findViewById(R.id.titlePostEdt);
        categoryBtn = findViewById(R.id.categoryBtn);
        dastresiBtn = findViewById(R.id.dastresiBtn);
        toggle_category = findViewById(R.id.sub_toggle_button_category);
        toggle_dastresi = findViewById(R.id.sub_toggle_button_dastresi);
        toggle_icon = findViewById(R.id.sub_toggle_button_icon);
        iconBtn = findViewById(R.id.iconBtn);
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

        adapterAttach = new AttachAdapter(array_object, new AttachAdapter.deleteAttachCallBack() {
            @Override
            public void position(int num) {
                params.remove("file<<" + (num + 1) + ">>");

                Log.i(TAG, "params: " + params.toString());
            }
        });
        recyclerViewlistAttach.setAdapter(adapterAttach);


        //for dastresi
        adapterDastresi = new DastresiAdapter(array_objectDastresi, new DastresiAdapter.SelectCallBack() {
            @Override
            public void Id(int num) {
                params.put("accessType", num);
            }
        });
        recyclerViewlistDastresi.setAdapter(adapterDastresi);


        //for category
        adapterCategory = new DastresiAdapter(array_objectCategory, new DastresiAdapter.SelectCallBack() {
            @Override
            public void Id(int num) {
                params.put("Category", num);
            }
        });
        recyclerViewlistCategory.setAdapter(adapterCategory);
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
            adapterAttach.notifyDataSetChanged();
            params.put("file<<" + attachFiles.size() + ">>", new File(selectedFilePath));

            Log.i(TAG, "onActivityResult: " + params.toString());
        } else if (requestCode == 1) {
            if (data == null) {
                return;
            }
            Uri selectedImage = data.getData();

            selectedFilePath = FilePath.getPath(this, selectedImage);
            attachFiles.add(new AttachFile(selectedFilePath, "1", "1"));
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

        view3.setVisibility(View.VISIBLE);

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
            Intent intent = new Intent(SendPostActivity.this, Main4Activity.class);
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
    }
}