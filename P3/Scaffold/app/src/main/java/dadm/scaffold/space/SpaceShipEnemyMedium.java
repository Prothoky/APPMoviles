package dadm.scaffold.space;

import dadm.scaffold.R;
import dadm.scaffold.engine.GameEngine;
import dadm.scaffold.engine.Sprite;

/*
Clase de nave enemiga de tipo bombardero
Velocidad: lenta
Tamaño: grande
Disparo: si
 */
public class SpaceShipEnemyMedium extends Sprite {

    private double speedFactor;
    private int scoreGiven = 40;    // Puntuación que añade al ser destruído
    private long timeElapsed;   // Almacena el tiempo pasado
    private long timeBetweenBullets = 1500; // Tiempo entre disparos

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

    // Actualiza la posición y calcula si ha pasado el tiempo de disparar de nuevo
    @Override
    public void onUpdate(long elapsedMillis, GameEngine gameEngine) {
        positionY += speedFactor * elapsedMillis;
        if (positionY > gameEngine.height) {
            gameEngine.removeGameObject(this);
        }
        timeElapsed += elapsedMillis;
        if (timeElapsed > timeBetweenBullets) { // Si han pasado 1.5 segundos, disparar
            timeElapsed = 0;
            fire(gameEngine);
        }
    }

    // Si ha chocado con una bala del jugador o con el jugador, se destruye, suma puntos y reproduce sonido
    @Override
    public void processCollision(GameEngine gameEngine, int collisionGroup) {
        if (collisionGroup == 1 || collisionGroup == 2) {
            gameEngine.addScore(scoreGiven);
            gameEngine.removeGameObject(this);
            gameEngine.playSound(2);
        }
    }

    // Dispara un proyectil y reproduce un sonido
    private void fire(GameEngine gameEngine) {
        Bullet bullet1 = gameEngine.getBulletEnemy();
        if (bullet1 == null) {
            return;
        }
        bullet1.init(this, positionX + imageWidth/2, positionY, 0);
        gameEngine.addGameObject(bullet1);
        gameEngine.playSound(1);
    }

}

