package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys;

import org.academiadecodigo.PopStarsSpaceInvaders.Check;
import org.academiadecodigo.PopStarsSpaceInvaders.Direction;

public abstract class GenericBadGuy extends Check {

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


    public void hide(){

    }
}
