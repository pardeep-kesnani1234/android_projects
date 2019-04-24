package com.example.dell.myapplication1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public void playMusic(View v)
    {
int id= v.getId();
        Log.i("id","id value is:"+id);


        String nameID;
        nameID=v.getResources().getResourceEntryName(id);
        Log.i("nameID","nameID value is:"+nameID);

        int myMusic=getResources().getIdentifier(nameID,"raw","com.example.dell.myapplication1");
        MediaPlayer mediaPlayer= MediaPlayer.create(this,myMusic);
        mediaPlayer.start();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
