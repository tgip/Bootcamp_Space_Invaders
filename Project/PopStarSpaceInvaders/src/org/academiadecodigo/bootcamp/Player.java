package org.academiadecodigo.bootcamp;

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
        pos_x = 100;
        pos_y = 100;
        rectangle = new Rectangle(pos_x, pos_y, 50, 50);
        rectangle.setColor(Color.RED);
        rectangle.fill();


    }

    public void move() {

        if (direction == Direction.RIGHT) {
            pos_x = pos_x + 10;
            rectangle.translate(10, 0);

        }

        if (direction == Direction.LEFT) {
            pos_x = pos_x - 10;
            rectangle.translate(-10, 0);
        }


    }


    public Shot shoot() {
        shot = new Shot(pos_x, pos_y);
        return shot;
    }

        public void setDirection (Direction direction){
            this.direction = direction;
        }



    public int getPos_x(){
        return  pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }
    public int getHealth() {
        return health;
    }
}


