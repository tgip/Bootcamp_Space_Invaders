package org.academiadecodigo.PopStarsSpaceInvaders;

import javax.swing.*;
import java.awt.*;

public class Launcher {
  public static void main(String[] args) throws InterruptedException {
    Game game = new Game();

    game.init();
    game.start();
  }
}