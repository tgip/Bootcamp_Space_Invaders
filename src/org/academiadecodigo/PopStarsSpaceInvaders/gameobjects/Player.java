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

    protected CollisionDetector collisionDetector;
    protected GridDirection currentDirection;

    public Player() {
        super(200, 200, "resources/images/Humberto.png");

        posX=200;
        posY=200;

        picture.grow(-50,-50);
        picture.draw();

        currentDirection = GridDirection.values()[(int) (Math.random() * GridDirection.values().length)];
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public GridPosition getPos() {
        return pos;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

 /* public void setDirectionChangeLevel(int directionChangeLevel) {
        this.directionChangeLevel = directionChangeLevel;
    }

    /**
     * Sets the car into a crashed state
     */

  /*  public void move() {
        if (direction == Direction.RIGHT) {
            playerIcon.translate(10, 0);
        }
        if (direction == Direction.LEFT) {
            playerIcon.translate(-10, 0);
        }

    }

    public void move(double x, double y) {
        playerIcon.translate(x - posX, y - posY);
        posX=x;
        posY=y;

    }*/

    public void shoot()  {
        Shot shot = new Shot(picture.getX() + gun_pos, picture.getY());
       list.add(shot);

    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
