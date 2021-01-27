package com.atrinfanavaran.school.Activity.New;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atrinfanavaran.school.Adapter.New.ShowPostAttachAdapter;
import com.atrinfanavaran.school.Adapter.New.ShowPostMediaAdapter;
import com.atrinfanavaran.school.Domain.New.EducationPost;
import com.atrinfanavaran.school.Domain.New.GetTotalComment;
import com.atrinfanavaran.school.Domain.New.ShowPost;
import com.atrinfanavaran.school.Fragment.NavigationDrawerFragment;
import com.atrinfanavaran.school.Interface.PlayerCallBackMusic;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGetString;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackOperation;
import com.atrinfanavaran.school.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringEscapeUtils.unescapeHtml4;

public class ShowPostActivity extends BaseActivity {


    private Toolbar my_toolbar;
    private LinearLayoutManager linearLayoutManagerAttach;
    private LinearLayoutManager linearLayoutManagerMedia;
    private RecyclerView recyclerViewlistAttach;
    private RecyclerView recyclerViewlistMedia;
    private RecyclerView.Adapter adapterMedia;
    private RecyclerView.Adapter adapterAttach;
    ArrayList<ShowPost> attachFiles = new ArrayList<>();
    private TextView Text;

    //for sound player
    private Handler mHandler = new Handler();
    private int mFileDuration;
    private boolean translate = true;
    private MediaPlayer medPlayerActivity;
    private ImageView PlayBtn;
    private ScrollView scrollView;
    private ImageView icon;
    private TextView title, CountView, countComment;
    private int id;
    private ProgressBar progressBar;
    private LinearLayout commentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_post);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        getBundle();
        initView();
//        media();
//        timing();
        NavigationDrawer();

        setVariable();
        attach1();
        bottomView();
        setToolbar();
        StudentAddView();
        getCommentCount() ;
    }

    private void StudentAddView() {
        JSONObject params = new JSONObject();
        try {
            params.put("UserId", settingsBll().getApplicationUserId());
            params.put("EducationPostId", id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "StudentAddView: " + params.toString());
        controller().operationProcess(ShowPostActivity.this, "Api/EducationPost/StudentAddView", params.toString(), new CallbackOperation() {
            @Override
            public void onSuccess(String result) {
                Log.i(TAG, "StudentAddView: " + result);
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    private void setToolbar() {
        TextView titleToolbar = findViewById(R.id.titleToolbar);
        titleToolbar.setText(settingsBll().getSchoolName());
    }

    private void getBundle() {
        id = getIntent().getIntExtra("Id", 0);
//        id = 1032;
    }

    private void setVariable() {
        linearLayoutManagerAttach = new LinearLayoutManager(this);
        recyclerViewlistAttach.setLayoutManager(linearLayoutManagerAttach);

        linearLayoutManagerMedia = new LinearLayoutManager(this);
        recyclerViewlistMedia.setLayoutManager(linearLayoutManagerMedia);


        commentBtn.setOnClickListener(v -> {
            if (settingsBll.getUserType() == 1) {
                Intent intent = new Intent(ShowPostActivity.this, ListCommentTeacherActivity.class);
                intent.putExtra("EducationPostId", id);
                startActivity(intent);
            } else if (settingsBll.getUserType() == 2) {
                Intent intent = new Intent(ShowPostActivity.this, ListCommentActivity.class);
                intent.putExtra("EducationPostId", id);
                startActivity(intent);
            }
        });
    }

    private ArrayList<ShowPost> attach1() {
        progressBar.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);
        ArrayList<ShowPost> array_object = new ArrayList<>();
        SettingsBll settingsBll = new SettingsBll(this);
        controller().GetFromApi2("api/EducationPost/GetById?Id=" + id, new CallbackGetString() {
            @Override
            public void onSuccess(String resultStr) {
                Log.i(TAG, "onSuccess1: " + resultStr);
                try {
                    Gson gson = new Gson();

                    EducationPost educationPost = gson.fromJson(resultStr, EducationPost.class);
                    Log.i(TAG, "onSuccess2: " + educationPost.getData().getIconUrl());


                    title.setText(educationPost.getData().getTitle());
                    CountView.setText("بازدید: " + educationPost.getData().getViewCount());
                    RequestOptions requestOptions = new RequestOptions();

                    requestOptions.placeholder(R.mipmap.logo);
                    requestOptions.error(R.mipmap.logo);


                    Glide.with(getActivity())
                            .setDefaultRequestOptions(requestOptions)
                            .load(settingsBll.getUrlAddress() + "/" + educationPost.getData().getIconUrl())
                            .into(icon);

                    ArrayList<EducationPost.Data.Medias> res = educationPost.getData().getMedias();

                    if (res != null && res.size() > 0) {
                        Log.i(TAG, "onSuccess3: " + res.get(0).getMediaType());


                        array_object.add(new ShowPost(educationPost.getData().getDescription(), "1", null, null, null, null));

                        for (int i = 0; i < res.size(); i++) {
                            if (res.get(i).getMediaType() == 4) {
                                String durationTime = "--:--";
                                if (res.get(i).getDurationTime() != null) {
                                    if (res.get(i).getDurationTime().contains(".")) {
                                        String[] split = res.get(i).getDurationTime().split(Pattern.quote("."));
                                        if (split.length > 0) {
                                            durationTime = split[0];
                                        }
                                    } else {
                                        durationTime = res.get(i).getDurationTime();
                                    }
                                }
                                array_object.add(new ShowPost(res.get(i).getTitle(), "4", durationTime, res.get(i).getLenght(), settingsBll.getUrlAddress() + res.get(i).getUrl().replace("../", "/"), null));
                            } else if (res.get(i).getMediaType() == 3) {
                                array_object.add(new ShowPost(res.get(i).getTitle(), "3", "", res.get(i).getLenght(), settingsBll.getUrlAddress() + res.get(i).getUrl().replace("../", "/"), null));
                            } else {
                                array_object.add(new ShowPost(res.get(i).getTitle(), "2", null, res.get(i).getLenght(), settingsBll.getUrlAddress() + res.get(i).getUrl().replace("../", "/"), res.get(i).getTitle()));
                            }
                        }
                    }
//                    array_object.add(new ShowPost("test2", "2", "23:12", "15 MB", "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4", null));
//                    array_object.add(new ShowPost("test3", "3", "24:20", "13 MB", "https://dls.music-fa.com/tagdl/downloads/Shahab%20Mozaffari%20-%20Setayesh%20(128).mp3", null));
//                    array_object.add(new ShowPost("test3-1", "3", "23:20", "19 MB", "https://dls.music-fa.com/tagdl/99/Ayhan%20Bazzazi%20-%20Divoone%20(128).mp3", null));
//                    array_object.add(new ShowPost("تمرین 1", "4", null, "24 MB", "http://skanapp.ir/backup.zip", "backup.zip"));
//                    array_object.add(new ShowPost("تمرین 2", "4", null, "24 MB", "http://skanapp.ir/help.html", "help.html"));

//                    attachFiles = attach1();
                    getDataApi2(array_object, false);
                    scrollView.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                } catch (Exception e) {
                    Log.i(TAG, "onSuccess4: " + e);
                }
            }

            @Override
            public void onError(String error) {

            }
        });


//        array_object.add(new ShowPost("تست", "1", null, null, null, null));
//        array_object.add(new ShowPost(" تست2 ", "1", null, null, null, null));
//        array_object.add(new ShowPost("test2", "2", "23:12", "15 MB", "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4", null));
//        array_object.add(new ShowPost("test3", "3", "24:20", "13 MB", "https://dls.music-fa.com/tagdl/downloads/Shahab%20Mozaffari%20-%20Setayesh%20(128).mp3", null));
//        array_object.add(new ShowPost("test3-1", "3", "23:20", "19 MB", "https://dls.music-fa.com/tagdl/99/Ayhan%20Bazzazi%20-%20Divoone%20(128).mp3", null));
//        array_object.add(new ShowPost("تمرین 1", "4", null, "24 MB", "http://skanapp.ir/backup.zip", "backup.zip"));
//        array_object.add(new ShowPost("تمرین 2", "4", null, "24 MB", "http://skanapp.ir/help.html", "help.html"));

        return array_object;
    }


    private void initView() {

        my_toolbar = findViewById(R.id.toolbar);
        recyclerViewlistAttach = findViewById(R.id.viewAttach);
        recyclerViewlistMedia = findViewById(R.id.viewMedia);
        Text = findViewById(R.id.Text);
        scrollView = findViewById(R.id.scrollView2);
        icon = findViewById(R.id.icon);
        title = findViewById(R.id.titleTxt);
        progressBar = findViewById(R.id.progressBarRow3);
        CountView = findViewById(R.id.CountView);
        commentBtn = findViewById(R.id.commentBtn);
        countComment = findViewById(R.id.textView19);
    }

    private void NavigationDrawer() {

        NavigationDrawerFragment my_nav = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        my_nav.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), my_toolbar);

    }

    @Override
    public void onBackPressed() {

        finish();
    }

    private void getDataApi2(ArrayList<ShowPost> array_object, boolean notify) {


        for (int i = 0; i < array_object.size(); i++) {
            if (array_object.get(i).getType().equals("1")) {
                String escaped = unescapeHtml4("<html><body > <head></head>" + java.net.URLDecoder.decode(array_object.get(i).getTitle().replace("null", "-")) + "  </body><html>");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Text.append(Html.fromHtml(escaped, Html.FROM_HTML_MODE_COMPACT));
                } else {
                    Text.append(Html.fromHtml(escaped));
                }
            }
        }

        ArrayList<ShowPost> arrayMedia = new ArrayList<>();
        for (int i = 0; i < array_object.size(); i++) {
            if (array_object.get(i).getType().equals("3") || (array_object.get(i).getType().equals("4"))) {
                arrayMedia.add(array_object.get(i));
            }
        }
        adapterMedia = new ShowPostMediaAdapter(arrayMedia, new PlayerCallBackMusic() {
            @Override
            public void play(MediaPlayer medPlayer, ImageView playBtn, TextView timeTxt, SeekBar seekBar) {
                medPlayerActivity = medPlayer;
                PlayBtn = playBtn;
            }
        });
        recyclerViewlistMedia.setAdapter(adapterMedia);

        ArrayList<ShowPost> arrayAttach = new ArrayList<>();
        for (int i = 0; i < array_object.size(); i++) {
            if (array_object.get(i).getType().equals("2")) {
                arrayAttach.add(array_object.get(i));
            }
        }
        adapterAttach = new ShowPostAttachAdapter(arrayAttach);
        recyclerViewlistAttach.setAdapter(adapterAttach);


    }

    private void getCommentCount() {
        controller().GetFromApi2("api/EducationPost/GetTotalComment?Id=" + id, new CallbackGetString() {
            @Override
            public void onSuccess(String resultStr) {
                try {
                    GetTotalComment getTotalComment = gson().fromJson(resultStr, GetTotalComment.class);
                    countComment.setText("نظر:" + getTotalComment.getData());

                } catch (Exception e) {
                    Log.i(TAG, "onSuccessException: " + e);
                }
            }

            @Override
            public void onError(String error) {
                Toast.makeText(ShowPostActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (medPlayerActivity != null) {
            medPlayerActivity.pause();
//        Toast.makeText(SoundActivity.this, "موزیک موقتا متوقف شد", Toast.LENGTH_SHORT).show();
            PlayBtn.setImageResource(R.mipmap.play_icon);
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

        view4.setVisibility(View.VISIBLE);

        btn1.setOnClickListener(v -> {
            Intent intent = new Intent(ShowPostActivity.this, Main1Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(ShowPostActivity.this, Main2Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn3.setOnClickListener(v -> {
            Intent intent = new Intent(ShowPostActivity.this, Main3Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn4.setOnClickListener(v -> {
            Intent intent = new Intent(ShowPostActivity.this, ListPostActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            overridePendingTransition(0, 0); //0 for no animation
        });
        btn5.setOnClickListener(v -> {
            Intent intent = new Intent(ShowPostActivity.this, Main5Activity.class);
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