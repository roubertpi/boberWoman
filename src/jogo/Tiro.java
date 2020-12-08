package jogo;
import jplay.Sprite;
import jplay.URL;

/**
 * Created by Roubert on 01/06/2016.
 */
public class Tiro extends Sprite {
    public static final int LEFT = 1, RIGT = 2, STOP = 3, UP = 4, DOWN = 5;
    protected static final int velocidade_tiro = 1;
    protected int caminho = STOP;
    protected boolean movendo = false;
    protected int direcao = 3;

    public Tiro(double x, double y, int caminho) {
        super(URL.sprite("flecha.png"), 12);
        this.caminho = caminho;
        this.x = x;
        this.y = y;
    }

    public void mover() {
        if (caminho == LEFT) {
            this.x -= velocidade_tiro;
            if (direcao != 1) {
                setSequence(3, 6);
            }
            movendo = true;
        }
        if (caminho == RIGT) {
            this.x += velocidade_tiro;
            if (direcao != 2) {
                setSequence(6, 9);
            }
            movendo = true;
        }
        if (caminho == UP) {
            this.y -= velocidade_tiro;
            if (direcao != 2) {
                setSequence(11, 12);
            }
            movendo = true;
        }
        if (caminho == DOWN || caminho==STOP) {
            this.y += velocidade_tiro;
            if (direcao != 4) {
                setSequence(1, 3);
            }
            movendo = true;
        }
        if (movendo){
            update();
            movendo =false;
        }
    }
}