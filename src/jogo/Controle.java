package jogo;
import java.util.LinkedList;

import jplay.GameObject;
import jplay.TileInfo;

/**
 * Created by Roubert on 20/04/2016.
 */
public class Controle {
    public boolean colisao(GameObject obj, TileInfo tile) {
        if ((tile.id) <= 5 && obj.collided(tile)) {
            return true;
        } else
            return false;
    }

}
