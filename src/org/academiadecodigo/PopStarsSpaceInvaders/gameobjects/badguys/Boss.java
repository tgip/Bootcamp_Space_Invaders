package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys;

import org.academiadecodigo.PopStarsSpaceInvaders.Config;
import org.academiadecodigo.PopStarsSpaceInvaders.Direction;
import org.academiadecodigo.PopStarsSpaceInvaders.Shot;
import org.academiadecodigo.PopStarsSpaceInvaders.Sound;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GameObject;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GetRndBadGuyImg;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Boss extends GenericBadGuy  {

    private int posY;
    private boolean isDead;
    private int healf =2;
    //private GetRndBadGuyImg get=new GetRndBadGuyImg();
    public static final Sound sound = new Sound("/resources/sounds/pop1.wav");

    private int levelUp;

    public Boss(int pos_x, int pos_y) {
        super(pos_x, pos_y);
        this.posY=pos_y;
        isDead=false;
        picture.grow(50,50);
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
        if(healf==0) {
            isDead = true;
            hide();
        }else{
            sound.play(true);
            healf--;
        }
    }


    @Override
    public void move(){

        if (Config.BOARD_HEIGHT + Config.PADDING <= getEndY() + 10) {
            return;
        }

        picture.translate(0, 5+(levelUp+1));
        posY += 5+(levelUp+1);
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


}



