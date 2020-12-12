package dadm.scaffold.space;

import dadm.scaffold.engine.GameEngine;
import dadm.scaffold.engine.Sprite;
import dadm.scaffold.input.InputController;
import dadm.scaffold.input.JoystickInputController;

public class SpaceShipPlayer extends Sprite {

    private static final long TIME_BETWEEN_BULLETS = 350;
    private long timeSinceLastFire;

    private int maxX;
    private int maxY;
    private double speedFactor;

    private int healthPoints;   // Vidas restantes
    private boolean basicWeapon; // Arma en uso


    /*
    Instancia la nave, dependiendo del tipo.
    La primera es lenta y tiene 3 vidas
    La segunda es rápida y tiene 1 vida
     */
    public SpaceShipPlayer(GameEngine gameEngine, int type, int drawableRes){
        super(gameEngine, drawableRes, 1, 3);
        if (type == 0 ){
            speedFactor = pixelFactor * 80d / 1000d; // We want to move at 100px per second on a 400px tall screen
            maxX = gameEngine.width - imageWidth;
            maxY = gameEngine.height - imageHeight;
            healthPoints = 3;
        } else {
            speedFactor = pixelFactor * 150d / 1000d; // We want to move at 100px per second on a 400px tall screen
            maxX = gameEngine.width - imageWidth;
            maxY = gameEngine.height - imageHeight;
            healthPoints = 1;
        }

        basicWeapon = true;
    }


    @Override
    public void startGame() {
        positionX = maxX / 2;
        positionY = maxY / 2;
    }

    @Override
    public void onUpdate(long elapsedMillis, GameEngine gameEngine) {
        // Get the info from the inputController
        updatePosition(elapsedMillis, gameEngine.theInputController);
        if (gameEngine.theInputController.isFiring) {   // Si se ha pulsado el botón, cambiar de arma y notificar que se ha recibido
            basicWeapon = !basicWeapon;
            ((JoystickInputController) gameEngine.theInputController).fireApplied();
        }
        checkFiring(elapsedMillis, gameEngine);
    }

    @Override
    public void processCollision(GameEngine gameEngine, int collisionGroup) {
        // Si colisiona con un enemigo o un disparo enemigo se le baja 1 vida y si no le quedan
        // vidas llama a shipDestroyed()
        if (collisionGroup == 3 || collisionGroup == 4) {
            healthPoints--;
            if (healthPoints <= 0) {
                shipDestroyed(gameEngine);
            }
        }
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    /*
    Función que se llama cuando el jugador pierde todos sus health Points. Para el juego
     */
    private void shipDestroyed(GameEngine gameEngine) {
        gameEngine.levelCompleted();
        gameEngine.stopGame();
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
        if (timeSinceLastFire > TIME_BETWEEN_BULLETS) {
            timeSinceLastFire = 0;
            if (basicWeapon) {  // Dispara con el arma en uso
                fireBasic(gameEngine);
            } else {
                fireDual(gameEngine);
            }
        }
        else {
            timeSinceLastFire += elapsedMillis;
        }
    }

    /*
    Dispara un proyectil recto
     */
    private void fireBasic(GameEngine gameEngine) {
        Bullet bullet1 = gameEngine.getBulletPlayer();
        if (bullet1 == null) {
            return;
        }
        bullet1.init(this, positionX + imageWidth/2, positionY, 0);
        gameEngine.addGameObject(bullet1);
    }

    /*
    Dispara dos proyectiles en diagonal
     */
    private void fireDual(GameEngine gameEngine) {
        Bullet bullet1 = gameEngine.getBulletPlayer();
        if (bullet1 == null) {
            return;
        }
        Bullet bullet2 = gameEngine.getBulletPlayer();
        if (bullet2 == null) {
            bullet1.release(gameEngine);
            return;
        }
        bullet1.init(this, positionX + imageWidth/2, positionY, 1);
        gameEngine.addGameObject(bullet1);
        bullet2.init(this, positionX + imageWidth/2, positionY, 2);
        gameEngine.addGameObject(bullet2);
    }

}
