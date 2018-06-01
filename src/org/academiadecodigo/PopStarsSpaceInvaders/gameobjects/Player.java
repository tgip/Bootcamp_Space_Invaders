package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects;

import org.academiadecodigo.PopStarsSpaceInvaders.*;
import org.academiadecodigo.PopStarsSpaceInvaders.grid.Grid;
import org.academiadecodigo.PopStarsSpaceInvaders.grid.GridDirection;
import org.academiadecodigo.PopStarsSpaceInvaders.grid.GridPosition;

import java.util.LinkedList;
import java.util.List;

public class Player extends GameObject {

    private GridPosition pos;
    private Grid grid;
    private boolean dead;
    //  private int directionChangeLevel = 8;
    private int health;
    private Direction direction;
    private double posX;
    private double posY;
    public List<Shot> list = new LinkedList<Shot>();
    private CollisionDetector collisionDetector;

    private double gun_pos = 25;
    public Shot shot;

    public Player() {
        super(200, 200, "resources/images/Francisco.png");

        posX = 200;
        posY = 200;

        //picture.grow(-50, -50);
        picture.draw();

    }


    @Override
    public void destroy(GameObject target) {

    }

    ;


    @Override
    public boolean isDestroyed() {
        picture.delete();
        return dead;


    }

    ;

    @Override
    public void hit() {
        dead = true;
        picture.delete();
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public GridPosition getPos() {
        return pos;
    }


    public void move(double x, double y) {
        picture.translate(x - posX, y - posY);
        posX = x;
        posY = y;

    }

    public void shoot() {
        Shot shot = new Shot(picture.getX() + gun_pos, picture.getY());
        list.add(shot);
        collisionDetector.addShot(shot);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void reset() {
        for (Shot shot : list) {
            shot.hide();
        }
        list.clear();
    }

    @Override
    public void hide() {
        picture.delete();
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }
}
