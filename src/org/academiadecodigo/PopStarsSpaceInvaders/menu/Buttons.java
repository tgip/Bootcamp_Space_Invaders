package org.academiadecodigo.PopStarsSpaceInvaders.menu;

public class Buttons {

    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Buttons(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }
}
