package com.example.pardeep.viisualitemapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    public void Playtapped(View v)
    {
        mediaPlayer.start();
    }
    public void Pausetapped(View v)
    {
mediaPlayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView=(VideoView)findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.tera);


        //add media controller
        //creatingmedia controller object
        MediaController mediaController=new MediaController(this) ;
       //connceting the media controller with the videoview
        mediaController.setAnchorView(videoView);
        //conecting the video view withe the media controller
        videoView.setMediaController(mediaController);


        //run it
        videoView.start();




        //audio section
        mediaPlayer= MediaPlayer.create(this,R.raw.song);


        //getting context from audio service
        audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxVolume=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int CurrentVolume=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        //setting context to seekbar
        SeekBar volumeRocker=(SeekBar)findViewById(R.id.seekBar);
        volumeRocker.setMax(maxVolume);
        volumeRocker.setProgress(CurrentVolume);



        //set on click/change listener

        volumeRocker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // setting a player timeline
       final SeekBar timeline=(SeekBar)findViewById(R.id.seekBar2);
        timeline.setMax(mediaPlayer.getDuration());


        //for moving seekbar2 we new to create the timer which update it's view
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeline.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,500);









        //creating on seekchangelistner
        timeline.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mediaPlayer.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
