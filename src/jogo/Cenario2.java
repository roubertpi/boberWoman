package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

/**
 * Created by Roubert on 11/06/2016.
 */
public class Cenario2 extends Cenarios {
    private Window janela;
    private Scene cena;
    private Jogador jogador;
    private Keyboard teclado;
    private Inimigo inimigo[];


    public Cenario2(Window window){
        janela = window;
        cena= new Scene();
        cena.loadFromFile(URL.scenario("Cenario2.scn"));
        jogador = new Jogador (366,250);
        teclado = janela.getKeyboard();
        inimigo =new Inimigo[10];
        run();
    }
    private void run(){
        for (int i=0;i<inimigo.length;i++){
            inimigo[i]=new Inimigo(100*i,100*i);
        }
        while (true){
            jogador.mover(janela,teclado);
            jogador.caminho(cena);
            cena.moveScene(jogador);
            jogador.x += cena.getXOffset();
            jogador.y += cena.getYOffset();
            jogador.draw();

            for (int i=0;i<inimigo.length;i++){
                inimigo[i].caminho(cena);
                inimigo[i].perseguir(jogador.x,jogador.y);

                inimigo[i].x += cena.getXOffset();
                inimigo[i].y += cena.getYOffset();

                jogador.atirar(janela,cena,teclado,inimigo[i]);
                inimigo[i].draw();
                inimigo[i].morrer();
            }
            janela.update();
            janela.delay(0);

        }

    }


}
