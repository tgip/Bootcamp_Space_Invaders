package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.
  BadGuy01;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys.
  GenericBadGuy;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.Player;
import org.academiadecodigo.PopStarsSpaceInvaders.grid.Grid;
import org.academiadecodigo.PopStarsSpaceInvaders.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Movable;

import java.awt.Dimension;

import java.util.LinkedList;

import javax.swing.JPanel;

/**
 * The game logic
 */
public class Game {

  private Dimension d;
  private GenericBadGuy[] badGuys = new GenericBadGuy[20];
  private Player player;
  private Shot[] shot = new Shot[1];
  private SimpleGfxGrid simpleGfxGrid;
  private int x = 10;



  public void init(
  ) {
    simpleGfxGrid = new SimpleGfxGrid(100, 200);
    simpleGfxGrid.init(
    );
    player = new Player();
    MouseListener mouseListener = new MouseListener(player);

    ;

    for (int i = 0; i < 20; i++
            ) {
      x = x + 50;
      badGuys[i] = new BadGuy01(x, 10);
    }
  }

  public void start(
  ) throws InterruptedException {

    while (true) {

      // detectCollisions


      Thread.sleep(100);
      moveEnemy();
      for (Shot i : player.list) {
        i.move();
        for (GenericBadGuy gb : badGuys){
          if(i.colision(gb)){
            gb.hide();
          };
        }

      }
    }
  }

  public void moveEnemy() {

    for (GenericBadGuy gb : badGuys) {
      if (gb.getPosY() < (Config.BOARD_HEIGHT - Config.playerIcon_HEIGHT)) {
        gb.move();


      } else {
        gb.hide();
      }
    }

    /*
     * public void moveShot(){
     * for(Shot sh : shot){
     * sh.move(0,-1);
     * //collisionDetector.check(sh);
     * }
     * }
     */
  }
}
