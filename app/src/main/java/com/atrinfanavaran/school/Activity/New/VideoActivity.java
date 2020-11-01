package com.atrinfanavaran.school.Activity.New;



import android.os.Bundle;

import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.R;



public class VideoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
//
//        MyJzvdStd jzvdStd = (MyJzvdStd) findViewById(R.id.jz_video);
//        jzvdStd.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
//                , "饺子闭眼睛");
//        jzvdStd.posterImageView.setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
    }
//    @Override
//    public void onBackPressed() {
//        if (Jzvd.backPress()) {
//            return;
//        }
//        super.onBackPressed();
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Jzvd.releaseAllVideos();
//    }
}