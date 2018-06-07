package org.academiadecodigo.PopStarsSpaceInvaders.menu;

import org.academiadecodigo.PopStarsSpaceInvaders.CollisionDetector;
import org.academiadecodigo.PopStarsSpaceInvaders.MouseUser;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;

public class Cursor implements MouseUser {
    private double posX;
    private double posY;

    private CollisionDetector collisionDetector;
    // TODO : This isn't beeing used ?
    //  public static final Sound sound = new Sound("/resources/sounds/FudiMe.wav");



        /*public void move(double x, double y) {
            picture.translate(x - posX, y - posY);
            posX = x;
            posY = y;


        }*/

    private void click(double x, double y) {
        this.posX = x;
        this.posY = y;
    }


    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public void resetPosX() {
        this.posX = 0;
    }

    public void resetPosy() {
        this.posY = 0;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        click(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

