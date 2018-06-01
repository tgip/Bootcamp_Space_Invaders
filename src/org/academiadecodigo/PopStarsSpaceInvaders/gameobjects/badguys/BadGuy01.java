package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys;

import org.academiadecodigo.PopStarsSpaceInvaders.Config;
import org.academiadecodigo.PopStarsSpaceInvaders.Direction;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GameObject;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GetRndBadGuyImg;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BadGuy01 extends GenericBadGuy {

   // private Rectangle rectangle;
   private Picture badIcon;
    private int health;
    private Direction direction;
    private int pos_x;
    private int getY;
    private boolean isDead;
    private GetRndBadGuyImg get=new GetRndBadGuyImg();

    // private int gun_pos = 25;
    // private Shot shot;

    public BadGuy01(int pos_x, int pos_y) {
        super(pos_x, pos_y);
        this.pos_x = pos_x;
        this.getY = pos_y;

        //badIcon = new Picture(pos_x,pos_y,get.get());
        //badIcon.grow(-50,-50);
        //badIcon.draw();
        isDead=false;
        picture.draw();

    }

    @Override
    public void move(){

        if (Config.BOARD_HEIGHT + Config.PADDING <= getEndY() + 10) {
            return;
        }

        picture.translate(0, 10);
    }

    //public Shot shoot(){
    //    Shot shot = new  Shot(pos_x +gun_pos,pos_y);
    //     return shot;
    // }
    @Override
    public void destroy(GameObject target){
       target.hit();
       target.hide();
    };

    @Override
    public boolean isDestroyed(){
        return isDead;

    };

    @Override
    public void hit(){
        isDead=true;
        hide();
    };


    @Override

    public void setDirection(Direction direction) {
        this.direction = direction;
    }



    @Override
    public int getPosY(){
        return getY;
    }
}

/**
 * Defines a BadGuy
 * Has Health
 * Has a Speed (increases with skill)
 * can move in Direction
 * can die
 * */
