package dadm.scaffold.engine;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public abstract class Sprite extends GameObject {

    protected double positionX;
    protected double positionY;
    protected double rotation;
    protected double scaleFactor;   // Factor de escalado del sprite
    protected int collisionGroup;   // Índice del grupo de colisión

    protected double pixelFactor;

    private final Bitmap bitmap;
    protected final int imageHeight;
    protected final int imageWidth;

    private final Matrix matrix = new Matrix();

    protected Sprite (GameEngine gameEngine, int drawableRes) {
        Resources r = gameEngine.getContext().getResources();
        Drawable spriteDrawable = r.getDrawable(drawableRes);

        this.collisionGroup = 0;
        this.scaleFactor = 1;

        this.pixelFactor = gameEngine.pixelFactor;

        this.imageHeight = (int) (spriteDrawable.getIntrinsicHeight() * this.pixelFactor);
        this.imageWidth = (int) (spriteDrawable.getIntrinsicWidth() * this.pixelFactor);

        this.bitmap = ((BitmapDrawable) spriteDrawable).getBitmap();
    }

    // Constructor con seteo de collisionGroup
    protected Sprite (GameEngine gameEngine, int drawableRes, int collisionGroup) {
        Resources r = gameEngine.getContext().getResources();
        Drawable spriteDrawable = r.getDrawable(drawableRes);

        this.collisionGroup = collisionGroup;
        this.scaleFactor = 1;

        this.pixelFactor = gameEngine.pixelFactor;

        this.imageHeight = (int) (spriteDrawable.getIntrinsicHeight() * this.pixelFactor);
        this.imageWidth = (int) (spriteDrawable.getIntrinsicWidth() * this.pixelFactor);

        this.bitmap = ((BitmapDrawable) spriteDrawable).getBitmap();
    }

    // Constructor con seteo de collisionGroup y de scaleFactor
    protected Sprite (GameEngine gameEngine, int drawableRes, int collisionGroup, double scaleFactor) {
        Resources r = gameEngine.getContext().getResources();
        Drawable spriteDrawable = r.getDrawable(drawableRes);

        this.collisionGroup = collisionGroup;
        this.scaleFactor = scaleFactor;

        this.pixelFactor = gameEngine.pixelFactor;

        this.imageHeight = (int) (spriteDrawable.getIntrinsicHeight() * this.pixelFactor);
        this.imageWidth = (int) (spriteDrawable.getIntrinsicWidth() * this.pixelFactor);

        this.bitmap = ((BitmapDrawable) spriteDrawable).getBitmap();
    }

    @Override
    public void onDraw(Canvas canvas) {
        if (positionX > canvas.getWidth()
                || positionY > canvas.getHeight()
                || positionX < - imageWidth
                || positionY < - imageHeight) {
            return;
        }
        matrix.reset();
        matrix.postScale((float) (pixelFactor * scaleFactor), (float) (pixelFactor * scaleFactor));
        matrix.postTranslate((float) positionX, (float) positionY);
        matrix.postRotate((float) rotation, (float) (positionX + imageWidth/2), (float) (positionY + imageHeight/2));
        canvas.drawBitmap(bitmap, matrix, null);
    }

    // Devuelve un Rect con la hitbox del sprite
    public Rect getRect() {
        return new Rect((int) positionX, (int) positionY, (int) positionX + imageWidth, (int) positionY + imageHeight);
    }

    public int getCollisionGroup() {
        return collisionGroup;
    }

    public void setCollisionGroup(int collisionGroup) {
        this.collisionGroup = collisionGroup;
    }

    // Método que se debe llamar al detectar colisión
    public abstract void processCollision(int collisionGroup);

}
