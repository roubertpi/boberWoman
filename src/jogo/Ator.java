package jogo;

import jplay.GameObject;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Roubert on 01/06/2016.
 */
public class Ator extends Sprite{

    private double velocidade = 1;
    protected int direcao = 3;
    private boolean movendo = false;
    public double energia=1000;
    Controle controle = new Controle();

    public Ator(String filename,int numFrames) {
        super(filename,numFrames);
    }

    public void caminho(Scene cena){
        Point min = new Point((int)this.x,(int)this.y);
        Point max = new Point ((int)this.x + this.width,(int)this.y + this.height);

        Vector<?> title = cena.getTilesFromPosition(min,max);

        for (int i=0; i < title.size(); i++){
            TileInfo tile=(TileInfo)title.elementAt(i);
            if (controle.colisao(this,tile)==true){
                if (colisaohorizontal(this,tile)) {
                    if ((tile.y + tile.height - 2) < this.y) {
                        this.y = tile.y + this.height;
                    }
                    else if  (tile.y > (this.y + this.height - 2)){
                        this.y = tile.y - this.height;
                    }
                }
                if (colisaovertical(this,tile)) {
                    if(tile.x > (this.x + this.width - 2)){
                        this.x = tile.x - this.width;
                    }else if(this.x > (tile.x + tile.width - 2)) {
                        this.x = tile.x + this.width;
                    }
                }
            }
        }

    }

    /**
     *
     * @param obj2 tile do Cenario
     * @param obj1 Meu jogador
     * @return
     */
    private boolean colisaovertical(GameObject obj1, GameObject obj2){
        if ((obj2.x+obj2.width) <= obj1.x)
            return false;
        if ((obj1.x+obj1.width) <= obj2.x)
            return  false;
        else
            return true;
    }
    private boolean colisaohorizontal (GameObject obj1, GameObject obj2){
        if ((obj2.y+obj2.height) <= obj1.y)
            return  false;
        if ((obj1.y+obj1.height) <= obj2.y)
            return false;
        else
            return true;

    }

}

