package org.academiadecodigo.PopStarsSpaceInvaders.BadGuys;


import org.academiadecodigo.PopStarsSpaceInvaders.Direction;
import org.academiadecodigo.PopStarsSpaceInvaders.Shot;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class BadGuy01 extends GenericBadGuy {


    private Rectangle rectangle;
    private int health;
    private Direction direction;
    private int pos_x;
    private int pos_y;
    private boolean isDead;
   // private int gun_pos = 25;
   // private Shot shot;


    public BadGuy01(int pos_x, int pos_y) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        rectangle = new Rectangle(pos_x, pos_y, 50, 50);
        rectangle.setColor(Color.BLUE);
        rectangle.fill();
        isDead=false;


    }

    @Override
    public void move(){
            rectangle.translate(0, 10);
        }


    //public Shot shoot(){
    //    Shot shot = new  Shot(pos_x +gun_pos,pos_y);
   //     return shot;
   // }

   @Override

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public boolean isDead(){
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



