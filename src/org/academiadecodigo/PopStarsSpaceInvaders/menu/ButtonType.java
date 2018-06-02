package org.academiadecodigo.PopStarsSpaceInvaders.menu;

public enum ButtonType {
    PLAY( 70,630,358,730),
    TUTORIAL(410,630,710,730),
    CREDITS(760,630,1056,730),
    BACK(1098,630,1400,730);


    private int startX;
    private int startY;
    private int endX;
    private int endY;

    ButtonType(int startX, int startY, int endX, int endY) {
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

