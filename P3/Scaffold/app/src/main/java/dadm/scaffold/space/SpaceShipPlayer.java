package dadm.scaffold.space;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import dadm.scaffold.R;
import dadm.scaffold.engine.GameEngine;
import dadm.scaffold.input.InputController;
import dadm.scaffold.movement.Player;

public class SpaceShipPlayer extends Player {

    private final ImageView theShip;

    private static final int INITIAL_BULLET_POOL_AMOUNT = 6;
    private static final long TIME_BETWEEN_BULLETS = 250;
    List<Bullet> bullets = new ArrayList<Bullet>();
    private long timeSinceLastFire;


    public SpaceShipPlayer(final View parentView){
        super(parentView);
        theShip = new ImageView(view.getContext());
        Drawable shipDrawable = view.getContext().getResources().getDrawable(R.drawable.ship);
        theShip.setLayoutParams(new ViewGroup.LayoutParams(
                (int) (shipDrawable.getIntrinsicWidth() * pixelFactor),
                (int) (shipDrawable.getIntrinsicHeight() * pixelFactor)));
        theShip.setImageDrawable(shipDrawable);
        ((FrameLayout) view).addView(theShip);

        maxX -= (shipDrawable.getIntrinsicWidth() * pixelFactor);
        maxY -= (shipDrawable.getIntrinsicHeight() * pixelFactor);

        initBulletPool();
    }

    private void initBulletPool() {
        for (int i=0; i<INITIAL_BULLET_POOL_AMOUNT; i++) {
            bullets.add(new Bullet(view));
        }
    }

    private Bullet getBullet() {
        if (bullets.isEmpty()) {
            return null;
        }
        return bullets.remove(0);
    }

    void releaseBullet(Bullet bullet) {
        bullets.add(bullet);
    }


    @Override
    public void onUpdate(long elapsedMillis, GameEngine gameEngine) {
        // Get the info from the inputController
        updatePosition(elapsedMillis, gameEngine.theInputcontroller);
        checkFiring(elapsedMillis, gameEngine);
    }

    private void updatePosition(long elapsedMillis, InputController inputController) {
        positionX += speedFactor * inputController.horizontalFactor * elapsedMillis;
        if (positionX < 0) {
            positionX = 0;
        }
        if (positionX > maxX) {
            positionX = maxX;
        }
        positionY += speedFactor * inputController.verticalFactor * elapsedMillis;
        if (positionY < 0) {
            positionY = 0;
        }
        if (positionY > maxY) {
            positionY = maxY;
        }
    }

    private void checkFiring(long elapsedMillis, GameEngine gameEngine) {
        if (gameEngine.theInputcontroller.isFiring && timeSinceLastFire > TIME_BETWEEN_BULLETS) {
            Bullet bullet = getBullet();
            if (bullet == null) {
                return;
            }
            bullet.init(this, positionX + theShip.getWidth()/2, positionY);
            gameEngine.addGameObject(bullet);
            timeSinceLastFire = 0;
        }
        else {
            timeSinceLastFire += elapsedMillis;
        }
    }

    @Override
    public void onDraw() {
        textView.setText("["+(int) (positionX)+","+(int) (positionY)+"]");
        theShip.setTranslationX((int)positionX);
        theShip.setTranslationY((int)positionY);
    }
}
