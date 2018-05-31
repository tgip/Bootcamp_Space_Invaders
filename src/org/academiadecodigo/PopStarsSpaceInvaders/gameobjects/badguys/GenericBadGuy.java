package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys;

import org.academiadecodigo.PopStarsSpaceInvaders.Direction;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Drawable;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GameObject;

import javax.security.auth.Destroyable;

public abstract class GenericBadGuy extends GameObject implements Drawable, Destroyable {

    private static BadGuysTypes type;
    private int health;
    private int speed;
    private Direction direction = null;
    private boolean isDead=false;

    /**
     * Constructor for Generic BadGuy
     * */

    public GenericBadGuy(){
        super(200, 200, "resources/images/Humberto.png");

     //   posX=200;
      //  posY=200;

     //   picture.grow(-50,-50);
     //   picture.draw();

        this.direction = direction;
        this.speed = speed;
    }

    public abstract void move();

    public boolean isDestroyed() {
        return isDead;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}

/*
public void move(double x, double y) {
        playerIcon.translate(x - posX, y - posY);
        posX=x;
        posY=y;

 */