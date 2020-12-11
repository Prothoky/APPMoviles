package dadm.scaffold.space;

import dadm.scaffold.R;
import dadm.scaffold.engine.GameEngine;
import dadm.scaffold.engine.Sprite;

/*
Enemigo básico, sprite pequeño, se mueve hacia delante
 */
public class SpaceShipEnemySmall extends Sprite {

    private double speedFactor;
    private int scoreGiven = 20;    // Puntuación que añade al ser destruído

    public SpaceShipEnemySmall(GameEngine gameEngine, double positionX){
        super(gameEngine, R.drawable.enemy_small_simple, 3, 4);
        speedFactor = gameEngine.pixelFactor * 50d / 1000d;
        this.positionX = positionX;
        this.positionY = -imageHeight;
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
    }

    @Override
    public void processCollision(GameEngine gameEngine, int collisionGroup) {
        if (collisionGroup == 2) {  // Si colisiona con un disparo del jugador desaparece y suma puntos
            gameEngine.addScore(scoreGiven);
            gameEngine.removeGameObject(this);
        }
        return;
    }

}
