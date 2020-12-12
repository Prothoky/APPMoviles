package dadm.scaffold.space;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;

import dadm.scaffold.R;
import dadm.scaffold.engine.GameEngine;
import dadm.scaffold.engine.GameView;
import dadm.scaffold.engine.Sprite;

public class Explosion extends Sprite {

    private Resources r;
    private long tiempo =0;

    public Explosion(GameEngine gameEngine, int spriteDrawable) {
        super(gameEngine, R.drawable.explosion0);
        r = gameEngine.getContext().getResources();

    }

    @Override
    public void startGame() {

    }

    @Override
    public void onUpdate(long elapsedMillis, GameEngine gameEngine) {
        tiempo+=elapsedMillis;
        if (tiempo <200){
            bitmap = BitmapFactory.decodeResource(r, R.drawable.explosion0);
        }
        if (tiempo < 400 && tiempo > 200){
            bitmap = BitmapFactory.decodeResource(r, R.drawable.explosion1);
        }
        if (tiempo < 600 && tiempo > 400){
            bitmap = BitmapFactory.decodeResource(r, R.drawable.explosion2);
        }
        if (tiempo < 800 && tiempo > 600){
            bitmap = BitmapFactory.decodeResource(r, R.drawable.explosion3);
        }
        if (tiempo < 1000 && tiempo > 800){
            bitmap = BitmapFactory.decodeResource(r, R.drawable.explosion4);
        }
        if(tiempo > 1000){
            gameEngine.removeGameObject(this);
            tiempo=0;
        }
    }


    @Override
    public void processCollision(GameEngine gameEngine, int collisionGroup) {

    }

    public void updatePos(double x, double y){
        positionY = y;
        positionX = x;

    }
}

