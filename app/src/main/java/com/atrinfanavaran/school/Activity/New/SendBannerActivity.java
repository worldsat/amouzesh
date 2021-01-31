package com.atrinfanavaran.school.Activity.New;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alirezaafkar.sundatepicker.DatePicker;
import com.alirezaafkar.sundatepicker.components.DateItem;
import com.atrinfanavaran.school.Adapter.New.AttachBannerAdapter;
import com.atrinfanavaran.school.Adapter.New.CategoryAdapter;
import com.atrinfanavaran.school.Adapter.New.PositionAdapter;
import com.atrinfanavaran.school.Adapter.New.PostMiniListAdapter;
import com.atrinfanavaran.school.Domain.New.AttachFile;
import com.atrinfanavaran.school.Domain.New.BannerGetAll;
import com.atrinfanavaran.school.Domain.New.DropdownList;
import com.atrinfanavaran.school.Domain.New.EducationPostGetAll;
import com.atrinfanavaran.school.Fragment.NavigationDrawerFragment;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Controller;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGetString;
import com.atrinfanavaran.school.Kernel.Controller.Interface.IOnResponseListener;
import com.atrinfanavaran.school.Kernel.Helper.FilePath;
import com.atrinfanavaran.school.Kernel.Helper.roozh;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import top.defaults.colorpicker.ColorPickerPopup;

import static org.apache.commons.lang3.StringEscapeUtils.unescapeHtml4;

public class SendBannerActivity extends BaseActivity {

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
    private RecyclerView recyclerViewlistPostion;
    private RecyclerView.Adapter adapterAttach;
    private RecyclerView.Adapter adapterPost;
    private RecyclerView.Adapter adapterCategory;
    private RecyclerView.Adapter adapterposition;
    private ArrayList<AttachFile> attachFiles = new ArrayList<>();
    private ArrayList<DropdownList> PostList = new ArrayList<>();
    private ArrayList<DropdownList> CategoryList = new ArrayList<>();
    private ArrayList<DropdownList> positionList = new ArrayList<>();
    private LinearLayout addAttachFile;
    private HashMap<String, Object> params = new HashMap<>();
    private LinearLayout sendBtn;
    private Switch pinnedSwitch;
    private EditText socialNetworkPostEdt;
    private Editor editor;
    private LinearLayout PostListBtn, CategoryListBtn, positionBtn, layoutShowTime, timeBtn;
    private ImageView toggle_category, toggle_dastresi, toggle_icon, toggle_position, toggle_time;
    private BannerGetAll.Data object;
    private EditText dayShowBanner;
    private ConstraintLayout calendarBtn;
    private TextView dateShowTime;
    private ArrayList<Integer> PostSelectIds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_banner);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);


        RunPermissionDownload();
        initView();
        EditorWYSIWYG();
        getBundle();
        NavigationDrawer();
        setVariable();

        attachFiles.addAll(attach1());
        PostList = PostList();
        CategoryList = CategoryList();
        positionList = PostionList();

        getDataApi2(attachFiles, PostList, CategoryList, positionList, false);

        sendData();
        defaultValue();
        bottomView();
        NavigationDrawer();
        showTime();
        setToolbar();
    }
    private void setToolbar() {
        TextView titleToolbar=findViewById(R.id.titleToolbar);
        titleToolbar.setText(settingsBll().getSchoolName());
    }
    private void showTime() {

    }

    @SuppressLint("SetTextI18n")
    private void getBundle() {
        object = (BannerGetAll.Data) getIntent().getSerializableExtra("object");
        if (object != null) {
            socialNetworkPostEdt.setText(object.getSocialNetWorkLink());
            dayShowBanner.setText("" + object.getCreditDays());
            String availables[] = object.getAvailableDate().split("T");
            if (availables != null && availables.length > 0) {
                roozh roozh = new roozh();
                String date[] = availables[0].split("-");
                if (date != null && date.length > 0) {
                    int day = Integer.parseInt(date[2]);
                    int month = Integer.parseInt(date[1]);
                    int year = Integer.parseInt(date[0]);
                    roozh.GregorianToPersian(year, month, day);
                    dateShowTime.setText(roozh.getYear() + "-" + roozh.getMonth() + "-" + roozh.getDay());
                }
            }

            String escaped = unescapeHtml4(java.net.URLDecoder.decode(object.getDescription().replace("null", "-")));

            editor.render(escaped);
            pinnedSwitch.setChecked(object.isShowOnMainPage());
            if (object.getUrl() != null) {
                String file[] = object.getUrl().split("-");
                if (file != null && file.length > 0) {
                    attachFiles.add(new AttachFile(file[(file.length - 1)], String.valueOf(object.getId()), ""));
                }
            }

        }
    }

    private void defaultValue() {


        if (object != null) {
            params.put("id", object.getId());
            params.put("BannerPlace", object.getBannerPlace());
            params.put("AvailableDate", object.getAvailableDate());
        }
    }

    private void sendData() {


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (params.get("AvailableDate") == null) {
                    Toast.makeText(SendBannerActivity.this, "لطفا تاریخ نمایش بنر را مشخص نمائید", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!dayShowBanner.getText().toString().trim().isEmpty()) {
                    params.put("CreditDays", Integer.valueOf(dayShowBanner.getText().toString()));
                } else {
                    Toast.makeText(SendBannerActivity.this, "لطفا تعداد روز نمایش بنر را مشخص نمائید", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (params.get("CreditDays") == null) {
                    Toast.makeText(SendBannerActivity.this, "لطفا تعداد روز نمایش بنر را مشخص نمائید", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!socialNetworkPostEdt.getText().toString().trim().isEmpty()) {
                    if (params.get("bannerToPosts") == null && params.get("categoryId") == null) {
                        params.put("SocialNetWorkLink", socialNetworkPostEdt.getText().toString());
                    } else {
                        Toast.makeText(SendBannerActivity.this, "به دلیل درج اطلاعات شبکه اجتماعی، بایستی موارد انتخابی مربوط به لینک به پست و یا لینک به دسته بندی را حذف نمائید", Toast.LENGTH_LONG).show();
                        return;
                    }
                }


                if (pinnedSwitch.isChecked()) {
                    params.put("ShowOnMainPage", true);
                } else {
                    params.put("ShowOnMainPage", false);
                }
                SettingsBll settingsBll = new SettingsBll(SendBannerActivity.this);
                params.put("Description", StringEscapeUtils.escapeHtml4(editor.getContentAsHTML()));
                params.put("ApplicationUserId", settingsBll.getApplicationUserId());

                Controller controller = new Controller(SendBannerActivity.this);

//                settingsBll.setTicket("rewrwerewrrsggeetsdgffdgfdgfdgf");

                Log.i(TAG, "onActivityResult22: " + params.toString().replaceAll("<<.*>>", ""));

                controller.uploadFileNew(SendBannerActivity.this, "api/Banner/Add", null, params, new IOnResponseListener() {
                    @Override
                    public void onResponse(String response) {
//                        Toast.makeText(SendPostActivity.this, "ok", Toast.LENGTH_SHORT).show();
//                waiting.dismiss();

                        finish();
                        Intent intent = new Intent(SendBannerActivity.this, ListBannerActivity.class);
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

        recyclerViewlistPostion.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewlistPostion.setNestedScrollingEnabled(false);

        recyclerViewlistCategory.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewlistCategory.setNestedScrollingEnabled(false);

        calendarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                    dateShowTime.setText(year + "-" + month + "-" + day);


                    roozh roozh = new roozh();
                    roozh.PersianToGregorian(year, month, day);

                    String month2 = "";
                    if (roozh.getMonth() < 10) {
                        month2 = "0" + roozh.getMonth();
                    } else {
                        month2 = String.valueOf(roozh.getMonth());
                    }

                    String day2 = "";
                    if (roozh.getDay() < 10) {
                        day2 = "0" + roozh.getDay();
                    } else {
                        day2 = String.valueOf(roozh.getDay());
                    }

                    params.put("AvailableDate", roozh.getYear() + "-" + month2 + "-" + day2);

                }).show(getActivity().getSupportFragmentManager(), "");
            }
        });

        addAttachFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (attachFiles.size() > 0) {
                    Toast.makeText(SendBannerActivity.this, "حداکثر یه فایل قابل انتخاب است", Toast.LENGTH_SHORT).show();
                    return;
                }
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

        PostListBtn.setOnClickListener(v -> {
            if (!socialNetworkPostEdt.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "لطفا جهت انتخاب پست، اقدام به حذف متن شبکه های اجتماعی کنید", Toast.LENGTH_SHORT).show();
                return;
            }
            if (recyclerViewlistDastresi.getVisibility() == (View.VISIBLE)) {
                recyclerViewlistDastresi.setVisibility(View.GONE);
                toggle_dastresi.setImageResource(R.drawable.ic_expand_less);
            } else {
                recyclerViewlistDastresi.setVisibility(View.VISIBLE);
                toggle_dastresi.setImageResource(R.drawable.ic_expand_more);
            }
        });
        CategoryListBtn.setOnClickListener(v -> {
            if (!socialNetworkPostEdt.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "لطفا جهت انتخاب پست، اقدام به حذف متن شبکه های اجتماعی کنید", Toast.LENGTH_SHORT).show();
                return;
            }

            if (recyclerViewlistCategory.getVisibility() == (View.VISIBLE)) {
                recyclerViewlistCategory.setVisibility(View.GONE);
                toggle_category.setImageResource(R.drawable.ic_expand_less);
            } else {
                recyclerViewlistCategory.setVisibility(View.VISIBLE);
                toggle_category.setImageResource(R.drawable.ic_expand_more);
            }
        });

        positionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerViewlistPostion.getVisibility() == (View.VISIBLE)) {
                    recyclerViewlistPostion.setVisibility(View.GONE);
                    toggle_position.setImageResource(R.drawable.ic_expand_less);
                } else {
                    recyclerViewlistPostion.setVisibility(View.VISIBLE);
                    toggle_position.setImageResource(R.drawable.ic_expand_more);
                }
            }
        });
        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layoutShowTime.getVisibility() == (View.VISIBLE)) {
                    layoutShowTime.setVisibility(View.GONE);
                    toggle_time.setImageResource(R.drawable.ic_expand_less);
                } else {
                    layoutShowTime.setVisibility(View.VISIBLE);
                    toggle_time.setImageResource(R.drawable.ic_expand_more);
                }
            }
        });
        socialNetworkPostEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (params.get("bannerToPosts") != null) {
                    Toast.makeText(SendBannerActivity.this, "لطفا موارد انتخابی مربوط به لینک به پست و یا لینک به دسته بندی را حذف نمائید", Toast.LENGTH_SHORT).show();
                    if (s.length() != 0) {
                        socialNetworkPostEdt.removeTextChangedListener(this);
                        socialNetworkPostEdt.setText("");
                        socialNetworkPostEdt.addTextChangedListener(this);
                    }
                }
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


    private ArrayList<DropdownList> PostList() {

        ArrayList<DropdownList> array_object = new ArrayList<>();
//        array_object.add(new DropdownList("رایگان", 0, true));
//        array_object.add(new DropdownList("شامل هزینه", 1, false));
        controller().GetFromApi2("api/EducationPost/GetAll?Id=" + settingsBll().getApplicationUserId(), new CallbackGetString() {
            @Override
            public void onSuccess(String resultStr) {
                EducationPostGetAll educationPostGetAll = gson().fromJson(resultStr, EducationPostGetAll.class);
                for (int i = 0; i < educationPostGetAll.getData().size(); i++) {
                    boolean tick = false;
//                    if (i == 0) tick = true;
                    array_object.add(new DropdownList(
                            educationPostGetAll.getData().get(i).getTitle()
                            , educationPostGetAll.getData().get(i).getId(),
                            tick));
                }
            }

            @Override
            public void onError(String error) {
                Toast.makeText(SendBannerActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        });
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

    private ArrayList<DropdownList> PostionList() {

        ArrayList<DropdownList> array_object = new ArrayList<>();
        array_object.add(new DropdownList("بالا", 0, true));
        array_object.add(new DropdownList("پایین", 1, false));

        return array_object;
    }

    private void initView() {

        my_toolbar = findViewById(R.id.toolbar);
        addAttachFile = findViewById(R.id.addAttachFile);

        recyclerViewlistAttach = findViewById(R.id.viewAttach);
        recyclerViewlistDastresi = findViewById(R.id.viewDastresi);
        recyclerViewlistCategory = findViewById(R.id.viewCategory);
        recyclerViewlistPostion = findViewById(R.id.viewPostion);
        sendBtn = findViewById(R.id.sendBtn);
        pinnedSwitch = findViewById(R.id.switch10);
        socialNetworkPostEdt = findViewById(R.id.socialEdt);
        PostListBtn = findViewById(R.id.dastresiBtn);
        CategoryListBtn = findViewById(R.id.categoryBtn);
        positionBtn = findViewById(R.id.positionBtn);
        toggle_category = findViewById(R.id.sub_toggle_button_category);
        toggle_dastresi = findViewById(R.id.sub_toggle_button_dastresi);
        toggle_position = findViewById(R.id.sub_toggle_button_position);
        toggle_time = findViewById(R.id.sub_toggle_button_time);
        toggle_icon = findViewById(R.id.sub_toggle_button_icon);
        layoutShowTime = findViewById(R.id.layoutShowTime);
        timeBtn = findViewById(R.id.timeBtn);
        dayShowBanner = findViewById(R.id.dayShowBanner);
        calendarBtn = findViewById(R.id.icon_background);
        dateShowTime = findViewById(R.id.dateShowTime);

    }

    private void NavigationDrawer() {

        NavigationDrawerFragment my_nav = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        my_nav.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), my_toolbar);

    }


    private void RunPermissionDownload() {

        Dexter.withActivity(getActivity())
                .withPermissions(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE


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
              ,  Manifest.permission.READ_EXTERNAL_STORAGE
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


    private void getDataApi2(ArrayList<AttachFile> array_object, ArrayList<DropdownList> array_objectPost, ArrayList<DropdownList> array_objectCategory, ArrayList<DropdownList> array_objectPostion, boolean notify) {

        adapterAttach = new AttachBannerAdapter(array_object, new AttachBannerAdapter.deleteAttachCallBack() {
            @Override
            public void position(int num) {
                params.remove("file<<" + (num + 1) + ">>");

                Log.i(TAG, "params: " + params.toString());
            }
        });
        recyclerViewlistAttach.setAdapter(adapterAttach);


        //for dastresi
//        if (object != null) {
//            for (int i = 0; i < array_objectPost.size(); i++) {
//                if (array_objectPost.get(i).getListId() == object.getBannerToPosts().get()) {
//                    array_objectPost.get(i).setTick(true);
//                } else {
//                    array_objectPost.get(i).setTick(false);
//                }
//            }
//        }
        adapterPost = new PostMiniListAdapter(array_objectPost, object, new PostMiniListAdapter.SelectCallBack() {
            @Override
            public void Id(int num, boolean allSelect) {

                if (PostSelectIds.contains(num)) {
                    for (int i = 0; i < PostSelectIds.size(); i++) {
                        if (PostSelectIds.get(i) == num) {
                            PostSelectIds.remove(i);
                            break;
                        }
                    }
                } else {
                    PostSelectIds.add(num);
                }

                Log.i(TAG, "bannerToPostsId: " +PostSelectIds.toString().replace(" ", "").replace("]", "").replace("[", ""));
                if (PostSelectIds.size() > 0) {
                    params.put("bannerToPosts", PostSelectIds.toString().replace(" ", "").replace("]", "").replace("[", ""));
                } else {
                    if (params.get("bannerToPosts") != null) {
                        params.remove("bannerToPosts");
                    }
                }
                Log.i(TAG, "bannerToPosts: "+params.get("bannerToPosts") );
            }
        });
        recyclerViewlistDastresi.setAdapter(adapterPost);


        //for position
        if (object != null) {
            for (int i = 0; i < array_objectPostion.size(); i++) {
                if (array_objectPostion.get(i).getListId() == object.getBannerPlace()) {
                    array_objectPostion.get(i).setTick(true);
                } else {
                    array_objectPostion.get(i).setTick(false);
                }
            }
        }
        adapterposition = new PositionAdapter("", array_objectPostion, object, new PositionAdapter.SelectCallBack() {
            @Override
            public void Id(int num) {
                params.put("BannerPlace", num);
            }
        });
        recyclerViewlistPostion.setAdapter(adapterposition);


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
        adapterCategory = new CategoryAdapter("Category", array_objectCategory, object, new CategoryAdapter.SelectCallBack() {
            @Override
            public void Id(int num) {
                params.put("CategoryId", num);
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
            attachFiles.add(new AttachFile(selectedFilePath, "null", "1"));
            adapterAttach.notifyDataSetChanged();
            params.put("file<<" + attachFiles.size() + ">>", new File(selectedFilePath));

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
                new ColorPickerPopup.Builder(SendBannerActivity.this)
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
            Intent intent = new Intent(SendBannerActivity.this, ProfileActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(SendBannerActivity.this, Main2Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn3.setOnClickListener(v -> {
            Intent intent = new Intent(SendBannerActivity.this, Main3Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn4.setOnClickListener(v -> {
            Intent intent = new Intent(SendBannerActivity.this, ListPostActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn5.setOnClickListener(v -> {
            Intent intent = new Intent(SendBannerActivity.this,BookmarkListActivity.class);
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