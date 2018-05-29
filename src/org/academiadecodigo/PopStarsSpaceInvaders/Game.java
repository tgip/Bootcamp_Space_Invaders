package org.academiadecodigo.PopStarsSpaceInvaders;


public class Game {


    /**
     * The game logic
     */

    private int delay = 200;
    private Player player;
    // TODO - needs new array  to iterate over and move the badguys
    // private Enemy[] enemies = new Enemy[3];
    // TODO - needs new linked list to iterate over and move the shots
    // private Moveable shotsInAir = new Movable linkedlist

    public void init() {
        //create Screen
        player = new Player();
        MouseListener mouseListener = new MouseListener(player);
        //new KeyboardListener(player).activate();
    }

    public void start() throws InterruptedException {

        while (true) {

            // Pause for a while
            Thread.sleep(delay);

            //otherObjectsMove();
            //player.move_shots();
            //detectCollisions();
            //updateScores();
        }

    }

}
