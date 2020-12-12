package dadm.scaffold.engine;

import android.content.Context;
import android.media.MediaPlayer;

import dadm.scaffold.R;

/*
Controlador de música de fondo.
Permite reproducir la música de menú o del juego sin pararla al cambiar de fragmento.
 */
public class AudioController {

    private static MediaPlayer mediaPlayer;

    // Reproduce la música dependiendo del índice pasado como parámetro (0 = menú, 1 = partida)
    public static void PlayMusic(Context context, int index) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        if (index == 0) {
            mediaPlayer = MediaPlayer.create(context, R.raw.bgm_menu);
        } else {
            mediaPlayer = MediaPlayer.create(context, R.raw.bgm_gameplay);
        }
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(1, 1);
        mediaPlayer.start();
    }

    // Para la música
    public static void StopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

}