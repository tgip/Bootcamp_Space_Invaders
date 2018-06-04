package org.academiadecodigo.PopStarsSpaceInvaders.menu;

import org.academiadecodigo.PopStarsSpaceInvaders.*;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GameObject;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GetRndPlayerImg;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;

import java.util.LinkedList;
import java.util.List;

public class Cursor implements MouseUser {
     private double posX;

    private double posY;

        private CollisionDetector collisionDetector;
      //  public static final Sound sound = new Sound("/resources/sounds/FudiMe.wav");



        /*public void move(double x, double y) {
            picture.translate(x - posX, y - posY);
            posX = x;
            posY = y;


        }*/

        public void click( double x,double y) {
                this.posX = x;
                this.posY = y;

            }


    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public void resetPosX(){
            this.posX=0;
    }
    public void resetPosy(){
            this.posY=0;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        click(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

