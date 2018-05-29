package org.academiadecodigo.PopStarsSpaceInvaders;

/**
 * The game logic
 */
public class Game {

    private int delay = 200;
    private Player player;


    public void init() {
        player= new Player();
        new KeyboardListener(player).activate();
    }

    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            //otherObjectsMove();
            player.move();
            //player.move_shots();
        }

    }

}
