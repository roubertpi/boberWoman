package jogo;

import jplay.URL;

/**
 * Created by Roubert on 01/06/2016.
 */
public class Inimigo extends Ator {
    private double velocidade = 1;
    protected int direcao = 3;
    private boolean movendo = false;
    Controle controle = new Controle();
    public Inimigo(int x, int y) {
        super(URL.sprite("01.png"),1);
        this.x=x;
        this.y=y;
        this.setTotalDuration(2000);
        this.velocidade=0.3;
    }
public void perseguir (double x, double y){
    if (this.x > x &&  this.y <= y + 50 && this.y >=y-50){
        moveTo(x,y,velocidade);
        if (direcao !=1){
           /// setSequence(5,6);
            direcao =1;
        }
        movendo=true;
    } else if (this.x < x && this.y <= y + 50 && this.y >= -50) {
    moveTo(x,y,velocidade);
        if (direcao !=2){
            //setSequence(9,12);
            direcao=2;
        }
        movendo=true;
    }

    else if (this.y > y){
        moveTo(x,y,velocidade);
        if (direcao !=5) {
        //setSequence(13,16);
            direcao=4;
        }
        movendo=true;
     }
    else if (this.y <y){
    moveTo(x,y,velocidade);
        if(direcao !=5) {
      //  setSequence(1,4);
            direcao = 5;
        }
        movendo =true;
        }
if (movendo) {
    update();
    movendo = false;
             }

        }
    public void morrer (){
        if (this.energia<=0){
            this.velocidade=0;
            ///this.ataque=0;
            this.direcao=0;
            this.movendo=false;
            this.x=1_000_000;
        }
    }
    }


