package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GameObject;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.
        BadGuy01;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.BadGuy02;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.
        GenericBadGuy;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * The game logic
 */
public class Game {

    private GenericBadGuy[] badGuys = new GenericBadGuy[10];
    private GameObject[] stars = new GameObject[10];
    private Player player;
    private CollisionDetector collisionDetector;
    private int level =0;
    private boolean allDead;
    private Painel painel;


    public void init() {


        new Picture(10, 10, "resources/images/Stars.png").draw();
        painel=new Painel();
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
                System.out.println("Level" + level);
                newGame();

            }
            if(player.getDead()){
                for (GenericBadGuy badGuy : badGuys) {
                     badGuy.hide();
                     level =0;
                    }
                player.setDead(false);
                newGame();
                player.show();

            }
        }
        }


    private void generateBadGuys() {
        int x = 10;
        level = level +1;
        for (int i = 0; i < badGuys.length; i++) {
            x = x + 120;
            badGuys[i] = ((Math.random()<0.5)? new BadGuy01(x, 10): new BadGuy02(x,10));
            badGuys[i].setLevelUp(level);
        }


        }


    public void moveEnemy() {
        for (GenericBadGuy gb : badGuys) {
            gb.move();

        }
    }

    public void newGame(){

        generateBadGuys();
        player.reset();
        collisionDetector.reset(badGuys);
    }
}