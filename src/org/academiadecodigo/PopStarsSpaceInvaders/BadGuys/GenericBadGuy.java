package org.academiadecodigo.PopStarsSpaceInvaders.BadGuys;

import org.academiadecodigo.PopStarsSpaceInvaders.Moveable;
import org.academiadecodigo.PopStarsSpaceInvaders.Shot;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.PopStarsSpaceInvaders.Direction;

abstract public class GenericBadGuy {

    private static BadGuysTypes type;
    private int health;
    private int speed;
    private Direction direction = null;
    private boolean isDead=false;

    /**
     * Constructor for Generic BadGuy
     * */

    public GenericBadGuy(){
        this.direction = direction;
        this.speed = speed;
    }

    public abstract void move();

        public boolean isDead() {
        return isDead;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}


