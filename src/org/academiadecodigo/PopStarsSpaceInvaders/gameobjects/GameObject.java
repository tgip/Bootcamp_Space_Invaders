package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects;

import org.academiadecodigo.PopStarsSpaceInvaders.Destroyable;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.BadGuy02;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.PopStarsSpaceInvaders.Direction;

import java.util.List;

public abstract class GameObject implements Drawable, Destroyable {

    private Direction direction;
    protected Picture picture;
    private boolean destroyed;
    //private Shape picture;

    public GameObject(int x, int y, String path) {
            this.picture = new Picture(x, y, path);
            this.destroyed = false;
        }


    public void show() {
        this.picture.draw();
    }

    public void hide() {
        this.picture.delete();
    }

    public void move() {
        if (this.direction == null) {
            return;
        }

        int dx = 0;
        int dy = 0;

        switch (this.direction) {
            case UP:
                dy = 0;
                break;
            case DOWN:
                dy = 0;
                break;
            case LEFT:
                dx = 0;
                break;
            case RIGHT:
                dx = 0;
                break;
        }

        this.picture.translate(dx, dy);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void destroy() {
        this.destroyed = true;
        this.hide();
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    /**
     * return true if the given GameObject overlaps this
     */

    public boolean overlaps(GameObject other) {

        boolean topLeft =
                getX() >= other.getX() && getX() <= other.getEndX() &&
                        getY() >= other.getY() && getY() <= other.getEndY();

        boolean topRight =
                getEndX() >= other.getX() && getEndX() <= other.getEndX() &&
                        getY() >= other.getY() && getY() <= other.getEndY();

        boolean bottomLeft =
                getX() >= other.getX() && getX() <= other.getEndX() &&
                        getEndY() >= other.getY() && getEndY() <= other.getEndY();

        boolean bottomRight =
                getEndX() >= other.getX() && getEndX() <= other.getEndX() &&
                        getEndY() >= other.getY() && getEndY() <= other.getEndY();

        return topLeft || topRight || bottomLeft || bottomRight;
    }

    private int getEndX() {
        return picture.getX() + picture.getWidth();
    }

    protected int getEndY() {
        return picture.getY() + picture.getHeight();
    }

    public int getX() {
        return this.picture.getX();
    }

    public int getY() {
        return this.picture.getY();
    }
}

