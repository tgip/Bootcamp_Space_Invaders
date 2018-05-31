package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys;

import org.academiadecodigo.PopStarsSpaceInvaders.Direction;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GetRndBadGuyImg;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BadGuy01 extends GenericBadGuy {

   // private Rectangle rectangle;
   private Picture badIcon;
    private int health;
    private Direction direction;
    private int pos_x;
    private int pos_y;
    private boolean isDead;
    private GetRndBadGuyImg get=new GetRndBadGuyImg();

    // private int gun_pos = 25;
    // private Shot shot;

    public BadGuy01(int pos_x, int pos_y) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;

        badIcon = new Picture(pos_x,pos_y,get.get()););
        badIcon.grow(-50,-50);
        badIcon.draw();
        isDead=false;

    }

    @Override
    public void move(){
        badIcon.translate(0, 10);
    }

    //public Shot shoot(){
    //    Shot shot = new  Shot(pos_x +gun_pos,pos_y);
    //     return shot;
    // }

    @Override

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isDestroyed(){
        return isDead;
    }
}

/**
 * Defines a BadGuy
 * Has Health
 * Has a Speed (increases with skill)
 * can move in Direction
 * can die
 * */
