package com.example.mypiano;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    */
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View v = findViewById(android.R.id.content);
        v.setBackgroundColor(Color.WHITE);
        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        //Button buttonPlay = (Button) findViewById(R.id.button_play);
        //Button buttonPause = (Button) findViewById(R.id.button_pause);
        //Button buttonStop = (Button) findViewById(R.id.button_stop);
        //MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.audio_file);
        //buttonPlay.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) { mediaPlayer.start(); } });
        //buttonPause.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { mediaPlayer.pause();} });
        //buttonStop.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) { mediaPlayer.stop();} });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        mediaPlayer = null;
    }
}