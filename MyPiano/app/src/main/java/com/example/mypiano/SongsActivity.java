package com.example.mypiano;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class SongsActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);
    }

    @Override
    protected void onPause() {
        Context context = getApplicationContext();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> taskInfo = activityManager.getRunningTasks(1);
        if (!taskInfo.isEmpty()) {
            ComponentName topActivity = taskInfo.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                AudioController.StopMusic();
            }
        }
        super.onPause();
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
