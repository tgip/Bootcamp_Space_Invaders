package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects;

import org.academiadecodigo.PopStarsSpaceInvaders.*;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;
import java.util.List;

public class Player extends GameObject implements MouseUser{

    private boolean dead;
    //  private int directionChangeLevel = 8;
    private int health;
    private Direction direction;
    private double posX;
    private double posY;
    public List<Shot> list = new LinkedList<Shot>();
    private CollisionDetector collisionDetector;
    public static final Sound sound = new Sound("/resources/sounds/FudiMe.wav");
    private int level;



    private int playerLevel;
    private double gun_pos = 25;


    public Player() {
        super(0, Config.BOARD_HEIGHT - Config.playerIcon_HEIGHT, GetRndPlayerImg.get());
        posX = 0;
        posY = Config.BOARD_HEIGHT - Config.playerIcon_HEIGHT;
        picture.draw();

    }


    @Override
    public void destroy(GameObject target) {

    }


    @Override
    public boolean isDestroyed() {
        picture.delete();
        return dead;


    }


    @Override
    public void hit() {
        sound.play(true);
        dead = true;
        picture.delete();

    }

    public void move(double x, double y) {
        picture.translate(x - posX, y - posY);
        posX = x;
        posY = y;

    }

    public void shoot() {
        Shot shot = new Shot(picture.getX() + gun_pos, picture.getY());
        shot.setLevelt(level);
        list.add(shot);
        collisionDetector.addShot(shot);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void reset() {
        for (Shot shot : list) {
            shot.hide();
        }
        list.clear();
    }

    @Override
    public void hide() {
        picture.delete();
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    public boolean getDead() {
        return dead;
    }

    public void setDead(boolean b) {
        this.dead = b;
    }

    public void setLevel(int a){
        if (a == 1) {
            level=0;
        }
        this.level+=a;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        shoot();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x_pos = (int) e.getX();
        move(x_pos, (Config.BOARD_HEIGHT - Config.playerIcon_HEIGHT));

        if (x_pos > (Config.BOARD_WIDTH - Config.playerIcon_WIDTH + 10)) {
            x_pos = Config.BOARD_WIDTH - Config.playerIcon_WIDTH + 10;
        } else if (x_pos < 10) {
            x_pos = 10;
        }
    }
}
