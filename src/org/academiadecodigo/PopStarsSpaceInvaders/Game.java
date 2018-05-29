package org.academiadecodigo.PopStarsSpaceInvaders;

import org.academiadecodigo.PopStarsSpaceInvaders.BadGuys.GenericBadGuy;
import org.academiadecodigo.simplegraphics.graphics.Movable;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.academiadecodigo.PopStarsSpaceInvaders.Config;
/**
 * The game logic
 */
public class Game extends JPanel implements Movable, Config {

    private Dimension d;
    private GenericBadGuy[] badGuys;
    private Player player;
    private LinkedList<Shot> shot;

    private CollisionDetector collisionDetector;


    public void init() {
        player= new Player();
        MouseListener mouseListener = new MouseListener(player);

    }

    public void start() throws InterruptedException {

        while (true) {

            // detectCollisions
            collisionDetector = new CollisionDetector();

            //otherObjectsMove(); // for future

            //moveShots();
            moveShot();
            //moveEnemy();
            moveEnemy();
        }

    }

    public void moveEnemy(){
        for(GenericBadGuy gb : badGuys){
            gb.move();
            collisionDetector.check(gb);
        }
    }

    public void moveShot(){
        for(Shot sh : shot){
            sh.move(0,-1);
            collisionDetector.check(sh);
        }
    }
}
