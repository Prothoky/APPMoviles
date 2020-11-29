package dadm.scaffold.engine;

import java.util.Timer;
import java.util.TimerTask;

public class DrawThread {

    private static int EXPECTED_FPS = 30;
    private static final long TIME_BETWEEN_DRAWS = 1000 / EXPECTED_FPS;

    private final GameEngine theGameEngine;
    private Timer timer;

    public DrawThread(GameEngine gameEngine) {
        theGameEngine = gameEngine;
    }

    public void start() {
        stopGame();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                theGameEngine.onDraw();
            }
        }, 0, TIME_BETWEEN_DRAWS);
    }

    public void stopGame() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
    }

    public void pauseGame() {
        stopGame();
    }

    public void resumeGame() {
        start();
    }
}
