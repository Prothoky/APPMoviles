package dadm.scaffold.engine;

import android.graphics.Rect;

/*
Clase hitbox. Contiene una tupla Sprite + Rect, para poder comprobar las colisiones entre Rect y
luego avisar al gameObject con el que se asocia de que ha habido colisión.
 */
public class Hitbox{
    private Sprite sprite;
    private Rect rect;

    public Hitbox(Sprite sprite, Rect rect) {
        this.sprite = sprite;
        this.rect = rect;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public Rect getRect() {
        return rect;
    }
}
