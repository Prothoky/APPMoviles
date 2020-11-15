package com.example.mypiano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View v = findViewById(android.R.id.content);
        v.setBackgroundColor(Color.WHITE);
        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        AudioController.PlayBackground(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AudioController.PlayBackground(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AudioController.StopMusic();
    }

    public void goToFreePlay(View view) {
        Intent i = new Intent(this, FreePlayActivity.class);
        startActivity(i);
    }

    public void goToLessons(View view) {
        Intent i = new Intent(this, LessonsActivity.class);
        startActivity(i);
    }

    public void goToSongs(View view) {
        Intent i = new Intent(this, SongsActivity.class);
        startActivity(i);
    }
}