package org.academiadecodigo.bootcamp;

/**
 * The game logic
 */
public class Game {

    private Player player;



    public void init() {
        player = new Player();
        new KeyboardListener(player).activate();
    }

    public void start(){

    // create array of enemies
        // create player
        // loop

        // while exists enemy || exists player
        // player.move
        // loop through enemy array and move each one
        // loop through linked list of shots and move each one
        // compare positions of shots and enemies
            // if shot hits enemy ... update linked list of shots
                // remove shot from linked list
                // remove enemy from array
        // loop restart
        // if enemies.length == 0 ... game (level) ends
        // if player dies (we'll figure this out later) game ends.

            while (player.getHealth()>0) {
                player.move();


                }
                //otherObjectsMove();

                //player.move_shots();
            }
        }







