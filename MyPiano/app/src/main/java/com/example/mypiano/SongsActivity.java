package com.example.mypiano;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class SongsActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);
    }

    public void playChopin(View view) {
        AudioController.PlaySong(this, 0);
    }

    public void playClementi(View view) {
        AudioController.PlaySong(this, 1);
    }

    public void playDebussy(View view) {
        AudioController.PlaySong(this, 2);
    }

    public void playFaure(View view) {
        AudioController.PlaySong(this, 3);
    }

    public void playSchumann(View view) {
        AudioController.PlaySong(this, 4);
    }
}
