package com.atrinfanavaran.school.Interface;

import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public interface PlayerCallBackMusic {
    void play(MediaPlayer medPlayer, ImageView playBtn, TextView timeTxt, SeekBar seekBar);
}
