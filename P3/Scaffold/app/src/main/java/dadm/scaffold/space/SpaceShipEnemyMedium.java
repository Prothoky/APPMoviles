package dadm.scaffold.space;

import dadm.scaffold.R;
import dadm.scaffold.engine.GameEngine;
import dadm.scaffold.engine.Sprite;

public class SpaceShipEnemyMedium extends Sprite {

    private double speedFactor;
    private int scoreGiven = 40;    // Puntuación que añade al ser destruído
    private long timeElapsed;
    private long timeBetweenBullets = 1500;

    public SpaceShipEnemyMedium(GameEngine gameEngine, double positionX){
        super(gameEngine, R.drawable.enemy_medium_simple, 3, 3);
        speedFactor = gameEngine.pixelFactor * 25d / 1000d;
        this.positionX = positionX;
        this.positionY = -imageHeight;
        timeElapsed = 0;
    }

    @Override
    public void startGame() {
        positionX = 400;
    }

    @Override
    public void onUpdate(long elapsedMillis, GameEngine gameEngine) {
        positionY += speedFactor * elapsedMillis;
        if (positionY > gameEngine.height) {
            gameEngine.removeGameObject(this);
        }
        timeElapsed += elapsedMillis;
        if (timeElapsed > timeBetweenBullets) {
            timeElapsed = 0;
            fire(gameEngine);
        }
    }

    @Override
    public void processCollision(GameEngine gameEngine, int collisionGroup) {
        if (collisionGroup == 1 || collisionGroup == 2) {  // Si colisiona con un disparo del jugador desaparece y suma puntos
            gameEngine.addScore(scoreGiven);
            gameEngine.removeGameObject(this);
        }
        return;
    }

    private void fire(GameEngine gameEngine) {
        Bullet bullet1 = gameEngine.getBulletEnemy();
        if (bullet1 == null) {
            return;
        }
        bullet1.init(this, positionX + imageWidth/2, positionY, 0);
        gameEngine.addGameObject(bullet1);
    }

}

