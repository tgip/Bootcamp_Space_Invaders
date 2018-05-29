package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Shot implements Moveable {

    private Rectangle rectangle;
    private int health;
    private Direction direction;
    private int shotPosition;

    public Shot(int originX, int originY) {
        shotPosition=originY;
        rectangle = new Rectangle(originX,originY, 5, 5);
        rectangle.setColor(Color.BLACK);
        rectangle.fill();


    }

    public void move(){
            rectangle.translate(0, -10);
           // shotPosition =shotPosition-10;
    }

    public void setDirection(Direction direction) {
        this.direction = Direction.UP;
    }

    public int getShotPosition() {
        return shotPosition;
    }
    public void setShotPosition(int shotPosition){


    }
}
