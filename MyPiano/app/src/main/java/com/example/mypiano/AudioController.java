package com.example.mypiano;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioController {

    private static MediaPlayer mediaPlayer;

    public static void PlayBackground(Context context) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        mediaPlayer = MediaPlayer.create(context, R.raw.burgmuller);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    public static void PlaySong(Context context, int index) {
        mediaPlayer.stop();
        switch(index) {
            case 0:
                mediaPlayer = MediaPlayer.create(context, R.raw.chopin);
                break;
            case 1:
                mediaPlayer = MediaPlayer.create(context, R.raw.clementi);
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(context, R.raw.debussy);
                break;
            case 3:
                mediaPlayer = MediaPlayer.create(context, R.raw.faure);
                break;
            case 4:
                mediaPlayer = MediaPlayer.create(context, R.raw.schumann);
                break;
        }
        mediaPlayer.start();
    }


}
