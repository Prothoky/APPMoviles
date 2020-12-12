package dadm.scaffold.space;

import dadm.scaffold.R;
import dadm.scaffold.engine.GameEngine;
import dadm.scaffold.engine.Sprite;

public class Bullet extends Sprite {

    private double speedFactor;
    private double speedFactorX;
    private Explosion explosion;
    private Sprite parent;

    public Bullet(GameEngine gameEngine){
        super(gameEngine, R.drawable.shot_1_simple, 2, 4);

        speedFactor = gameEngine.pixelFactor * -300d / 1000d;
        explosion = new Explosion(gameEngine,R.drawable.explosion0);
    }

    public Bullet(GameEngine gameEngine, int collisionGroup){
        super(gameEngine, R.drawable.shot_2_simple, collisionGroup, 4);

        speedFactor = gameEngine.pixelFactor * 300d / 1000d;
        explosion = new Explosion(gameEngine,R.drawable.explosion0);
    }

    @Override
    public void startGame() {}

    @Override
    public void onUpdate(long elapsedMillis, GameEngine gameEngine) {
        positionY += speedFactor * elapsedMillis;
        positionX += speedFactorX * elapsedMillis;
        if (positionY < -imageHeight) {
            // And return it to the pool
            if (collisionGroup == 4) {
                gameEngine.releaseBulletEnemy(this);
            } else {
                gameEngine.releaseBulletPlayer(this);
            }
            gameEngine.removeGameObject(this);
        }
        if (positionY > gameEngine.height + imageWidth) {
            if (collisionGroup == 4) {
                gameEngine.releaseBulletEnemy(this);
            } else {
                gameEngine.releaseBulletPlayer(this);
            }
            gameEngine.removeGameObject(this);
        }
        if (positionX < -imageWidth) {
            if (collisionGroup == 4) {
                gameEngine.releaseBulletEnemy(this);
            } else {
                gameEngine.releaseBulletPlayer(this);
            }
            gameEngine.removeGameObject(this);
        }
        if (positionX > gameEngine.width + imageWidth) {
            if (collisionGroup == 4) {
                gameEngine.releaseBulletEnemy(this);
            } else {
                gameEngine.releaseBulletPlayer(this);
            }
            gameEngine.removeGameObject(this);
        }
    }


    @Override
    public void processCollision(GameEngine gameEngine, int collisionGroup) {
        if (collisionGroup == 1) {
            if (this.collisionGroup == 4) {
                explosion.updatePos(positionX, positionY);
                gameEngine.addGameObject(explosion);
                gameEngine.releaseBulletEnemy(this);
                gameEngine.removeGameObject(this);
            }
        } else if (collisionGroup == 3) {
            if (this.collisionGroup != 4) {
                explosion.updatePos(positionX, positionY);
                gameEngine.addGameObject(explosion);
                gameEngine.releaseBulletPlayer(this);
                gameEngine.removeGameObject(this);
            }
        }
    }

    public void init(Sprite parentPlayer, double initPositionX, double initPositionY, int bulletType) {
        if (collisionGroup == 4) {
            positionX = initPositionX + imageWidth/2 - getImageWidth()/2;
            positionY = initPositionY + imageHeight;
            parent = parentPlayer;
        } else {
            positionX = initPositionX - imageWidth/2;
            positionY = initPositionY - imageHeight/2;
            parent = parentPlayer;
        }
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

    public void release(GameEngine gameEngine) {
        if (collisionGroup == 4) {
            gameEngine.releaseBulletEnemy(this);
        } else {
            gameEngine.releaseBulletPlayer(this);
        }
    }
}
