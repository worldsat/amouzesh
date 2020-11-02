package com.atrinfanavaran.school.Adapter.New;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.atrinfanavaran.school.Activity.New.VideoActivity;
import com.atrinfanavaran.school.Domain.New.ShowPost;
import com.atrinfanavaran.school.Interface.PlayerCallBackMusic;
import com.atrinfanavaran.school.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ShowPostMediaAdapter extends RecyclerView.Adapter<ShowPostMediaAdapter.ViewHolder> {

    private final ArrayList<ShowPost> array_object;
    private Context context;
    private PlayerCallBackMusic playerCallBackMusic;

    private Handler mHandler = new Handler();
    private int mFileDuration;

    public ShowPostMediaAdapter(ArrayList<ShowPost> result, PlayerCallBackMusic playerCallBackMusic) {
        this.array_object = result;
        this.playerCallBackMusic = playerCallBackMusic;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_video_play, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        MediaPlayer medPlayer = new MediaPlayer();
        context = holder.itemView.getContext();
        holder.title.setText(array_object.get(position).getTitle());
        holder.time.setText(array_object.get(position).getTime());
        holder.size.setText(array_object.get(position).getSize());

        if (array_object.get(position).getType().equals("2")) {
            holder.icon.setImageResource(R.mipmap.play_video_media);
        } else if (array_object.get(position).getType().equals("3")) {
            holder.icon.setImageResource(R.mipmap.play_sound_media);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (array_object.get(position).getType().equals("2")) {
                    Intent intent = new Intent(context, VideoActivity.class);
                    intent.putExtra("object", array_object.get(position));
                    context.startActivity(intent);

                } else if (array_object.get(position).getType().equals("3")) {

                    holder.progressBarSound.setVisibility(View.VISIBLE);
                    media(medPlayer, holder.seekBar, holder.timeTxt, holder.playBtn, array_object.get(position), holder.progressBarSound, holder.soundPlayerLayout);


                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return array_object == null ? 0 : array_object.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, time, size;
        ConstraintLayout card, deleteIcon;
        ImageView icon;
        private ImageView playBtn;
        private TextView timeTxt;
        private SeekBar seekBar;
        LinearLayout soundPlayerLayout;
        ProgressBar progressBarSound;

        private ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            time = itemView.findViewById(R.id.timeTxt);
            size = itemView.findViewById(R.id.sizeTxt);
            card = itemView.findViewById(R.id.item);
            deleteIcon = itemView.findViewById(R.id.icon_background);
            icon = itemView.findViewById(R.id.icon);
            playBtn = itemView.findViewById(R.id.playBtn);
            timeTxt = itemView.findViewById(R.id.timerTxt);
            seekBar = itemView.findViewById(R.id.seekBar);
            soundPlayerLayout = itemView.findViewById(R.id.soundPlayer);
            progressBarSound = itemView.findViewById(R.id.progressBarSound);


        }
    }

    ///for sound player
    private void timing(SeekBar seekBar, MediaPlayer medPlayer) {
        this.mFileDuration = medPlayer.getDuration();
        seekBar.setMax(this.mFileDuration / 1000);
    }

    private void setup(MediaPlayer medPlayer, SeekBar seekBar, TextView timeTxt) {
        seekBar.setMax(mFileDuration / 1000);
        String time = String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(medPlayer.getDuration()),
                TimeUnit.MILLISECONDS.toSeconds(medPlayer.getDuration()) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(medPlayer.getDuration()))
        );

        timeTxt.setText("00:00/" + time);
    }

    private void media(MediaPlayer medPlayer, SeekBar seekBar, TextView timeTxt, ImageView playBtn, ShowPost arrayObject, ProgressBar progressBar, LinearLayout soundPlayerLayout) {

        seekBar.setRotation(180);
        if (soundPlayerLayout.getVisibility() == View.VISIBLE) {
            soundPlayerLayout.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
            if (medPlayer.isPlaying()) {
                medPlayer.pause();
                playBtn.setImageResource(R.mipmap.play_icon);
                return;
            }
        }
//        if (medPlayer == null) {


//            medPlayer = MediaPlayer.create(context, Uri.parse(arrayObject.getLink()));
//            medPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//            MediaPlayer mediaPlayer = new MediaPlayer();

//            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
//                public boolean onError(MediaPlayer mp, int what, int extra) {
//                    mp.reset();
//                    Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
//                    return false;
//                }
//            });
//
        medPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mp) {

                timing(seekBar, mp);
                setup(mp, seekBar, timeTxt);
                MediaPlayer finalMedPlayer = mp;

                progressBar.setVisibility(View.GONE);
                soundPlayerLayout.setVisibility(View.VISIBLE);

                playBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        playerCallBackMusic.play(finalMedPlayer, playBtn, null, null);
                        if (!finalMedPlayer.isPlaying()) {

                            SharedPreferences sp = ((Activity) context).getApplicationContext().getSharedPreferences("Token", 0);
                            float speed = sp.getFloat("speed", 1.0f);
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                finalMedPlayer.setPlaybackParams(finalMedPlayer.getPlaybackParams().setSpeed(speed));
                            }
                            finalMedPlayer.start();
                            Toast.makeText(context, "صوت در حال پخش", Toast.LENGTH_SHORT).show();
                            playBtn.setImageResource(R.mipmap.pause_icon);


                            //Make sure you update Seekbar on UI thread
                            ((Activity) context).runOnUiThread(new Runnable() {

                                @Override
                                public void run() {
                                    if (finalMedPlayer != null && finalMedPlayer.isPlaying()) {

                                        int mCurrentPosition = finalMedPlayer.getCurrentPosition() / 1000;

                                        seekBar.setProgress(mCurrentPosition);
                                    }

                                    String time = String.format("%02d:%02d",
                                            TimeUnit.MILLISECONDS.toMinutes(finalMedPlayer.getDuration()),
                                            TimeUnit.MILLISECONDS.toSeconds(finalMedPlayer.getDuration()) -
                                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(finalMedPlayer.getDuration()))
                                    );
                                    String time2 = String.format("%02d:%02d",
                                            TimeUnit.MILLISECONDS.toMinutes(finalMedPlayer.getCurrentPosition()),
                                            TimeUnit.MILLISECONDS.toSeconds(finalMedPlayer.getCurrentPosition()) -
                                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(finalMedPlayer.getCurrentPosition()))
                                    );

                                    timeTxt.setText(time2 + "/" + time);

                                    // Running this thread after 100 milliseconds
                                    mHandler.postDelayed(this, 100);

                                }
                            });
                        } else {
                            finalMedPlayer.pause();

                            Toast.makeText(context, "صوت متوقف شد", Toast.LENGTH_SHORT).show();
                            playBtn.setImageResource(R.mipmap.play_icon);
                        }
                    }
                });
                MediaPlayer finalMedPlayer1 = mp;
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (finalMedPlayer1 != null && fromUser) {
                            finalMedPlayer1.seekTo(progress * 1000);
                        }
                    }
                });
            }
        });


        try {
            medPlayer.reset();
            medPlayer.setDataSource(arrayObject.getLink());
            medPlayer.prepareAsync();

        } catch (IllegalArgumentException e) {
            Log.d("moh3n", "IllegalArgumentException: " + e.toString());
        } catch (IllegalStateException e) {
            Log.d("moh3n", "IllegalStateException: " + e.toString());
        } catch (IOException e) {
            Log.d("moh3n", "IOException: " + e.toString());
        }


    }

}
