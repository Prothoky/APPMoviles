package dadm.scaffold.engine;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.List;

import dadm.scaffold.input.InputController;

public class GameEngine {


    private List<GameObject> gameObjects = new ArrayList<GameObject>();
    private List<GameObject> objectsToAdd = new ArrayList<GameObject>();
    private List<GameObject> objectsToRemove = new ArrayList<GameObject>();
    // Lista de hitboxes ordenadas por grupo de colisión
    // Es una lista de Hitbox, que contiene un Rect + su gameObject
    private List<List<Hitbox>> collisionGroups = new ArrayList<>();

    private UpdateThread theUpdateThread;
    private DrawThread theDrawThread;
    public InputController theInputController;
    private final GameView theGameView;

    public int width;
    public int height;
    public double pixelFactor;
    // Número de grupos de colisiones. No colisionan objetos de un mismo grupo
    // 0 - no colisionables
    // 1 - colisiones A
    // 2 - colisiones B
    private int numCollisionGrups = 3;

    private Activity mainActivity;

    public GameEngine(Activity activity, GameView gameView) {
        mainActivity = activity;

        theGameView = gameView;
        theGameView.setGameObjects(this.gameObjects);
        this.width = theGameView.getWidth()
                - theGameView.getPaddingRight() - theGameView.getPaddingLeft();
        this.height = theGameView.getHeight()
                - theGameView.getPaddingTop() - theGameView.getPaddingTop();

        this.pixelFactor = this.height / 400d;

        // Inicializamos los grupos de colisiones
        for (int i = 0; i < numCollisionGrups; i++) {
            collisionGroups.add(new ArrayList<Hitbox>());
        }
    }

    public void setTheInputController(InputController inputController) {
        theInputController = inputController;
    }

    public void startGame() {
        // Stop a game if it is running
        stopGame();

        // Setup the game objects
        int numGameObjects = gameObjects.size();
        for (int i = 0; i < numGameObjects; i++) {
            gameObjects.get(i).startGame();
        }

        // Start the update thread
        theUpdateThread = new UpdateThread(this);
        theUpdateThread.start();

        // Start the drawing thread
        theDrawThread = new DrawThread(this);
        theDrawThread.start();
    }

    public void stopGame() {
        if (theUpdateThread != null) {
            theUpdateThread.stopGame();
        }
        if (theDrawThread != null) {
            theDrawThread.stopGame();
        }
    }

    public void pauseGame() {
        if (theUpdateThread != null) {
            theUpdateThread.pauseGame();
        }
        if (theDrawThread != null) {
            theDrawThread.pauseGame();
        }
    }

    public void resumeGame() {
        if (theUpdateThread != null) {
            theUpdateThread.resumeGame();
        }
        if (theDrawThread != null) {
            theDrawThread.resumeGame();
        }
    }

    public void addGameObject(GameObject gameObject) {
        if (isRunning()) {
            objectsToAdd.add(gameObject);
        } else {
            gameObjects.add(gameObject);
        }
        mainActivity.runOnUiThread(gameObject.onAddedRunnable);
    }

    public void removeGameObject(GameObject gameObject) {
        objectsToRemove.add(gameObject);
        mainActivity.runOnUiThread(gameObject.onRemovedRunnable);
    }

    public void onUpdate(long elapsedMillis) {
        int numGameObjects = gameObjects.size();
        clearCollisionGroups(); // Reseteo de grupo de colisiones
        for (int i = 0; i < numGameObjects; i++) {
            GameObject gameObject = gameObjects.get(i);
            gameObject.onUpdate(elapsedMillis, this);
            if (gameObject instanceof Sprite) { // Si el gameObject es un sprite, añadirlo a las colisiones
                Sprite sprite = (Sprite) gameObject;
                collisionGroups.get(sprite.getCollisionGroup()).add(new Hitbox(sprite, sprite.getRect()));
                /*
                System.out.println("grupo 0 = " + collisionGroups.get(0).size());
                System.out.println("grupo 1 = " + collisionGroups.get(1).size());
                System.out.println("grupo 2 = " + collisionGroups.get(2).size());
                 */
            }
        }
        checkCollisions();  // Comprueba las colisiones
        synchronized (gameObjects) {
            while (!objectsToRemove.isEmpty()) {
                gameObjects.remove(objectsToRemove.remove(0));
            }
            while (!objectsToAdd.isEmpty()) {
                gameObjects.add(objectsToAdd.remove(0));
            }
        }
    }

    public void onDraw() {
        theGameView.draw();
    }

    public boolean isRunning() {
        return theUpdateThread != null && theUpdateThread.isGameRunning();
    }

    public boolean isPaused() {
        return theUpdateThread != null && theUpdateThread.isGamePaused();
    }

    public Context getContext() {
        return theGameView.getContext();
    }

    /*
    Comprueba las colisiones que se han ocasionado.
    Comprueba colisiones entre DIFERENTES collisionGroups, sin contar el grupo 0 (no colisionables)
    Cuando hay colisión, se la comunica a los sprites (y le da información de con quién colisionó)
     */
    private void checkCollisions() {
        for (int i = 1; i < numCollisionGrups; i++) {
            for (int j = 0; j < collisionGroups.get(i).size(); j++) {
                Rect rect1 = collisionGroups.get(i).get(j).getRect();
                for (int k = i + 1; k < numCollisionGrups; k++) {
                    for (int l = 0; l < collisionGroups.get(k).size(); l++) {
                        if (Rect.intersects(rect1, collisionGroups.get(k).get(l).getRect())) {
                            System.out.println(rect1.toString() + " colisiona con " + collisionGroups.get(k).get(l).getRect().toString());
                            collisionGroups.get(i).get(j).getSprite().processCollision(collisionGroups.get(k).get(l).getSprite().getCollisionGroup());
                            collisionGroups.get(k).get(l).getSprite().processCollision(collisionGroups.get(i).get(j).getSprite().getCollisionGroup());
                        }
                    }
                }
            }
        }
    }

    // Resetea la lista de hitboxes
    private void clearCollisionGroups() {
        for (int i = 0; i < numCollisionGrups; i++) {
            collisionGroups.get(i).clear();
        }
    }
}
