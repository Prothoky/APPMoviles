package dadm.scaffold.movement;

import android.view.View;
import android.widget.TextView;

import dadm.scaffold.R;
import dadm.scaffold.engine.GameEngine;
import dadm.scaffold.engine.GameObject;
import dadm.scaffold.input.InputController;

public abstract class Player extends GameObject {

    protected int maxX;
    protected int maxY;
    protected double positionX;
    protected double positionY;
    protected double speedFactor;
    protected double pixelFactor;

    protected final TextView textView;

    protected final View view;

    public Player(final View parentView){
        view = parentView;
        pixelFactor = view.getHeight() / 400d;
        maxX = view.getWidth() - view.getPaddingRight() - view.getPaddingRight();
        maxY = view.getHeight() - view.getPaddingTop() - view.getPaddingBottom();
        speedFactor = pixelFactor * 100d / 1000d; // We want to move at 100px per second on a 400px tall screen

        textView = (TextView) view.findViewById(R.id.txt_score);
    }

    @Override
    public void startGame() {
        positionX = maxX / 2;
        positionY = maxY / 2;
    }

    @Override
    public void onDraw() {
        textView.setText("["+(int) (positionX)+","+(int) (positionY)+"]");
    }
}
