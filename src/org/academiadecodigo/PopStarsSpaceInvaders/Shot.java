package org.academiadecodigo.PopStarsSpaceInvaders;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Shot extends Check implements Moveable {

    private Rectangle rectangle;
    private int health;
    private Direction direction;
    private double posX;
    private double posY;

  public Shot (double originX, double originY)
  {
    rectangle = new Rectangle (originX, originY, 5, 5);
    rectangle.setColor (Color.BLACK);
    rectangle.fill ();
  }

    public Shot(double originX, double originY) {
        posX = originX;
        posY = originY;
        rectangle = new Rectangle(originX,originY, 5, 5);
        rectangle.setColor(Color.BLACK);
        rectangle.fill();
    }

    public void move(double pos_x, double pos_y){
        pos_y--;
        rectangle.translate(0, -1);
    }


    public void setDirection(Direction direction) {
        this.direction = Direction.UP;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }
}
