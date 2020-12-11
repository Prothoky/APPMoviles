package dadm.scaffold.space;

import dadm.scaffold.R;
import dadm.scaffold.engine.GameEngine;
import dadm.scaffold.engine.Sprite;

public class Bullet extends Sprite {

    private double speedFactor;
    private double speedFactorX;

    private SpaceShipPlayer parent;

    public Bullet(GameEngine gameEngine){
        super(gameEngine, R.drawable.shot_1_simple, 2, 4);

        speedFactor = gameEngine.pixelFactor * -300d / 1000d;
    }

    @Override
    public void startGame() {}

    @Override
    public void onUpdate(long elapsedMillis, GameEngine gameEngine) {
        positionY += speedFactor * elapsedMillis;
        positionX += speedFactorX * elapsedMillis;
        if (positionY < -imageHeight) {
            gameEngine.removeGameObject(this);
            // And return it to the pool
            parent.releaseBullet(this);
        }
        if (positionX < -imageWidth) {
            gameEngine.removeGameObject(this);
            parent.releaseBullet(this);
        }
        if (positionX > gameEngine.width + imageWidth) {
            gameEngine.removeGameObject(this);
            parent.releaseBullet(this);
        }
    }

    @Override
    public void processCollision(GameEngine gameEngine, int collisionGroup) {
        if (collisionGroup == 3 || collisionGroup == 4) {
            parent.releaseBullet(this);
            gameEngine.removeGameObject(this);
        }
    }


    public void init(SpaceShipPlayer parentPlayer, double initPositionX, double initPositionY, int bulletType) {
        positionX = initPositionX - imageWidth/2;
        positionY = initPositionY - imageHeight/2;
        parent = parentPlayer;
        switch (bulletType) {
            case 0:
                speedFactorX = 0;
                break;
            case 1:
                speedFactorX = speedFactor;
                break;
            case 2:
                speedFactorX = -speedFactor;
                break;
        }
    }

    public void release() {
        parent.releaseBullet(this);
    }
}
