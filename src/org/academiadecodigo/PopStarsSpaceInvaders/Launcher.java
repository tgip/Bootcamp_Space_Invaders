package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.menu.MenunChoice;

public class Launcher {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        MenunChoice menunChoice = new MenunChoice();
        menunChoice.init();
        menunChoice.start();
        game.init();
        game.start();
    }
}