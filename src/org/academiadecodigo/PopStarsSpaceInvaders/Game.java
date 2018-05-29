package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.BadGuys.BadGuy01;
import org.academiadecodigo.PopStarsSpaceInvaders.BadGuys.BadGuysFactory;
import org.academiadecodigo.PopStarsSpaceInvaders.BadGuys.GenericBadGuy;

/**
 * The game logic
 */
public class Game {

    private int delay = 200;
    private Player player;
    private GenericBadGuy [] badGuy;
    private int a=0;
    private int b=50;


    public void init() {
        player = new Player();
        badGuy = new GenericBadGuy[8];
        new KeyboardListener(player).activate();
        for (int i = 0; i < 8; i++) {
            badGuy[i] = new BadGuy01(b, 0);
            b=b+100;


        }
    }

    public void start() throws InterruptedException {

        while (true) {

            for(int i=0; i<8;i++) {

                badGuy[i].move();

            }

            // Pause for a while
            Thread.sleep(delay);

            //otherObjectsMove();
            player.move(10,0);
            //player.move_shots();
        }

    }

}
