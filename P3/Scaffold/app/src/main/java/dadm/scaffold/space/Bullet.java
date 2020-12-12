package dadm.scaffold.space;

import dadm.scaffold.R;
import dadm.scaffold.engine.GameEngine;
import dadm.scaffold.engine.Sprite;

public class Bullet extends Sprite {

    private double speedFactor;
    private double speedFactorX;
    private Explosion explosion;
    private Sprite parent;

    // Constructor genérico de bullet de jugador
    public Bullet(GameEngine gameEngine){
        super(gameEngine, R.drawable.shot_1_simple, 2, 4);

        speedFactor = gameEngine.pixelFactor * -300d / 1000d;
        explosion = new Explosion(gameEngine,R.drawable.explosion0);
    }

    // Constructor de bullet con seteo de drawable resource y de collisionGroup (para crear bullets de enemigos)
    public Bullet(GameEngine gameEngine, int drawableResource, int collisionGroup){
        super(gameEngine, drawableResource, collisionGroup, 4);

        speedFactor = gameEngine.pixelFactor * 300d / 1000d;
        explosion = new Explosion(gameEngine,R.drawable.explosion0);
    }

    @Override
    public void startGame() {}

    /*
    Actualiza la posición de la bala
    Si se sale por algún límite lo devuelve al pool adecuado
     */
    @Override
    public void onUpdate(long elapsedMillis, GameEngine gameEngine) {
        positionY += speedFactor * elapsedMillis;
        positionX += speedFactorX * elapsedMillis;

        // Si se sale de alguno de los límites, lo devolvemos a su pool (enemigo o jugador)
        if (positionY < -imageHeight) {
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
        // Si la bala impacta con un enemigo, eliminarla y reproducir animación
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

    /*
    Inicializa la bala en posición y velocidad en X
    type 0 - sin velocidad x
    type 1 - diagonal hacia la izquierda
    type 2 - diagonal hacia la derecha
     */
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
        // Dependiendo del tipo de bala, asignar movimiento en X
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

    // Libera la bala dependiendo de la pool a la que pertenezca
    public void release(GameEngine gameEngine) {
        if (collisionGroup == 4) {
            gameEngine.releaseBulletEnemy(this);
        } else {
            gameEngine.releaseBulletPlayer(this);
        }
    }
}
