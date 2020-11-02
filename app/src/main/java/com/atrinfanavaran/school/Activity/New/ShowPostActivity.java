package com.atrinfanavaran.school.Activity.New;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atrinfanavaran.school.Adapter.New.ShowPostAttachAdapter;
import com.atrinfanavaran.school.Adapter.New.ShowPostMediaAdapter;
import com.atrinfanavaran.school.Domain.New.ShowPost;
import com.atrinfanavaran.school.Fragment.NavigationDrawerFragment;
import com.atrinfanavaran.school.Interface.PlayerCallBackMusic;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.R;

import java.util.ArrayList;

public class ShowPostActivity extends BaseActivity {

    private static final int Time_Between_Two_Back = 2000;
    private long TimeBackPressed;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_post);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);


        initView();
//        media();
//        timing();
        NavigationDrawer();

        setVariable();
        attachFiles = attach1();

        getDataApi2(attachFiles, false);
    }

    private void setVariable() {
        linearLayoutManagerAttach = new LinearLayoutManager(this);
        recyclerViewlistAttach.setLayoutManager(linearLayoutManagerAttach);

        linearLayoutManagerMedia = new LinearLayoutManager(this);
        recyclerViewlistMedia.setLayoutManager(linearLayoutManagerMedia);

    }

    private ArrayList<ShowPost> attach1() {

        ArrayList<ShowPost> array_object = new ArrayList<>();
        array_object.add(new ShowPost("تست", "1", null, null, null, null));
        array_object.add(new ShowPost(" تست2 ", "1", null, null, null, null));
        array_object.add(new ShowPost("test2", "2", "23:12", "15 MB", "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4", null));
        array_object.add(new ShowPost("test3", "3", "24:20", "13 MB", "https://dls.music-fa.com/tagdl/downloads/Shahab%20Mozaffari%20-%20Setayesh%20(128).mp3", null));
        array_object.add(new ShowPost("test3-1", "3", "23:20", "19 MB", "https://dls.music-fa.com/tagdl/99/Ayhan%20Bazzazi%20-%20Divoone%20(128).mp3", null));
        array_object.add(new ShowPost("تمرین 1", "4", null, "24 MB", "http://skanapp.ir/backup.zip", "backup.zip"));
        array_object.add(new ShowPost("تمرین 2", "4", null, "24 MB", "http://skanapp.ir/help.html", "help.html"));

        return array_object;
    }


    private void initView() {

        my_toolbar = findViewById(R.id.toolbar);
        recyclerViewlistAttach = findViewById(R.id.viewAttach);
        recyclerViewlistMedia = findViewById(R.id.viewMedia);
        Text = findViewById(R.id.Text);
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
        for (int i = 0; i < array_object.size(); i++) {
            if (array_object.get(i).getType().equals("1")) {
                Text.append(array_object.get(i).getTitle());
            }
        }

        ArrayList<ShowPost> arrayMedia = new ArrayList<>();
        for (int i = 0; i < array_object.size(); i++) {
            if (array_object.get(i).getType().equals("2") || (array_object.get(i).getType().equals("3"))) {
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
            if (array_object.get(i).getType().equals("4")) {
                arrayAttach.add(array_object.get(i));
            }
        }
        adapterAttach = new ShowPostAttachAdapter(arrayAttach);
        recyclerViewlistAttach.setAdapter(adapterAttach);


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


}