package dadm.scaffold.space;

import dadm.scaffold.R;
import dadm.scaffold.engine.GameEngine;
import dadm.scaffold.engine.Sprite;

/*
Enemigo básico, sprite pequeño, se mueve hacia delante
 */
public class SpaceShipEnemySmall extends Sprite {

    private double speedFactor;

    public SpaceShipEnemySmall(GameEngine gameEngine){
        super(gameEngine, R.drawable.enemy_small, 2);
        speedFactor = gameEngine.pixelFactor * 50d / 1000d;
    }

    @Override
    public void startGame() {
        positionX = 50;
    }

    @Override
    public void onUpdate(long elapsedMillis, GameEngine gameEngine) {
        positionY += speedFactor * elapsedMillis;
        if (positionY < -imageHeight) {
            gameEngine.removeGameObject(this);
        }
    }

    @Override
    public void processCollision(int collisionGroup) {
        //System.out.println(getRect().toString());
        return;
    }

}
