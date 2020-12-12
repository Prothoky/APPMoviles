package dadm.scaffold.engine;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class ScoreView extends GameObject {
private final float textWidth;
private final float textHeight;

private Paint paint;

private String scoreText = "";

/*
Clase que muestra la puntuación y las vidas restantes por pantalla
 */
public ScoreView(GameEngine gameEngine) {
    paint = new Paint();
    paint.setTextAlign(Paint.Align.CENTER);
    textHeight = (float) (25 * gameEngine.pixelFactor);
    textWidth = (float) (80 * gameEngine.pixelFactor);
    paint.setTextSize(textHeight / 2);
}

    @Override
    public void startGame() { }

    @Override
    public void onUpdate(long elapsedMillis, GameEngine gameEngine) {
        scoreText = "  HEALTH: " + gameEngine.player.healthPoints + " -  SCORE: " + gameEngine.score;
    }

    @Override
    public void onDraw(Canvas canvas) {
        paint.setColor(Color.GRAY);
        canvas.drawRect(0, 0, textWidth*2, textHeight, paint);
        paint.setColor(Color.WHITE);
        canvas.drawText(scoreText, 200, textHeight*2/3 , paint);
    }
}

