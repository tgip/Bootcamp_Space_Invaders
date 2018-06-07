package org.academiadecodigo.PopStarsSpaceInvaders.menu;

import org.academiadecodigo.PopStarsSpaceInvaders.MouseListener;

public class MenunChoice {

    private Cursor cursor;
    private Menu menu;
    // TODO - what is r? Rounds?
    private int r = 0;

    public void init() {
        cursor = new Cursor();
        MouseListener gameCursor = new MouseListener(cursor);
        menu = new Menu(cursor);
        menu.selection();
    }

    public void start() {
        while (r < 10) {
            double i = cursor.getPosX();
            double f = cursor.getPosY();
            menu.setY(f);
            menu.setX(i);
            r++;
        }
    }
}
