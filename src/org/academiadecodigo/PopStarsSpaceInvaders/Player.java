package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player implements Moveable {

    private Rectangle rectangle;
    private int health;
    private Direction direction;
    private int pos_x;
    private int pos_y;
    private int gun_pos = 25;
    public Shot[] shotsInAir;
    private Shot shot;


    public Player() {
        pos_x= 100;
        pos_y=100;
        rectangle = new Rectangle(pos_x, pos_y, 50, 50);
        rectangle.setColor(Color.RED);
        rectangle.fill();
        shotsInAir= new Shot[100];
        shot= new Shot(pos_x,pos_y);
    }

    public void move(){

        if (direction == Direction.RIGHT) {
            pos_x=pos_x + 10;
            rectangle.translate(10, 0);
        }

        if (direction == Direction.LEFT) {
            pos_x=pos_x - 10;
            rectangle.translate(-10, 0);
        }

        if(direction == Direction.SPACE){
            shot.move();

        }
    }


   // public void shoot(){
    //  Shot shot = new  Shot(pos_x +gun_pos,pos_y);
    //}

 /*   public void move_shots(){
        for (Shot moveThisShit : shotsInAir){
            moveThisShit.move();
        }

    }

    */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
