package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects;

import org.academiadecodigo.PopStarsSpaceInvaders.*;
import org.academiadecodigo.PopStarsSpaceInvaders.grid.Grid;
import org.academiadecodigo.PopStarsSpaceInvaders.grid.GridDirection;
import org.academiadecodigo.PopStarsSpaceInvaders.grid.GridPosition;

import java.util.LinkedList;
import java.util.List;

public class Player extends GameObject implements Drawable {

    private GridPosition pos;
    private Grid grid;
    private boolean dead = false;
  //  private int directionChangeLevel = 8;
    private int health;
    private Direction direction;
    private double posX;
    private double posY;
    public List<Shot> list= new LinkedList<Shot>();

    private double gun_pos = 25;
    public Shot shot;




    public Player() {
        super(200, 200, "resources/images/Humberto.png");

        posX=200;
        posY=200;

        picture.grow(-50,-50);
        picture.draw();


    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public GridPosition getPos() {
        return pos;
    }


    public void move(double x, double y) {
        picture.translate(x - posX, y - posY);
        posX=x;
        posY=y;

    }

    public void shoot()  {
        Shot shot = new Shot(picture.getX() + gun_pos, picture.getY());
       list.add(shot);

    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void hit() {
    }
}
