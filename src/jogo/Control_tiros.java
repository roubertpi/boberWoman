package jogo;


import jplay.Scene;

import java.util.LinkedList;

/**
 * Created by Roubert on 02/06/2016.
 */
public class Control_tiros {
LinkedList <Tiro> tiros=new LinkedList<>();
    public void ad_tiro (double x, double y, int caminho, Scene cena){
        Tiro tiro=new Tiro(x,y,caminho);
        tiros.addFirst(tiro);
        cena.addOverlay(tiro);
    }
    public void run (Ator inimigo){
        for (int i=0; i <tiros.size();i++){
            Tiro tiro = tiros.removeFirst();
            tiro.mover();
            tiros.addLast(tiro);
        if (tiro.collided(inimigo)){
            tiro.x=1_000_000;
            inimigo.energia-=250;

        }
        }

    }

}
