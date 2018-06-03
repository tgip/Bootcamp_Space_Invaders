package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GameObject;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.
        BadGuy01;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.BadGuy02;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.Boss;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.
        GenericBadGuy;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Player;
import org.academiadecodigo.PopStarsSpaceInvaders.menu.Cursor;
import org.academiadecodigo.PopStarsSpaceInvaders.menu.Menu;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * The game logic
 */
public class Game {

    private GenericBadGuy[] badGuys = new GenericBadGuy[10];
    private GameObject[] stars = new GameObject[10];
    private Player player;
    private CollisionDetector collisionDetector;
    private int level = 1;
    private boolean allDead;
    private Painel painel;
    private Menu menu;
    private Cursor cursor;



    public void init() throws InterruptedException {
        menu=new Menu();


        cursor= new Cursor();

        MouseListener mouseListener = new MouseListener(cursor);
        cursor.putMenu(menu);
        menu.selection();

        System.out.println(menu.getX()+ " "+menu.getY());


        new Picture(10, 10, "resources/images/Stars.png").draw();
        painel = new Painel();
        player = new Player();




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
                painel.addLevel(level);
                System.out.println("Level" + level);
                newGame();

            }
            if (player.getDead()) {
                for (GenericBadGuy badGuy : badGuys) {
                    badGuy.hide();
                    level = 0;
                }
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
        Double a;
        for (int i = 0; i < badGuys.length; i++) {
            a=(Double)(Math.random() * ( 1 - 0 ));
            x = x + 120;
            if (level < 3) {
                badGuys[i] = ((Math.random() < 0.5) ? new BadGuy01(x, 10) : new BadGuy02(x, 10));
                badGuys[i].setLevelUp(level);
            } else {
                if(a<0.4){
                    badGuys[i] =new BadGuy01(x, 10);
                    badGuys[i].setLevelUp(level);
                }else if(a>0.4&&a<0.8){
                    badGuys[i] =new BadGuy02(x, 10);
                    badGuys[i].setLevelUp(level);
                }else{
                    badGuys[i]=new Boss(x,10);
                    if(level<=5){
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
        player.reset();
        collisionDetector.reset(badGuys);
    }

}