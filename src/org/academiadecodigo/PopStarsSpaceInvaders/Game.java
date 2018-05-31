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
  private LinkedList<Shot> shot = new Shot[1];
  private SimpleGfxGrid simpleGfxGrid;
  private int x = 10;

  private CollisionDetector collisionDetector;

  public void init () {
    simpleGfxGrid = new SimpleGfxGrid (100, 200);
    simpleGfxGrid.init ();
    player = new Player ();
    MouseListener mouseListener = new MouseListener (player);

    for (int i = 0; i < 20; i++) {
      x = x + 50;
      badGuys[i] = new BadGuy01 (x, 10);
    }
  }

    public void start () throws InterruptedException {

    while (true) {

      // detectCollisions

      collisionDetector = new CollisionDetector ();
      Thread.sleep (100);
      moveEnemy ();
      for (Shot i:player.list) { i.move (); }
    }
  }

  public void moveEnemy () {
    for (GenericBadGuy gb:badGuys) {
      gb.move ();
      collisionDetector.check(gb);
    }
  }

  /*
  public void move(double x, double y) {
        playerIcon.translate(x - posX, y - posY);
        posX=x;
        posY=y;

   */

  /*
   * public void moveShot(){
   * for(Shot sh : shot){
   * sh.move(0,-1);
   * //collisionDetector.check(sh);
   * }
   * } 
   */
}
/*
public class Game {

    private GameMap gameMap;
    private Dimension d;
    private CollisionDetector collisionDetector;
    private Player player;
    private GenericBadGuy[] badGuys = new GenericBadGuy[20];
    private BadGuysFactory badGuysFactory;
    private Shot[] shot = new Shot[1];
    private SimpleGfxGrid simpleGfxGrid;

    private int x = 10;

    /*

     *

    public Game(){
        this.collisionDetector = new CollisionDetector(this.player);
        collisionDetector.add(this.player);
        this.shot = new Shot[];
        this.shot.init();
        this.gameMap = new GameMap();
        this.player = new Player(0, 0, collisionDetector, this, shot);
        this.badGuys = new GenericBadGuy(30, collisionDetector, gameMap, this,);
        this.badGuys.init();
        this.badGuysFactory = new BadGuysFactory(30, collisionDetector, gameMap, this);
        this.badGuysFactory.init();
    }

    public void init () {
        simpleGfxGrid = new SimpleGfxGrid (100, 200);
        simpleGfxGrid.init ();
        player = new Player ();
        MouseListener mouseListener = new MouseListener (player);

        for (int i = 0; i < 20; i++) {
            x = x + 50;
            badGuys[i] = new BadGuy01 (x, 10);
        }
    }

    public void start () throws InterruptedException {

     /*
       while (this.isRunning()) {
            this.createEnemy();
            this.collisionDetector.collide();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
      */

    /*    while (true) {
            // detectCollisions
            collisionDetector = new CollisionDetector ();
            Thread.sleep (100);
            moveEnemy ();
            for (Shot i:player.list) {
                i.move ();
            }
        }
    }

    public void moveEnemy () {
        for (GenericBadGuy gb:badGuys) {
            gb.move ();
            collisionDetector.check (gb);
        }
    }

    public boolean isRunning() {
        return !this.player.isDestroyed();
    }

    public Shot getShot() {
        return this.shot;
    }
    /*
     * public void moveShot(){
     * for(Shot sh : shot){
     * sh.move(0,-1);
     * //collisionDetector.check(sh);
     * }
     * }
     *
}
 */