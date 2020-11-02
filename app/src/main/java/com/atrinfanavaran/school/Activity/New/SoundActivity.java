package com.atrinfanavaran.school.Activity.New;

import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.atrinfanavaran.school.R;

import java.util.concurrent.TimeUnit;

public class SoundActivity extends AppCompatActivity {


    private int position, List;
    private MediaPlayer medPlayer;
    private Button playBtn;
    private TextView timeTxt;
    private SeekBar seekBar;


    private Handler mHandler = new Handler();
    private int mFileDuration;
    private boolean translate = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        initview();

        setVariable();
        media();
        timing();
    }

    private void setVariable() {
//        SettingBtn.setOnClickListener(view -> startActivity(new Intent(SoundActivity.this, SettingsActivity.class)));
    }


    private void timing() {
        this.mFileDuration = this.medPlayer.getDuration();
        this.seekBar.setMax(this.mFileDuration / 1000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        medPlayer.pause();
//        Toast.makeText(SoundActivity.this, "موزیک موقتا متوقف شد", Toast.LENGTH_SHORT).show();
        playBtn.setBackgroundResource(R.mipmap.plus_list);
    }

    private void setup() {
        seekBar.setMax(mFileDuration / 1000);
        String time = String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(medPlayer.getDuration()),
                TimeUnit.MILLISECONDS.toSeconds(medPlayer.getDuration()) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(medPlayer.getDuration()))
        );

        timeTxt.setText("00:00/" + time);
    }

    private void media() {
//        ScrollToPosition scrollToPosition = new ScrollToPosition(recyclerView, response, adapter);

        seekBar.setRotation(180);
        if (medPlayer == null) {

//            medPlayer = MediaPlayer.create(this, Uri.parse("https://dls.music-fa.com/tagdl/99/Ayhan%20Bazzazi%20-%20Divoone%20(128).mp3"));
            medPlayer = MediaPlayer.create(this, Uri.parse("https://dls.music-fa.com/tagdl/downloads/Shahab%20Mozaffari%20-%20Setayesh%20(128).mp3"));
            medPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        }
        setup();
//        medPlayer.setLooping(true);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!medPlayer.isPlaying()) {

//                    medPlayer.start();
                    SharedPreferences sp = getApplicationContext().getSharedPreferences("Token", 0);
                    float speed = sp.getFloat("speed", 1.0f);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        medPlayer.setPlaybackParams(medPlayer.getPlaybackParams().setSpeed(speed));
                    }
                    medPlayer.start();
                    Toast.makeText(SoundActivity.this, "صوت در حال پخش", Toast.LENGTH_SHORT).show();
                    playBtn.setBackgroundResource(R.mipmap.add);


                    //Make sure you update Seekbar on UI thread
                    SoundActivity.this.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            if (medPlayer != null && medPlayer.isPlaying()) {

                                int mCurrentPosition = medPlayer.getCurrentPosition() / 1000;
//                                Log.i("moh3n", "run: " + mCurrentPosition);
                                seekBar.setProgress(mCurrentPosition);

                                if (sp.getBoolean("scrollToPosition", true)) {
                                    if (!translate) {
//                                        scrollToPosition.GoTo(scrollToPosition.getPosFromSound(mCurrentPosition));
                                    }
                                }
                            }
//                            mHandler.postDelayed(this, 1000);

                            String time = String.format("%02d:%02d",
                                    TimeUnit.MILLISECONDS.toMinutes(medPlayer.getDuration()),
                                    TimeUnit.MILLISECONDS.toSeconds(medPlayer.getDuration()) -
                                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(medPlayer.getDuration()))
                            );
                            String time2 = String.format("%02d:%02d",
                                    TimeUnit.MILLISECONDS.toMinutes(medPlayer.getCurrentPosition()),
                                    TimeUnit.MILLISECONDS.toSeconds(medPlayer.getCurrentPosition()) -
                                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(medPlayer.getCurrentPosition()))
                            );

                            timeTxt.setText(time2 + "/" + time);

                            // Running this thread after 100 milliseconds
                            mHandler.postDelayed(this, 100);

                        }
                    });
                } else {
                    medPlayer.pause();
//                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
//
//                        medPlayer.reset();
//
//                    }
                    Toast.makeText(SoundActivity.this, "صوت متوقف شد", Toast.LENGTH_SHORT).show();
                    playBtn.setBackgroundResource(R.mipmap.plus_list);
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (medPlayer != null && fromUser) {
                    medPlayer.seekTo(progress * 1000);
                }
            }
        });

    }


    private void initview() {

        playBtn = findViewById(R.id.playBtn);
        timeTxt = findViewById(R.id.timeTxt);
        seekBar = findViewById(R.id.seekBar);


    }
}