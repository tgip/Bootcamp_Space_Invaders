package org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.badguys;

import org.academiadecodigo.PopStarsSpaceInvaders.Config;
import org.academiadecodigo.PopStarsSpaceInvaders.Direction;
import org.academiadecodigo.PopStarsSpaceInvaders.Shot;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GameObject;
import org.academiadecodigo.PopStarsSpaceInvaders.gameobjects.GetRndBadGuyImg;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BadGuy02 extends GenericBadGuy  {

    private int posY;
        private boolean isDead;
        //private GetRndBadGuyImg get=new GetRndBadGuyImg();
        private Picture get = new Picture(10, 10, "resources/images/Star.png");
        private int levelUp;

        public BadGuy02(int pos_x, int pos_y) {
            super(pos_x, pos_y);
            this.posY=pos_y;
            isDead=false;
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
            isDead=true;
            hide();
        }


    @Override
    public void move(){

        if (Config.BOARD_HEIGHT + Config.PADDING <= getEndY() + 10) {
            return;
        }

        picture.translate(0, 5+(levelUp+5));
        posY += 5+levelUp;
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


}



