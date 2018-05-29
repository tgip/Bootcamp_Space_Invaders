package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.BadGuys.BadGuy01;
import org.academiadecodigo.PopStarsSpaceInvaders.BadGuys.BadGuysFactory;

/**
 * The game logic
 */
public class Game {

    private int delay = 200;
    private Player player;
    private BadGuy01 badGuy;
    private int a=0;


    public void init() {
        player= new Player();
        new KeyboardListener(player).activate();
        badGuy= new BadGuy01();


    }

    public void start() throws InterruptedException {

        while (true) {

            if(a>10){
            badGuy.move();}

            a++;

            // Pause for a while
            Thread.sleep(delay);

            //otherObjectsMove();
            player.move();
            //player.move_shots();
        }

    }

}
