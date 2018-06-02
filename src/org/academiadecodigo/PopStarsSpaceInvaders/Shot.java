package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GetRndBadGuyImg;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Player;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Drawable;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GameObject;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.GenericBadGuy;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Shot extends GameObject {

    private boolean isDead;
    private int health;
    private Direction direction;
    private double posX;
    private double posY;
    private static final Sound sound = new Sound("/resources/sounds/LaserShot.wav");


    public Shot(double originX, double originY) {
        super(0, 0, "resources/images/potato.png");


        posY = originY;
        posX = originX;
        sound.play(true);
        picture.translate(originX, originY);
        show();
    }

    public void move() {
        if (posY > 10) {
            picture.translate(0, -20);
            setPosY(getPosY() - 20);
        }
        else {
            hide();
        }
    }

    public void move(int enemyShotPosition) {
        if (posY < 10) {
            picture.translate(0, enemyShotPosition);
            setPosY(getPosY() + enemyShotPosition);
        }
        else {

            hide();
        }
    }

    public double getPosX(
    ) {
        return posX;
    }


    @Override
    public void destroy(GameObject target) {
        target.hit();
        target.hide();
    }

    ;

    @Override
    public boolean isDestroyed() {
        return isDead;

    }

    @Override
    public void hit() {
        isDead = true;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }



    public void setDirection(Direction direction) {
        this.direction = Direction.UP;
    }

}
