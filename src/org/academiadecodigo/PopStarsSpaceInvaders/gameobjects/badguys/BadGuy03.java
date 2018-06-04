package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys;

import org.academiadecodigo.PopStarsSpaceInvaders.Config;
import org.academiadecodigo.PopStarsSpaceInvaders.Shot;
import org.academiadecodigo.PopStarsSpaceInvaders.Sound;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GameObject;

public class BadGuy03 extends GenericBadGuy  {

    private int posY;
    private boolean isDead;
    private int health =2;
    //private GetRndBadGuyImg get=new GetRndBadGuyImg();
    public static final Sound sound = new Sound("/resources/sounds/pop1.wav");

    private int levelUp;

    public BadGuy03(int pos_x, int pos_y, int health, int size) {
        super(pos_x, pos_y);
        this.posY=pos_y;
        isDead=false;
        this.health=health;
        picture.grow(size,size);
        picture.draw();

    }

    @Override
    public void destroy(GameObject target){
        target.hit();
        target.hide();
    }

    @Override
    public boolean isDestroyed(){
        return isDead;

    }

    @Override
    public void hit(){
        if(health==0) {
            isDead = true;
            hide();
        }else{
            sound.play(true);
            health--;
        }
    }


    @Override
    public void move(){

        if (Config.BOARD_HEIGHT + Config.PADDING <= getEndY() + 10) {
            return;
        }

        picture.translate(0, (levelUp+5));
        posY += (levelUp+5);
    }

    public void shoot() {
        Shot shot = new Shot(picture.getX() , picture.getY());
        shot.move(10);
        badGuyShotList.add(shot);
        //collisionDetector.addShot(shot);
    }

    @Override
    public void setLevelUp(int increase){
        this.levelUp=this.levelUp+increase;
    }

    @Override
    public int getPosY() {
        return posY;

    }

    public boolean isDead() {
        return isDead;
    }

    public void kill(boolean dead) {
        isDead = dead;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevelUp() {
        return levelUp;
    }
}



