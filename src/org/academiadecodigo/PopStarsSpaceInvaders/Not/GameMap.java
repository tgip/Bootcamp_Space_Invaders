package org.academiadecodigo.PopStarsSpaceInvaders.Not;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameMap {

    public static final int PADDING = 10;

    public static final int WIDTH = 960;
    public static final int HEIGHT = 540;

    private Picture screen;
    private Picture start;
    private Picture exit;
    private Picture cursor;

    public GameMap() {
        this.start = new Picture(1050, 305, "resources/image/start.jpg");
        this.cursor = new Picture(1040, 330, "resources/image/cursor.png");
        this.screen = createNewScreen();
        this.init();
    }

    private void init() {
        this.start.draw();
        this.cursor.draw();
        this.screen.draw();
    }

    private Picture createNewScreen() {
        return new Picture(
                GameMap.PADDING,
                GameMap.PADDING,
                "res/background.png"
        );
    }

    public boolean isInBounds(int x, int y, int width, int height) {
        return 0 <= x && x <= GameMap.WIDTH - width
                && 0 <= y && y <= GameMap.HEIGHT - height;
    }

}
