package jogo;

import jplay.*;
import jplay.Window;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Vector;

/**
 * Created by Roubert on 20/04/2016.
 */
public class Jogador extends Ator {
    private double velocidade = 1;
    protected int direcao = 3;
    private boolean movendo = false;
    Controle controle = new Controle();

    public Jogador(String filename, int numFrames) {
        super(filename, numFrames);
    }


    public Jogador(int x, int y) {
        super(URL.sprite("jogador.png"),20);
        this.x = x;
        this.y = y;
        this.setTotalDuration(2000);
    }

    Control_tiros tiros = new Control_tiros();

    public void atirar(Window janela, Scene cena, Keyboard teclado, Ator inimigo) {
        if (teclado.keyDown(KeyEvent.VK_SPACE)) {
            tiros.ad_tiro(x + 5, y + 4, direcao, cena);
        }
        tiros.run(inimigo);
    }

    /**
     * Intaciando o Teclado
     */
    public void mover(Window janela, Keyboard teclado) {
        /**
         * Comando Que da Funcionalidade as Teclas Apertadas
         */
        if (teclado.keyDown(Keyboard.LEFT_KEY)) {
            if (this.x > 0) {
                this.x -= velocidade;
            }
            if (direcao != 1) {
               setSequence(5,8);
                direcao = 1;
            }
            movendo = true;
        } else if (teclado.keyDown(Keyboard.RIGHT_KEY)) {
            if (this.x < janela.getWidth() - 60) {
                this.x += velocidade;
            }
            if (direcao != 2) {
                setSequence(9, 12);
                direcao = 2;
            }
            movendo = true;
        } else if (teclado.keyDown(Keyboard.UP_KEY)) {
            if (this.y > 0) {
                this.y -= velocidade;
            }
            if (direcao != 4) {
                setSequence(13, 16);
                direcao = 4;
            }
            movendo = true;
        } else if (teclado.keyDown(Keyboard.DOWN_KEY)) {
            if (this.y < janela.getHeight() - 60)
                this.y += velocidade;
            if (direcao != 5) {
                setSequence(0, 4);
                direcao = 5;
            }
            movendo = true;
        }
        if (movendo) {
            update();
            movendo = false;
        }

    }

    public void morrer() {
        if (this.energia <= 0) {
            this.velocidade = 0;
            ///this.ataque=0;
            this.direcao = 0;
            this.movendo = false;
            this.x = 1_000_000;
        }
    }
}    /**
     * Controle de Caminho, onde o Personagem pode Percorrer
     * funcao caminho é pra pegar o tamanho do personagem
     * this,tile faz referencia a classe Controle
     * this.x e this.y é a posição do meu Jogador
      */
