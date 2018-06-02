package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys;

import org.academiadecodigo.PopStarsSpaceInvaders.Config;
import org.academiadecodigo.PopStarsSpaceInvaders.Direction;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GameObject;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GetRndBadGuyImg;

public class BadGuy01 extends GenericBadGuy {


    private Direction direction;
    private int posY;
    private boolean isDead;
    private GetRndBadGuyImg get=new GetRndBadGuyImg();
    private int levelUp;



    public BadGuy01(int pos_x, int pos_y) {
        super(pos_x, pos_y);
        this.posY=pos_y;

        isDead=false;
        picture.draw();

    }


    @Override
    public void destroy(GameObject target){
       target.hit();
       target.hide();
    }

    @Override
    public void move(){

        if (Config.BOARD_HEIGHT + Config.PADDING <= getEndY() + 10) {
            return;
        }

        picture.translate(0, levelUp+3);
        posY += levelUp+3;
    }

    @Override
    public boolean isDestroyed(){
        return isDead;

    }

    @Override
    public void hit(){
        isDead=true;
        hide();

    }

    @Override
    public void setLevelUp(int increase){
        this.levelUp=this.levelUp+increase;
    }

    @Override
    public int getPosY() {
        return posY;

    }
}

