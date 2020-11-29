package dadm.scaffold.counter;

import android.view.View;
import android.widget.TextView;

import dadm.scaffold.engine.GameEngine;
import dadm.scaffold.engine.GameObject;

public class ScoreGameObject extends GameObject {
    private final TextView textView;
    private long totalMillis;

    public ScoreGameObject(View view, int viewResId) {
        textView = (TextView) view.findViewById(viewResId);
    }

    @Override
    public void onUpdate(long elapsedMillis, GameEngine gameEngine) {
        totalMillis += elapsedMillis;
    }

    @Override
    public void startGame() {
        totalMillis = 0;
    }

    @Override
    public void onDraw() {
        textView.setText(String.valueOf(totalMillis));
    }
}
