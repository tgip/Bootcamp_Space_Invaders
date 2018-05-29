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
    private Shot shot;


    public Player() {
        pos_x= 100;
        pos_y=100;
        rectangle = new Rectangle(pos_x, pos_y, 50, 50);
        rectangle.setColor(Color.RED);
        rectangle.fill();
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

    }




  public void move(int x, int y){

      rectangle.translate(pos_x-x,pos_y-y);
      pos_x=x;
      pos_y=y;

  }

   public Shot shoot(){
        Shot shot = new  Shot(pos_x +gun_pos,pos_y);
        return shot;
    }

 /*   public void move_shots(){
        for (Shot moveThisShit : shotsInAir){
            moveThisShit.move();
        }

    }

    */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setPos_x(int pos_x){
        this.pos_x=pos_x;
    }

    public void setPos_y(int pos_y){
        this.pos_y=pos_y;
    }

    public int getPos_x() {
        return pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }
}
