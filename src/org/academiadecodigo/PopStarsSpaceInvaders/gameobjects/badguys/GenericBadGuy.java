package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys;

import org.academiadecodigo.PopStarsSpaceInvaders.Config;
import org.academiadecodigo.PopStarsSpaceInvaders.Direction;
import org.academiadecodigo.PopStarsSpaceInvaders.Shot;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GameObject;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GetRndBadGuyImg;

import java.util.LinkedList;
import java.util.List;

public abstract class GenericBadGuy extends GameObject  {

    //private static BadGuysTypes type;
    //private int health;
    private int levelUp;
    private Direction direction = null;
    private boolean isDead=false;
    private int posY;
    private int posX;
    public List<Shot> badGuyShotList =new LinkedList<>();

    /**
     * Constructor for Generic BadGuy
     * */

    public GenericBadGuy(int x, int y) {
        super(x, y, GetRndBadGuyImg.get());
        this.posX=x;
        this.posY=y;

    }

    public abstract void move();



    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getPosY() {
        return posY;

    }

    public int getPosX() {
        return posX;
    }


    public void setLevelUp(int increase){
        this.levelUp=this.levelUp+increase;
    }


}

