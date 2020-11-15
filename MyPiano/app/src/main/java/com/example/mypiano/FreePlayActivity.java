package com.example.mypiano;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

public class FreePlayActivity extends AppCompatActivity {

    SoundPool soundPool;
    int do1, do2, re1, re2, mi1, mi2, fa1, fa2, sol1, sol2, la2, la3, si2, si3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_play);
        AudioController.StopMusic();
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        do1 = soundPool.load(this, R.raw.do1, 1);
        do2 = soundPool.load(this, R.raw.do2, 1);
        re1 = soundPool.load(this, R.raw.re1, 1);
        re2 = soundPool.load(this, R.raw.re2, 1);
        mi1 = soundPool.load(this, R.raw.mi1, 1);
        mi2 = soundPool.load(this, R.raw.mi2, 1);
        fa1 = soundPool.load(this, R.raw.fa1, 1);
        fa2 = soundPool.load(this, R.raw.fa2, 1);
        sol1 = soundPool.load(this, R.raw.sol1, 1);
        sol2 = soundPool.load(this, R.raw.sol2, 1);
        la2 = soundPool.load(this, R.raw.la2, 1);
        la3 = soundPool.load(this, R.raw.la3, 1);
        si2 = soundPool.load(this, R.raw.si2, 1);
        si3 = soundPool.load(this, R.raw.si3, 1);
    }

    public void playKey(View v) {
        switch (v.getId()) {
            case R.id.key_0:
                soundPool.play(do1, 1, 1, 0, 0, 1);
                break;
            case R.id.key_1:
                soundPool.play(re1, 1, 1, 0, 0, 1);
                break;
            case R.id.key_2:
                soundPool.play(mi1, 1, 1, 0, 0, 1);
                break;
            case R.id.key_3:
                soundPool.play(fa1, 1, 1, 0, 0, 1);
                break;
            case R.id.key_4:
                soundPool.play(sol1, 1, 1, 0, 0, 1);
                break;
            case R.id.key_5:
                soundPool.play(la2, 1, 1, 0, 0, 1);
                break;
            case R.id.key_6:
                soundPool.play(si2, 1, 1, 0, 0, 1);
                break;
            case R.id.key_7:
                soundPool.play(do2, 1, 1, 0, 0, 1);
                break;
            case R.id.key_8:
                soundPool.play(re2, 1, 1, 0, 0, 1);
                break;
            case R.id.key_9:
                soundPool.play(mi2, 1, 1, 0, 0, 1);
                break;
            case R.id.key_10:
                soundPool.play(fa2, 1, 1, 0, 0, 1);
                break;
            case R.id.key_11:
                soundPool.play(sol2, 1, 1, 0, 0, 1);
                break;
            case R.id.key_12:
                soundPool.play(la3, 1, 1, 0, 0, 1);
                break;
            case R.id.key_13:
                soundPool.play(si3, 1, 1, 0, 0, 1);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
    }
}