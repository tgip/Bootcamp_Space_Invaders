package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.
        BadGuy01;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.
        GenericBadGuy;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Player;
import org.academiadecodigo.PopStarsSpaceInvaders.grid.Grid;
import org.academiadecodigo.PopStarsSpaceInvaders.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.Dimension;

import java.util.LinkedList;

import javax.swing.JPanel;

/**
 * The game logic
 */
public class Game {

    private Dimension d;
    private GenericBadGuy[] badGuys = new GenericBadGuy[10];
    private Player player;
    private CollisionDetector collisionDetector;


    public void init() {
        //simpleGfxGrid = new SimpleGfxGrid(100, 200);
        //simpleGfxGrid.init();
        new Picture(10, 10, "resources/images/Stars.png").draw();
        player = new Player();
        MouseListener mouseListener = new MouseListener(player);

        generateBadGuys();

        collisionDetector = new CollisionDetector(player, badGuys);
        player.setCollisionDetector(collisionDetector);
    }

    public void start() throws InterruptedException {

        while (true) {

            Thread.sleep(100);
            moveEnemy();
            for (Shot i : player.list) {
                i.move();
            }

            collisionDetector.collide();

            boolean allDead = true;
            for (GenericBadGuy badGuy : badGuys) {
                if (!badGuy.isDestroyed()) {
                    allDead = false;
                    break;
                }
            }

            if (allDead) {
                generateBadGuys();
                player.reset();
                collisionDetector.reset(badGuys);
            }
        }
    }

    private void generateBadGuys() {
        int x = 10;

        for (int i = 0; i < badGuys.length; i++) {
            x = x + 120;
            badGuys[i] = new BadGuy01(x, 10);
        }
    }

    public void moveEnemy() {
        for (GenericBadGuy gb : badGuys) {
            gb.move();

        }
    }
}