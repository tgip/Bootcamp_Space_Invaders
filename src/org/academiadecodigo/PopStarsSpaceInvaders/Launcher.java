package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.menu.MenuChoice;

public class Launcher {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        MenuChoice menuChoice = new MenuChoice();

        menuChoice.init();
        menuChoice.start();
        game.init();
        game.start();
    }
}