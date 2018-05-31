package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects;

import org.academiadecodigo.PopStarsSpaceInvaders.*;
import org.academiadecodigo.PopStarsSpaceInvaders.grid.Grid;
import org.academiadecodigo.PopStarsSpaceInvaders.grid.GridColor;
import org.academiadecodigo.PopStarsSpaceInvaders.grid.GridDirection;
import org.academiadecodigo.PopStarsSpaceInvaders.grid.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Player extends Check implements Moveable {

    private GridPosition pos;
    private Grid grid;
    private boolean crashed = false;
    private int directionChangeLevel = 8;
    private Picture playerIcon;
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

        posX=(Config.BOARD_HEIGHT-Config.playerIcon_WIDTH)/2;
        posY=(Config.BOARD_WIDTH-Config.playerIcon_WIDTH)/2;

        playerIcon = new Picture(posX,posY,"resources/images/Humberto.png");
        playerIcon.draw();

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

    public void setDirectionChangeLevel(int directionChangeLevel) {
        this.directionChangeLevel = directionChangeLevel;
    }

    /**
     * Sets the car into a crashed state
     */

    public void move() {
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

    }

    public void shoot()  {
        Shot shot = new Shot(playerIcon.getX() + gun_pos, playerIcon.getY());
       list.add(shot);

    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
