package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Player;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.BadGuy03;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.GenericBadGuy;
import org.academiadecodigo.PopStarsSpaceInvaders.menu.Cursor;
import org.academiadecodigo.PopStarsSpaceInvaders.menu.Menu;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * The game logic
 */
public class Game {

    private GenericBadGuy[] badGuys = new GenericBadGuy[10];

    private Player player;
    private CollisionDetector collisionDetector;
    private int level = 1;
    private boolean allDead;
    private Painel painel;
    private Menu menu;
    private Cursor cursor;

    public void init() {
        new Picture(10, 10, "resources/images/Stars.png").draw();
        painel = new Painel();
        player = new Player();
        MouseListener mouseListener = new MouseListener(player);
        KeyboardListener missilLaucher = new KeyboardListener(player);
        generateBadGuys();
        collisionDetector = new CollisionDetector(player, badGuys);
        player.setCollisionDetector(collisionDetector);
    }

    public void start() throws InterruptedException {
        while (true) {
            Thread.sleep(100);
            moveEnemy();
            collisionDetector.moveShots();

            painel.addPoint(collisionDetector.getPoints());
            collisionDetector.collide();
            boolean allDead = true;
            for (GenericBadGuy badGuy : badGuys) {
                if (!badGuy.isDestroyed()) {
                    allDead = false;
                    break;
                }
            }

            if (allDead) {
                level++;
                player.setLevel(level);
                painel.addLevel(level);
                System.out.println("Level" + level);
                newGame();
            }

            if (player.getDead()) {
                for (GenericBadGuy badGuy : badGuys) {
                    badGuy.hide();
                }
                level = 1;
                player.setLevel(level);
                player.setDead(false);
                newGame();
                player.show();
                painel.addLevel(1);
                collisionDetector.setPoints(0);
            }
        }
    }

    private void generateBadGuys() {
        int x = 10;
        Double RNGGenerator;
        for (int i = 0; i < badGuys.length; i++) {
            RNGGenerator = (Math.random());
            x = x + 120;
            if (level < 3) {
                badGuys[i] = ((Math.random() < 0.5) ? new BadGuy03(x, 10, 1, 0) : new BadGuy03(x, 10, 1, 50));
                badGuys[i].setLevelUp(level);
            } else {
                if (RNGGenerator < 0.4) {
                    badGuys[i] = new BadGuy03(x, 10, 1, 0);
                    badGuys[i].setLevelUp(level);
                } else if (RNGGenerator > 0.4 && RNGGenerator < 0.8) {
                    badGuys[i] = new BadGuy03(x, 10, 1, 50);
                    badGuys[i].setLevelUp(level);
                } else {
                    badGuys[i] = new BadGuy03(x, 10, 3, 50);
                    if (level <= 5) {
                        badGuys[i].setLevelUp(level);
                    }
                }
            }
        }
    }

    public void moveEnemy() {
        for (GenericBadGuy gb : badGuys) {
            gb.move();
        }
    }

    public void newGame() {
        generateBadGuys();
        collisionDetector.resetBadguys(badGuys);
    }
}