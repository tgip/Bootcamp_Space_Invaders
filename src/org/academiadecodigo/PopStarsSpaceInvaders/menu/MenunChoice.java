package org.academiadecodigo.PopStarsSpaceInvaders.menu;

import org.academiadecodigo.PopStarsSpaceInvaders.CollisionDetector;
import org.academiadecodigo.PopStarsSpaceInvaders.MouseListener;
import org.academiadecodigo.PopStarsSpaceInvaders.Painel;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MenunChoice {

    private Cursor cursor;
    private Menu menu;
    private int r=0;

    public void init() throws InterruptedException {


       cursor = new Cursor();
        MouseListener gameCursor = new MouseListener(cursor);
        double i= cursor.getPosX();
        double f=cursor.getPosY();
        menu= new Menu(cursor);
        menu.selection();




    }

    public void start(){

        while( r<10){
            double i= cursor.getPosX();
            double f=cursor.getPosY();
            menu.setY(f);
            menu.setX(i);
            r++;

        }
    }
}
