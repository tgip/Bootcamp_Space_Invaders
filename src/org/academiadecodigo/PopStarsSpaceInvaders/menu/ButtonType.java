package org.academiadecodigo.PopStarsSpaceInvaders.menu;

public enum ButtonType {
    PLAY(78, 665, 366, 748),
    TUTORIAL(426, 665, 710, 730),
    CREDITS(760, 665, 1056, 730),
    EXIT(1098, 665, 1400, 730),
    CREDITBACK(526, 665, 910, 730),
    BACK(366, 655, 710, 730),
    TUTORIALSTART(760, 665, 1400, 730);


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

