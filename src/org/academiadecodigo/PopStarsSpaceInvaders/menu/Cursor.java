package org.academiadecodigo.PopStarsSpaceInvaders.menu;

import org.academiadecodigo.PopStarsSpaceInvaders.*;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GameObject;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GetRndPlayerImg;

import java.util.LinkedList;
import java.util.List;

public class Cursor extends GameObject  {
    private Menu menu;
    private double posX;

    private double posY;

        private CollisionDetector collisionDetector;
      //  public static final Sound sound = new Sound("/resources/sounds/FudiMe.wav");


        public Cursor() {
            super(200, 200, GetRndPlayerImg.get());
            posX = 0;
            posY = Config.BOARD_HEIGHT - Config.playerIcon_HEIGHT;
            picture.draw();

        }


        @Override
        public void destroy(GameObject target) {

        }

        @Override
        public void hit(){

        }


        public void move(double x, double y) {
            picture.translate(x - posX, y - posY);
            posX = x;
            posY = y;


        }

        public void click(double x,double y) {
          try {
              this.posX = x;
              this.posY = y;
              menu = new Menu();
              menu.setX(x);
              menu.setY(y);
          }catch (InterruptedException e){
              System.out.println("Está dando merda!");
          }

        }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }


    }

