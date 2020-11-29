package dadm.scaffold.space;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import dadm.scaffold.R;
import dadm.scaffold.engine.GameEngine;
import dadm.scaffold.movement.Player;

public class Bullet extends Player {

    private final ImageView bulletImageView;
    private final double imageHeight;
    private final double imageWidth;

    private SpaceShipPlayer parent;

    public Bullet(View parentView){//}, double pixelFactor) {
        super(parentView);

        speedFactor = pixelFactor * -300d / 1000d;

        bulletImageView = new ImageView(view.getContext());
        Drawable bulletDrawable = view.getContext().getResources().getDrawable(R.drawable.bullet);
        imageWidth = bulletDrawable.getIntrinsicWidth() * pixelFactor;
        imageHeight = bulletDrawable.getIntrinsicHeight() * pixelFactor;
        bulletImageView.setLayoutParams(new ViewGroup.LayoutParams(
                (int) (imageWidth),
                (int) (imageHeight)));
        bulletImageView.setImageDrawable(bulletDrawable);
        bulletImageView.setVisibility(View.GONE);
        ((FrameLayout) view).addView(bulletImageView);

    }

    @Override
    public void startGame() {}

    @Override
    public void onUpdate(long elapsedMillis, GameEngine gameEngine) {
        positionY += speedFactor * elapsedMillis;
        if (positionY < -imageHeight) {
            gameEngine.removeGameObject(this);
            // And return it to the pool
            parent.releaseBullet(this);
        }
    }

    @Override
    public void onDraw() {
        bulletImageView.animate().translationX((int) positionX).translationY((int) positionY)
                .setDuration(1)
                .start();
    }

    @Override
    public void onRemovedFromGameUiThread() {
        bulletImageView.setVisibility(View.GONE);
    }

    @Override
    public void onAddedToGameUiThread() {
        bulletImageView.setVisibility(View.VISIBLE);
    }

    public void init(SpaceShipPlayer parentPlayer, double initPositionX, double initPositionY) {
        positionX = initPositionX - imageWidth/2;
        positionY = initPositionY - imageHeight/2;
        parent = parentPlayer;
    }
}
